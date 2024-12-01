import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String secretWord = "Марик".toLowerCase();

        System.out.println("Добро пожаловать в MyWordle!\n" +
                "У вас будет 5 попыток на отгадывание секретного слова, состоящего из 5-и букв");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Попытка №1: ");
        String userInput = scanner.nextLine().toLowerCase();
        if (secretWord.equals(userInput)) {
            System.out.println("Поздравляю! Секретное слово отгадано!");
        } else {
            System.out.println("Вы проиграли. Секретное слово: \"" + secretWord + "\"");
        }
    }
}