package hw4;

public class Main {
    private final static int HEIGHT = 4;
    private final static int WIDTH = 4;

    public static void main(String[] args) {

        String[][] input1 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        String[][] input2 = {{"1", "2", "3", "a"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        String[][] input3 = {{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};

        try {
            System.out.println(convertToInt(input1));
            System.out.println(convertToInt(input2));
            System.out.println(convertToInt(input3));
        } catch (MyArrayDataException | MyArraySizeException e ) {
            e.printStackTrace();
        }
    }

    public static int convertToInt(String[][] array) throws MyArrayDataException, MyArraySizeException {

        if (array.length != HEIGHT || array[0].length != WIDTH) {
            throw new MyArraySizeException("Ошибка! Задан неверный размер массива");
        }

        int result = 0;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Ошибка! В ячейке [%s][%s]", i, j));
                }
            }
        }

        return result;
    }

    private static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    private static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }


}
