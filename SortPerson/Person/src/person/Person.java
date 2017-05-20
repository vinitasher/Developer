
package person;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Person {

    @NotNull
    @Pattern(regexp = "^(123-45-6789|XXX-XX-XXXX)$", message = "SSN is invalid")
    private String ssn;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Double heightIn;
    @NotNull
    private Double weightLb;

    Person(String ssn, Date dateOfBirth, String firstName, String lastName, Double heightIn,
            Double weightLb) throws Exception{
        if(ssn != null && ssn.matches("\\d{3}-\\d{2}-\\d{4}")){
            this.ssn = ssn;
        } else {
            throw new Exception("SSN is invalid");
        }
        
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightIn = heightIn;
        this.weightLb = weightLb;
    }
    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the heightIn
     */
    public Double getHeightIn() {
        return heightIn;
    }

    /**
     * @param heightIn the heightIn to set
     */
    public void setHeightIn(Double heightIn) {
        this.heightIn = heightIn;
    }

    /**
     * @return the weightLb
     */
    public Double getWeightLb() {
        return weightLb;
    }

    /**
     * @param weightLb the weightLb to set
     */
    public void setWeightLb(Double weightLb) {
        this.weightLb = weightLb;
    }
}

