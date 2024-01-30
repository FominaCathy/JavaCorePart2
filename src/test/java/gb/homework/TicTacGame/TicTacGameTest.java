package gb.homework.TicTacGame;

import gb.homework.TicTacGame.Game.TicTacGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TicTacGameTest extends AbstractTest {

    @BeforeEach
    void initGame() {
        game.startGame();
    }

    // проверить checkWin

    @ParameterizedTest
    @MethodSource("listDataValid")
    void checkWin(int[] firstCoord, int[] secondCoord) {

        for (int i = 0; i < firstCoord.length; i++) {
            game.stepGame(firstCoord[i], secondCoord[i], 'X');
        }

        assertTrue(game.checkWin('X'));
    }

    @ParameterizedTest
    @MethodSource("listDataInValid")
    void checkNotWin(int[] firstCoord, int[] secondCoord) {

        for (int i = 0; i < firstCoord.length; i++) {
            game.stepGame(firstCoord[i], secondCoord[i], 'X');
        }

        game.printField();

        assertFalse(game.checkWin('X'));
    }


    static Stream<Arguments> listDataInValid() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2}, new int[]{0, 1, 2, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{0, 0}),
                Arguments.of(new int[]{0, 1, 2}, new int[]{1, 1, 2})
        );
    }

    static Stream<Arguments> listDataValid() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 0}, new int[]{0, 1, 2}),
                Arguments.of(new int[]{0, 1, 2}, new int[]{0, 0, 0}),
                Arguments.of(new int[]{0, 1, 2}, new int[]{0, 1, 2}),
                Arguments.of(new int[]{0, 1, 2}, new int[]{2, 1, 0})
        );
    }


}
