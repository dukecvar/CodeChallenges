package io.dukecvar.bowling;

public class TenthFrame extends Frame {

    protected TenthFrame(Frame previousFrame) {
        super(previousFrame);
    }

    public void roll(int pins) {
        if ( (rolls.size() == 2 && (rolls.get(0) + rolls.get(1) < 10))
                || rolls.size() == 3) {
            throw new BowlingException("Frame complete");
        }
        rolls.add(pins);
        updateScore();

        if (rolls.size() == 1) {
            if( rolls.get(0) == 10 ) {
                pinsRemaining = 10;
            } else {
                pinsRemaining -= pins;
            }
        } else if (rolls.size() == 2 ) {
            if (rolls.get(0) == 10 && rolls.get(1) != 10) {
                pinsRemaining = 10 - pins;
            } else if (rolls.get(0) + rolls.get(1) == 10 || rolls.get(1) == 10) {
                pinsRemaining = 10;
            }
        }
    }

    protected boolean isComplete() {
        return rolls.size() == 3 || (rolls.size() == 2 && (rolls.get(0) + rolls.get(1) < 10));
    }

    protected boolean updateScore() {
        if ( score >= 0 ) {
            return true;
        } else if (previousFrame.updateScore() && isComplete()) {
            score = rolls.get(0) + rolls.get(1) + (rolls.size()==3 ? rolls.get(2) : 0) + previousFrame.getScore();
            return true;
        } else {
            return false;
        }
    }

    public int getBonusPoints(int numberOfRolls) {
        if (numberOfRolls == 1) {
            return super.getBonusPoints(numberOfRolls);
        } else if (numberOfRolls == 2 && rolls.size() >= 2) {
            return rolls.get(0) + rolls.get(1);
        } else {
            return -100;
        }
    }

}
