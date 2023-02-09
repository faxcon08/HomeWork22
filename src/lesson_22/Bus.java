package lesson_22;

import java.util.ArrayList;

public class Bus extends Transport<BusDriver, Mechanic> implements Competing {
    private BusDriver driver;
    private BusCapacity busCapacity;
    @Override
    public boolean isNeedDiagnostic() {
        return false;
    }
    public BusCapacity getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(BusCapacity busCapacity) {
        this.busCapacity = busCapacity;
    }

    public void setBusCapacity(int count) {
        BusCapacity newBusCapacity = BusCapacity.getBusCapacityByCount(count);
        if (newBusCapacity != null)
            this.busCapacity = newBusCapacity;
    }

    public void printType() {
        String print = (this.busCapacity != null) ? this.busCapacity.toString() : "Данных по транспортному средству недостаточно";
        System.out.println("Тип транспортного средства: " + print);
    }
    public Bus(String brand, String model, double engineVolume){
        super(brand,model,engineVolume);
    }
    public Bus(String brand, String model, double engineVolume, ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.setLicence(DriverLicence.BUS_LICENCE);
        ;
    }

    public Bus(String brand, String model, double engineVolume, BusDriver driver, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver = driver;
        this.setLicence(DriverLicence.BUS_LICENCE);
    }

    public Bus(String brand, String model, double engineVolume, BusCapacity busCapacity, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver = driver;
        this.setLicence(DriverLicence.BUS_LICENCE);
        this.busCapacity = busCapacity;
    }

    public Bus(String brand, String model, double engineVolume, BusDriver driver, BusCapacity busCapacity, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver = driver;
        this.setLicence(DriverLicence.BUS_LICENCE);
        this.busCapacity = busCapacity;
    }

    @Override
    public BusDriver getDriver() {
        if (driver == null) {
            System.out.println("У автобуса " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return new BusDriver("no bus driver", 0);
        }
        return driver;
    }

    @Override
    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    @Override
    public void printMessage() {
        if (this.driver == null) {
            System.out.println("У автобуса " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return;
        }
        System.out.println("Водитель " + this.driver.getDriverFullName() +
                " управляет автобусом " + this.getBrand() + " " + this.getModel() + " и будет участвовать в заезде");
    }

    @Override
    public void startMoving() {
        System.out.println("Bus move");
    }

    @Override
    public void stopMoving() {
        System.out.println("Bus stop");
    }

    @Override
    public String toString() {
        String capacity = (busCapacity!=null)? busCapacity.toString():"";
        return "Bus: " + super.toString()+"  "+capacity;
    }

    ////////////////////////////// interface methods ////////////////
    @Override
    public void pitStop() {
        System.out.println("Bus on pitStop");
    }

    @Override
    public void bestCircleTime() {
        System.out.println("Best Circle Time for Bus");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Max Speed for Bus");
    }

    @Override
    public void passDiagnostic()  {
        try {
            throw new TransportTypeException("Автобус " + this.getBrand() + " " + this.getModel() + " диагностику проходить не должен");
        } catch (TransportTypeException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
