package day4.quickhit;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/14 19:26
 */
public class Start {
    public static void main(String[] args) {
        Player player = new Player(1, 0, 0, 0);
        Game game = new Game(player);
        game.start();


    }
}
