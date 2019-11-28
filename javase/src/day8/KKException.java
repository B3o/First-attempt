package day8;

import java.util.ArrayList;

/**
 * @author Bmo
 * @date 2019/11/23 11:33
 */
public class KKException extends Error{
    ArrayList<Base> a = new ArrayList<Base>();

    public static void main(String[] args) {
        String b = "sdad ";

        b.indexOf("@");
    }
}
