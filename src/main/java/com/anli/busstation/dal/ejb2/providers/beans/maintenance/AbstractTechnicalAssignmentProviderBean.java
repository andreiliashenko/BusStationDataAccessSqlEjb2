package com.anli.busstation.dal.ejb2.providers.beans.maintenance;

import com.anli.busstation.dal.ejb2.providers.beans.AbstractBSProviderBean;
import com.anli.busstation.dal.interfaces.entities.maintenance.TechnicalAssignment;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;
import org.joda.time.DateTime;

public abstract class AbstractTechnicalAssignmentProviderBean<I extends TechnicalAssignment>
        extends AbstractBSProviderBean<I> {

    public List<I> findByMechanic(Mechanic mechanic) {
        return getEntityHandler().selectEntitiesByEqualsOrContains("mechanic", mechanic);
    }

    public List<I> findByAnyMechanic(Collection<Mechanic> mechanicList) {
        return getEntityHandler().selectEntitiesByAny("mechanic", mechanicList);
    }

    public List<I> findByBeginTimeRange(DateTime leftBT, boolean strictLeft,
            DateTime rightBT, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("beginTime", leftBT, strictLeft,
                rightBT, strictRight);
    }

    public List<I> findByEndTimeRange(DateTime leftET, boolean strictLeft,
            DateTime rightET, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("endTime", leftET, strictLeft, rightET, strictRight);
    }

    public List<I> findByServiceCostRange(BigDecimal leftCost, boolean strictLeft,
            BigDecimal rightCost, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("serviceCost", leftCost, strictLeft,
                rightCost, strictRight);
    }

    public List<BigInteger> collectIdsByMechanic(Mechanic mechanic) {
        return getEntityHandler().collectKeysByEqualsOrContains("mechanic", mechanic);
    }

    public List<BigInteger> collectIdsByAnyMechanic(Collection<Mechanic> mechanicList) {
        return getEntityHandler().collectKeysByAny("mechanic", mechanicList);
    }

    public List<BigInteger> collectIdsByBeginTimeRange(DateTime leftBT, boolean strictLeft,
            DateTime rightBT, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("beginTime", leftBT, strictLeft, rightBT, strictRight);
    }

    public List<BigInteger> collectIdsByEndTimeRange(DateTime leftET, boolean strictLeft,
            DateTime rightET, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("endTime", leftET, strictLeft, rightET, strictRight);
    }

    public List<BigInteger> collectIdsByServiceCostRange(BigDecimal leftCost, boolean strictLeft,
            BigDecimal rightCost, boolean strictRight) throws RemoteException {
        return getEntityHandler().collectKeysByRange("serviceCost", leftCost, strictLeft,
                rightCost, strictRight);
    }
}
