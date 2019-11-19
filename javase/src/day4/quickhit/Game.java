package day4.quickhit;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/14 16:46
 */
public class Game {
    Player player;

    public Game(Player player) {
        this.player = player;
    }
    void start() {
        Scanner sc = new Scanner(System.in);
        while (player.getLevelNo() != 6) {
            for (int i = 0; i < LevelParam.levels[player.getLevelNo() - 1].getStrTimes(); ++i) {
                String out = printStr();
                System.out.println(out);
                player.setStartTime(System.currentTimeMillis());
                String str = sc.next();
                printResult(out, str);
            }
        }
        System.out.println("您已打通此游戏，感谢游玩！鞠躬！");
    }
    String printStr() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int strLength = LevelParam.levels[this.player.getLevelNo() - 1].getStrLength();
        for (int i = 0; i < strLength; ++i) {
            int rand = random.nextInt(strLength) % 4;
            switch (rand) {
                case 0:
                    sb.append("<");
                    break;
                case 1:
                    sb.append(">");
                    break;
                case 2:
                    sb.append("*");
                    break;
                case 3:
                    sb.append("?");
                    break;
            }
        }
        return sb.toString();
    }
    void printResult(String out, String in) {
        if (!out.equals(in)) {
            System.out.println("不好意思，输入错误，游戏结束。");
            System.exit(1);
        }
        long currentTime = System.currentTimeMillis();
        if ((currentTime - player.getStartTime()) / 1000
            > LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()) {
            System.out.println("你输入太慢了，已经超时，退出！");
            System.exit(1);
        }
        player.setCurScore(player.getCurScore()
            + LevelParam.levels[player.getLevelNo() - 1].getPerScore());
        if (player.getCurScore() >=
                (LevelParam.levels[player.getLevelNo() - 1].getStrTimes() * LevelParam.levels[player.getLevelNo() - 1].getPerScore())) {
            System.out.println("恭喜晋级！");
            player.setLevelNo(player.getLevelNo() + 1);
            player.setCurScore(0);
        }
        System.out.printf("输入正确，您的积分%d，您的级别%d，已用时间%d秒。%n"
        , player.getCurScore(), player.getLevelNo(), (System.currentTimeMillis() - player.getStartTime())/1000);
//        if (player.getLevelNo() - 1 == 6) {
//            System.out.println("您已满级，感谢游玩，游戏结束");
//            System.exit(1);
//        }
    }
}
