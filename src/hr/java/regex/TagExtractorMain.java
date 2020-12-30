package hr.java.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagExtractorMain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<String> outputList = new ArrayList<>();
        while(testCases>0){
            String line = in.nextLine();
            outputList.addAll(check(line));
            testCases--;
        }

        for (int i = 0; i < outputList.size(); i++) {
            System.out.println(outputList.get(i));
        }

    }

    private static List<String> check(String line){

        String regex = "(<(([a-zA-Z 0-9\\p{Punct}])+)>)([a-zA-Z 0-9\\p{Punct}&&[^<>]]+?)(</((\\2))>)";
        Pattern p = Pattern.compile(regex);

        return fetchList(line,p);
    }

    private static List<String> fetchList(String line , Pattern p) {
        List<String> newList = new ArrayList<>();
        Matcher m = p.matcher(line);

        boolean isModified = false;
        while (m.find()) {
            String firstTag = m.group(1);
            String endTag = m.group(5);
            String matchedPart = m.group();
            line = line.replace(matchedPart,"");
            matchedPart = matchedPart.replaceAll(firstTag,"");
            matchedPart = matchedPart.replaceAll(endTag,"");
            newList.add(matchedPart);
            isModified = true;
        }
        if(!isModified) {
            newList.add("None");
        }
        return newList;
    }
}
