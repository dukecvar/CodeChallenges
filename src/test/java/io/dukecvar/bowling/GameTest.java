package io.dukecvar.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void maintest() {
        Game game = new Game();

        game.roll(5);
        game.roll(5);
        Assertions.assertEquals(0, game.getScore());
        // 0 now, 20 after 1 roll

        game.roll(10);
        Assertions.assertEquals(20, game.getScore());
        // 20 now, 41 after 2 roll

        game.roll(10);
        Assertions.assertEquals(20, game.getScore());
        // 20 now
        // 56 after

        game.roll(1);
        Assertions.assertEquals(41, game.getScore());
        game.roll(4);
        Assertions.assertEquals(61, game.getScore());


        game.roll(8);
        game.roll(1);
        Assertions.assertEquals(70, game.getScore());

        game.roll(8);
        game.roll(2);
        Assertions.assertEquals(70, game.getScore());
        // 70 now; 89 later

        game.roll(9);
        Assertions.assertEquals(89, game.getScore());
        game.roll(1);
        Assertions.assertEquals(89, game.getScore());
        // 89 now; 109 1 roll later

        game.roll(10);
        Assertions.assertEquals(109, game.getScore());
        // 109 now, 139 2 rolls later

        game.roll(10);
        Assertions.assertEquals(109, game.getScore());

        game.roll(10);
        Assertions.assertEquals(139, game.getScore());
        game.roll(10);
        Assertions.assertEquals(169, game.getScore());
        game.roll(10);
        Assertions.assertEquals(199, game.getScore());

        System.out.println(game);
    }

    @Test
    void perfectGame() {
        Game game = new Game();

        while(!game.isGameOver()) {
            game.roll(10);
        }

        Assertions.assertEquals(300, game.getScore());
        System.out.println(game);
    }

    @Test
    void bowlRandomGame() {
        Game game = new Game();
        int maxPins = game.getCurrentFrame().getPinsRemaining();
        while(!game.isGameOver() && maxPins > 0 ) {
            int randRoll = getRandomRollScore(maxPins);
            game.roll(randRoll);
            if(game.getCurrentFrame().isComplete()) {
                maxPins = 10;
            } else {
                maxPins = game.getCurrentFrame().getPinsRemaining();
            }

        }
        System.out.println(game);
    }


    static int getRandomRollScore(int maxPins) {
        return (int) (Math.random() * maxPins + 1);
    }

}