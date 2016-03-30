package epam.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "UNIT_ID", unique = true, nullable = false)
    private long unitId;
    @Column(name = "UNIT_NAME", nullable = false)
    private String unitName;

    public Unit(){
    }

    public Unit(String name) {
        this.unitName = name;
    }

    @OneToMany(mappedBy="unit")
    private List<Employee> employees;

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
