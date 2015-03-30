package com.anli.busstation.dal.ejb2.providers.beans.staff;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.staff.Employee;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import org.joda.time.DateTime;

public abstract class AbstractEmployeeProviderBean<I extends Employee>
        extends AbstractBSProviderBean<I> {

    public List<I> findByName(String name) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("name", name);
    }

    public List<I> findByNameRegexp(String nameRegexp) {
        return getEntityHandler().selectEntitiesByRegexp("name", nameRegexp);
    }

    public List<I> findBySalaryRange(BigDecimal salaryLeft, boolean strictLeft,
            BigDecimal salaryRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("salary", salaryLeft, strictLeft,
                salaryRight, strictRight);
    }

    public List<I> findByHiringDateRange(DateTime hiringDateLeft, boolean strictLeft,
            DateTime hiringDateRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("hiringDate", hiringDateLeft, strictLeft,
                hiringDateRight, strictRight);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsBySalaryRange(BigDecimal salaryLeft, boolean strictLeft,
            BigDecimal salaryRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("salary", salaryLeft, strictLeft,
                salaryRight, strictRight);
    }

    public List<BigInteger> collectIdsByHiringDateRange(DateTime hiringDateLeft, boolean strictLeft,
            DateTime hiringDateRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("hiringDate", hiringDateLeft, strictLeft,
                hiringDateRight, strictRight);
    }
}
