package org.perflab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите длину интервала");
            int m = scan.nextInt();
            System.out.println("Введите длину массива");
            int n = scan.nextInt();

            ArrayList<Integer> integerArr = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                integerArr.add((int) (Math.random() * n));
            }

            System.out.print("Полученный путь: ");
            for (int i = 0; i < n; i++) {
                if (m > integerArr.size()) {
                    return;
                }
                if (m <= integerArr.size() - 1) {
                    int nextIndex = m - i;
                    String stringPath = String.valueOf(printPath(integerArr, nextIndex).charAt(0));
                    System.out.printf(stringPath);
                }
            }
        }
        catch (IndexOutOfBoundsException ex)
        {
            System.out.println();
        }
    }

    private static String printPath (ArrayList<Integer> array, int index) {
        StringBuilder sb = new StringBuilder();
        int nextIndex = index;
        do {
            sb.append(array.get(nextIndex++));
            if (nextIndex > array.size() - 1) {
                nextIndex = 0;
            }
        }
        while (nextIndex != index);

        return String.valueOf(sb);
    }
}
