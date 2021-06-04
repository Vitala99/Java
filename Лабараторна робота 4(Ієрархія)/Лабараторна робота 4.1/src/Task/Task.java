package Task;

import java.io.*;
import java.util.*;

public class Task {
    ArrayList<Exchange_rate> rate;

    public Task() throws IOException {
        rate = read_from_file();
    }

    public void add() throws IOException {
        Exchange_rate new_spam = new Exchange_rate();
        System.out.println("\nВведіть інформацію :");
        new_spam.input();
        rate.add(new_spam);

        System.out.println("\nЗапись додана!");

        this.write_to_file();
    }

    public void edit() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер, який ви хочете редагувати : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > rate.size()) {
            System.err.println("Не вірно введений номер!");
            this.edit();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        System.out.println("\nВідредагуйте :");
        rate.get(nomer).input();
        System.out.println("\nРедагування пройшло успішно!");

        this.write_to_file();
    }

    public void print() throws IOException {
        count_note();

        int i = 0;
        System.out.println("\n--------Інформація про акції :--------");
        for (var p :
                rate) {
            System.out.println("\nКурс акції №" + (++i) + " :");
            p.output();
            System.out.println("\n---------------------------------------");
        }
    }

    public void search() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть назву компанії, який ви шукаєте : ");
        String name = scanner.nextLine();

        boolean flag = false;
        int i = 0;
        for (var op :
                rate) {
            if (op.getName().equals(name)) {
                if (flag == false) {
                    System.out.println("\nРезультат : ");
                    flag = true;
                }
                System.out.println("Курс акцій №" + (i + 1) + " :");
                op.output();
                System.out.println();
                i++;
            }
        }

        if (flag == false) {
            System.out.println("Пошук не вдалий!");
        }
    }

    public void sort() throws IOException {
        count_note();
        ArrayList<Exchange_rate> sortrate = new ArrayList<Exchange_rate>(rate);
        Scanner scanner = new Scanner(System.in);
        for(;;) {
            System.out.print("\nВведіть параметр по якому відбудеться сортування : ");
            String commnd = scanner.nextLine();
            switch (commnd) {
                case "name":
                    sortrate.sort(Comparator.comparing(Exchange_rate::getName));
                    break;
                case "kod":
                    sortrate.sort(Comparator.comparing(Exchange_rate::getKod));
                    break;
                case "date":
                    Exchange_rate[] arr = sort_date();

                    int i = 0;
                    System.out.println("\n--------Відсортований список :--------");
                    for (var p :
                            arr) {
                        System.out.println("\nКурс акцій №" + (i + 1) + " :");
                        p.output();
                        i++;
                    }
                    System.out.println("\n--------------------------------------");
                    return;
                case "open course":
                    sortrate.sort(Comparator.comparing(Exchange_rate::getOpening_course));
                    break;
                case "close course":
                    sortrate.sort(Comparator.comparing(Exchange_rate::getClosing_course));
                    break;
                case "help":
                    System.out.println("\nname - по назві компанії" + "\n" +
                            "kod - по коду на біржі" + "\n" +
                            "date - по код на біржі" + "\n" +
                            "open course - по курсу відкриття" + "\n" +
                            "close course - по курсу закриття");
                    continue;
                default:
                    System.out.println("Не вірно введений параметр сортування(help-допомога). Введіть ще раз :");
                        continue;
            }
            break;
        }

        int i = 0;
        System.out.println("\n--------Відсортований список :--------");
        for (var p :
                sortrate) {
            System.out.println("\nКурс акцій №" + (i + 1) + " :");
            p.output();
            i++;
        }
        System.out.println("\n--------------------------------------");
    }

    public void delete() throws IOException {
        count_note();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть порядковий номер, який ви хочете видалити : ");
        String line = scanner.nextLine();
        if (!line.matches("\\d+") || Integer.parseInt(line) <= 0 || Integer.parseInt(line) > rate.size()) {
            System.err.println("Не вірно введений номер!");
            this.delete();
            return;
        }
        int nomer = Integer.parseInt(line);
        nomer--;

        rate.remove(nomer);
        System.out.println("\nВидалення пройшло успішно!");

        this.write_to_file();
    }

    public void task() throws IOException {
        count_note();

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n1.Завдання 1" + "\n" +
                    "2.Завдання 2" + "\n" +
                    "3.Завдання 3" + "\n" +
                    "4.Вернутись назад" + "\n" +
                    "Введіть число : ");
            int nomer = scanner.nextInt();

            if (nomer < 1 || nomer > 4) {
                System.out.println("Не вірно введене число!! Введіть ще раз :");
                continue;
            }

            switch (nomer) {
                case 1:
                    task_1();
                    break;
                case 2:
                    task_2();
                    break;
                case 3:
                    task_3();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void task_1() {
        try {
            DateRate beg_date = new DateRate();
            DateRate end_date = new DateRate();
            System.out.println("\nВведіть першу дату :");
            beg_date.inputDate();
            System.out.println("\nВведіть другу дату :");
            end_date.inputDate();

            if (beg_date.better(end_date))
                throw new IOException("Перша дата не може бути бульшою за другу!");
            double opening_course = 0;
            int count_day = 0;
            for (Exchange_rate rate : rate) {
                if (!beg_date.better(rate.date) || beg_date.equally(rate.date))
                    if (end_date.better(rate.date) || end_date.equally(rate.date)) {
                        opening_course += rate.opening_course;
                        count_day++;
                    }
            }

            if (count_day == 0)
                throw new IOException("В заданий період не було найдено записів!");

            double result = (double) opening_course / count_day;

            System.out.println("Середня вартість акцій по закриттю за період(" + beg_date.toString() + " - " + end_date.toString() + ") = " + result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void task_2() {
        int count_day = 0;
        for (Exchange_rate rate : rate) {
            if(rate.opening_course < rate.closing_course)
                count_day++;
        }

        System.out.println("\nКількість днів, коли курс зростав протягом дня = " + count_day);

    }

    private void task_3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення спам повідомлень : ");
        int course = scanner.nextInt();

        int count_day = 0;
        for (Exchange_rate rate : rate) {
            if (rate.closing_course > course)
                count_day++;
        }

        System.out.println("Дні, коли зміна курсу за день перевищувала задане значення(" + course + ") = " + count_day);
    }

    private Exchange_rate[] sort_date() {
        Exchange_rate[] arr = new Exchange_rate[rate.size()];
        arr = rate.toArray(arr);
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j].getDate().better(arr[j + 1].getDate())) {
                    Exchange_rate temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    private void count_note() throws IOException {
        if (rate.size() == 0)
            throw new IOException("Записів нема!");
    }


    /* Цей метод перевіряє чи файл існує
     * вказаному за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     */
    private static void isFile(String filepath) throws IOException {
        //перевірка чи файл існує
        File file = new File(filepath);
        if (!file.isFile())
            //throw new IOException("Файл не знайдено!");
            file.createNewFile();
    }

    /*Цей метод записує у файл за шляхом {@param filepath}
     * текст {@param text}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     */
    public void write_to_file() throws IOException {
        isFile("Rate.txt");

        BufferedWriter output = new BufferedWriter(new FileWriter("Rate.txt"));
        for (var p :
                rate) {
            output.write(p.to_string());
        }
        output.flush();
        output.close();
        output.close();
    }

    /*Цей метод зчитує з файлу за шляхом {@param filepath}
     *
     * @param filepath шлях до файлу
     * @throws IOException якщо файлу по шляху {@code filepath} не існує
     * @return ArrayList<Spam>
     */
    private static ArrayList<Exchange_rate> read_from_file() throws IOException {
        isFile("Rate.txt");

        BufferedReader reader = new BufferedReader(new FileReader("Rate.txt"));
        String text;
        ArrayList<Exchange_rate> arrayList = new ArrayList<>();
        while ((text = reader.readLine()) != null) {
            arrayList.add(new Exchange_rate(text, reader.readLine(),
                    Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()),
                    Double.parseDouble(reader.readLine()), Double.parseDouble(reader.readLine())));
        }
        reader.close();
        return arrayList;
    }
}
