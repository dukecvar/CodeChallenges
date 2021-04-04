package io.dukecvar.bowling;

//import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bowling {

    public static void main(String[] args) {
        Game game = new Game();
        BufferedReader bufReader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String line = null;
            gamePrompt(game);
            while (!game.isGameOver() && (line = bufReader.readLine()) != null) {
                int pins = Integer.parseInt(line);
                if(pins > game.getMaxPinsForNextRoll()) {
                    pins = game.getMaxPinsForNextRoll();
                }
                game.roll(pins);
                System.out.println(game);
                if(game.isGameOver()) {
                    break;
                } else {
                    gamePrompt(game);
                }
            }
            bufReader.close();
            game.toString();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void gamePrompt(Game game) {
        System.out.print("Frame:" + game.getCurrentFrame().getFrameNumber()
                + " roll (max:" + game.getMaxPinsForNextRoll() + ") --> ");
    }

}
