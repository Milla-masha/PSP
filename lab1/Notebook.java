package by.mariya.notebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Notebook extends Computer implements Comparable<Notebook>{
    private int workingTime;
    private int batteryCells;
    private double price;

    Notebook(String os, String cpu, double ram, int workingtime, int batterycells, double price) {
        super(os, cpu, ram);
        this.workingTime = workingtime;
        this.batteryCells = batterycells;
        this.price = price;
    }

    Notebook() {}
    public int getWorkingTime() {
        return workingTime;
    }


    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public int getBatteryCells() {
        return batteryCells;
    }

    public void setBatteryCells(int batteryCells) {
        this.batteryCells = batteryCells;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

       
        public String toString() {
            return "Notebook{" +
                    "os=" + os +
                    ", cpu=" + cpu +
                    ", ram=" + ram +
                    ", workingTime=" + workingTime +
                    ", batteryCells=" + batteryCells +
                    ", price=" + price +
                    '}';
        }


    
        public int compareTo(Notebook o) {
            return o.getWorkingTime() - workingTime;
        }
    public static void write(List<Notebook> notebooks, String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), notebooks);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Notebook> read(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(new File(path), Notebook[].class));
        } catch (Exception e) {
            throw new RuntimeException("Error read objects.", e);
        }
    }
}
