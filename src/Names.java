import java.util.Scanner;

public interface Names {

    static void lookingForNames(double[] numericalData, String[] stringData, int c) {
        System.out.println();

        System.out.println("Wybieram dane dot jednej osoby(łącznie rekordów "+c+" w pliku");
        Scanner input = new Scanner(System.in);
        String choice= input.nextLine();
        for (int i=0;i<c;i++) {
            if (choice.equals(stringData[i])) {
                System.out.println("Dla imienia: " + choice + "| znaleziono: |" + numericalData[i] + "|"
                        + numericalData[i + 1] + "|" + numericalData[i + 2]);
            }
//            break;

        }
    }
}
