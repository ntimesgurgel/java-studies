package br.com.alura.springdatajpa.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="work_unit")
public class WorkUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String address;

    @ManyToMany(mappedBy = "workUnitList", fetch = FetchType.EAGER)
    private List<Employee> employeeList;

    public WorkUnit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "WorkUnit{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
