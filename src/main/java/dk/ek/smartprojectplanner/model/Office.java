
package dk.ek.smartprojectplanner.model;

public class Office {

    private int officeId;
    private String officeName;
    private String officeCountry;

    public Office(int officeId, String officeName, String officeCountry) {
        this.officeId = officeId;
        this.officeName = officeName;
        this.officeCountry = officeCountry;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getOfficeCountry() {
        return officeCountry;
    }

    public void setOfficeCountry(String officeCountry) {
        this.officeCountry = officeCountry;
    }
}
