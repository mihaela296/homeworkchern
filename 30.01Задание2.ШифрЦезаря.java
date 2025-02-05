import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class CaesarCipher {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int ALPHABET_SIZE = ALPHABET.length();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим работы:");
        System.out.println("1. Шифрование текста");
        System.out.println("2. Расшифровка текста с известным ключом");
        System.out.println("3. Расшифровка методом brute force");
        System.out.println("4. Выход");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Введите путь к файлу с оригинальным текстом: ");
                String inputFilePath = scanner.nextLine();
                System.out.print("Введите путь к файлу для записи зашифрованного текста: ");
                String outputFilePath = scanner.nextLine();
                System.out.print("Введите ключ (сдвиг): ");
                int shift = scanner.nextInt();
                encryptFile(inputFilePath, outputFilePath, shift);
                break;
            case 2:
                System.out.print("Введите путь к зашифрованному файлу: ");
                String encryptedFilePath = scanner.nextLine();
                System.out.print("Введите путь к файлу для записи расшифрованного текста: ");
                String decryptedOutputFilePath = scanner.nextLine();
                System.out.print("Введите ключ (сдвиг): ");
                int decryptShift = scanner.nextInt();
                decryptFile(encryptedFilePath, decryptedOutputFilePath, decryptShift);
                break;
            case 3:
                System.out.print("Введите путь к зашифрованному файлу: ");
                String bruteForceFilePath = scanner.nextLine();
                bruteForceDecrypt(bruteForceFilePath);
                break;
            case 4:
                System.out.println("Выход из программы.");
                break;
            default:
                System.out.println("Неверный выбор.");
        }

        scanner.close();
    }

    private static void encryptFile(String inputFilePath, String outputFilePath, int shift) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            String encryptedContent = shiftText(content, shift);
            Files.write(Paths.get(outputFilePath), encryptedContent.getBytes());
            System.out.println("Шифрование завершено. Результат записан в файл: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void decryptFile(String inputFilePath, String outputFilePath, int shift) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            String decryptedContent = shiftText(content, -shift);
            Files.write(Paths.get(outputFilePath), decryptedContent.getBytes());
            System.out.println("Расшифровка завершена. Результат записан в файл: " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static String shiftText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % ALPHABET_SIZE; // Убедимся, что сдвиг в пределах алфавита

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                int originalPosition = character - base;
                int newPosition = (originalPosition + shift + ALPHABET_SIZE) % ALPHABET_SIZE;
                result.append((char) (base + newPosition));
            } else {
                result.append(character); // Не изменяем не буквенные символы
            }
        }
        return result.toString();
    }

    private static void bruteForceDecrypt(String inputFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFilePath)));
            for (int shift = 1; shift < ALPHABET_SIZE; shift++) {
                String decryptedContent = shiftText(content, -shift);
                System.out.println("Ключ: " + shift + ", Расшифрованный текст: " + decryptedContent);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}