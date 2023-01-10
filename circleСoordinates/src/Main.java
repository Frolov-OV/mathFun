import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static String pathToCircleData;
    public static String pathToPointData;

    public static float radius;
    public static float centerX;
    public static float centerY;

    public static float axisX;
    public static float axisY;



    public static void main(String[] args) {
        try {
        Scanner scanCircle = new Scanner(System.in);
        Scanner scanPoint = new Scanner(System.in);
        System.out.println("Укажите путь к файлу с центром окружности и его радиусом");
        pathToCircleData = scanCircle.nextLine();
        System.out.println("Укажите путь к файлу с координатами точек");
        pathToPointData = scanPoint.nextLine();

        char[] circleData = readFile(pathToCircleData).replaceAll("\\s","").toCharArray();
            for (int i = 0; i < circleData.length; i++) {
                centerX = Character.digit(circleData[0], 10);
                centerY = Character.digit(circleData[1], 10);
                radius = Character.digit(circleData[2], 10);
            }

        char[] strToArray = readFile(pathToPointData).replaceAll("\\s","").toCharArray();
        for(int i = 0; i < strToArray.length; i += 2) {
            for(int j = 1; j < strToArray.length; j +=2) {
                axisX = Character.digit(strToArray[i], 10);
                axisY = Character.digit(strToArray[j], 10);

                for (int k = 0; k < strToArray.length / 2; k++) {
                    if (circleCenter(axisX, axisY) > radius) {
                        System.out.println("2 - точка снаружи");
                    } else if (circleCenter(axisX, axisY) == radius) {
                        System.out.println("0 - точка лежит на окружности");
                    } else {
                        System.out.println("1 - точка внутри");
                    }
                }
            }
        }
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
    private static float circleCenter(float circleX, float circleY) {
        return (float) Math.sqrt(Math.pow(Math.abs(circleX - centerX), 2) + Math.pow(Math.abs(circleY - centerY), 2));
    }
}
