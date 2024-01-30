package gb.homework.TicTacGame;

import gb.homework.TicTacGame.Game.TicTacGame;
import org.junit.jupiter.api.BeforeAll;

public class AbstractTest {
    static TicTacGame game;

    @BeforeAll
    static void init(){
        game = new TicTacGame(3, 3);

    }
}
