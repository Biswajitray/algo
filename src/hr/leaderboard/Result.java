package hr.leaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void main(String []s) {
       //fromConstant();
        //fromConstant1();
        fromConstant2();
   //     fromMultiConstant();
     //   fromFile();
    }
    private static void fromConstant() {
        List<Integer> ranked = new ArrayList<>();
        ranked.add(1);


        List<Integer> player = new ArrayList<>();
        player.add(1);
        player.add(1);

        List<Integer> newRank = climbingLeaderboard(ranked , player);
        System.out.println(newRank);
    }
    private static void fromConstant1() {
        List<Integer> ranked = new ArrayList<>();
        ranked.add(100);
        ranked.add(100);
        ranked.add(50);
        ranked.add(40);
        ranked.add(40);
        ranked.add(20);
        ranked.add(10);


        List<Integer> player = new ArrayList<>();
        player.add(5);
        player.add(25);
        player.add(50);
        player.add(120);

        List<Integer> newRank = climbingLeaderboard(ranked , player);
        System.out.println(newRank);
    }

    private static void fromConstant2() {
        List<Integer> ranked = new ArrayList<>();
        ranked.add(100);
        ranked.add(90);
        ranked.add(90);
        ranked.add(80);
        ranked.add(75);
        ranked.add(60);

        List<Integer> player = new ArrayList<>();
        player.add(50);
        player.add(65);
        player.add(77);
        player.add(90);
        player.add(102);

        List<Integer> newRank = climbingLeaderboard(ranked , player);
        System.out.println(newRank);
    }
    private static void fromMultiConstant() {
        List<Integer> ranked = new ArrayList<>();
        ranked.add(103);
        ranked.add(99);
        ranked.add(92);
        ranked.add(85);
        ranked.add(81);
        ranked.add(69);
        ranked.add(68);
        ranked.add(63);
        ranked.add(63);
        ranked.add(63);
        ranked.add(61);
        ranked.add(57);
        ranked.add(51);
        ranked.add(47);
        ranked.add(46);
        ranked.add(38);
        ranked.add(30);
        ranked.add(28);
        ranked.add(25);
        ranked.add(22);
        ranked.add(15);
        ranked.add(14);
        ranked.add(12);
        ranked.add(6);
        ranked.add(4);


        List<Integer> player = new ArrayList<>();
        player.add(1);
        player.add(1);
        player.add(5);
        player.add(5);
        player.add(6);
        player.add(14);
        player.add(19);
        player.add(20);
        player.add(23);
        player.add(25);
        player.add(29);
        player.add(29);
        player.add(30);
        player.add(30);
        player.add(32);
        player.add(37);
        player.add(38);
        player.add(38);
        player.add(38);
        player.add(41);
        player.add(41);
        player.add(44);
        player.add(45);
        player.add(45);
        player.add(47);
        player.add(59);
        player.add(59);

        List<Integer> newRank = climbingLeaderboard(ranked , player);
        System.out.println(newRank);
    }
    private static void fromFile() {
        List<Integer> ranked = new ArrayList<>();
        try {
            BufferedReader brRank = new BufferedReader(new FileReader("C:\\Project\\algo\\ranked.txt"));
            String line = "";

            while( ( line = brRank.readLine()) != null ) {
                ranked.add(Integer.parseInt(line.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> player = new ArrayList<>();

        try {
            BufferedReader brRank = new BufferedReader(new FileReader("C:\\Project\\algo\\score.txt"));
            String line = "";

            while( ( line = brRank.readLine()) != null ) {
                player.add(Integer.parseInt(line.trim()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> newRank = climbingLeaderboard(ranked , player);
        System.out.println(newRank);
    }

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked // descending order
     *  2. INTEGER_ARRAY player // ascending order
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> rankList = new ArrayList<>();
        Iterator<Integer> rankIterator = ranked.listIterator();
        int prev = -1;
        while(rankIterator.hasNext())
        {
            int cur = rankIterator.next();

            if(cur == prev)
                rankIterator.remove();

            prev = cur;
        }
        int end = ranked.size() ;
        for (int score : player ) {
                int pos = getPos(ranked, score, 0, end);
                if (pos < ranked.size())
                    end = pos;
                rankList.add(pos);
        }

        return rankList;
    }

    /**
     * get the position in the list
     *
     * /// 100,100,90,90,90,80,70,60,60,60
     * For 60 : pos is 8 , which is begining of 50
     * For 59 : pos is 11
     * @param ranked
     * @param score
     * @param startPos
     * @param endPos
     * @return
     */
    private static int getPos(List<Integer> ranked , int score , int startPos , int endPos) {
        int pos = -2;

        int midPos = startPos + ((endPos - startPos) / 2 );

        int curr = ranked.get(midPos);
        int prev = curr;
        if(score == curr){
            pos = (midPos + 1 ); // position starts from 0
        } else if(score > curr) { // greater than mid i.e. on left side
            int startNum = ranked.get(startPos);

            if(score < startNum) {
                pos = getPos(ranked , score ,startPos , midPos);
            } else if(score > startNum) {
                if(startPos > 0) {
                    pos = startPos ;
                } else
                    pos = 1;
            } else { // score == startNum
                pos =  startPos + 1;
            }
        } else if(score < curr) { // lesser than mid and smallest is end num
            int endNum = ranked.get(endPos - 1);
            if( score > endNum) {
                pos = getPos(ranked , score ,midPos , endPos);
            } else if (score < endNum){
                pos = endPos + 1; // last pos is size - 1
            } else { // equals to endPos
                pos =  endPos ;
            }
        }

        return pos;
    }


}

