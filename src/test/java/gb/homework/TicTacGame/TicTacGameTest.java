package gb.homework.TicTacGame;

import gb.homework.TicTacGame.Game.TicTacGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TicTacGameTest {

   // проверить checkWin
    @Test
    void test1(){
        TicTacGame game = new TicTacGame(4, 3);
        game.startGame();
        game.stepGame(0,0, 'X');
        game.stepGame(1,1, 'X');
        game.stepGame(2,2, 'X');

        assertTrue(game.checkWin('X'));

    }

}
