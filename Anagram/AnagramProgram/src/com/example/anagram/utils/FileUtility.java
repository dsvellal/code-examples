package com.philips.anagram.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.philips.elasticsearch.metrics.client.Metrics;

public class FileUtility {
  private static Metrics metrics = null;
  static {
    try {
      metrics = new Metrics(FileUtility.class);
    } catch (final IOException e) {
      e.printStackTrace(System.out);
    }
  }

  private FileUtility() {

  }

  public static List<String> getLines(final String path) throws IOException {
    final long startTime = System.nanoTime();
    List<String> lines = new ArrayList<>();
    if (path == null || path.isEmpty()) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GETLINES", Arrays.asList("PATH_NULL"), (endTime - startTime));
      throw new IllegalArgumentException("Path provided is null or empty");
    }

    final File file = new File(path);
    if (!file.exists()) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GETLINES", Arrays.asList("FILE_NULL"), (endTime - startTime));
      throw new IllegalArgumentException("File doesn't exist in provided path: " + path);
    }

    lines = Files.readAllLines(Paths.get(path));
    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("FILE_GETLINES", (endTime - startTime));

    return lines;
  }

  public static File getDirectoryFile(final String directoryPathString, final String defaultDirectoryPathString) {
    final long startTime = System.nanoTime();
    String directoryPathStringToBeUsed = null;
    if (directoryPathString == null || directoryPathString.isEmpty()) {
      metrics.putMetric("FILE_GET_DIRECTORY_DEFAULT_DIRECTORY", 1);
      directoryPathStringToBeUsed = defaultDirectoryPathString;
    } else {
      directoryPathStringToBeUsed = directoryPathString;
    }

    final File directory = new File(directoryPathStringToBeUsed);
    if (!directory.isDirectory()) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GET_DIRECTORY", Arrays.asList("DIRECTORY_NULL"), (endTime - startTime));
      throw new IllegalArgumentException(
          "Directory path specified: " + directoryPathStringToBeUsed + " is not a directory.");
    }

    final long endTime = System.nanoTime();
    metrics.publishSuccessMetrics("FILE_GET_DIRECTORY", (endTime - startTime));
    return directory;
  }

  public static List<String> getListOfStringFromDirectoryAndFileNumber(String directoryPathString, final int fileNumber,
      final String defaultDirecetoryPathString) {
    final long startTime = System.nanoTime();
    try {
      if (directoryPathString == null || directoryPathString.isEmpty()) {
        metrics.putMetric("FILE_GET_LIST_DEFAULT_PATH", 1);
        directoryPathString = defaultDirecetoryPathString;
      }

      final Path filePath = getPath(directoryPathString, fileNumber, defaultDirecetoryPathString);
      final List<String> lines = FileUtility.getLines(filePath.toString());

      final long endTime = System.nanoTime();
      metrics.publishSuccessMetrics("FILE_GET_LIST", (endTime - startTime));
      return lines;

    } catch (final IOException e) {
      // TODO: Log statement here
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GET_LIST", Arrays.asList("INPUT_ERROR"), (endTime - startTime));
      return null;
    }

  }

  private static Path getPath(final String directoryPathString, final int fileNumber,
      final String defaultDirectoryPath) {
    final long startTime = System.nanoTime();
    if (fileNumber < 1) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GET_PATH", Arrays.asList("FILENO_ERROR"), (endTime - startTime));
      throw new IllegalArgumentException("File number can not be less than 1.");
    }

    final File directory = FileUtility.getDirectoryFile(directoryPathString, defaultDirectoryPath);
    final File[] filesInDirectory = directory.listFiles();
    if (filesInDirectory.length < (fileNumber - 1)) {
      final long endTime = System.nanoTime();
      metrics.publishFailureMetrics("FILE_GET_PATH", Arrays.asList("DIRECTORY_ERROR"), (endTime - startTime));
      throw new IllegalArgumentException("The specified directory: " + directory.getAbsolutePath() + " contains only "
          + filesInDirectory.length + " files. Unable to fetch file number: " + fileNumber);
    }

    for (final File file : filesInDirectory) {
      if (file.getName().contains(Integer.toString(fileNumber))) {
        final long endTime = System.nanoTime();
        metrics.publishSuccessMetrics("FILE_GET_PATH", (endTime - startTime));
        return file.toPath();
      }
    }

    final long endTime = System.nanoTime();
    metrics.publishFailureMetrics("FILE_GET_PATH", Arrays.asList("GETPATH_ERROR"), (endTime - startTime));
    throw new IllegalArgumentException("Unable to get the file name which contains number: " + fileNumber
        + " from the list of files in the directory: " + directoryPathString);
  }
}
