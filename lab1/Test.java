package by.mariya.notebook;

import java.io.*;
import java.util.*;

class Test {

    public static void main(String[] args) throws IOException {
        List<Notebook> notebooks = new ArrayList<Notebook>();
        boolean cycle = true;
        while (cycle) {
        	System.out.println(" ���� \n���� ������ - 1 \n����� ������ - 2 \n����������(workingTime) - 3 \n������� ������� - 4 \n������� ������ - 5 \n������ � ���� - 6 \n������ ����� - 7 \n����� - 8 ");
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
                	System.out.println("\n������� ���������� ����� �������� �� ������ ��� �������� ");
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
                	 System.out.println("!!! �������� �������� !!!");
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
