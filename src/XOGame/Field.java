package XOGame;

import java.util.Arrays;

public class Field {

    private final int fieldSizeX;
    private final int fieldSizeY;
    public char[][] field;

    public Field(int fieldSizeX, int fieldSizeY) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        field = new char[fieldSizeX][fieldSizeY];
    }

    public int getFieldSizeX() {
        return fieldSizeX;
    }

    public int getFieldSizeY() {
        return fieldSizeY;
    }

    public void setXY(int x, int y, char symbol) {
        field[x][y] = symbol;
    }

    public char getXY(int x, int y) {
        return field[x][y];
    }

    public void initField() {

        for (char[] row : field) {
            Arrays.fill(row, ConstantList.DOT_EMPTY);
        }
    }

    public void drawField() {


        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++){
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++){
            System.out.print(i + 1 + "|");

            for (int j = 0; j <  fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++){
            System.out.print("-");
        }
        System.out.println();
    }


}
