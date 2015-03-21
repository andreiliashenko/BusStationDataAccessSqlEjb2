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

    public List<I> findByAnyMechanic(Collection<Mechanic> mechanics) {
        return getEntityHandler().selectEntitiesByAny("mechanic", mechanics);
    }

    public List<I> findByBeginTimeRange(DateTime beginTimeLeft, boolean strictLeft,
            DateTime beginTimeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("beginTime", beginTimeLeft, strictLeft,
                beginTimeRight, strictRight);
    }

    public List<I> findByEndTimeRange(DateTime endTimeLeft, boolean strictLeft,
            DateTime endTimeRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("endTime", endTimeLeft, strictLeft,
                endTimeRight, strictRight);
    }

    public List<I> findByServiceCostRange(BigDecimal serviceCostLeft, boolean strictLeft,
            BigDecimal serviceCostRight, boolean strictRight) {
        return getEntityHandler().selectEntitiesByRange("serviceCost", serviceCostLeft, strictLeft,
                serviceCostRight, strictRight);
    }

    public List<BigInteger> collectIdsByMechanic(Mechanic mechanic) {
        return getEntityHandler().collectKeysByEqualsOrContains("mechanic", mechanic);
    }

    public List<BigInteger> collectIdsByAnyMechanic(Collection<Mechanic> mechanics) {
        return getEntityHandler().collectKeysByAny("mechanic", mechanics);
    }

    public List<BigInteger> collectIdsByBeginTimeRange(DateTime beginTimeLeft, boolean strictLeft,
            DateTime beginTimeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("beginTime", beginTimeLeft, strictLeft,
                beginTimeRight, strictRight);
    }

    public List<BigInteger> collectIdsByEndTimeRange(DateTime endTimeLeft, boolean strictLeft,
            DateTime endTimeRight, boolean strictRight) {
        return getEntityHandler().collectKeysByRange("endTime", endTimeLeft, strictLeft,
                endTimeRight, strictRight);
    }

    public List<BigInteger> collectIdsByServiceCostRange(BigDecimal serviceCostLeft, boolean strictLeft,
            BigDecimal serviceCostRight, boolean strictRight) throws RemoteException {
        return getEntityHandler().collectKeysByRange("serviceCost", serviceCostLeft, strictLeft,
                serviceCostRight, strictRight);
    }
}
