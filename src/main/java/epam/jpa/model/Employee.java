package epam.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "EMP_ID", unique = true, nullable = false)
    private long empId;

    @Column(name = "EMP_NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @Embedded
    private Address address;

    @OneToOne(fetch= FetchType.LAZY)
    private EmployeePersonalInfo info;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
    private List<Project> projects;

    @ManyToOne(fetch= FetchType.LAZY)
    private Unit unit;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public EmployeePersonalInfo getInfo() {
        return info;
    }

    public void setInfo(EmployeePersonalInfo info) {
        this.info = info;
    }



    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
