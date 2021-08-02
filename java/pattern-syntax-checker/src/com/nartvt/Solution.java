package com.nartvt;

/*
Write a class called MyRegex which will contain a string pattern. You need to write a regular
 expression and assign it to the pattern such that it can be used to validate an IP address.
  Use the following definition of an IP address:
  <sumary>
  IP address is a string in the form "A.B.C.D",
  where the value of A, B, C, and D may range from 0 to 255.
  Leading zeros are allowed.
  The length of A, B, C, or D can't be greater than 3.
  </sumary>
 */


public class Solution {
    public static void main(String[] args) {
        String patternWeak = "(\\d{1}|\\d{2}|(0|1)[0-4]\\d{1}|2[0-4]\\d{1}|25[0-5])";
        String pattern = patternWeak + "\\." + patternWeak + "\\." + patternWeak + "\\." + patternWeak;
        String[] test1 = {"12.12.12.12",
                "13.13.13.112",
                "VUUT.12.12",
                "111.111.11.111",
                "1.1.1.1.1.1.1",
                ".....",
                "1...1..1..1",
                "0.0.0.0",
                "255.0.255.0",
                "266.266.266.266",
                "00000.000000.0000000.00001",
                "0023.0012.0012.0034"};
        boolean[] case1Out = {
                true,
                true,
                false,
                true,
                false,
                false,
                false,
                true,
                true,
                false,
                false,
                false};
        String[] test2 = {
                "259.259.259.259",
                "266.266.266.266",
                "255.255.255.255",
                "555.555.555.555",
                "666.666.666.666",
                "249.249.249.249",
                "249.249.249.256"};
        boolean[] case2Out = {
                false,
                false,
                true,
                false,
                false,
                true,
                false};

        String[] test3 = {"000.12.12.034",
                "121.234.12.12",
                "23.45.12.56",
                "00.12.123.123123.123",
                "122.23",
                "Hello.IP"};
        boolean[] case3Out = {
                true,true,true,false,false,false
        };

        boolean isPass = true;
        for (int i=0;i<test1.length;i++) {
            String IP= test1[i];
            if(!(IP.matches(pattern) == case1Out[i])){
                isPass = false;
            }
//            System.out.println(IP.matches(pattern));
        }
        if(isPass){
            System.out.println("CASE 1: PASS!");
        }
        isPass = true;
        System.out.println("==========================");
        for (int i=0;i<test2.length;i++) {
            String IP= test2[i];
            if(!(IP.matches(pattern) == case2Out[i])){
                isPass = false;
            }
//            System.out.println(IP.matches(pattern));
        }
        if(isPass){
            System.out.println("CASE 2: PASS!");
        }
        isPass = true;
        System.out.println("==========================");
        for (int i=0;i<test3.length;i++) {
            String IP= test3[i];
            if(!(IP.matches(pattern) == case3Out[i])){
                isPass = false;
            }
//            System.out.println(IP.matches(pattern));
        }
        if(isPass){
            System.out.println("CASE 3: PASS!");
        }
    }
}
