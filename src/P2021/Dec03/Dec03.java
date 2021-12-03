package P2021.Dec03;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Dec03 {

    public static void main(String[] args) {
        List<String> bits = fileInput();
        if (bits != null) {
            findBit2(bits);
        }
    }

    private static List<String> fileInput() {
        List<String> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("resources/03-file.txt"));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void findBit(List<String> li) {
        int noInLine = li.get(0).length();
        List<ArrayList<Integer>> bitsExtracted = new ArrayList<>();
        for (int i = 0; i < noInLine; i++) {
            bitsExtracted.add(new ArrayList<>());
        }

        for (String line : li) {
            for (int k = 0; k < line.length(); k++) {
                Integer e = parseInt(String.valueOf(line.charAt(k)));
                bitsExtracted.get(k).add(e);
            }

        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (ArrayList<Integer> line : bitsExtracted) {
            int zeros = 0;
            int ones = 0;
            for (int e : line) {
                if (e == 0) {
                    zeros++;
                } else if (e == 1) {
                    ones++;
                }
            }
            if (zeros > ones) {
                gamma.append(0);
                epsilon.append(1);
            } else {
                gamma.append(1);
                epsilon.append(0);
            }
        }
        int gammaBit = parseInt(gamma.toString(), 2);
        int epsilonBit = parseInt(epsilon.toString(), 2);
        System.out.println(gammaBit);
        System.out.println(epsilonBit);
        System.out.println(gammaBit * epsilonBit);
    }

    private static void findBit2(List<String> li) {
        int noInLine = li.get(0).length();
        Iterator<String> oxygenI = li.iterator();
        List<String> oxygenL = li;
        List<ArrayList<Integer>> bitsExtracted = new ArrayList<>();
        for (int i = 0; i < noInLine; i++) {
            bitsExtracted.add(new ArrayList<>());
        }
        for (String line : li) {
            for (int k = 0; k < line.length(); k++) {
                Integer e = parseInt(String.valueOf(line.charAt(k)));
                bitsExtracted.get(k).add(e);
            }
        }
        for (ArrayList<Integer> line : bitsExtracted) {
            int index = 0;
            int zeros = 0;
            int ones = 0;
            int OEliminator = 0;
            int CEliminator = 1;
            for (int e : line) {
                if (e == 0) {
                    zeros++;
                } else if (e == 1) {
                    ones++;
                }
            }
            if (zeros > ones) {

            } else {
                while (oxygenI.hasNext()) {
                    String j = oxygenI.next();
                    if (oxygenI.next() != null) {
                        if (OEliminator == Integer.parseInt(String.valueOf(j.charAt(index)))) {
                            oxygenI.remove();
                        }
                    }
                }
            }
        }


    }
}
