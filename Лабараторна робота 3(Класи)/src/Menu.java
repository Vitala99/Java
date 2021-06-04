import TaskOne.Books;
import TaskTwo.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        TaskOne();
        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1.Перше завдання." + "\n" +
                    "2.Друге завдання." + "\n" +
                    "3.Вихід." + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            switch (nomer) {
                case 1:
                    TaskOne();
                    break;
                case 2:
                    TaskTwo();
                    break;
                case 3:
                    return;
                default:
                    System.err.println("Не вірно введене число! Введіть ще раз :");
                    break;
            }
        }*/
    }

    /*
    * 24. Описати клас для бази зданих з інформацією про книги бібліотеки з полями: автор, назва книги, видавництво, рік видання.
    Відсортувати масив за прізвищами авторів та вивести на екран у формі таблиці. Підрахувати кількість книг від кожного видавництва.
    * */
    public static void TaskOne(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Books> list = new ArrayList<Books>();
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література", "Грамота", 2021));
        list.add(new Books("Михайло Булгаков", "Майстер и Маргарита", "Азбука", 2012));
        list.add(new Books("Даніель Дефо", "Робінзон Крузо", "Золота Полиця", 2018));
        list.add(new Books("Оскар Уфйльд", "Портрет Доріана Грея", "Азбука", 2010));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));
        list.add(new Books("Олександр Авраменко", "ЗНО 2021. Українська мова та література.", "Грамота", 2021));

        ArrayList<String> editions = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        list.sort(Comparator.comparing(Books::getAuthor));
        for(var p : list) {
            if(!editions.contains(p.getEdition())){
                editions.add(p.getEdition());
                count.add(1);
            }
            else{
                count.set(editions.indexOf(p.getEdition()), count.get(editions.indexOf(p.getEdition())) + 1);
            }
            System.out.println(p.toString());
        }
        System.out.println();

        for(int i=0;i<editions.size();i++)
            System.out.println(editions.get(i) + " - " + count.get(i) + " книг");
    }

    /*public static void TaskTwo(){
        try {
            Scanner scanner = new Scanner(System.in);
            Task task = new Task();
            for(;;){
                System.out.print("\nВведіть команду : ");
                String command = scanner.nextLine();

                switch (command){
                    case "add":
                        task.add();
                        break;
                    case "edit":
                        task.edit();
                        break;
                    case "print":
                        task.print();
                        break;
                    case "search":
                        task.search();
                        break;
                    case "sort":
                        task.sort();
                        break;
                    case "delete":
                        task.delete();
                        break;
                    case "exit":
                        return;
                    case "help":
                        System.out.println("\nadd - додати фільм" + "\n" +
                                "edit - редагувати фільм" + "\n" +
                                "print - висести список фільмів" + "\n" +
                                "search - пошук фільма" + "\n" +
                                "sort - сортування фільмів" + "\n" +
                                "delete - видалити фільм" + "\n" +
                                "exit - вихід");
                        break;
                    default:
                        System.err.print("Не вірно введена команда(help - допомога)! Введіть ще раз :");
                        break;
                }
            }
        }
        catch (IOException ex){
            System.err.println(ex.getMessage());
        }
    }*/
}
