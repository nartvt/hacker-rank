package com.nartvt;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        String pattern = "<(.+)>([^<>]+)</\\1>";
        Pattern p = Pattern.compile(pattern);
        while(testCases>0){
            String line = in.nextLine();
            Matcher m = p.matcher(line);
            boolean isFound = false;
            while(m.find()){
                System.out.println(m.group(2));
                isFound = true;
            }
            if(!isFound){
                System.out.println("None");
            }
            //Write your code here

            testCases--;
        }
    }
}
