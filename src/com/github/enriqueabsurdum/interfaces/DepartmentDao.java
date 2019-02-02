package com.github.enriqueabsurdum.interfaces;

import com.github.enriqueabsurdum.models.Department;

public interface DepartmentDao extends GenericDao<Department, Integer> {

    public Department getByDepartment(String value);
}
