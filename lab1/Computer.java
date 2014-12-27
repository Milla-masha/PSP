package by.mariya.notebook;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

 class Computer implements Serializable {

    protected String os;
    protected String cpu;
    protected double ram;

    Computer(String os, String cpu, double ram) {
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
    }

    Computer() {
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

     public String getOs() {
         return os;
     }

     public void setOs(String os) {
         this.os = os;
     }

     public String getCpu() {
         return cpu;
     }

     public void setCpu(String cpu) {
         this.cpu = cpu;
     }

     public double getRam() {
         return ram;
     }

     public void setRam(double ram) {
         this.ram = ram;
     }

 }

