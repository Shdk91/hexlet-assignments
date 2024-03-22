package exercise;

import java.sql.SQLOutput;

// BEGIN
public class App {

    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
            System.out.println("Вычисление окончено");
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
            System.out.println("Вычисление окончено");
        }
    }
}
// END
