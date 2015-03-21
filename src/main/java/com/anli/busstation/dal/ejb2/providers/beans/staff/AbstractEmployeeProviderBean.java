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

    public List<I> findBySalaryRange(BigDecimal salaryLeft, boolean leftStrict,
            BigDecimal salaryRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("salary", salaryLeft, leftStrict,
                salaryRight, rightStrict);
    }

    public List<I> findByHiringDateRange(DateTime hiringDateLeft, boolean leftStrict,
            DateTime hiringDateRight, boolean rightStrict) {
        return getEntityHandler().selectEntitiesByRange("hiringDate", hiringDateLeft, leftStrict,
                hiringDateRight, rightStrict);
    }

    public List<BigInteger> collectIdsByName(String name) {
        return getEntityHandler().collectKeysByEqualsOrContains("name", name);
    }

    public List<BigInteger> collectIdsByNameRegexp(String nameRegexp) {
        return getEntityHandler().collectKeysByRegexp("name", nameRegexp);
    }

    public List<BigInteger> collectIdsBySalaryRange(BigDecimal salaryLeft, boolean leftStrict,
            BigDecimal salaryRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("salary", salaryLeft, leftStrict,
                salaryRight, rightStrict);
    }

    public List<BigInteger> collectIdsByHiringDateRange(DateTime hiringDateLeft, boolean leftStrict,
            DateTime hiringDateRight, boolean rightStrict) {
        return getEntityHandler().collectKeysByRange("hiringDate", hiringDateLeft, leftStrict,
                hiringDateRight, rightStrict);
    }
}
