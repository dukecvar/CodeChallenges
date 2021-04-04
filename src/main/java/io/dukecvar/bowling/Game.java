package io.dukecvar.bowling;

public class Game {
    Frame firstFrame;
    Frame currentFrame;

    public Game() {
        firstFrame = Frame.getNewFrame(null);
        currentFrame = firstFrame;
    }

    public Frame getCurrentFrame() {
        return currentFrame;
    }

    public int getScore() {
        return currentFrame.getScore();
    }

    public boolean isGameOver() {
        return currentFrame.isTenth() && currentFrame.isComplete();
    }

    public void roll(int pins) {
       currentFrame.roll(pins);
        if(!isGameOver() && currentFrame.isComplete()) {
            currentFrame = Frame.getNewFrame(currentFrame);
        }
    }

    public int getMaxPinsForNextRoll() {
        if( isGameOver() ) {
            return 0;
//        } else if( currentFrame.isComplete() ) {
//            return 10;
        } else {
            return currentFrame.getPinsRemaining();
        }
    }

    public String toString() {
        Frame frame = firstFrame;
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while(frame != null) {
            sb.append( (first?"":",") + frame.toString() + "\n");
            frame = frame.getNextFrame();
            first = false;
        }
        return "{\"game\":[\n" + sb.toString() + "]";
    }
}
