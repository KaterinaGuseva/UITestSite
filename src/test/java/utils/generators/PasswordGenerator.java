package utils.generators;

import utils.MyConfiguration;

import java.security.SecureRandom;

import static utils.Constants.*;

public class PasswordGenerator {

    private static String email = MyConfiguration.getEmail();

    private static SecureRandom random = new SecureRandom();

    public static String generatePassword() {
        StringBuilder result = new StringBuilder(PASSWORD_LENGTH);
        String strLowerCase = generateRandomString(CHAR_LOWERCASE, SIZE_LOWER_CASE);
        result.append(strLowerCase);

        String strUppercaseCase = generateRandomString(CHAR_UPPERCASE, SIZE_UPPER_CASE);
        result.append(strUppercaseCase);

        String strDigit = generateRandomString(DIGIT, SIZE_DIGIT);
        result.append(strDigit);

        result.append(email);

        return result.toString();
    }

    private static String generateRandomString(String input, int size) {

        if (input == null || input.length() <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        if (size < 1) {
            throw new IllegalArgumentException("Invalid size.");
        }
        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(input.length());
            result.append(input.charAt(index));
        }
        return result.toString();
    }
}
