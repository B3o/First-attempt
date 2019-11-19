package day4.quickhit;

/**
 * @author Bmo
 * @date 2019/11/14 17:37
 */
public class LevelParam {
    public final static Level[] levels = new Level[6];
    static {
        levels[0] = new Level(1, 2, 10, 6, 1);
        levels[1] = new Level(2, 3, 9, 8, 2);
        levels[2] = new Level(3, 4, 8, 10, 5);
        levels[3] = new Level(4, 5, 7, 12, 8);
        levels[4] = new Level(5, 6, 6, 13, 10);
        levels[5] = new Level(6, 7, 5, 15, 15);
    }
}
