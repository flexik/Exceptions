package Lesson_2;

/** Исправьте код там, где требуется:
 * public static void main(String[] args) throws Exception {
 *    try {
 *        int a = 90;
 *        int b = 3;
 *        System.out.println(a / b);
 *        printSum(23, 234);
 *        int[] abc = { 1, 2 };
 *        abc[3] = 9;
 *    } catch (Throwable ex) {
 *        System.out.println("Что-то пошло не так...");
 *    } catch (NullPointerException ex) {
 *        System.out.println("Указатель не может указывать на null!");
 *    } catch (IndexOutOfBoundsException ex) {
 *        System.out.println("Массив выходит за пределы своего размера!");
 *    }
 * }
 * public static void printSum(Integer a, Integer b) throws FileNotFoundException {
 *    System.out.println(a + b);
 * }
 *
 * Ответ:
 * 1) метод `printSum` объявлен с возможным выбросом исключения `FileNotFoundException`, но внутри метода нет кода, который мог бы вызвать это исключение.
 * 2) порядок блоков `catch` неверен - более общие исключения должны быть обработаны в последнюю очередь.
 */

public class Task3 {
    public static void main(String[] args) {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (ArithmeticException ex) {
                System.out.println("Деление на ноль!");
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            }
        }

        public static void printSum(Integer a, Integer b) {
            System.out.println(a + b);
        }
}
