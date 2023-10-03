package Lesson_2;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        float number = readFloatFromUser();
        System.out.println("Вы ввели число: " + number);

    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float number;

        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                number = Float.parseFloat(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }

        return number;
    }

}
