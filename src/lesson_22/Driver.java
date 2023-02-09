package lesson_22;



abstract public class Driver  {

    protected static class Default_Values{
        static String default_Name = "default_name";
        static DriverLicence default_Driver_Licence = DriverLicence.CAR_LICENCE;
        static int default_Driver_Experience = 1;
    }
    private String driverFullName;
    private DriverLicence licence;
    private int driverExperience;

    public Driver(String fullName, String licence, int driverExperience) {
        this.driverFullName = simpleStringCheck(fullName, Default_Values.default_Name);
        licence = simpleStringCheck(licence, Default_Values.default_Driver_Licence.toString()).toUpperCase();
        switch (licence) {
            case ("B"):
            case("CAR"):
            case ("CAR_LICENCE"):
            case ("CAR LICENCE"):
                this.licence=DriverLicence.CAR_LICENCE;
                break;
            case ("D"):
            case("BUS"):
            case ("BUS_LICENCE"):
            case ("BUS LICENCE"):
                this.licence=DriverLicence.BUS_LICENCE;
                break;
            case ("C"):
            case("TRUCK"):
            case ("TRUCK_LICENCE"):
            case ("TRUCK LICENCE"):
                this.licence=DriverLicence.TRUCK_LICENCE;
                break;
            case("0"):
            case("ZERO"):
            case ("ZERO_LICENCE"):
            case ("ZERO LICENCE"):
                this.licence=DriverLicence.NO_LICENCE;
                break;
            default:
                System.out.println("Incorrect Driver Licence. Changed to Licecne 'A'");
                this.licence=DriverLicence.CAR_LICENCE;
                break;
        }
        this.driverExperience = (driverExperience>=0)? driverExperience : Default_Values.default_Driver_Experience;
    } // constructor 1

    public Driver(String fullname, DriverLicence licence, int driverExperience) {
        this.driverFullName = simpleStringCheck(fullname, Default_Values.default_Name);
        this.licence=licence;
        this.driverExperience = (driverExperience>=0)? driverExperience : Default_Values.default_Driver_Experience;
    } // constructor 2

    /////////////// utility ////////////////
    protected String simpleStringCheck(String forCheck, String default_value) {
        if (forCheck == null || forCheck.isBlank()) {
            //throw new IllegalArgumentException("Empty string");
            System.out.println("Пустая стропка, замена на "+default_value);
            return default_value;
        }
        return forCheck.trim().replaceAll("\\s+", " ");
    } // check

    //////////////// methods /////////////////

    public void startMoving() {
            System.out.println("Driver: " + this.driverFullName + " start moving");

    }

    public void stopMoving() {
        System.out.println("Driver: " + this.driverFullName + " stop moving");
    }

    public void refuelCar() {
        System.out.println("Driver: " + this.driverFullName + " refuel");
    }
    //////////////// getters /////////////////

    public String getDriverFullName() {
        return driverFullName;
    }

    public DriverLicence getLicence() {
        return licence;
    }

    public int getDriverExperience() {
        return driverExperience;
    }

    @Override
    public int hashCode() {
        return this.getDriverFullName().hashCode()+this.getDriverExperience()+this.getLicence().name().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if (obj==null || obj.getClass()!=this.getClass())
            return false;
        Driver driver = (Driver) obj;
        return (this.getDriverFullName().equals(driver.getDriverFullName())) &&
                (this.getDriverExperience() == driver.getDriverExperience()) &&
                (this.getLicence().name().equals(driver.getLicence().name()));
    }
}
