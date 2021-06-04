package TaskOne;

import java.util.Date;
import java.util.Scanner;

/*
24. Описати клас для бази зданих з інформацією про книги бібліотеки з полями: автор, назва книги, видавництво, рік видання.
Відсортувати масив за прізвищами авторів та вивести на екран у формі таблиці. Підрахувати кількість книг від кожного видавництва.
* */

public class Books {
    String author;
    String name;
    String edition;
    int years;

    public Books() {
        author = "";
        name = "";
        edition = "";
        years = 0;
    }

    public Books(String author, String name, String edition, int years) {
        this.author = author;
        this.name = name;
        this.edition = edition;
        this.years = years;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.print("Автор : ");
        author = scanner.nextLine();
        System.out.print("Назва книги : ");
        name = scan.nextLine();
        System.out.print("Видавництво : ");
        edition = scanner.nextLine();
        System.out.print("Рік видавництва : ");
        years = scanner.nextInt();
    }


    @Override
    public String toString() {
        return author + '\t' +
                name + '\t' +
                edition + '\t' +
                years;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}