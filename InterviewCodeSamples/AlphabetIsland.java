import java.util.Scanner;
import java.util.StringTokenizer;

public class AlphabetIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.valueOf(scanner.nextLine());
        int columns = Integer.valueOf(scanner.nextLine());
        String[][] alphabetIsland = new String[rows][columns];

        for (int i=0; i<rows; i++) {
            String[] columnArray = scanner.nextLine().split(" ");
            if (columnArray.length != columns) {
                System.out.println("-1");
            }
            for (int j=0; j<columnArray.length; j++) {
                alphabetIsland[i][j] = columnArray[j];
            }
        }

        System.out.println(alphabetIsland);

        scanner.close();
    }
}