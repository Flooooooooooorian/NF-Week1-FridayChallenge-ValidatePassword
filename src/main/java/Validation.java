import java.util.Scanner;

public class Validation {

    public static Scanner scanner = new Scanner(System.in);
    public static String[] forbiddenPasswordList = {"12345678", "Passwort123!"};
    public static char[] specialCharacter = {'!', '"', '§', '$', '%', '&', '/', '(', ')', '=', '?', '`', '²', '³', '{', '[', ']', '}', 'ß', '´', '+', '*', '~', '#', '-', '_', ',', ';', '.', ':', 'µ', '<', '>', '|', '^', '°', '@', '€'};
    public static char[] upperCase = {'Q', 'W', 'E', 'R', 'T', 'Z', 'U', 'I', 'O', 'P', 'Ü', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Ö', 'Ä', 'Y', 'X', 'C', 'V', 'B', 'N', 'M'};
    public static char[] lowerCase = {'q', 'w', 'e', 'r', 't', 'z', 'u', 'i', 'o', 'p', 'ü', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'ö', 'ä', 'y', 'x', 'c', 'v', 'b', 'n', 'm'};
    public static char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public static boolean checkUpperCase(String Password) {
        char[] password = Password.toCharArray();
        boolean valid = false;
        for (int i = 0; i < Password.length(); i++) {
            for (int x = 0; x < upperCase.length; x++) {
                if (password[i] == upperCase[x]) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    public static boolean checkLowerCase(String Password) {
        char[] password = Password.toCharArray();
        boolean valid = false;
        for (int i = 0; i < Password.length(); i++) {
            for (int x = 0; x < lowerCase.length; x++) {
                if (password[i] == lowerCase[x]) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    public static boolean checkSpecialCharacter(String Password) {
        char[] password = Password.toCharArray();
        boolean valid = false;
        for (int i = 0; i < Password.length(); i++) {
            for (int x = 0; x < specialCharacter.length; x++) {
                if (password[i] == specialCharacter[x]) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    public static boolean checkNums(String Password) {
        char[] password = Password.toCharArray();
        boolean valid = false;
        for (int i = 0; i < Password.length(); i++) {
            for (int x = 0; x < nums.length; x++) {
                if (password[i] == nums[x]) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    public static boolean isLongerThan7(String Password) {
        if (Password.length() > 7) {
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        if (isAllowed(reader())) {
            System.out.println("Das Passwort ist valide");
            return;
        } else System.out.println("Das Passwort entspricht nicht unseren Sicherheitsbestimmungen, bitte beachte:" +
                "\nmindestens 8 Zeichen lang" +
                "\nmin ein Großbuchstabe" +
                "\nmin ein Kleinbuchstabe" +
                "\nmin eine Zahl" +
                "\nmin ein Sonderzeichen.");
        main(args);

    }

    // Eingabe des Users einlesen (scanner)
    public static String reader() {
        System.out.println("Bitte geben Sie das zu validierende Passwort ein: ");
        return scanner.nextLine();
    }

    // Vergleich mit Datenbank der nicht erlaubten Passwörter und dem Safety Checker
    public static boolean isAllowed(String Password) {
        for (int i = 0; i < forbiddenPasswordList.length; i++) {
            if (forbiddenPasswordList[i].equals(Password)) {
                System.out.println("Das Passwort ist nicht gültig!");
                return false;
            }
        }
        return safetyCheck(Password);
    }

    // Gegenchecken ob Sicherheitsstandards erfüllt sind (ein Großbuchstabe, ein Kleinbuchstabe, eine Zahl und ein Sonderzeichen. Min 8 Zeichen lang)
    public static boolean safetyCheck(String Password) {
        if (checkUpperCase(Password)
                && checkLowerCase(Password)
                && checkSpecialCharacter(Password)
                && checkNums(Password)
                && isLongerThan7(Password)) {
            return true;
        } else return false;
    }


}

