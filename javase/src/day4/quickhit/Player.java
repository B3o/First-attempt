package day4.quickhit;

import java.util.Scanner;

/**
 * @author Bmo
 * @date 2019/11/14 16:46
 */
public class Player {
    private int levelNo;
    private int curScore;
    private long startTime;
    private int elapsedTime;

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getCurScore() {
        return curScore;
    }

    public void setCurScore(int curScore) {
        this.curScore = curScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public Player(int levelNo, int curScore, long startTime, int elapsedTime) {
        this.levelNo = levelNo;
        this.curScore = curScore;
        this.startTime = startTime;
        this.elapsedTime = elapsedTime;
    }

    public void play() {

    }
}
