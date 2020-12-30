package hr.java;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalMain {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here
      //  quickSort(s , 0 , n  );
        for (int i = 0; i < (n - 1 ); i++) {
            int maxPos = i;

            for (int j = i; j < n ; j++) {
                BigDecimal firstElement = new BigDecimal(s[maxPos]);
                BigDecimal secondElement = new BigDecimal(s[j]);
                int compareVal = firstElement.compareTo(secondElement);
                if( compareVal < 0 ) {
                    maxPos = j;
                }
            }
            if( i != maxPos){
                String temp = s[maxPos];
                s[maxPos] = s[i];
                s[i] = temp;
            }
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

    private static void quickSort(String[] a , int start , int end){

        if(end <= start)
            return;

        int pivot = start;

        int i = pivot + 1;
        int j;
        BigDecimal pivotElement = new BigDecimal(a[pivot]);
        for ( j = i ; j < end ; j++)
        {
            BigDecimal nextElement = new BigDecimal(a[j]);
            int compareVal = nextElement.compareTo(pivotElement);
            if( compareVal > 0 ) {
                String temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        if(!a[i-1].equalsIgnoreCase(a[pivot])) {
            String temp = a[i - 1];
            a[i - 1] = a[pivot];
            a[pivot] = temp;
        }

        quickSort(a,start , i - 1  );
        quickSort(a,i , end );

    }
}
