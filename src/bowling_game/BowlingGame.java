package bowling_game;

public class BowlingGame {

    //we don't know wow many rolls there will be, but no more than 21 (up to 2 per frame for 9 first frames
    //and max 3 for frame 10)
    private final int[] rolls = new int[21];
    int currentRoll = 0;
    int numberOfFrames = 10;

    public void executeRoll(int pins) {
        //assigns number of pins knocked down in current roll
        rolls[currentRoll++] = pins;
    }

    public int calculateScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < numberOfFrames; frameIndex++) {

            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += rolls[rollIndex] + rolls[rollIndex + 1];
                rollIndex += 2;
            }
        }
        return score;
    }
    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }
}
