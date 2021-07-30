package com.nartvt;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "He is a very very good boy, isn't he?";
        String regex = "[ ?,!_@'.]+";
        String []blanks = s.split(regex);
        System.out.println(blanks.length);
        for (String blank:blanks){

                System.out.println(blank);

            System.out.println();
        }
        // Write your code here.
        scan.close();
    }

}