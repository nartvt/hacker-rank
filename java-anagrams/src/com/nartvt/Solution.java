package com.nartvt;

import java.util.Map;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            String[] arr = a.toLowerCase().split("");
            String[] brr = b.toLowerCase().split("");
            java.util.Map<String, Integer> aDictMaps = new java.util.HashMap<>();
            java.util.Map<String, Integer> bDictMaps = new java.util.HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                returnLowerCase(arr, aDictMaps, i);
                returnLowerCase(brr, bDictMaps, i);
            }
            for (String s : brr) {
                String lower = s.toLowerCase();
                if (!aDictMaps.containsKey(lower) || !bDictMaps.containsKey(lower)) {
                    return false;
                } else if (!aDictMaps.get(lower).equals(bDictMaps.get(lower))) {
                    return false;
                }
            }
            return true;
        }
    }
    private static void returnLowerCase(String[] array, Map<String, Integer> dictMaps, int i) {
        String lower = array[i];
        if (dictMaps.get(lower) != null) {
            int counter = dictMaps.get(lower);
            counter++;
            dictMaps.put(lower, counter);
        } else {
            dictMaps.put(lower, 1);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}