package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.interfaces.entities.staff.Employee;

public class EmployeeProviderBean extends AbstractEmployeeProviderBean<Employee> {

    @Override
    protected String getEntityName() {
        return "Employee";
    }

    @Override
    public Employee create() {
        return null;
    }
}
