package Logic;

import java.util.List;
import java.util.Random;

public class WordleGame {
    private String secretWord;
    private int maxAttempts;

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public WordleGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.secretWord = getRandomSecretWord();
    }

    public String getGreetings() {
        return "Добро пожаловать в MyWordle!\nУ Вас будет " + maxAttempts +
                " попыток на отгадывание секретного слова, состоящего из " + secretWord.length() + " букв";
    }

    public static String getRandomSecretWord() {
        List<String> dictionary = List.of("Актёр", "Башня", "Васик", "Гладь",
                "Денис", "Егерь", "Ёршик", "Жираф",
                "Закат", "Индюк", "Йемен", "Ковер",
                "Лапти", "Марик", "Налет", "Отчет",
                "Петух", "Ручка", "Салон", "Талия",
                "Учеба", "Флора", "Хомяк", "Цапля",
                "Чешки", "Шатер", "Щепка", "Эгида",
                "Юнона", "Ягода");
        return dictionary.get(new Random().nextInt(dictionary.size())).toLowerCase();
    }

    public boolean isCorrect(String playersWord) {
        return secretWord.equals(playersWord);
    }

    public String getFeedback(String playersWord) {
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
        return feedback.append(" (введенное слово: ").append(playersWord).append(")").toString();
    }

    public String getCongratulations() {
        return "Поздравляю! Секретное слово отгадано!";
    }

    public String getFailMessage() {
        return "Вы проиграли. Секретное слово: \"" + secretWord + "\"";
    }
}