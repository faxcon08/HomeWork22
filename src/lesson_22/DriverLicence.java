package lesson_22;

public enum DriverLicence {
    NO_LICENCE("ZERO"),
    CAR_LICENCE("B"),
    BUS_LICENCE("D"),
    TRUCK_LICENCE("C");

    private String typeLicence;
    private DriverLicence(String typeLicence) {
        this.typeLicence=typeLicence;
    }
}
