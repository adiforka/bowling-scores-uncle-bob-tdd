package bowling_game_test;

import bowling_game.BowlingGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {

    BowlingGame game;

    @BeforeEach
    void setUp() {
        game = new BowlingGame();
    }

    @Test
    void testGutterGame() {
        //given
        rollMany(20, 0);
        //when
        int actualScore = game.calculateScore();
        //then
        assertEquals(0, actualScore);
    }

    @Test
    void testAllOnes() {
        //given
        rollMany(20, 1);
        //when
        int score = game.calculateScore();
        //then
        assertEquals(20, score);
    }

    @Test
    void testOneSpare() {
        //given
        rollSpare();
        game.executeRoll(3);
        rollMany(17, 0);

        //when
        int actualScore = game.calculateScore();

        //then
        assertEquals(16, actualScore);
    }

    @Test
    void testOneStrike() {
        //given
        game.executeRoll(10);
        game.executeRoll(3);
        game.executeRoll(7);
        rollMany(17, 0);

        //when
        int actualScore = game.calculateScore();

        //then
        assertEquals(30, actualScore);
    }

    @Test
    void testTwoStrikes() {
        //given
        game.executeRoll(10);
        game.executeRoll(3);
        game.executeRoll(4);
        game.executeRoll(10);
        game.executeRoll(2);
        rollMany(15, 0);

        //when
        int score = game.calculateScore();

        //then
        assertEquals(38, score);
    }

    @Test
    void testPerfectGame() {
        //given
        rollMany(12, 10);

        //when
        int score = game.calculateScore();

        //then
        assertEquals(300, score);
    }


    //private helper methods to make tests cleared
    private void rollMany(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
           game.executeRoll(pins);
        }
    }

    private void rollSpare() {
        game.executeRoll(5);
        game.executeRoll(5);
    }

    private void rollStrike() {
        game.executeRoll(10);
    }
}