package Task;

import java.util.Scanner;

public class Company_promotion {
    String name;        //назва компанії
    String kod;         //код на біржі


    //конструктор без параметрів
    public Company_promotion() {
        name = "";
        kod = "";
    }
    //конструктор з параметрами
    public Company_promotion(String name, String kod) {
        this.name = name;
        this.kod = kod;
    }


    //метод для вводу даних
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Назва компанії : ");
        name = scanner.nextLine();
        System.out.print("Код на біржі : ");
        kod = scanner.nextLine();
    }
    //метод для виводу даних
    public void output() {
        System.out.println("Назва компанії - " + name);
        System.out.println("Код на біржі - " + kod);
    }


    //перевизначення методу toString()
    @Override
    public String toString() {
        return "Company_promotion{" +
                "name='" + name + '\'' +
                ", kod='" + kod + '\'' +
                '}';
    }


    //гетери
    public String getName() { return name; }
    public String getKod() { return kod; }

    //сетери
    public void setName(String name) { this.name = name; }
    public void setKod(String kod) { this.kod = kod; }
}
