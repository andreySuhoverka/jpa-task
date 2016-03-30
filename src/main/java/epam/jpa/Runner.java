package epam.jpa;

import epam.jpa.model.Project;
import epam.jpa.service.Service;

public class Runner {

    public static void main(String[] args) {

        /*EmployeePersonalInfo employeePersonalInfo = new EmployeePersonalInfo("suhoverka.andrey@gmail.com", "7777373");
        session.save(employeePersonalInfo);
        session.flush();

        Employee emp = new Employee();
        emp.setName("andre");
        emp.setAddress(new Address("leschinskogo", 7));
        emp.setStatus(EmployeeStatus.BUSY);

        emp.setInfo(employeePersonalInfo);
        session.save(emp);

        Project project = new Project();
        project.setEmployees(Arrays.asList(emp));

        session.save(project);

        Unit unit = new Unit("ihg");
        unit.setEmployees(Arrays.asList(emp));
        session.save(unit);*/

        Service service = new Service();


        Project p = service.findById(33,Project.class);
        System.out.println(p.getName());
        service.deleteById(33,Project.class);
        Project p1 = service.findById(33,Project.class);
        System.out.println(p1);


    }


}
