import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Tasks {
    /*
     * 24. а) підраховує кількість великих літер у тексті;
     * б) виводить на екран слова, що мають найменшу кількість літер.
     * */
    public static void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();

        if (str.length() == 0) {
            throw new IOException("Не був введений рядок!");
        }

        System.out.println("\nРезультат :");
        task1_a(str);
        task1_b(str);
    }

    //а) підраховує кількість великих літер у тексті;
    private static void task1_a(String str){
        String[] words = str.split("[\\s]+");

        int n = 0;
        for(String p : words) {
            char[] chars = p.toCharArray();
            for (char ch : chars)
                if (!Character.isLowerCase(ch)) {
                    n++;
                }
        }

        System.out.println("а)Кількість великих літер у тексті = " + n);
    }

    //б) виводить на екран слова, що мають найменшу кількість літер.
    private static void task1_b(String str){
        String[] words = str.split("[\\s]+");

        int min = words[0].toCharArray().length;
        for (String p : words)
            if(min > p.toCharArray().length)
                min = p.toCharArray().length;

        System.out.println("\nб)Cлова, що мають найменшу кількість літер :");
        for (String p : words)
            if(p.toCharArray().length == min)
                System.out.print(p + " ");

        System.out.println();
    }



    /*
    * 24. Створіть файл дійсних чисел. Підрахуйте кількість елементів файлу,
    * більших за n (кількість елементів файлу, n та самі елементи вводяться з клавіатури).
    * */
    public static void task2(String filepath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть к-ть чисел : ");
        int kilkist = scanner.nextInt();
        if(kilkist < 0) throw  new IOException("Кількість чисел не може бути відємною!");
        else if(kilkist == 0) return;

        double[] mas = new double[kilkist];
        String str = "";
        System.out.println("Введіть числа :");
        for (int i = 0; i < kilkist; i++) {
            mas[i] = scanner.nextDouble();
            str += mas[i] + " ";
        }

        System.out.print("Введіть число \'n\' : ");
        double n = scanner.nextDouble();

        createFile(filepath);
        outputFile(filepath, str);

        int count = 0;
        for(double d : mas){
            if(d > n){
                count++;
            }
        }

        System.out.println("Кількість елементів файлу, більших за " + n + " = " + count);
    }



    /*
    * б) виводить на екран всі слова, що мають непарну кількість приголосних літер.
     * */
    /*public static void task3(String inputPath, String outputPath) throws IOException {
        String text = inputFile(inputPath);

        text = text.replaceAll("[.!,?;:'\"]", "");
        String[] words = text.split("[\\s]+");

        if(words.length <= 0) throw new IOException("Файл пустий.");

        //масив char голосних букв
        char[] vowels={'e', 'y', 'u', 'i', 'o', 'a', 'у', 'е', 'ї', 'і', 'а', 'о', 'є', 'я', 'и', 'ю'};

        String result = "";

        System.out.println("Текст :" + "\n" + text);
        System.out.println("Cлова, що мають непарну кількість приголосних літер : ");
        for (String p : words) {
            char[] word = p.toCharArray();
            int count = 0;
            for (char ch : word) {
                boolean flag = true;
                for (char ch1 : vowels)
                    if (ch == ch1 || ch == Character.toUpperCase(ch1)) {
                        flag = false;
                        break;
                    }

                    if (flag)
                        count++;

            }

            if (count % 2 == 1)
                result += p + " ";
        }

        outputFile(outputPath, result);
        System.out.println(result);
    }*/


    private static void isFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");
    }

    private static void createFile(String filepath) throws IOException{
        //створення файлу
        File file = new File(filepath);
        if(!file.isFile())
            file.createNewFile();
    }

    private static void outputFile(String filepath, String text) throws IOException{
        isFile(filepath);

        //записуємо в файл
        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        output.write(text);
        output.flush();
        output.close();
    }


    private static String inputFile(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        return lines.toString();
    }
}
