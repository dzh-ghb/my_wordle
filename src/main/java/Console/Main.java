package Console;

import Logic.WordleGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WordleGame game = new WordleGame(5);

        System.out.println(game.getGreetings());
        Scanner scanner = new Scanner(System.in);
        for (int attempt = 1; attempt <= game.getMaxAttempts(); attempt++) {
            System.out.print("Попытка №" + attempt + ": ");
            String userInput = scanner.nextLine().toLowerCase();

            if (game.isCorrect(userInput)) {
                System.out.println(game.getCongratulations());
                return; //завершение программы при отгадывании слова
            } else {
                System.out.println(game.getFeedback(userInput));
            }
        }
        System.out.println(game.getFailMessage());
    }
}