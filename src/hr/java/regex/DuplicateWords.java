package hr.java.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

       /* String regex = "[a-zA-Z ]*\b[a-zA-Z]{2}+\b[a-zA-Z ]*";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.replaceAll());
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();*/
        CheckRegex();
    }

    private static void CheckRegex(){
        String regex = "(\\b(\\w)+\\b)(\\s(\\1)\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        String input = "on the the THE thecar for for ready asdfas ertert";

        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
           // System.out.println("Groups : " + m.group() +" group number : " +m.group().split(" ")[0]);
             input = input.replaceAll(m.group(), m.group().split(" ")[0]);
        }

        // Prints the modified sentence.
        System.out.println(input);

    }
}