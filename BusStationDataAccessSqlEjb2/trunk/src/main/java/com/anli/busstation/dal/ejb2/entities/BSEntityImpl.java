package com.anli.busstation.dal.ejb2.entities;

import com.anli.busstation.dal.interfaces.entities.BSEntity;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

public abstract class BSEntityImpl implements BSEntity {

    protected BigInteger id;

    @Override
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object comparee) {
        if (this.id == null) {
            return false;
        }
        if (comparee == null) {
            return false;
        }
        if (!this.getClass().equals(comparee.getClass())) {
            return false;
        }
        BSEntityImpl compareeEntity = (BSEntityImpl) comparee;
        return this.id.equals(compareeEntity.getId());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Deprecated
    protected boolean nullableDeepEquals(BSEntityImpl first, BSEntityImpl second) {
        if (first != null) {
            return first.deepEquals(second);
        } else {
            return (second == null);
        }
    }

    @Deprecated
    protected boolean nullableEquals(Object first, Object second) {
        if (first != null) {
            return first.equals(second);
        } else {
            return (second == null);
        }
    }

    @Deprecated
    protected boolean nullableEquals(Comparable first, Comparable second) {
        if (first != null) {
            if (second == null) {
                return false;
            }
            return first.compareTo(second) == 0;
        } else {
            return (second == null);
        }
    }

    @Deprecated
    protected boolean nullableListDeepEquals(List<BSEntityImpl> first, List<BSEntityImpl> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null) {
            Iterator<BSEntityImpl> firstIter = first.iterator();
            Iterator<BSEntityImpl> secondIter = second.iterator();
            while (firstIter.hasNext() && secondIter.hasNext()) {
                if (!nullableDeepEquals(firstIter.next(), secondIter.next())) {
                    return false;
                }
            }
            return !firstIter.hasNext() && !secondIter.hasNext();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " id = " + id;
    }
}
