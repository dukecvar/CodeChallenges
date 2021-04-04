package io.dukecvar.bowling;

public class NormalFrame extends Frame {

    protected NormalFrame(Frame previousFrame) {
        super(previousFrame);
    }

    public void roll(int pins) {
        if ( (rolls.size() == 1 && rolls.get(0) == 10) || rolls.size() == 2 ) {
            throw new BowlingException("Frame complete");
        }
        rolls.add(pins);
        updateScore();
        pinsRemaining -= pins;
    }

    public boolean isComplete() {
        return isStrike() || rolls.size() == 2;
    }

    protected boolean updateScore() {
        if ( score >= 0 ) {
            return true;
        } else if (previousFrame == null || previousFrame.updateScore()) {
            if (isStrike() && nextFrame != null) {
                int next2 = nextFrame.getBonusPoints(2);
                if (next2 >= 0) {
                    score = rolls.get(0) + next2 + (previousFrame == null ? 0 : previousFrame.getScore());
                    return true;
                }
            } else if (isSpare() && nextFrame != null) {
                int next1 = nextFrame.getBonusPoints(1);
                if (next1 >= 0) {
                    score = rolls.get(0) + rolls.get(1) + next1 + (previousFrame == null ? 0 : previousFrame.getScore());
                    return true;
                }
            } else if(rolls.size() == 2 && rolls.get(0) + rolls.get(1) < 10) {
                score = rolls.get(0) + rolls.get(1) + (previousFrame == null ? 0 : previousFrame.getScore());
                return true;
            }
        }
        return false;
    }
}
