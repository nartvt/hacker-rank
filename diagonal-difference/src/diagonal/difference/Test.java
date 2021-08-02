package diagonal.difference;

import java.util.Arrays;

public class Test {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "z";
        String largest = "A";
        String[] arr = hashString(s, k).split("-");
        System.out.println(Arrays.toString(arr));
        for (String a : arr) {

                if (smallest.compareTo(a) > 0) smallest = a;
                if (largest.compareTo(a) < 0) largest = a;


        }
        return smallest + "\n" + largest;
    }

    private static String hashString(String s, int k) {
        StringBuilder builder = new StringBuilder();
        String[] arr = s.split("");
        for (int i = 0; i < arr.length; i++) {
            if ((i + k) <= arr.length) {
                builder.append(s.substring(i, i + k)).append("-");
            }
        }

        return builder.substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        String s = "fsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH";
        int k = 100;
        System.out.println(getSmallestAndLargest(s, k));
    }
}
