package workers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

public class Worker implements Comparable<Worker> {
    private String name;
    private String position;
    private String dataOfAppointment;

    public Worker() {
    }

    public Worker(String name, String position, String dataOfAppointment) {
        this.name = name;
        this.position = position;
        this.dataOfAppointment = dataOfAppointment;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDataOfAppointment() {
        return dataOfAppointment;
    }

    public String toString() {
        return "Ім'я та прізвище: " + getName() +
                ", посада: " + getPosition() +
                ", дата прийняття на посаду: " + getDataOfAppointment();
    }

    Worker[] workers = new Worker[5];

    public void displayInfo() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < workers.length; i++) {
            System.out.println("Введіть ім'я та прізвище працівника: ");
            String name = scanner.nextLine();
            System.out.println("Введіть посаду працівника: ");
            String position = scanner.nextLine();
            String dataOfAppointment;
            while (true) {
                System.out.println("Введіть дату прийняття працівника на посаду у форматі dd.MM.yyyy з урахуванням, що компанія працює з 2000 року: ");
                dataOfAppointment = scanner.nextLine();
                DateTimeFormatter date = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                try {
                    LocalDate localDate = LocalDate.parse(dataOfAppointment, date);
                    LocalDate minDate = LocalDate.of(2000, 1, 1);
                    if (localDate.isBefore(minDate)) {
                        System.out.println("Дата не може бути раніше 01.01.2000");
                    }

                } catch (DateTimeParseException e) {
                    System.out.println("Невірний формат або неіснуюча дата.");
                }

                break;
            }
            workers[i] = new Worker(name, position, dataOfAppointment);

        }

        Arrays.sort(workers);
        System.out.println("Список працівників в алфавітному порядку: ");
        for (Worker temp : workers) {
            System.out.println(temp.toString());
        }
    }

    @Override
    public int compareTo(Worker o) {
        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.position.compareTo(o.position);
        }
        return result;
    }

    public void workExperience() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate minDate = LocalDate.of(2010, 1, 1);
        for (Worker temp : workers) {
            try {
                LocalDate hireDate = LocalDate.parse(temp.dataOfAppointment, formatter);
                if (hireDate.isBefore(minDate)) {
                    System.out.println(temp);
                }
            } catch (DateTimeParseException e) {
                System.out.println("Невірний формат дати у працівника: " + temp.name);
            }
        }
    }
}


class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.displayInfo();
        System.out.println("Працівникі, стаж роботи яких більше 14 років: ");
        worker.workExperience();
    }
}
