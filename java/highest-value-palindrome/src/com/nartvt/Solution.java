package com.nartvt;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    private static String reserve(String s) {
        StringBuilder reserve = new StringBuilder();
        String[] splits = s.split("");
        int length = splits.length;
        for (int i = 0; i < length; i++) {
            reserve.append(splits[length - (i + 1)]);
        }
        return reserve.toString();
    }

    private static int findDiff(String s, int n) {
        char[] arr = s.toCharArray();
        int diff = 0;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                diff++;
            }
        }
        return diff;
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        if (s.equalsIgnoreCase("") || k < 0 || n < 0) return "-1";
        if (k == 0) return s;
        char[] arr = s.toCharArray();
        int diff = 0;
        StringBuilder diff_index = new StringBuilder();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                diff++;
                diff_index.append(i+"."+j);
            }
        }
        if (diff > k) {
            return "-1";
        }
        if (s.length() == 1) return "9";
        if (k >= n && n > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < k; i++) {
                builder.append("9");
            }
            return builder.toString();
        }

        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
//        if (diff == 0 && k % 2 != 0) {
//        final char haft = arr[arr.length - (arr.length / 2 + 1)];
        if (diff_index.toString().equalsIgnoreCase("")) {
            if (n % 2 != 0 && k % 2 != 0) {

                int count = 0;
                for (int k_low = 0; k_low < k / 2 + 1; k_low++) {
                    arr[arr.length - (arr.length / 2 - k_low + 1)] = '9';
                    count++;
                }
                if (count < k) {
                    for (int k_high = k / 2; k_high < k; k_high++) {
                        arr[arr.length - (arr.length / 2 + k_high - 1)] = '9';
                    }
                }

            }
            builder.append(String.valueOf(arr));
            System.out.println(arr);
        } else {
            String[] diff_index_arr = diff_index.toString().split(",");
            for (String index : diff_index_arr) {
                arr[Integer.parseInt(index)] = '9';
            }
        }

//        }
        int diffFind = findDiff(builder.toString(), n);
        if (diffFind != 0) {
            return highestValuePalindrome(builder.toString(), n, diffFind);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(highestValuePalindrome("3943", 4, 1));
//        System.out.println(highestValuePalindrome("092282", 6, 3));
//        System.out.println(highestValuePalindrome("0011", 4, 1));
//        System.out.println(highestValuePalindrome("777", 3, 0));
//        FileTest case5 = readFile(folder + "5.txt");
//        System.out.println(highestValuePalindrome(case5.s, case5.n, case5.k));
//        FileTest case4 = readFile(folder + "4.txt");
//        System.out.println(highestValuePalindrome(case4.s, case4.n, case4.k));
//        FileTest case3 = readFile(folder + "3.txt");
//        System.out.println(highestValuePalindrome(case3.s, case3.n, case3.k));
//        FileTest case2 = readFile(folder + "2.txt");
//        System.out.println(highestValuePalindrome(case2.s, case2.n, case2.k));
//        FileTest case1 = readFile(folder + "1.txt");
//        System.out.println(highestValuePalindrome(case1.s, case1.n, case1.k));
//        System.out.println(highestValuePalindrome("12345", 5, 1));
//        System.out.println(highestValuePalindrome("1263521", 7, 3));
//        System.out.println(highestValuePalindrome("5", 1, 1));
//        System.out.println(highestValuePalindrome("932239", 6, 2));
//        System.out.println(highestValuePalindrome("3943", 4, 4));
//        System.out.println(highestValuePalindrome("11331", 5, 4));
//        System.out.println(highestValuePalindrome("092282", 6, 3));
        String []s=new String[10];
        s[0] = "123";
        s[1] = "45";
        s[2] = "766";
        s[3] = "324324";
        s[4] = ".324";
        s[5] = "0.325";
        s[6] = "-234";
        s[7] = "4546";
        s[8] = "100";
        s[9] = "0";


        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                //convert to big decimal inside comparator
                //so permanent string values are never changed
                //aka you only use the BigDecimal values to
                //compare the strings!
                BigDecimal a = new BigDecimal(a1);
                BigDecimal b = new BigDecimal(a2);
                return a.compareTo(b);
            }
        }));
         for(String va:s){
             System.out.println(va);
         }
    }

    private static final String folder = System.getProperty("user.dir") + File.separator + "java/highest-value-palindrome/testcase/";

    private static FileTest readFile(String pathToFile) {
        FileTest fileTest = new FileTest();
        try (InputStream inputStream = new FileInputStream(pathToFile)) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String num = br.readLine();
                String[] split = num.split(" ");
                fileTest.n = Integer.parseInt(split[0].trim());
                fileTest.k = Integer.parseInt(split[1].trim());
                fileTest.s = br.readLine().trim();
                return fileTest;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileTest.n = 1;
        fileTest.k = 0;
        fileTest.s = "1";
        return fileTest;
    }
}
