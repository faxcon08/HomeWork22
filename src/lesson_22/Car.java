package lesson_22;

import java.util.ArrayList;

public class Car  extends Transport <CarDriver, Mechanic> implements Competing{
    private CarDriver driver;
    private BodyType bodyType;

    @Override
    public boolean isNeedDiagnostic() {
        return true;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public void printType() {
        String print = (this.bodyType != null) ? this.bodyType.toString() : "Данных по транспортному средству недостаточно";
        System.out.println("Тип транспортного средства: "+print);
    }
    public Car(String brand, String model, double engineVolume){
        super(brand,model,engineVolume);
    }
    public Car(String brand, String model, double engineVolume, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.setLicence(DriverLicence.CAR_LICENCE);
    }
    public Car(String brand, String model, double engineVolume, BodyType bodyType, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.setLicence(DriverLicence.CAR_LICENCE);
        this.bodyType=bodyType;
    }
    public Car(String brand, String model, double engineVolume, CarDriver driver, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume,mechanics);
        this.driver=driver;
        this.setLicence(DriverLicence.CAR_LICENCE);
    }
    public Car(String brand, String model, double engineVolume, CarDriver driver, BodyType bodyType, ArrayList <Mechanic> mechanics) {
        super(brand, model, engineVolume, mechanics);
        this.driver=driver;
        this.setLicence(DriverLicence.CAR_LICENCE);
        this.bodyType=bodyType;
    }
    @Override
    public CarDriver getDriver() {
        if(driver==null) {
            System.out.println("У машины " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return new CarDriver("no car driver", 0);
        }
        return driver;
    }

    @Override
    public void setDriver(CarDriver driver) {this.driver =  driver;}
    @Override
    public void printMessage() {
        if (this.driver==null) {
            System.out.println("У машины " + this.getBrand() + " " + this.getModel() + " еще нет водителя");
            return;
        }
        System.out.println("Водитель " + this.driver.getDriverFullName() +
                " управляет автомобилем " + this.getBrand() + " " + this.getModel() + " и будет участвовать в заезде");
    }

    @Override
    public void startMoving() {
        System.out.println("Car start");
    }

    @Override
    public void stopMoving() {
        System.out.println("Car stop");
    }

    @Override
    public String toString() {
        String body = (bodyType!=null)? bodyType.toString():"";
        return "CAR: "+super.toString()+" "+body;
    }

    ////////////////////// interface methods //////////////////////
    @Override
    public void pitStop() {
        System.out.println("Car on pitStop");
    }

    @Override
    public void bestCircleTime() {
        System.out.println("Best Circle Time for Car");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Max Speed for Car");
    }


    @Override
    public void passDiagnostic() {
        System.out.println("Диагностика для автомобиля: "+this.getBrand()+" "+this.getModel());
    }
}// class Car
