package Task;

import java.util.Scanner;

public class Exchange_rate extends Company_promotion {
    DateRate date;              //Дата
    double opening_course;      //Курс відкриття
    double closing_course;      //Курс закриття


    //конструктор без параметрів
    public Exchange_rate() {
        date = new DateRate();
        opening_course = 0;
        closing_course = 0;
    }
    //конструктор з параметрами
    public Exchange_rate(int d, int m, int y, double opening_course, double closing_course) {
        this.date = new DateRate(d,m,y);
        this.opening_course = opening_course;
        this.closing_course = closing_course;
    }
    //конструктор з параметрами
    public Exchange_rate(String name, String kod, int d, int m, int y, double opening_course, double closing_course) {
        super(name, kod);
        this.date = new DateRate(d,m,y);
        this.opening_course = opening_course;
        this.closing_course = closing_course;
    }


    //метод для вводу даних
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Назва компанії : ");
        name = scanner.nextLine();
        System.out.print("Код на біржі : ");
        kod = scanner.nextLine();
        System.out.println("Дату : ");
        date.inputDate();
        System.out.print("Курс відкриття : ");
        opening_course = scanner.nextDouble();
        System.out.print("Курс закриття : ");
        closing_course = scanner.nextDouble();
    }
    //метод для виводу даних
    @Override
    public void output() {
        System.out.println("Назва компанії - " + name);
        System.out.println("Код на біржі - " + kod);
        System.out.println("Дату - " + date.toString());
        System.out.println("Курс відкриття - " + opening_course);
        System.out.println("Курс закриття - " + closing_course);
    }


    //перевизначення методу toString()
    @Override
    public String toString() {
        return name + '\t' +
                kod + '\t' +
                date.toString() + '\t' +
                opening_course + '\t' +
                closing_course;
    }
    public String to_string() {
        return name + '\n' +
                kod + '\n' +
                date.to_string() + '\n' +
                opening_course + '\n' +
                closing_course + '\n';
    }


    //гетери
    public DateRate getDate() { return date; }
    public double getOpening_course() { return opening_course; }
    public double getClosing_course() { return closing_course; }

    //сетери
    public void setDate(DateRate date) { this.date = date; }
    public void setOpening_course(double opening_course) { this.opening_course = opening_course; }
    public void setClosing_course(double closing_course) { this.closing_course = closing_course; }
}