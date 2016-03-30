package epam.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class EmployeePersonalInfo {


    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "INFO_ID", unique = true, nullable = false)
    private long id;
    @Column(name = "EMAIL", nullable = true)
    private String email;
    @Column(name = "TELEPHONE", nullable = true)
    private String telephone;

    public EmployeePersonalInfo(){
    }
    public EmployeePersonalInfo(String email, String telephone) {
        this.email = email;
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
