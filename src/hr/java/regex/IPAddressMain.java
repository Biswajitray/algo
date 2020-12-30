package hr.java.regex;

import java.util.Scanner;

public class IPAddressMain {
    public static void main(String[] args){
 /*       Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
*/
        String IP = "255.255.0.255.0";
        System.out.println(IP.matches(new MyRegex().pattern));
    }
}
class MyRegex {
   // public String pattern = "((([0-9]{1,2}+)|(^[01][0-9]{1,2}+)|(^[02][0-5][0-9]))\\.)+";
   // public String pattern = "([0-1]{0,1}+[0-9]{0,1}+[0-9]{0,1}+)";
   public String pattern = "((([2][0-4][0-9])|([2][5][0-5])|([0-1]{0,1}+[0-9]{0,1}+[0-9]{0,1}+))\\.){3}+(([2][0-4][0-9])|([2][5][0-5])|([0-1]{0,1}+[0-9]{0,1}+[0-9]{0,1}+))";
}