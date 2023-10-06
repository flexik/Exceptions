package Lesson_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 Фамилия Имя Отчество датарождения номертелефона пол

 Форматы данных:
 фамилия, имя, отчество - строки
 датарождения - строка формата dd.mm.yyyy
 номертелефона - целое беззнаковое число без форматирования
 пол - символ латиницей f или m.

 Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
 обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
 Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои.
 Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
 Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
 <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

 Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 Не забудьте закрыть соединение с файлом.
 При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

public class IntermediateCertification {

        public static void main(String[] args) {
            try {
                String inputData = readInputData();
                saveToFile(inputData);
                System.out.println("Данные успешно сохранены в файл.");
            } catch (InvalidInputException | IOException e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }

        public static String readInputData() throws InvalidInputException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные через пробел, в формате: Фамилия Имя Отчество датарождения(dd.mm.yyyy) номертелефона пол(f, m)");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new InvalidInputException("Неверное количество данных: ожидается 6 параметров, а вы ввели " + data.length + " параметров.");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!isValidDate(birthDate)) {
                throw new InvalidInputException("Неверный формат даты рождения: ожидается dd.mm.yyyy.");
            }

            if (!isValidPhoneNumber(phoneNumber)) {
                throw new InvalidInputException("Неверный формат номера телефона: ожидается целое беззнаковое число.");
            }

            if (!isValidGender(gender)) {
                throw new InvalidInputException("Неверный формат пола: ожидается символ 'f' или 'm'.");
            }

            return surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
        }

        public static boolean isValidDate(String date) {
            return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
        }

        public static boolean isValidPhoneNumber(String phoneNumber) {
            return phoneNumber.matches("\\d+");
        }

        public static boolean isValidGender(String gender) {
            return gender.equals("f") || gender.equals("m");
        }

        public static void saveToFile(String data) throws IOException {
            String surname = data.split(" ")[0];
            BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true));
            writer.write(data);
            writer.newLine();
            writer.close();
        }
    }

    class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
}
