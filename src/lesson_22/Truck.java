package lesson_22;

import java.util.ArrayList;

public class Truck extends Transport <TruckDriver,Mechanic> implements Competing{
    private TruckDriver driver;
    private LoadCapacity loadCapacity;
    @Override
    public boolean isNeedDiagnostic() {
        return true;
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public void setLoadCapacity(Float weight) {
        LoadCapacity newLoadCapacity = LoadCapacity.getLoadCapacityByWeight(weight);
        if(newLoadCapacity!=null)
            this.loadCapacity=newLoadCapacity;
    }
    public void printType() {
        String print = (this.loadCapacity != null) ? this.loadCapacity.toString() : "Данных по транспортному средству недостаточно";
        System.out.println("Тип транспортного средства: "+print);
    }
    public Truck(String brand, String model, double engineVolume){
        super(brand,model,engineVolume);
    }
    public Truck(String brand, String model, double engineVolume, ArrayList<Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.setLicence(DriverLicence.TRUCK_LICENCE);
    }
    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.setLicence(DriverLicence.TRUCK_LICENCE);
        this.loadCapacity=loadCapacity;
    }
    public Truck(String brand, String model, double engineVolume,TruckDriver driver, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver=driver;
        this.setLicence(DriverLicence.TRUCK_LICENCE);
    }
    public Truck(String brand, String model, double engineVolume,TruckDriver driver, LoadCapacity loadCapacity, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver=driver;
        this.setLicence(DriverLicence.TRUCK_LICENCE);
        this.loadCapacity=loadCapacity;
    }
    @Override
    public TruckDriver getDriver() {
        if(driver==null) {
            System.out.println("У грузовика " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return new TruckDriver("no truck driver", 0);
        }
        return driver;
    }
    @Override
    public void setDriver(TruckDriver driver) {this.driver=driver;}
    @Override
    public void printMessage() {
        if (this.driver==null) {
            System.out.println("У грозовика " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return;
        }
        System.out.println("Водитель " + this.driver.getDriverFullName() +
                " управляет грузовиком " + this.getBrand() + " " + this.getModel() + " и будет участвовать в заезде");
    }

    @Override
    public void startMoving() {
        System.out.println("Truck start moving");
    }

    @Override
    public void stopMoving() {
        System.out.println("Truck stop moving");
    }

    @Override
    public String toString() {
        String capacity = (loadCapacity!=null)? loadCapacity.toString():"";
        return "Truck: " + super.toString()+"  "+capacity;
    }

    ////////////////////////////// interface methods ////////////////
    @Override
    public void pitStop() {
        System.out.println("Truck on pitStop");
    }

    @Override
    public void bestCircleTime() {
        System.out.println("Best Circle Time for Truck");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Max Speed for Truck");
    }
    @Override
    public void passDiagnostic() {
        System.out.println("Диагностика для грузовика: "+this.getBrand()+" "+this.getModel());
    }
}
