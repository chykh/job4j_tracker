package ru.job4j.early;

public class PasswordValidator {
    private static final String[] FORBIDDEN = {"qwerty", "12345", "password", "admin", "user"};

    public static boolean hasUpCase(String password) {
        boolean result = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean hasLowCase(String password) {
        boolean result = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean hasDigit(String password) {
        boolean result = false;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean hasSpecial(String password) {
        boolean result = false;
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean hasSpecialSubString(String password) {
        boolean result = false;
        password = password.toLowerCase();
        for (String subString : FORBIDDEN) {
            if (password.contains(subString)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }

        if (password.length() > 32 ||  password.length() < 8) {
            throw new IllegalArgumentException(
                    "Password should be length [8, 32]"
            );
        }

        if (!hasUpCase(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter"
            );
        }
        if (!hasLowCase(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter"
            );
        }
        if (!hasDigit(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure"
            );
        }
        if (!hasSpecial(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (hasSpecialSubString(password)) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }
}
