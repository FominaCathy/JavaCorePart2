package gb.homework.TicTacGame;

import gb.homework.TicTacGame.Game.ConsoleUI;

public class Start {

    public static void main(String[] args) {
        int sizeField = 3;
        int winCount = 3;
        ConsoleUI.game(sizeField, winCount);

    }

}