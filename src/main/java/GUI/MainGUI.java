package GUI;

import Logic.WordleGame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application { //наследование от класса, позволяющего работать с GUI
    private String textFontSize = "-fx-font-size: 12px;";
    private int attemptCount = 1; //переменная-счетчик попыток
    private int maxAttempts = 5;

    @Override
    public void start(Stage primaryStage) { //инстанс Stage - основа/шаблон/форма для отрисовки GUI
        WordleGame game = new WordleGame(5);

        VBox root = new VBox(10); //создание родителя с указанием отступов
        root.setStyle(textFontSize);
        GridPane attemptsInfo = new GridPane(); //элемент, позволяющий динамически добавлять элементы

        Label greetingsLabel = new Label(game.getGreetings()); //создание лейбла
        TextField userInput = new TextField();
        Label resultLabel = new Label();

        Button submitButton = new Button("Проверить введенное значение");

        submitButton.setOnAction(event -> {
            String userInputText = userInput.getText(); //получение пользовательского ввода
            boolean isCorrect = game.isCorrect(userInputText); //проверка введенного слова
            if (isCorrect) {
                resultLabel.setText(game.getCongratulations());
                userInput.setDisable(true); //отключение возможности ввода
                submitButton.setDisable(true); //отключение возможности нажатия на кнопку
                return;
            }
            Label attemptLabel = new Label();
            attemptLabel.setText("Попытка №" + attemptCount + ": " + game.getFeedback(userInputText));
            attemptsInfo.add(attemptLabel, 0, attemptCount);
            userInput.clear();
            if (attemptCount == maxAttempts) {
                resultLabel.setText(game.getFailMessage());
                userInput.setDisable(true);
                submitButton.setDisable(true);
                return;
            }
            attemptCount++;
        });

        root.getChildren().addAll(greetingsLabel, userInput, attemptsInfo, submitButton, resultLabel); //помещение элементов на форму (добавление в список дочерних элементов формы)
        Scene scene = new Scene(root, 450, 250); //создание окна размером 400х300
        primaryStage.setScene(scene); //создание сцены на форме
        primaryStage.show(); //отображение сцены (формы)
    }

    public static void main(String[] args) { //метод запуска графического приложения
        launch(args); //метод из пакета javafx, инициирующий формирование сцены и вызывающая метод start,
        //в параметры передаются параметры метода main
    }
}