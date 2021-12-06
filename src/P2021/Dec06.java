package P2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dec06 {
    public static void main(String[] args) {
        List<Long> li = fileInput();
        days(li);
    }

    private static String textInput() {
        String input = "4,1,4,1,3,3,1,4,3,3,2,1,1,3,5,1,3,5,2,5,1,5,5,1,3,2,5,3,1,3,4,2,3,2,3,3,2,1,5,4,1,1,1,2,1,4,4,4,2,1,2,1,5,1,5,1,2,1,4,4,5,3,3,4,1,4,4,2,1,4,4,3,5,2,5,4,1,5,1,1,1,4,5,3,4,3,4,2,2,2,2,4,5,3,5,2,4,2,3,4,1,4,4,1,4,5,3,4,2,2,2,4,3,3,3,3,4,2,1,2,5,5,3,2,3,5,5,5,4,4,5,5,4,3,4,1,5,1,3,4,4,1,3,1,3,1,1,2,4,5,3,1,2,4,3,3,5,4,4,5,4,1,3,1,1,4,4,4,4,3,4,3,1,4,5,1,2,4,3,5,1,1,2,1,1,5,4,2,1,5,4,5,2,4,4,1,5,2,2,5,3,3,2,3,1,5,5,5,4,3,1,1,5,1,4,5,2,1,3,1,2,4,4,1,1,2,5,3,1,5,2,4,5,1,2,3,1,2,2,1,2,2,1,4,1,3,4,2,1,1,5,4,1,5,4,4,3,1,3,3,1,1,3,3,4,2,3,4,2,3,1,4,1,5,3,1,1,5,3,2,3,5,1,3,1,1,3,5,1,5,1,1,3,1,1,1,1,3,3,1";
        return input;
    }

    private static List<Long> fileInput() {
        String contents = textInput();
        String[] array = contents.split(",");
        Long[] arrayN = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            Long intNew = (long) Integer.parseInt(array[i]);
            arrayN[i] = intNew;
        }
        return Arrays.asList(arrayN);
    }

    private static void days(final List<Long> state) {
        int day = 0;
        List<Long> stateChange = state;
        while (day < 256) {
            stateChange = lanternFish(stateChange);
            day++;
        }
        System.out.println(stateChange.size());
    }

    private static List<Long> lanternFish(List<Long> previousLF) {
        List<Long> newLF = new ArrayList<>();
        int zeros = 0;
        for (Long i : previousLF) {
            if (i != 0) {
                newLF.add(i-1);
            } else {
                zeros++;
                newLF.add((long)6);
            }
        }
        if (zeros != 0) {
            for (int i = 0; i < zeros; i++) {
                newLF.add((long)8);
            }
        }

        return newLF;
    }


}
