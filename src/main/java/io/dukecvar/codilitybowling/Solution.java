package io.dukecvar.codilitybowling;

// you can also use imports, for example:
//import org.junit.Test;
//import org.junit.Assert;«

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

public class Solution {
//
//
//    class Bowling {
//
//        List<Frame> scoreCard = new ArrayList<>();
//        int frameCount = 0;
//
//        public void roll(int pins) {
//            // TODO
//            if(frameCount == 10 && scoreCard.get(frameCount).isComplete()) {
//                return;
//            }
//            Frame frame = null;
//            if(scoreCard.size() == frameCount) {
//                frame = new Frame();
//                scoreCard.add(frame);
//                frameCount++;
//            } else {
//                frame = scoreCard.get(frameCount - 1);
//            }
//
//            frame.setStrike();
//
//
//        }
//
//        public int score() {
//            int score = 0;
//
//            for(int i = 0; i < scoreCard.size(); i++) {
//                if(scoreCard.get(i).isSpare() && scoreCard.size() <= i + 1) {
//                    score += scoreCard.get(i+1).
//                }
//            }
//
//            return 6;
//        }
//
//        List<Frame> getScoreCard () {
//            return scoreCard;
//        }
//    }
//
//    @Test
//    public void testSingleRoll() {
//        Bowling b = new Bowling();
//        // b.roll(6);
//
//        b.roll(10);
//
//        Assert.assertTrue( b.getScoreCard().get(0).isStrike() ) ;
//
//        Assert.assertEquals(6, b.score());
//    }
//
//
//    @Test
//    public void testMultiRoll() {
//        Bowling b = new Bowling();
//        b.roll(6);
//        b.roll(3);
//        b.roll(5);
//
//        Assert.assertEquals(14, b.score());
//    }
//
//    @Test
//    public void spareRollPlusOne() {
//        Bowling b = new Bowling();
//        b.roll(6);
//        b.roll(4);
//        b.roll(4);
//
//        Assert.assertEquals(18, b.score());
//    }
//
//    @Test
//    public void strikeRollPlusTwo() {
//        Bowling b = new Bowling();
//        b.roll(10);
//        b.roll(4);
//        b.roll(4);
//
//        Assert.assertEquals(26, b.score());
//    }
//
//    @Test
//    public void testFrame() {
//        Frame f = new Frame();
//        Assert.assertFalse(f.isStrike());
//        Assert.assertFalse(f.isSpare());
//        Assert.assertFalse(f.isComplete());
//
//        f.setStrike();
//        Assert.assertTrue(f.isStrike());
//        Assert.assertFalse(f.isSpare());
//        Assert.assertTrue(f.isComplete());
//
//        // f = new Frame();
//        // Assert.assertFalse(f.isStrike());
//        // Assert.assertFalse(f.isSpare());
//        // Assert.assertFalse(f.isComplete());
//
//    }
//
//    class Frame {
//        private int first = -1;
//        private int second = -1 ;
//        private boolean isStrike = false;
//        private boolean isSpare = false;
//        private int score = 0;
//
//        void setStrike() {
//            isStrike = true;
//        }
//
//        boolean isStrike() {
//            return isStrike;
//        }
//
//        boolean isSpare() {
//            return isSpare;
//        }
//
//        void setSpare() {
//            isSpare = true;
//        }
//
//        void setFirstRoll(int roll) {
//            this.first = roll;
//        }
//
//        void setSecondRoll(int roll) {
//            this.second = roll;
//        }
//
//        int getScore() {
////            if()
//        }
//
//        boolean isComplete() {
//            return (isStrike || isSpare || !(first== -1 && second == -1) );
//        }
//    }
}