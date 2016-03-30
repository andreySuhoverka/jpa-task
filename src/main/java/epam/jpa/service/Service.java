package epam.jpa.service;

import epam.jpa.model.Employee;
import epam.jpa.model.Project;
import epam.jpa.model.Unit;
import epam.jpa.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Service {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public <T> T createEmployee(T entity){
        return wrapInTransaction(() -> {
            session.save(entity);
            return entity;
        });
    }

    public <T> T findById(long id, Class<T> entityClass){
        return session.get(entityClass, id);
    }

    public <T> void deleteById(long id, Class<T> entityClass){
        wrapInTransaction(() -> {
            T persistentInstance = session.load(entityClass, id);
            if (persistentInstance != null) {
                session.delete(persistentInstance);
            }
            return null;
        });
    }

    public <T> void update(T entity){
        wrapInTransaction(() -> {
            session.saveOrUpdate(entity);
            return null;
        });
    }

    public void addEmployeeToUnitByIds(List<Long> ids, Unit u) {
        ids.forEach((id) -> {
            wrapInTransaction(() -> {
                Employee emp = session.load(Employee.class, id);
                emp.setUnit(u);
                session.saveOrUpdate(emp);
                return null;
            });
        });
    }

    public void assignEmployeeForProjectByIds(List<Long> ids, Project p) {
        ids.forEach((id) -> {
            wrapInTransaction(() -> {
                Employee emp = session.load(Employee.class, id);
                emp.setProjects(Arrays.asList(p));
                session.saveOrUpdate(emp);
                return null;
            });
        });
    }

    private <T> T wrapInTransaction(Supplier<T> supplier) {
        session.beginTransaction();
        T entity = supplier.get();
        session.getTransaction().commit();
        return entity;
    }





}
