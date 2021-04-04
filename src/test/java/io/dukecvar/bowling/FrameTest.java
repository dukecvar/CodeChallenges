package io.dukecvar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FrameTest {

    @Test
    void constructorTest() {
        Exception exception = Assertions.assertThrows(
                BowlingException.class,
                () -> {
                    throwExceptionForTooManyFrames();
                }
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Game over")
        );

    }

    void throwExceptionForTooManyFrames() {
        Frame frame = Frame.getNewFrame(null);
        for(int i = 0; i<=10; i++) {
            frame = Frame.getNewFrame(frame);
        }
    }

    @Test
    void rollExceptionsTest() {
        Frame frame = Frame.getNewFrame(null);
        frame.roll(1);
        frame.roll(2);
//        Assertions.assertEquals(-100, frame.getScore());
        Exception exception = Assertions.assertThrows(
                BowlingException.class,
                () -> {
                    frame.roll(3);
                }
        );
        Assertions.assertTrue(
                exception.getMessage().contains("Frame complete")
        );

//        Assertions.assertEquals(3, frame.getScore());
//        frame.roll(4);
    }

    @Test
    void updateScoreTest() {
        //non extra pins frame
        Frame frame1 = Frame.getNewFrame(null);
        frame1.roll(3);
        Assertions.assertEquals(0, frame1.getScore());
        frame1.roll(2);
        Assertions.assertEquals(5, frame1.getScore());

        // strike
        Frame frame2 = Frame.getNewFrame(frame1);
        frame2.roll(10);
        Assertions.assertEquals(5, frame2.getScore());

        Frame frame3 = Frame.getNewFrame(frame2);
        frame3.roll(3);
        Assertions.assertEquals(5, frame3.getScore());
        frame3.roll(2);
        Assertions.assertEquals(20, frame2.getScore());
        Assertions.assertEquals(25, frame3.getScore());

        // spare
        Frame frame4 = Frame.getNewFrame(frame3);
        Assertions.assertEquals(25, frame4.getScore());
        frame4.roll(9);
        Assertions.assertEquals(25, frame4.getScore());
        frame4.roll(1);
        Assertions.assertEquals(25, frame4.getScore());

        Frame frame5 = Frame.getNewFrame(frame4);
        Assertions.assertEquals(25, frame5.getScore());
        frame5.roll(5);
        Assertions.assertEquals(40, frame4.getScore());
        Assertions.assertEquals(40, frame5.getScore());
        frame5.roll(2);
        Assertions.assertEquals(47, frame5.getScore());
    }


    @Test
    void nextRollsTests() {
        Frame frame = Frame.getNewFrame(null);
        Assertions.assertEquals(-100, frame.getBonusPoints(1));
        Assertions.assertEquals(-100, frame.getBonusPoints(2));

        frame.roll(10);
        Assertions.assertEquals(0, frame.getScore());

        Assertions.assertEquals(10, frame.getBonusPoints(1));
        Assertions.assertEquals(-100, frame.getBonusPoints(2));

        Frame frame2 = Frame.getNewFrame(frame);
        frame2.roll(4);
        frame2.roll(6);

        Assertions.assertEquals(10, frame.getBonusPoints(1));
        Assertions.assertEquals(14, frame.getBonusPoints(2));

//        Frame frame3 = new Frame(frame2);
//        frame3.roll(3);
//        frame3.roll(5);
//
//        Assertions.assertEquals(10, frame2.getBonusPoints(1));
//        Assertions.assertEquals(14, frame2.getBonusPoints(2));

    }

    @Test
    void perfectGame() {
        Frame frame = null;
        for(int i = 0; i < 10; i++) {
            frame = Frame.getNewFrame(frame);
            frame.roll(10);
            System.out.println(frame);
        }
        frame.roll(10);
        frame.roll(10);
        Assertions.assertEquals(300, frame.getScore());



    }
}