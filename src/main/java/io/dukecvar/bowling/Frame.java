package io.dukecvar.bowling;

import java.util.ArrayList;

public abstract class Frame {
    protected ArrayList<Integer> rolls = new ArrayList<>();
    protected int score = -100;
    protected Frame previousFrame = null;
    protected Frame nextFrame = null;
    protected int frameNumber;

    protected int pinsRemaining = 10;

    public abstract void roll(int pins);
    protected abstract boolean updateScore();
    abstract protected boolean isComplete();

    public boolean isTenth() { return frameNumber == 10; }

    public static Frame getNewFrame(Frame previousFrame) {
        if(previousFrame == null || previousFrame.getFrameNumber() < 9) {
            return new NormalFrame(previousFrame);
        } else if (previousFrame.getFrameNumber() == 9) {
            return new TenthFrame(previousFrame);
        } else {
            throw new BowlingException("Game over");
        }
    }

    protected Frame(Frame previousFrame) {
        if (previousFrame == null) {
            frameNumber = 1;
        } else {
            this.previousFrame = previousFrame;
            frameNumber = previousFrame.getFrameNumber() + 1;
            previousFrame.setNextFrame(this);
        }

    }

    protected void setNextFrame(Frame frame) {
        nextFrame = frame;
    }

    protected Frame getNextFrame(){
        return nextFrame;
    }

    public Frame getPreviousFrame() {
        return previousFrame;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public int getPinsRemaining() {
        return pinsRemaining;
    }


    // this is a running score for the game as it's played
    // It only reflects the score of this frames roll score after
    // it's complete and all spares & strike extra points have been assigned
    // otherwise, it returns the previous frames score
    public int getScore() {
        return (score >= 0 ? score :
                (previousFrame==null ? 0 : previousFrame.getScore()));
    }

    protected boolean isStrike() {
        return (rolls.size() == 1 && rolls.get(0) == 10);
    }

    protected boolean isSpare() {
        return (rolls.size() == 2 && (rolls.get(0) + rolls.get(1) == 10) );
    }



    protected int getBonusPoints(int numberOfRolls) {
        if (numberOfRolls == 1) {
            if(rolls.size() >= 1) {
                return rolls.get(0);
            } else {
                return -100;
            }
        } else if (numberOfRolls == 2) {
            if (rolls.size() == 2) {
                return rolls.get(0) + rolls.get(1);
            } else if (rolls.size() == 1 && nextFrame != null && nextFrame.getBonusPoints(1) > -1) {
                return rolls.get(0) + nextFrame.getBonusPoints(1);
            } else {
                return -100;
            }
        } else {
            return -100;
        }
    }

    protected String getRollScore(int rollIndex) {
        return (rollIndex < rolls.size() ? Integer.toString(rolls.get(rollIndex)) : "");
    }

    public String toString() {
        return "{"
                + "\"frame\":" + frameNumber
                + ", \"role1\":\"" + getRollScore(0) + "\""
                + ", \"role2\":\"" + getRollScore(1) + "\""
                + (frameNumber == 10 ? ", \"role3\":\"" + getRollScore(2)  + "\"": "")
                + ", \"score\":\"" + (score<0?"(" + getScore() + ")":getScore()) + "\""
                + "}";
    }
}
