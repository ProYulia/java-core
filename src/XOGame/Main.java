package XOGame;

public class Main {

    public static void main(String[] args) {

        Field field = new Field(5, 5);
        Game game = new Game(field);
        // условие для победы (по умолчанию - длина поля)
        game.setCellsToWin(4);

        field.initField();
        field.drawField();
        game.startGame();

    }
}
