package lesson_22;

public class Mechanic {
    private String firstName="default_First_Name";
    private String lastName="default_Last_Name";
    private String company="default_Company";

    private boolean simpleStringCheck(String forCheck) {
        if(forCheck!=null && !forCheck.isBlank())
            return true;
        return false;
    }
    public Mechanic(String firstName, String lastName, String company) {
        if(simpleStringCheck(firstName))
            this.firstName=firstName;
        if(simpleStringCheck(lastName))
            this.lastName=lastName;
        if(simpleStringCheck(company))
            this.company=company;
    }

    public void makeDiagnostic() {
        System.out.println("Mechanic: " + this.firstName + " " + this.lastName + " working in company: " + this.company + "- make Diagnostic");
    }

    public void repairTransport() {
        System.out.println("Mechanic: " + this.firstName + " " + this.lastName + " working in company: " + this.company + "- repair Transport");
    }

    ////// getters /////

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }
    ////// setters /////

    public void setFirstName(String firstName) {
        if(simpleStringCheck(firstName))
            this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (simpleStringCheck(lastName))
            this.lastName = lastName;
    }

    public void setCompany(String company) {
        if(simpleStringCheck(company))
            this.company = company;
    }

    @Override
    public String toString() {
        return this.firstName+" "+this.lastName+" ["+this.company+"]";
    }
}
