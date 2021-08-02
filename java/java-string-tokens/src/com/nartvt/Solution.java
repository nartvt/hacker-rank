package com.nartvt;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String regex = "[,+?!_@ '.]+";
        s = s.trim();
        if (s.length() == 0) {
            System.out.println(0);
        } else {
            String[] blanks = s.split(regex);
            System.out.println(blanks.length);
            if (blanks.length > 0) {

                for (String blank : blanks) {

                    System.out.println(blank);
                }
            }

        }

        // Write your code here.
        scan.close();
    }

}