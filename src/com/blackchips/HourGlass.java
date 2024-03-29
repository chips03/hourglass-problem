package com.blackchips;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxHourGlassSum = Integer.MIN_VALUE;

        // Write your code here
        for (int i = 0; i < 4; i++) {
            List<Integer> hourGlassTop = arr.get(i);
            List<Integer> hourGlassBottom = arr.get(i+2);

            for (int j = 0; j < 4; j++) {
                int hourGlassSumFirst = hourGlassTop.get(j) + hourGlassTop.get(j + 1) + hourGlassTop.get(j + 2);
                int hourGlassSumSecond = arr.get(i+1).get(j+1);
                int hourGlassSumThird = hourGlassBottom.get(j) + hourGlassBottom.get(j + 1) + hourGlassBottom.get(j + 2);
                int hourGlassSum = hourGlassSumFirst + hourGlassSumSecond + hourGlassSumThird;

                if(hourGlassSum > maxHourGlassSum) {
                    maxHourGlassSum = hourGlassSum;
                }
            }

        }

        return maxHourGlassSum;
    }

}
public class HourGlass {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        System.out.println(String.valueOf(result));
        bufferedReader.close();
    }
}
