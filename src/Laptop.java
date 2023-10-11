//   Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//    Создать множество ноутбуков.
//    Написать метод, который будет запрашивать у пользователя
//    критерий (или критерии) фильтрации и выведет ноутбуки,
//    отвечающие фильтру. Критерии фильтрации можно хранить в Map.
//    Например:
//    “Введите цифру, соответствующую необходимому критерию:
//     1 - ОЗУ
//     2 - Объем ЖД
//     3 - Операционная система
//     4 - Цвет …
//     Далее нужно запросить минимальные значения
//     для указанных критериев - сохранить параметры фильтрации
//     можно также в Map.
//     Отфильтровать ноутбуки их первоначального множества
//     и вывести проходящие по условиям.

import java.util.*;
import java.util.Set;
import java.util.HashSet;

public class Laptop {
    private static String minValue;
    private String brand;
    private int ram; // ОЗУ
    private  int hddSize; //Обьем ЖД
    private  String os; // операционная система
    private  String color;

    // Конструктор класса
    public Laptop(String brand, int ram, int hddSize, String os, String color) {

        this.brand = brand;
        this.ram = ram;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;

    }

    // геттеры и сеттеры для полей класса
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public  int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public  int getHddSize() {
        return hddSize;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public  String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public  String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Переопределение метода toString() для удобного вывода информации о ноутбуке


    @Override

    public String toString() {
        return "Ноутбук [Бренд: " + brand + ", ОЗУ: " + ram + " ГБ, Обьем ЖД: " + hddSize + " ГБ, ОС: " + os + ", Цвет: " + color + "]";
    }


    public static void main(String[] args) {

        // Создание множества ноутбуков

        Set<Laptop> laptops = new HashSet<>();

        // Добавление ноутбуков в множество

        laptops.add(new Laptop("HP", 8, 1000, "Windows 10", "grey"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS", "silver"));
        laptops.add(new Laptop("Lenovo", 12, 2000, "Windows 10", "black"));
        laptops.add(new Laptop("Dell", 8, 500, "Windows 10", "black"));
        laptops.add(new Laptop("Asus", 16, 1000, "Windows 10", "black"));


        // Метод для фильтрации и вывода ноутбуков

        filterLaptops(laptops);

    }

    public static void filterLaptops(Set<Laptop> laptops) {

        // Создание Map с критериями фильтрации и их минимальными значениями

        Map<String, String> criteria = new HashMap<>();

        criteria.put("1", "ОЗУ");
        criteria.put("2", "Обьем ЖД");
        criteria.put("3", "операционная система");
        criteria.put("4", "Цвет");

        // Запрос критерия фильтрации у пользователя

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите цифру соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Обьем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String userInput = scanner.nextLine();

        // Если критерий существует


        if (criteria.containsKey(userInput)) {

            String selectedCriteria = criteria.get(userInput);
            System.out.println("Введите минимальное значение для " + selectedCriteria + ":");
            String minValue = scanner.nextLine();


            // Фильтрация ноутбуков по выбранному критерию и его минимальному значению

            Set<Laptop> filteredLaptops = new HashSet<>();


            //switch (Objects.<String>requireNonNull(selectedCriteria)) {
            switch (selectedCriteria) {
                case "ОЗУ":


                    int minRam = Integer.parseInt(minValue);

                    for (Laptop laptop : laptops) {
                        if (laptop.getRam() >= minRam) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                case "Обьем ЖД":


                    int minHddSize = Integer.parseInt(minValue);

                    for (Laptop laptop : laptops) {
                        if (laptop.getHddSize() >= minHddSize) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                case "Операционная система":

                    for (Laptop laptop : laptops) {
                        if (laptop.getOs().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;


                case "Цвет":

                    for (Laptop laptop : laptops) {
                        if (laptop.getColor().equalsIgnoreCase(minValue)) {
                            filteredLaptops.add(laptop);
                        }
                    }
                    break;

                default:
                    System.out.println("Некорректный ввод критерия ! ");

                    return;


            }

            // вывод отфильтрованных ноутбуков

            if (filteredLaptops.isEmpty()) {

                System.out.println("Ноутбуки удовлетворяющие условиям фильтрации не найдены.");

            } else {
                for (Laptop laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }

        } else {

            System.out.println("Некорректный ввод критерия !");

        }
    }
}








