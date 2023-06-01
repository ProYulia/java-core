package XOGame;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();
    private final Field field;
    private int cellsToWin;

    public Game(Field field) {
        this.field = field;
        cellsToWin = field.getFieldSizeX();
    }

    public void setCellsToWin(int cellsToWin) {
        this.cellsToWin = cellsToWin;
    }

    public void startGame() {

        while (true){
            humanTurn();
            field.drawField();
            if (gameCheck(ConstantList.DOT_HUMAN, "Вы победили!"))
                break;
            aiTurn();
            field.drawField();
            if (gameCheck(ConstantList.DOT_AI, "Компьютер победил!"))
                break;
        }
    }

    private void humanTurn(){
        int x, y;
        do
        {
            System.out.print("Введите координаты хода Y и X через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field.setXY(x, y, ConstantList.DOT_HUMAN);
    }

    private boolean isCellEmpty(int x, int y){
        return field.getXY(x, y) == ConstantList.DOT_EMPTY;
    }
    private boolean isCellValid(int x, int y){
        return x >= 0 &&  x < field.getFieldSizeY() && y >= 0 && y < field.getFieldSizeY();
    }
    private void aiTurn(){
        int x, y;
        do
        {
            x = random.nextInt(field.getFieldSizeX());
            y = random.nextInt(field.getFieldSizeY());
        }
        while (!isCellEmpty(x, y));
        field.setXY(x, y, ConstantList.DOT_AI);
    }
    
    private boolean checkWin(char c){
        // Проверка по горизонталям
        int row  = 0;

        for (int i = 0; i < field.getFieldSizeY(); i++) {
            for (int j = 0; j < field.getFieldSizeX(); j++) {
                if (field.getXY(i, j) == c) row++;
            }
            if (row == cellsToWin) return true;
            row = 0;
        }

        // Проверка по диагоналям
        for (int i = 0; i < field.getFieldSizeX(); i++) {
            if (field.getXY(i, i) == c) row++;
        }

        if (row == cellsToWin) return true;
        row = 0;

        for (int i = 0; i < field.getFieldSizeX(); i++) {
            if (field.getXY(field.getFieldSizeX() - i - 1, i) == c) row++;
        }

        // Проверка по вертикалям
        if (row == cellsToWin) return true;
        row = 0;

        for (int i = 0; i < field.getFieldSizeX(); i++) {
            for (int j = 0; j < field.getFieldSizeY(); j++) {
                if (field.getXY(j, i) == c) row++;
            }
            if (row == cellsToWin) return true;
            row = 0;
        }
        return false;
    }


    private boolean checkDraw(){
        for (int x = 0; x < field.getFieldSizeX(); x++){
            for (int y = 0; y < field.getFieldSizeY(); y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    private boolean gameCheck(char c, String str){
        if (checkWin(c)){
            System.out.println(str);
            return true;
        }
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }
}
