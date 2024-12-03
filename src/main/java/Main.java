import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secretWord = getRandomSecretWord().toLowerCase();
        int maxAttempts = 5;

        System.out.println("Добро пожаловать в MyWordle!\nУ Вас будет " + maxAttempts +
                " попыток на отгадывание секретного слова, состоящего из " + secretWord.length() + " букв");
        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Попытка №" + attempt + ": ");
            String userInput = scanner.nextLine().toLowerCase();
            if (secretWord.equals(userInput)) {
                System.out.println("Поздравляю! Секретное слово отгадано!");
                return; //завершение программы при отгадывании слова
            } else {
                System.out.println("Подсказка: " + getFeedback(secretWord, userInput));
            }
        }
        System.out.println("Вы проиграли. Секретное слово: \"" + secretWord + "\"");
    }

    private static String getFeedback(String secretWord, String playersWord) {
        if (secretWord.length() != playersWord.length()) {
            return "Пожалуйста, введите слово из " + secretWord.length() + " букв";
        }
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char currentSymbol = playersWord.charAt(i);
            if (secretWord.charAt(i) == currentSymbol) {
                feedback.append(currentSymbol);
            } else if (secretWord.contains(String.valueOf(currentSymbol))) {
                feedback.append("?");
            } else {
                feedback.append("_");
            }
        }
        return feedback.toString();
    }

    private static String getRandomSecretWord() {
        List<String> dictionary = List.of("Актёр", "Башня", "Васик", "Гладь",
                "Денис", "Егерь", "Ёршик", "Жираф",
                "Закат", "Индюк", "Йемен", "Ковер",
                "Лапти", "Марик", "Налет", "Отчет",
                "Петух", "Ручка", "Строка", "Талия",
                "Учеба", "Флора", "Хомяк", "Цапля",
                "Чешки", "Шатер", "Щепка", "Эгида",
                "Юнона", "Ягода");
        return dictionary.get(new Random().nextInt(dictionary.size()));
    }
}