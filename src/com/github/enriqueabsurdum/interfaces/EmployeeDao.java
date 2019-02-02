package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Employee;

public interface EmployeeDao extends GenericDao<Employee, Integer> {

    public Employee getByRun(String value);

}
