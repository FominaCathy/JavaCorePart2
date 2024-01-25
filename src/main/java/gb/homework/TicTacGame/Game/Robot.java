package gb.homework.TicTacGame.Game;

import java.util.Random;


public class Robot {
    private final TicTacGame game;
    private int sizeField;
    private char empty;
    private int winCount;
    private Random random = new Random();

    public Robot(TicTacGame game) {
        this.game = game;
        this.sizeField = game.getSizeField();
        this.empty = game.getEmpty();
        this.winCount = TicTacGame.getWinCount();
    }

    /**
     * шаг робота. потом можно будет сделать выборку в зависисости от сложности
     *
     * @return
     */
    public int[] step(int level) {

        if (level == 0) {
            return stepEasy();
        }
        if (level == 1) {
            stepMedium();
        }
        return stepHard();
    }

    /**
     * рандомный выбор шага робота
     *
     * @return
     */
    private int[] stepEasy() {
        int rndX;
        int rndY;
        do {
            rndX = random.nextInt(sizeField);
            rndY = random.nextInt(sizeField);
        } while (game.getField()[rndX][rndY] != empty);

        return new int[]{rndX, rndY};

    }

    /**
     * робот не дает выиграть игроку
     *
     * @return
     */
    private int[] stepMedium() {

        //проверяет есть ли выигрышная ход для игрока и занимает эту клетку, если она есть
        int[] temp = searchWinStep(TicTacGame.getDotGamer());
        if ((temp[0] != -1) && (temp[1] != -1)) {
            return new int[]{temp[0], temp[1]};
        }

        return stepEasy();
    }

    /**
     * робот не дает выиграть и пытается сам победить (подбирает шаги для себя более выгодные)
     *
     * @return
     */
    private int[] stepHard() {
        //сначала проверяет есть ли выигрышные комбинации
        int[] temp = searchWinStep(TicTacGame.getDotRobot());
        if ((temp[0] != -1) && (temp[1] != -1)) {
            return new int[]{temp[0], temp[1]};
        }

        return stepMedium();
    }

    private int[] searchWinStep(char dot) {
        int[] temp = checkVertical(dot);
        if ((temp[0] != -1) && (temp[1] != -1)) {
            return new int[]{temp[0], temp[1]};
        }

        temp = checkHorizontal(dot);
        if ((temp[0] != -1) && (temp[1] != -1)) {
            return new int[]{temp[0], temp[1]};
        }

        temp = checkDiagonal(dot);
        if ((temp[0] != -1) && (temp[1] != -1)) {
            return new int[]{temp[0], temp[1]};
        }

//        temp = checkDiagonalReversed(dot);
//        if ((temp[0] != -1) && (temp[1] != -1)) {
//            return new int[]{temp[0], temp[1]};
//        }
//
        return checkDiagonalReversed(dot);
    }

