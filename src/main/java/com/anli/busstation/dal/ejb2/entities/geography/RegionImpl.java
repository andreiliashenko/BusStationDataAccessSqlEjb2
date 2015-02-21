package com.anli.busstation.dal.ejb2.entities.geography;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.entities.geography.Region;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import java.util.List;

public class RegionImpl extends BSEntityImpl implements Region {

    protected String name;
    protected Integer code;
    protected List<StationImpl> stations;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public List<Station> getStations() {
        return (List) stations;
    }

    public void setStations(List<StationImpl> stations) {
        this.stations = stations;
    }

    @Override
    public boolean deepEquals(BSEntity comparee) {
        if (!this.equals(comparee)) {
            return false;
        }
        RegionImpl regComparee = (RegionImpl) comparee;
        return nullableEquals(this.name, regComparee.name)
                && nullableEquals(this.code, regComparee.code)
                && nullableListDeepEquals((List) this.stations, (List) regComparee.stations);
    }

    @Override
    public String toString() {
        return super.toString() + " name = " + name + " code = " + code
                + " stations = " + stations;
    }
}
