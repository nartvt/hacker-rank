package diagonal.difference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        if (arr == null || arr.isEmpty()) return 0;
        int diagonaLeft = 0;
        int diagonaRight = 0;
        int size = arr.size();
        int index = 0;
        for (List<Integer> list : arr) {
            diagonaLeft += list.get(index);
            diagonaRight += list.get(size - index - 1);
            index++;
        }
        if (diagonaLeft > diagonaRight) {
            return (diagonaLeft - diagonaRight);
        } else {
            return (diagonaRight - diagonaLeft);
        }

    }

    public static String timeConversion(String s) {
        if (s != null && s.length() > 2) {
            String[] splits = s.split(":");
            StringBuilder builder = new StringBuilder();
            if (s.contains("AM")) {
                int first = Integer.parseInt(splits[0]);
                if (first == 12) {
                    splits[0] = "00";
                }
            }
            if (s.contains("PM")) {
                int hours = Integer.parseInt(splits[0]);
                if (hours != 12) {
                    hours += 12;
                }
                splits[0] = hours + "";
            }
            String last = splits[splits.length - 1];
            last = last.replaceAll("\\D", "");
            splits[splits.length - 1] = last;
            builder.append(splits[0]);
            builder.append(":");
            for (int i = 1; i < splits.length; i++) {

                builder.append(splits[i]);

                if (i != splits.length - 1) {
                    builder.append(":");
                }
            }
            return builder.toString();
        }
        return s;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
