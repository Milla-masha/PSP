package by.mariya.notebook;

import java.io.*;
import java.util.*;

class Test {

    public static void main(String[] args) throws IOException {
        List<Notebook> notebooks = new ArrayList<Notebook>();
        boolean cycle = true;
        while (cycle) {
        	System.out.println(" Меню \nВвод данных - 1 \nВывод данных - 2 \nСортировка(workingTime) - 3 \nУдалить элемент - 4 \nОчистка памяти - 5 \nЗапись в файл - 6 \nЧтение файла - 7 \nВыход - 8 ");
            int choise = (new Scanner(System.in)).nextInt();
            switch (choise) {

                case 1:
                    createColl(notebooks);
                    break;

                case 2:
                    for (Notebook element : notebooks) {
                        System.out.println(element);
                    }
                    break;
                case 3:

                    Collections.sort(notebooks);
                    break;

                case 4:
                	System.out.println("\nВведите порядковый номер элемента из списка для удаления ");
                   int index = (new Scanner(System.in)).nextInt();
                   notebooks.remove(index - 1);
                    break;

                case 5:
                    notebooks.clear();
                    break;

                case 6:
                    Notebook.write(notebooks,"D://Document.txt");
                    break;

                case 7:
                    notebooks= Notebook.read("D://Document.txt");
                    for (Notebook element : notebooks) {
                        System.out.println(element);}
                    break;

                case 8:
                    cycle = false;
                    break;

                default:
                	 System.out.println("!!! Выберите действие !!!");
                    break;
            }
        }

    }

    private static void createColl(List<Notebook> notebooks) {
        Scanner in = new Scanner(System.in);
        System.out.println("String os, String cpu, double  ram, int workingTime, int batteryCells, double price");
        String os = in.nextLine();
        String cpu = in.nextLine();
        double ram = in.nextDouble();
        int workingTime = in.nextInt();
        int batteryCells = in.nextInt();
        double price = in.nextDouble();
        notebooks.add(new Notebook(os, cpu, ram, workingTime, batteryCells, price));
    }


}
