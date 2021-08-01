package com.nartvt;

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

    public static String highestValuePalindrome(String s, int n, int k) {
        if (s.equalsIgnoreCase("") || k <= 0 || k > n) return "-1";
        if (Integer.parseInt(s) == 0) return "-1";
        if (s.equalsIgnoreCase(reserve(s))) return s;
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (n % 2 == 0) {
            String one = s.substring(0, s.length() / 2).toLowerCase();
            String two = s.substring(one.length()).toLowerCase();

            final String[] splitOne = one.split("");
            final String[] splitTwo = reserve(two).split("");
            int counter = 0;
            for (int i = 0; i < one.length(); i++) {
                if (!splitOne[i].equalsIgnoreCase(splitTwo[i])) {
                    splitTwo[i] = splitOne[i];
                    counter++;
                }
            }
            if (counter > k) return "-1";
            for (int i = 0; i < one.length(); i++) {
                builder.append(splitOne[i]);
                builder2.append(splitTwo[i]);
            }
            builder.append(reserve(builder2.toString()));
        } else {
            String one = s.substring(0, (s.length() / 2) - 1).toLowerCase();
            String two = s.substring(s.length() / 2).toLowerCase();
            String middle = s.substring((s.length() / 2) - 1, (s.length() / 2));

            final String[] splitOne = one.split("");
            final String[] splitTwo = reserve(two).split("");
            int counter = 0;
            for (int i = 0; i < one.length(); i++) {
                if (!splitOne[i].equalsIgnoreCase(splitTwo[i])) {
                    splitTwo[i] = splitOne[i];
                    counter++;
                }
            }
            if (counter > k) return "-1";
            for (int i = 0; i < one.length(); i++) {
                builder.append(splitOne[i]);
                builder2.append(splitTwo[i]);
            }
            builder.append(middle).append(reserve(builder2.toString()));
        }
        String shortNumber = Integer.parseInt(builder.toString()) + "";
        String firstChactor = builder.substring(0, 1);
        String endChactor = builder.substring(builder.length() - 1, builder.length());

        if (firstChactor.equalsIgnoreCase(endChactor) && firstChactor.equalsIgnoreCase("0")) {
            String split = shortNumber.substring(0, 1);
            return split.concat(shortNumber.substring(0, shortNumber.length() - 1)).concat(split);
        }
        return builder.toString();
        // Write your code here
    }

    public static void main(String[] args) {
        System.out.println(highestValuePalindrome("3943", 4,1));
        System.out.println(highestValuePalindrome("092282", 6,3));
        System.out.println(highestValuePalindrome("0011", 4,1));
    }
}
