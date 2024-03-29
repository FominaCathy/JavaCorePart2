package gb.homework.TicTacGame.Game;


/**
 * игра крестики-нолики. минимальный размер поля = 3 минимальное кол-во фишек для победы = 3
 */
public class TicTacGame {
    private static char dotGamer = 'X';
    private static char dotRobot = 'O';
    private static char empty = '*';
    private int sizeField;
    private int winCount;
    private int lastXGamer;
    private int lastYGamer;


    private char[][] field;

    public TicTacGame(int sizeField, int winCount) {
        this.sizeField = Math.max(sizeField, 3);
        this.winCount = Math.min(Math.max(winCount, 3), Math.max(sizeField, 3));
        field = new char[this.sizeField][this.sizeField];
    }

    public boolean stepGame(int i, int j, char dot) {
        if ((i < this.sizeField) && (j < this.sizeField) && (field[i][j] == empty)) {
            this.field[i][j] = dot;
            lastXGamer = i;
            lastYGamer = j;
            return true;
        }
        return false;
    }

    public void startGame() {
        for (int i = 0; i < sizeField; i++) {
            for (int j = 0; j < sizeField; j++) {
                field[i][j] = empty;
            }
        }
    }


    public void printField() {
        System.out.print("\t" + "- ");
        for (int j = 0; j < sizeField; j++) {
            System.out.print((j + 1) + "\t" + "- ");
        }
        System.out.println();
        for (int i = 0; i < sizeField; i++) {
            System.out.print((i + 1) + "\t" + "|");
            for (int j = 0; j < sizeField; j++) {
                System.out.print(" " + field[i][j] + " |");
            }
            System.out.println();
        }
    }

    /**
     * проверка выигрыша игрока
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    public boolean checkWin(char dot) {

        return checkVertical(dot) || (checkHorizontal(dot)) ||
                (checkDiagonal(dot)) || (checkDiagonalReversed(dot));
    }


    /**
     * проверка выигрышной комбинации по вертикали с использованием скользящего окна
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    private boolean checkVertical(char dot) {
        int shift = Math.max((lastXGamer - winCount + 1), 0);
        int countDot = 0;
        //
        while ((shift + winCount <= sizeField) && (shift <= lastXGamer)) {
            for (int i = 0; i < winCount; i++) {
                if (field[shift + i][lastYGamer] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shift++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по горизонтали с использованием скользящего окна
     *
     * @param dot - фишка игрока
     * @return да или нет
     */
    private boolean checkHorizontal(char dot) {
        int shift = Math.max((lastYGamer - winCount + 1), 0);
        ;
        int countDot = 0;
        //
        while ((shift + winCount <= sizeField) && (shift <= lastYGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[lastXGamer][shift + j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shift++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по диагонали
     *
     * @param dot фишка игрока
     * @return да или нет
     */
    private boolean checkDiagonal(char dot) {

        int shift = Math.min(winCount - 1, Math.min(lastXGamer, lastYGamer));
        int shiftX = lastXGamer - shift;
        int shiftY = lastYGamer - shift;
        int countDot = 0;

        while ((shiftX + winCount <= sizeField) && (shiftY + winCount <= sizeField) && (shiftX <= lastXGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[shiftX + j][shiftY + j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shiftX++;
            shiftY++;
        }
        return false;
    }

    /**
     * проверка выигрышной комбинации по обратной диагонали
     *
     * @param dot фишка игрока
     * @return да или нет
     */
    private boolean checkDiagonalReversed(char dot) {

        int shift = Math.min(winCount - 1, Math.min(lastXGamer, sizeField - 1 - lastYGamer));
        int shiftX = lastXGamer - shift;
        int shiftY = lastYGamer + shift;
        int countDot = 0;

        while ((shiftX + winCount <= sizeField) && (shiftY - winCount + 1 >= 0) && (shiftX <= lastXGamer)) {
            for (int j = 0; j < winCount; j++) {
                if (field[shiftX + j][shiftY - j] == dot) {
                    countDot++;
                }
            }
            if (countDot == winCount) {
                return true;
            }
            countDot = 0;
            shiftX++;
            shiftY--;
        }
        return false;
    }

    public char getEmpty() {
        return empty;
    }

    public int getSizeField() {
        return sizeField;
    }

    public char[][] getField() {
        return field;
    }

    public static char getDotGamer() {
        return dotGamer;
    }

    public static char getDotRobot() {
        return dotRobot;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLastXGamer() {
        return lastXGamer;
    }

    public int getLastYGamer() {
        return lastYGamer;
    }
}