    /**
     * поиск выигрышной комбинации на вертикалях
     *
     * @return координаты позиции, в которую нужно поставить фишку чтобы игрок не выиграл
     */
    private int[] checkVertical(char dot) {
        int shift = 0;
        int countDot = 0;
        int currX = -1;

        for (int j = 0; j < sizeField; j++) {
            shift = 0;
            while (shift <= sizeField - winCount) {
                currX = -1;
                for (int i = 0; i < winCount; i++) {
                    if (TicTacGame.getField()[shift + i][j] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[shift + i][j] == empty) {
                        currX = shift + i;
                    }
                }
                if ((countDot == winCount - 1) && (currX != -1)) {
                    return new int[]{currX, j};
                }
                countDot = 0;
                shift++;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * поиск выигрышной комбинации на горизонтали
     *
     * @return координаты позиции, в которую нужно поставить фишку чтобы игрок не выиграл
     */
    private int[] checkHorizontal(char dot) {
        int shift = 0;
        int countDot = 0;
        int currY = -1;

        for (int i = 0; i < sizeField; i++) {
            shift = 0;
            while (shift <= sizeField - winCount) {
                currY = -1;
                for (int j = 0; j < winCount; j++) {
                    if (TicTacGame.getField()[i][shift + j] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[i][shift + j] == empty) {
                        currY = shift + j;
                    }
                }
                if ((countDot == winCount - 1) && (currY != -1)) {
                    return new int[]{i, currY};
                }
                countDot = 0;
                shift++;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * поиск выигрышной комбинации на прямой диагонали
     *
     * @return координаты позиции, в которую нужно поставить фишку чтобы игрок не выиграл
     */
    private int[] checkDiagonal(char dot) {
        int shiftX = 0;
        int countDot = 0;
        int currX = -1;
        int currY = -1;
        // вниз
        for (int j = 0; j <= sizeField - winCount; j++) {
            shiftX = 0;
            while (shiftX <= sizeField - winCount - j) {
                for (int i = 0; i < winCount; i++) {
                    if (TicTacGame.getField()[shiftX + i + j][shiftX + i] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[shiftX + i + j][shiftX + i] == empty) {
                        currX = shiftX + i + j;
                        currY = shiftX + i;
                    }
                }
                if ((countDot == winCount - 1) && (currY != -1) && (currX != -1)) {
                    return new int[]{currX, currY};
                }
                countDot = 0;
                currX = -1;
                currY = -1;
                shiftX++;
            }
        }

        for (int j = 0; j <= sizeField - winCount; j++) {
            shiftX = 0;
            while (shiftX <= sizeField - winCount - j) {
                currX = -1;
                currY = -1;
                for (int i = 0; i < winCount; i++) {
                    if (TicTacGame.getField()[shiftX + i][shiftX + i + j] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[shiftX + i][shiftX + i + j] == empty) {
                        currX = shiftX + i;
                        currY = shiftX + i + j;
                    }
                }
                if ((countDot == winCount - 1) && (currY != -1) && (currX != -1)) {

                    return new int[]{currX, currY};
                }
                countDot = 0;
                shiftX++;
            }
        }


        return new int[]{-1, -1};
    }

    /**
     * поиск выигрышной комбинации по обратной диагонали
     *
     * @return координаты позиции, в которую нужно поставить фишку чтобы игрок не выиграл
     */
    private int[] checkDiagonalReversed(char dot) {
        int shiftX;
        int countDot = 0;
        int currX = -1;
        int currY = -1;

        for (int j = 0; j <= sizeField - winCount; j++) {
            shiftX = 0;

            while (shiftX <= sizeField - winCount - j) {
                for (int i = 0; i < winCount; i++) {
                    if (TicTacGame.getField()[shiftX + i + j][sizeField - 1 - i - shiftX] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[shiftX + i + j][sizeField - 1 - i - shiftX] == empty) {
                        currX = shiftX + i + j;
                        currY = sizeField - 1 - i - shiftX;
                    }

                }
                if (countDot == winCount - 1) {
                    return new int[]{currX, currY};
                }
                countDot = 0;
                currX = -1;
                currY = -1;
                shiftX++;
            }
        }

        for (int j = 0; j <= sizeField - winCount; j++) {
            shiftX = 0;
            while (shiftX <= sizeField - winCount - j) {
                currX = -1;
                currY = -1;
                for (int i = 0; i < winCount; i++) {
                    if (TicTacGame.getField()[shiftX + i][sizeField - 1 - i - j] == dot) {
                        countDot++;
                    } else if (TicTacGame.getField()[shiftX + i][sizeField - 1 - i - j] == empty) {
                        currX = shiftX + i;
                        currY = sizeField - 1 - i - j;
                    }
                }
                if (countDot == winCount - 1) {
                    return new int[]{currX, currY};
                }
                countDot = 0;
                shiftX++;
            }
        }
        return new int[]{-1, -1};
    }
}
