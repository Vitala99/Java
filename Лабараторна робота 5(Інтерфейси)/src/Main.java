import Tasks.TaskOne.TaskOne;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskOne task = new TaskOne();
        for (; ; ) {
            try {
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command) {
                    case "add" -> task.add();
                    case "edit" -> task.edit();
                    case "print" -> task.print();
                    case "printlist" -> task.printlist();
                    case "search" -> task.search();
                    case "sort" -> task.sort();
                    case "delete" -> task.delete();
                    case "task" -> task.task();
                    case "exit" -> {
                        return;
                    }
                    case "help" -> {
                        System.out.println("\nadd - додати інформацію про студента" + "\n" +
                                "edit - редагувати інформацію про студента" + "\n" +
                                "print - висести інформацію про студента" + "\n" +
                                "printlist - висести інформацію про студента у вигляді таблиці" + "\n" +
                                "search - пошук інформації про студента" + "\n" +
                                "sort - сортування інформації про студента" + "\n" +
                                "delete - видалити інформацію про студента" + "\n" +
                                "task - відсоток студентів, що мають незадовільні оцінки" + "\n" +
                                "exit - вихід");
                    }
                    default -> System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
