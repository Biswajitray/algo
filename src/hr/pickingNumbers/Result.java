package hr.pickingNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Result {
    /*
            * Complete the 'pickingNumbers' function below.
            * The function is expected to return an INTEGER.
            * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {

        int subArrayLength = 2;
        Map<String,Integer> countMap = new HashMap<>();

        for (int num : a) {
          int oneLess = num - 1;
          int oneMore = num + 1;
          String lessKey = oneLess + "_" + num;
          String moreKey = num + "_" + oneMore;
          Integer count = countMap.get(lessKey);
          if(count != null) {
              count++;
              countMap.put(lessKey , count);
          } else
              countMap.put(lessKey , 1);


          count = countMap.get(moreKey);
          if(count != null) {
            count++;
              countMap.put(moreKey , count);
          } else
            countMap.put(moreKey , 1);
        }

        Iterator<String> keyIterator = countMap.keySet().iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            int tempCount = countMap.get(key);

            subArrayLength = tempCount > subArrayLength ? tempCount : subArrayLength;
        }
        return subArrayLength;
    }


    public static int pickingNumbers1(List<Integer> a) {
        // Write your code here
        int minNum = 0;
        int maxNum = 0;

        int prev = minNum = maxNum = a.get(0);
        int count =1 ;
        int subArrayLength = 2;
        int sameNumberCount = 1;
        /**
         *  maxNum - minNum = 1 or 0
         *  lastLoc  - firstLoc
         */
        for (int i = 1; i < a.size(); i++) {

            int currNum = a.get(i);

            if(currNum != prev ) {

                /**
                 * If the currNum and prev is having a difference of 1, then only consider the sameNumberCount or reset it to 0
                 *
                 */
                int diffValue = currNum < prev ? prev - currNum : currNum - prev;
                if( (diffValue == 1 ) ) {
                    /// for sequence like 2211, during transition from 2 to 1
                    /// 11223344 all transition have difference of 1
                    int minDiffValue = currNum - minNum;
                    minDiffValue = minDiffValue < 0 ? minDiffValue * -1 : minDiffValue;

                    if(minDiffValue > 1)
                    {
                        subArrayLength = subArrayLength < count ? count : subArrayLength;
                        count = sameNumberCount;

                        /**
                         * Here we are in a situation where prev number and curr number is not same
                         * but there difference is 1
                         * i.e 1112223333 or 44433332222  kind of sequence
                         * Now we have to identify between curr and prev number about the max and min number
                         */

                        minNum = prev < currNum ? prev : currNum;
                        maxNum = prev < currNum ? currNum : prev;
                    }
                    int maxDiffValue = currNum - maxNum;
                    maxDiffValue = maxDiffValue < 0 ? maxDiffValue * -1 : maxDiffValue;

                    count++;
                } else {
                    subArrayLength = subArrayLength < count ? count : subArrayLength;
                    count = 1;
                    maxNum = minNum = currNum;
                }

                sameNumberCount = 1;
            } else {
                sameNumberCount++;
                count++;
            }

            if(currNum > maxNum)
                maxNum = currNum;

            if(currNum < minNum)
                minNum = currNum;

            prev = currNum;
        }
        subArrayLength = subArrayLength < count ? count : subArrayLength;
        return subArrayLength;
    }


    public static void main(String[] s) {
        int[] a = { 1 , 1 , 1 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 4 , 4 , 4 , 4 };
        List<Integer> listOfNumber = new ArrayList<>();
        /*listOfNumber.add(1);
        listOfNumber.add(1);
        listOfNumber.add(1);
        listOfNumber.add(2);
        listOfNumber.add(2);
        listOfNumber.add(2);
        listOfNumber.add(3);
        listOfNumber.add(3);
        listOfNumber.add(3);
        listOfNumber.add(3);
        listOfNumber.add(4);
        listOfNumber.add(4);
        listOfNumber.add(4);
        listOfNumber.add(4);
*/
        /*
        listOfNumber.add(4);
        listOfNumber.add(6);
        listOfNumber.add(5);
        listOfNumber.add(3);
        listOfNumber.add(3);
        listOfNumber.add(1);

*/
        listOfNumber.add(1);
        listOfNumber.add(1);
        listOfNumber.add(2);
        listOfNumber.add(2);
        listOfNumber.add(4);
        listOfNumber.add(4);
        listOfNumber.add(5);
        listOfNumber.add(5);
        listOfNumber.add(5);
        System.out.println(pickingNumbers(listOfNumber));
    }
}
