import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Tasks {
    /*
     * 24. Написати програму, яка в залежності від порядкового номера кольору у спектрі (1,2,...7)
     * виводить його назву (червоний, помаранчевий, жовтий, зелений, блакитний, синій, фіолетовий)
     * */
    public void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число (1-7) : ");
        int nomer = scanner.nextInt();
        do {
            if (nomer >= 1 && nomer <= 7) {
                switch (nomer) {
                    case 1:
                        System.out.println("Червоний");
                        break;
                    case 2:
                        System.out.println("Помаранчевий");
                        break;
                    case 3:
                        System.out.println("Жовтий");
                        break;
                    case 4:
                        System.out.println("Зелений");
                        break;
                    case 5:
                        System.out.println("Блакитний");
                        break;
                    case 6:
                        System.out.println("Синій");
                        break;
                    case 7:
                        System.out.println("Фіолетовий");
                        break;
                }
                break;
            } else {
                System.out.print("Введіть число (1-7): ");
                nomer = scanner.nextInt();
            }
        } while (true);
    }


    /*
     * 24. Протабулювати функцію y=f(x), з параметром x, який змінюється від 'a' до 'b' з кроком dx
     * */
    public void task2() {
        double a = -Math.PI, b = Math.PI;
        double dx = Math.PI / 10;

//        for (double x = a; x <= b; x += dx) {
//            double y = 5 * x * Math.sin(x);
//            System.out.println("x = " + String.format("%.2f", x) + "\ty = "+ String.format("%.2f", y));
//        }

        double x = a;
        do {
            double y = 5 * x * Math.sin(x);
            System.out.println("x = " + String.format("%.2f", x) + "\ty = " + String.format("%.2f", y));
            x += dx;
        } while (x <= b);
    }


    /*
     * 24. Визначити 1) добуток додатних елементів масиву;
     * 2) суму елементів масиву, розташованих до останнього додатного елемента.
     * */
    public void task3() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(200) - 100;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();

        task3_1(mas);
        task3_2(mas);
    }

    public void task3_1(int[] mas) {
        int dobutok = 1;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 0) {
                dobutok *= mas[i];
            }
        }

        System.out.println("Добуток додатніх елементів = " + dobutok);
    }

    public void task3_2(int[] mas) throws IOException {
        int index = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 0) {
                index = i;
            }
        }

        if (index == 0)
            throw new IOException("Нема елементів перед останнім додатнім елементом!");

        int suma = 0;
        for (int i = 0; i < index; i++) {
            suma += mas[i];
        }

        System.out.println("Сума елементів перед останнім додатнім елементом(" + mas[index] + ") = " + suma);
    }


    /*
     * 24. Дано цілочислову матрицю А розмірності nxm, n-парне.
     * Поміняти місцями верхню та нижню половини масиву.
     * */
    /*public void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть висоту матриці(парне число) : ");
        int n = scanner.nextInt();
        System.out.print("Введіть ширину матриці : ");
        int m = scanner.nextInt();
        for (; ; ) {
            if (n < 0 || (n % 2) != 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть висоту матриці(парне число) : ");
                n = scanner.nextInt();
            }
            if (m < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть ширину матриці : ");
                m = scanner.nextInt();
            }
            if ((n > 0 || (n % 2) == 0) && m > 0) break;
        }
        int[][] mas = new int[n][m];
        System.out.println("1.Ввести матрицю з клавіатури.");
        System.out.println("2.Згенерувати матрицю.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести матрицю з клавіатури.");
                System.out.println("2.Згенерувати матрицю.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("A [" + i + "][" + j + "] = ");
                    mas[i][j] = scanner.nextInt();
                }
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mas[i][j] = random.nextInt(200) - 100;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        task4_1(mas);

        System.out.println("\nРезультат :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void task4_1(int[][] mas) {
        for (int i = 0; i < mas.length/2; i++) {
            int[] newmas = mas[i];
            mas[i] = mas[i + mas.length/2];
            mas[i + mas.length/2] = newmas;
        }
    }*/
}
