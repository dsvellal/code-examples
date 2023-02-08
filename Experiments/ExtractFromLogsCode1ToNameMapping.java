import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.StringTokenizer;

class ExtractFromLogsCode1ToNameMapping {
    public static void main(final String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./../Logs.txt"));
            Set<String> users = new HashSet<>();
            BufferedWriter writer = new BufferedWriter(new FileWriter("./../Users.txt", true));
            for (String line: lines) {
                if (line.contains("[1]")) {
                    StringTokenizer strTok = new StringTokenizer(line, " ");
                    StringJoiner strJoiner = new StringJoiner(",");
                    while (strTok.hasMoreTokens()) {
                        String token = strTok.nextToken();
                        if (token.contains("'") || token.contains("CODE1")) {
                            strJoiner.add(token);
                        }
                    }
                    String user = strJoiner.toString().replaceAll(",,", ",")
                                    .replaceAll("\\(", "")
                                    .replaceAll("\\)", "")
                                    .replaceAll("'", "")
                                    .replaceAll(",OU=Users","")
                                    .replaceAll(",OU=CODE,DC=code1,DC=emi,DC=philips,DC=com","");
                    users.add(user);
                }
            }
            for(String user: users) {
                writer.append(user);
                writer.append("\n");
                System.out.println(user);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(3);
        }
    }
}
