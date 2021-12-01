package J2020;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class J01 {

    public static void j01(){
        List<Integer> numbers = listofNums();
    }

    private static List<Integer> listofNums(){

        try{
            File file = new File("01-Source.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<Integer> listOfNumbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                listOfNumbers.add(Integer.valueOf(line));
            }
            return listOfNumbers;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
