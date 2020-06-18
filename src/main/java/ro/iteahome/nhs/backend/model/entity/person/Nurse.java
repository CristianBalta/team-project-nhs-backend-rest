package ro.iteahome.nhs.backend.model.entity.person;

import ro.iteahome.nhs.backend.model.entity.institution.Institution;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "nurses")
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;

    @NotNull(message = "CNP CANNOT BE EMPTY.")
    @Pattern(regexp = "[1-8]\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])(0[1-9]|[1-4]\\d|5[0-2]|99)\\d{4}", message = "INVALID CNP")
    @Column(name = "cnp", nullable = false, unique = true, columnDefinition = "VARCHAR(13)")
    private String cnp;

    @NotNull(message = "TITLE CANNOT BE EMPTY.")
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(20)")
    private String title; // TODO: Create this by concatenating corresponding enum values chosen via a drop-down menu.

    @NotNull(message = "FIRST NAME CANNOT BE EMPTY.")
    @Column(name = "first_name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String firstName;

    @NotNull(message = "LAST NAME CANNOT BE EMPTY.")
    @Column(name = "last_name", nullable = false, columnDefinition = "VARCHAR(50)")
    private String lastName;

    @NotNull(message = "EMAIL CANNOT BE EMPTY.")
    @Email(regexp = ".+@.+\\.\\w+", message = "INVALID EMAIL ADDRESS")
    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private String email;

    @NotNull(message = "PHONE NUMBER CANNOT BE EMPTY.")
    @Pattern(regexp = "^0040\\d{9}$", message = "INVALID PHONE NUMBER")
    @Column(name = "phone_ro", nullable = false, unique = true, columnDefinition = "VARCHAR(13)")
    private String phoneNoRo;

    @NotNull(message = "NURSING LICENSE NUMBER CANNOT BE EMPTY.")
    @Column(name = "nursing_license", nullable = false, unique = true, columnDefinition = "VARCHAR(10)")
    private String nursingLicenseNo;

    @NotNull(message = "SPECIALTIES CANNOT BE EMPTY.")
    @Column(name = "specialties", nullable = false, columnDefinition = "VARCHAR(255)")
    private String specialties; // TODO: Create this by concatenating corresponding enum values chosen via a drop-down menu.

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "nurses_institutions",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "institution_id", referencedColumnName = "id"))
    private Set<Institution> institutions;

    public Nurse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNoRo() {
        return phoneNoRo;
    }

    public void setPhoneNoRo(String phoneNoRo) {
        this.phoneNoRo = phoneNoRo;
    }

    public String getNursingLicenseNo() {
        return nursingLicenseNo;
    }

    public void setNursingLicenseNo(String nursingLicenseNo) {
        this.nursingLicenseNo = nursingLicenseNo;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Set<Institution> institutions) {
        this.institutions = institutions;
    }
}