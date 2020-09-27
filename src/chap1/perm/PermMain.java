package chap1.perm;

import java.util.ArrayList;
import java.util.Arrays;

public class PermMain {
    public static void main(String[] s)
    {
        String[] data = { "a" , "b" , "c" , "d"} ;
        String[] returnData = combination(data);
        System.out.println("Total combinations ==> " + returnData.length);
        for (String combination: returnData ) {
            System.out.println(combination);
        }
    }
    public static String[] combination(String[] s)
    {
        if(s.length == 2)
        {
            return new String[]{s[0] + s[1], s[1] + s[0]};
        }
        else
        {
            int len = s.length;
            String[] newStringArray = new String[len - 1];
            String[] returnString = new String[0];

            for( int i = 0 ; i < len ; i++)
            {
                int newCount = 0;
                String matchedStr = "";
                for ( int  j = 0 ; j < len ; j++)
                {
                    if(s[j] != s[i])
                    {
                        newStringArray[newCount] = s[j];
                        newCount++;
                    }
                    else
                        matchedStr = s[j];
                }

                returnString = mergeArray(returnString , createCombinations(matchedStr , combination(newStringArray)));
            }
            return returnString;
        }
    }

    private static String[] createCombinations(String matchedStr , String[] modifiedStrArr)
    {
        String[] returnString = new String[modifiedStrArr.length];
        for (int i = 0; i < modifiedStrArr.length; i++) {
            returnString[i] = matchedStr + modifiedStrArr[i];
        }

        return returnString;
    }

    private static String[] mergeArray(String[] first, String[] second)
    {
        String[] finalArray = new String[first.length + second.length];
        for (int i = 0 ; i < first.length ; i++) {
            finalArray[i] = first[i];
        }
        for (int i = 0;  i < second.length; i++) {
            finalArray[i + first.length] = second[i];
        }
        return finalArray;
    }
}
