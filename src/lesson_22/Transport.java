package lesson_22;

import java.util.ArrayList;

abstract public class Transport<T extends Driver, S extends Mechanic> {

    private ArrayList <S> mechanicsList;

    public ArrayList<S> getMechanicsList() {
        return mechanicsList;
    }

    abstract public boolean isNeedDiagnostic();

    public void printMechanicsList() {
        if(mechanicsList!=null) {
            if (mechanicsList.size() > 0) {
                int count = 1;
                for (Mechanic mechanic : mechanicsList) {
                    System.out.println(" Mechanic #" + (count++) + ": " + mechanic.getFirstName() + " " + mechanic.getLastName() + " (" + mechanic.getCompany() + ")");
                }
            }
        }  else
            System.out.println("Список механиков не задан");
    }
    public void setMechanicsList(ArrayList<S> mechanicsList) {
        if(mechanicsList!=null)
            this.mechanicsList = mechanicsList;
    }

    private DriverLicence licence = DriverLicence.NO_LICENCE;

    public DriverLicence getLicence() {
        return licence;
    }

    protected void setLicence(DriverLicence licence) {
        this.licence = licence;
    }

    /////// fields ///////
    private final String brand;
    private final String model;
    private final double engineVolume;


    ////////////////////////////////// class for default values ///////////////////////////
    protected static class Default_Values{
        static String default_brand = "default_brand";
        static String default_model = "default_model";
        static double default_engine_volume = 2.0;
    } // Default_Values

    /////// constructor /////
    public Transport(String brand, String model, double engineVolume, ArrayList<S> mechanicsList) {

        this.brand = simpleCheckString(brand, Default_Values.default_brand);
        this.model = simpleCheckString(model, Default_Values.default_model);
        this.engineVolume = (engineVolume > 0) ? engineVolume : Default_Values.default_engine_volume;
        this.mechanicsList=mechanicsList;
    }// constructor
    public Transport(String brand, String model, double engineVolume) {

        this.brand = simpleCheckString(brand, Default_Values.default_brand);
        this.model = simpleCheckString(model, Default_Values.default_model);
        this.engineVolume = (engineVolume > 0) ? engineVolume : Default_Values.default_engine_volume;
        this.mechanicsList=new ArrayList<S>();
        Mechanic noMechanic = new Mechanic("NO_MECHANICS","NO_MECHANICS","NO_COMPANY");
        this.mechanicsList.add((S) noMechanic);
    }// constructor2

    /////// utility ////////

    protected String simpleCheckString(String forCheck, String default_value) {
        if(forCheck==null || forCheck.isBlank()) {
            System.out.println("Некорректный ввод. Значение будет измененено на: "+default_value);
            return default_value;
        }
        return forCheck.trim().replace("\\s+"," ");
    }
    @Override
    public String toString() {
        return String.format("Brand[%1$s], Model[%2$s], EngineVolume[%3$.1f]", brand, model, engineVolume);
    }
    /////// methods ///////

    abstract public void startMoving();

    abstract public void stopMoving();

    /////// getters //////

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    abstract public void setDriver(T driver);

    abstract public void printMessage();

    abstract public T getDriver();

    abstract public void printType();

    public void passDiagnostic()  {
        System.out.println("Диагностика для транспорта пройдена");
    }

    @Override
    public int hashCode() {
        return brand.hashCode()+model.hashCode()+(int)(engineVolume*100);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj== null || obj.getClass()!=this.getClass())
            return false;
        Transport toCompare = (Transport) obj;
        return this.getBrand().equals(toCompare.getBrand()) && this.getModel().equals(toCompare.getModel()) && (this.getEngineVolume() == toCompare.engineVolume);
    }
} // Transport
