import lesson_22.BusDriver;
import lesson_22.Driver;
import lesson_22.DriverLicence;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class Main {
    public static void printDrivers(Set<Driver> drivers) {
        Iterator<Driver> iterator= drivers.iterator();
        while (iterator.hasNext()) {
            System.out.print("[" + iterator.next().getDriverFullName() + "] ");
        }
        System.out.println();
    }

    static public void printSeparator(String arg) {
        if (arg.isBlank()) {
            System.out.println("---------------------------------------");
        }else {
            System.out.println("=============== "+arg+" =================");
        }
    }
    public static void main(String[] args) {

        Set <Driver> drivers = new HashSet<>();
        drivers.add(new BusDriver("Fist Driver",1));
        drivers.add(new BusDriver("Second Driver", 2));
        drivers.add(new BusDriver("Third Driver", 3));
        drivers.add(new BusDriver("Fourth Driver", 4));
        drivers.add(new BusDriver("Fifth Driver", 5));

        printSeparator("First Task");
        printDrivers(drivers);
        printSeparator("");

        System.out.println("Try to add the same Driver");
        drivers.add(new BusDriver("Fourth Driver", 4));
        drivers.add(new BusDriver("Fifth Driver", 5));
        printDrivers(drivers);


    }
}