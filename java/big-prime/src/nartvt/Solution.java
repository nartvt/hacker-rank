package nartvt;

public class Solution {
    public static void main(String[] args) {
        int number = 33337;
        if (isPrime(number)) {
            System.out.printf("%d isPrime", number);
        } else {
            System.out.printf("%d Not is Prime", number);
        }
        System.out.println();
        String numberString = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111119";
        if (isPrime(numberString)) {
            System.out.printf("%s isPrime", numberString);
        } else {
            System.out.printf("%s Not is Prime", numberString);
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(String number) {
        if (number == null || number.length() == 0) return false;
        if (number.length() == 1) return isPrime(Integer.parseInt(number));
        int last = Integer.parseInt(number.substring(number.length() - 1));
        switch (last) {
            case 0:
            case 5:
            case 2:
            case 4:
            case 6:
            case 8:
                return false;
        }
        if (number.length() <= (Integer.MAX_VALUE + "").length()) return isPrime(Integer.parseInt(number));

        int total = 0;
        String temp = number;
        while (temp.length() != 1) {
            final String[] arr = number.split("");

            for (String val : arr) {
                total += Integer.parseInt(val);
            }
            temp = total + "";
            if (temp.length() != 1) {
                total = 0;
            }
        }
        return isPrime(total);
    }
}
