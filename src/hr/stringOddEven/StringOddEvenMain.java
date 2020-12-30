package hr.stringOddEven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringOddEvenMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(bufferedReader.readLine().trim());

        String[] strings = new String[lines];
        for (int i = 0; i < lines; i++) {
            strings[i] = bufferedReader.readLine().trim();
        }
        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < lines; i++) {
            bufferedWriter.write(changeString(strings[i]));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    private static String  changeString(String origString) {
        int len = origString.length();
        StringBuilder evenString = new StringBuilder();
        StringBuilder oddString = new StringBuilder();
        for (int i = 0; i < (len -2) ; i+=2) {
            evenString.append(origString.charAt(i));
            oddString.append(origString.charAt(i+1));
        }

        if( (len%2) == 1 ) {
            evenString.append(origString.charAt(len -1));
        } else {
            evenString.append(origString.charAt(len -2));
            oddString.append(origString.charAt(len -1));
        }

        evenString.append("  ");
        evenString.append(oddString);

        return evenString.toString();
    }

}
