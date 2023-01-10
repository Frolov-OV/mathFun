package org.perfLab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String pathToNumbData;
    public static int average = 0;
    public static double sum = 0;
    public static int minus;
    public static int plus;
    public static int equals;



    public static void main(String[] args) {
        try {
            Scanner scanNumbs = new Scanner(System.in);
            System.out.println("Укажите путь к файлу c номерами");
            pathToNumbData = scanNumbs.nextLine();

            String[] numbData = readFile(pathToNumbData).replaceAll("\\s+"," ").split(" ");
            double[] numArr = new double[numbData.length];
            for (int i = 0; i < numbData.length; i++) {
                numArr[i] = Double.parseDouble(numbData[i]);
            }
            for (double db : numArr) {
                sum += db;
                average = (int) sum / numArr.length;
            }
            System.out.println("Количество шагов: " + stepSum(numArr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static String readFile (String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }
    private static int stepSum (double[] number) {
        ArrayList<Integer> sumArr = new ArrayList<>(number.length);
        for (double dub : number) {
            if (dub < average) {
                minus = (int) (average - dub);
                sumArr.add(minus);
            } else if (dub > average) {
                plus = (int) (dub - average);
                sumArr.add((plus));
            } else {
                equals = (int) dub;
                sumArr.add(equals);
            }
        }
        return sumArr.stream().mapToInt(Integer :: intValue).sum ();
    }
}
