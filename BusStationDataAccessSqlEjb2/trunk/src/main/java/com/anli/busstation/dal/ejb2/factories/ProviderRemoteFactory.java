package com.anli.busstation.dal.ejb2.factories;

import com.anli.busstation.dal.ejb2.providers.homes.BSEntityProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.vehicles.BusProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.maintenance.BusRefuellingProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.maintenance.BusRepairmentProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.maintenance.BusServiceProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.DriverProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.DriverSkillProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.EmployeeProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.vehicles.GasLabelProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.MechanicProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.MechanicSkillProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.vehicles.ModelProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.geography.RegionProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.RidePointProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.RideProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.RideRoadProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.geography.RoadProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.RoutePointProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.RouteProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.staff.SalesmanProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.geography.StationProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.maintenance.StationServiceProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.maintenance.TechnicalAssignmentProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.vehicles.TechnicalStateProviderHome;
import com.anli.busstation.dal.ejb2.providers.homes.traffic.TicketProviderHome;
import com.anli.busstation.dal.ejb2.providers.remotes.BSEntityProviderRemote;
import com.anli.busstation.dal.interfaces.providers.BSEntityProvider;
import com.anli.busstation.dal.interfaces.providers.vehicles.BusProvider;
import com.anli.busstation.dal.interfaces.providers.maintenance.BusRefuellingProvider;
import com.anli.busstation.dal.interfaces.providers.maintenance.BusRepairmentProvider;
import com.anli.busstation.dal.interfaces.providers.maintenance.BusServiceProvider;
import com.anli.busstation.dal.interfaces.providers.staff.DriverProvider;
import com.anli.busstation.dal.interfaces.providers.staff.DriverSkillProvider;
import com.anli.busstation.dal.interfaces.providers.staff.EmployeeProvider;
import com.anli.busstation.dal.interfaces.providers.vehicles.GasLabelProvider;
import com.anli.busstation.dal.interfaces.providers.staff.MechanicProvider;
import com.anli.busstation.dal.interfaces.providers.staff.MechanicSkillProvider;
import com.anli.busstation.dal.interfaces.providers.vehicles.ModelProvider;
import com.anli.busstation.dal.interfaces.providers.geography.RegionProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.RidePointProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.RideProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.RideRoadProvider;
import com.anli.busstation.dal.interfaces.providers.geography.RoadProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.RoutePointProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.RouteProvider;
import com.anli.busstation.dal.interfaces.providers.staff.SalesmanProvider;
import com.anli.busstation.dal.interfaces.providers.geography.StationProvider;
import com.anli.busstation.dal.interfaces.providers.maintenance.StationServiceProvider;
import com.anli.busstation.dal.interfaces.providers.maintenance.TechnicalAssignmentProvider;
import com.anli.busstation.dal.interfaces.providers.vehicles.TechnicalStateProvider;
import com.anli.busstation.dal.interfaces.providers.traffic.TicketProvider;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProviderRemoteFactory extends AbstractLookupFactory {
    
    private static final Logger LOG = LoggerFactory.getLogger(ProviderRemoteFactory.class);
    
    protected final static Map<Class<? extends BSEntityProvider>, Class<? extends BSEntityProviderHome>> implementations = new HashMap<>();
    
    {
        implementations.put(BusProvider.class, BusProviderHome.class);
        implementations.put(BusRefuellingProvider.class, BusRefuellingProviderHome.class);
        implementations.put(BusRepairmentProvider.class, BusRepairmentProviderHome.class);
        implementations.put(BusServiceProvider.class, BusServiceProviderHome.class);
        implementations.put(DriverProvider.class, DriverProviderHome.class);
        implementations.put(DriverSkillProvider.class, DriverSkillProviderHome.class);
        implementations.put(EmployeeProvider.class, EmployeeProviderHome.class);
        implementations.put(GasLabelProvider.class, GasLabelProviderHome.class);
        implementations.put(MechanicProvider.class, MechanicProviderHome.class);
        implementations.put(MechanicSkillProvider.class, MechanicSkillProviderHome.class);
        implementations.put(ModelProvider.class, ModelProviderHome.class);
        implementations.put(RegionProvider.class, RegionProviderHome.class);
        implementations.put(RidePointProvider.class, RidePointProviderHome.class);
        implementations.put(RideProvider.class, RideProviderHome.class);
        implementations.put(RideRoadProvider.class, RideRoadProviderHome.class);
        implementations.put(RoadProvider.class, RoadProviderHome.class);
        implementations.put(RoutePointProvider.class, RoutePointProviderHome.class);
        implementations.put(RouteProvider.class, RouteProviderHome.class);
        implementations.put(SalesmanProvider.class, SalesmanProviderHome.class);
        implementations.put(StationProvider.class, StationProviderHome.class);
        implementations.put(StationServiceProvider.class, StationServiceProviderHome.class);
        implementations.put(TechnicalAssignmentProvider.class, TechnicalAssignmentProviderHome.class);
        implementations.put(TechnicalStateProvider.class, TechnicalStateProviderHome.class);
        implementations.put(TicketProvider.class, TicketProviderHome.class);
    }
    
    public <I> BSEntityProviderRemote<?> getProvider(Class<? extends BSEntityProvider> type) {
        try {
            Class<? extends BSEntityProviderHome> implementation = implementations.get(type);
            if (implementation == null) {
                return null;
            }
            return (BSEntityProviderRemote) lookupRemote(implementation).create();
        } catch (RemoteException remoteException) {
            LOG.error("Could not create provider by home interface", remoteException);
            return null;
        }
    }
}
