package demo_01.service;

import java.util.List;

public interface IEmployeeService <T,E>{
    List<T> findAll();
    void save(T t);
    T findById(E id);
    void delete(E id);
    int newId();
    boolean existsByEmail(String email);
    boolean checkRoles(List<String> role);
}
