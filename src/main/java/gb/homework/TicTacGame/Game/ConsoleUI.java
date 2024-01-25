package gb.homework.TicTacGame.Game;

import java.util.Scanner;


public class ConsoleUI {
    static Scanner scanner = new Scanner(System.in);

    /**
     * игра крестики - нолики
     *
     * @param sizeField - размер игрового поля
     * @param winCount  - число фишек для победы
     */
    public static void game(int sizeField, int winCount) {

        boolean stop = false;
        TicTacGame game = new TicTacGame(sizeField, winCount);
        Robot robot = new Robot(game);
        int countStep = 0;
        int maxStep = TicTacGame.getSizeField() * TicTacGame.getSizeField();

        while (!stop) {
            int level = choiceLevel();
            game.startGame();
            boolean finish = false;
            game.printField();

            while ((!finish) && (countStep < maxStep)) {
                stepGamer();
                countStep++;

                if (game.checkWin(TicTacGame.getDotGamer())) {
                    System.out.println("Ура! вы победили");
                    finish = true;
                } else if (countStep < maxStep) {
                    stepRobot(robot, level);
                    countStep++;
                    if (game.checkWin(TicTacGame.getDotRobot())) {
                        System.out.println("Победил робот");
                        finish = true;
                    }
                }
                if (countStep == maxStep) {
                    System.out.println("Ничья. Игра окончена");
                    finish = true;
                }
                game.printField();
            }
            if (!nextGame()) {
                stop = true;
            }
            countStep = 0;
        }
        System.out.println("Пока!");
    }

    /**
     * шаг игрока
     */
    private static void stepGamer() {
        boolean flag = false;
        System.out.println("ваш ход (введите номер строки и столбца через пробел):");
        while (!flag) {

            String step = scanner.nextLine();
            if (step.matches("[0-9+]\\s[0-9+]")) {
                int i = Integer.parseInt(step.split(" ")[0]);
                int j = Integer.parseInt(step.split(" ")[1]);
                flag = TicTacGame.stepGame(i - 1, j - 1, TicTacGame.getDotGamer());
            }
            if (!flag) {
                System.out.println("ошибка. поробуйте еще раз");
            }
        }
    }

    /**
     * шаг робота
     *
     * @param robot
     */
    private static void stepRobot(Robot robot, int level) {
        //TODO добавить уровень сложности
        int[] coord = robot.step(level);
        TicTacGame.stepGame(coord[0], coord[1], TicTacGame.getDotRobot());
    }

    /**
     * запрос у ирока будет ли он игратть следующий раунд
     *
     * @return
     */
    private static boolean nextGame() {
        System.out.println("Сыграем еще раз? Да: укажи Y, y, Д, д. Нет: любой другой символ");
        String step = scanner.nextLine();
        if (step.matches("[YyДд]")) {
            return true;
        }
        return false;
    }

    private static int choiceLevel() {
        int level = -1;
        while (level == -1) {
            System.out.println("выберете уровень сложности: \n0 - (простой) \n1 - (средний) \n2 - (сложный)");
            String levelStr = scanner.nextLine();
            if (levelStr.matches("[0-2]")) {
                level = Integer.parseInt(levelStr);
            }
        }
        return level;
    }
}
