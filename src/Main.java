public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses) {
        int count = 0;

        for (char ch : parentheses.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int number) {
        StringBuilder reversed = new StringBuilder();

        while (number != 0) {
            int digit = number % 10;
            reversed.append(digit);
            number /= 10;
        }

        return reversed.toString();
    }

    // 3. encryptThis
    public static String encryptThis(String message) {
        StringBuilder encrypted = new StringBuilder();

        String[] words = message.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if(word.length()>2) {
                char firstChar = word.charAt(0);
                char secondChar = word.charAt(word.length() - 1);
                String middleChars = word.substring(2, word.length() - 1);
                char lastChars = word.charAt(1);
                int charCode = (int) firstChar;

                encrypted.append(charCode).append(secondChar).append(middleChars).append(lastChars);

                if (i != words.length - 1) {
                    encrypted.append(" ");
                }
            }
            else{
                int firstChar = word.charAt(0);
                char secondChar = word.charAt(word.length() - 1);
                int charCode = (int) firstChar;

                encrypted.append(charCode).append(secondChar);
            }

        }

        return encrypted.toString();
    }

    // 4. decipherThis
    public static String decipherThis(String encryptedMessage) {
        StringBuilder unencrypted = new StringBuilder();
        String[] codes = encryptedMessage.split(" ");
        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            int number = Integer.parseInt(code.replaceAll("\\D", ""));
            String letters = code.replaceAll("\\d", "");
            char firstChar = (char) number;
            if (letters.length() > 1) {
                char secondChar = letters.charAt(letters.length() - 1);
                char thirdChar = letters.charAt(0);
                String rest = letters.substring(1, letters.length() - 1);
                unencrypted.append(firstChar).append(secondChar).append(rest).append(thirdChar);
            } else {
                unencrypted.append(firstChar).append(letters);
            }
            unencrypted.append(" ");
        }
        if (unencrypted.length() > 0) {
            unencrypted.deleteCharAt(unencrypted.length() - 1);
        }
        return unencrypted.toString();
    }
}