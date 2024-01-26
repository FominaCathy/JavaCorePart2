package gb.homework.TicTacGame;

import gb.homework.TicTacGame.Game.Robot;
import gb.homework.TicTacGame.Game.TicTacGame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


@ExtendWith(MockitoExtension.class)
public class RobotTest {
    @Test
    void test() {
        TicTacGame game = Mockito.spy(new TicTacGame(3, 3));

        Robot robot = new Robot(game);
        char[][] testField = {{'X', '*', 'O'}, {'X', '*', 'O'}, {'*', '*', '*'}};

        Mockito.when(game.getField()).thenReturn(testField);


        assertArrayEquals(new int[]{2, 0}, robot.step(1));

        assertArrayEquals(new int[]{2, 2}, robot.step(2));

    }


}
