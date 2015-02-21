package com.anli.busstation.dal.ejb2.entities.staff;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import java.math.BigDecimal;
import org.joda.time.DateTime;

public abstract class EmployeeImpl extends BSEntityImpl implements Employee {

    protected String name;
    protected BigDecimal salary;
    protected DateTime hiringDate;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public DateTime getHiringDate() {
        return hiringDate;
    }

    @Override
    public void setHiringDate(DateTime hiringDate) {
        this.hiringDate = hiringDate;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        EmployeeImpl empComparee = (EmployeeImpl) comparee;
        return nullableEquals(this.name, empComparee.name)
                && nullableEquals(this.hiringDate, empComparee.hiringDate)
                && nullableEquals(this.salary, empComparee.salary);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name
                + " salary = " + salary + " hiringDate = " + hiringDate;
    }
}
