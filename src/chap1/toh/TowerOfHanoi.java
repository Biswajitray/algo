package chap1.toh;

import java.util.Arrays;

public class TowerOfHanoi {
    public static void main(String[] s)
    {
        String towerA = "Tower A";
        String towerB = "Tower B";
        String towerC = "Tower C";

        int totalElement = 14;
        moveDisc(totalElement, towerA , towerB , towerC);
    }

    private static void moveDisc(int length, String towerA , String towerB, String towerC)
    {
        if(length > 0)
        {
            moveDisc(length -1 , towerA , towerC , towerB);
            System.out.println("Move element (" + length + ") from " + towerA + " to " + towerB);
            moveDisc(length -1 , towerC , towerB , towerA);
        }

    }
}
