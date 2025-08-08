package workers;

import java.util.Arrays;
import java.util.Scanner;

public class Worker implements Comparable<Worker> {
    private String name;
    private String position;
    private int yearOfAppointment;

    public Worker() {
    }

    public Worker(String name, String position, int yearOfAppointment) {
        this.name = name;
        this.position = position;
        this.yearOfAppointment = yearOfAppointment;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getYearOfAppointment() {
        return yearOfAppointment;
    }

    public String toString() {
        return "Ім'я та прізвище: " + getName() +
                ", посада: " + getPosition() +
                ", рік прийняття: " + getYearOfAppointment();
    }

    Worker[] workers = new Worker[5];
    public void displayInfo() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < workers.length; i++) {
            System.out.println("Введіть ім'я та прізвище працівника: ");
            String name = scanner.nextLine();
            System.out.println("Введіть посаду працівника: ");
            String position = scanner.nextLine();
            int yearOfAppointment;
            while (true) {
                try {
                    System.out.println("Введіть рік прийняття працівника на посаду з урахуванням, що компанія працює з 2000 року: ");
                    yearOfAppointment = scanner.nextInt();
                    scanner.nextLine();
                    if (yearOfAppointment < 2000) {
                        throw new IllegalAccessException("Невірно введений рік прийняття на роботу");
                    }break;
                } catch (Exception e) {
                    System.out.println("Введіть рік прийняття працівника на посаду у вигляді числа");
                }
            }

            workers[i] = new Worker(name, position, yearOfAppointment);
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
    public void workExperience(){
        for(Worker temp : workers){
            if(temp.getYearOfAppointment() < 2010){
                System.out.println(temp);
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
