package ru.stqa.pft.rest.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Pharmacys extends ForwardingSet<PharmacyData> {

    private Set<PharmacyData> delegate;

    public Pharmacys(Pharmacys pharmacys) {
        this.delegate = new HashSet<PharmacyData>(pharmacys.delegate);
    }

    public Pharmacys(Collection<PharmacyData> pharmacys) {
        this.delegate = new HashSet<PharmacyData>(pharmacys);
    }


    @Override
    protected Set<PharmacyData> delegate() {
        return delegate;
    }

    public Pharmacys() {
        this.delegate = new HashSet<>();
    }

    public Pharmacys withAdded(PharmacyData pharmacy) {
        Pharmacys pharmacys = new Pharmacys(this);
        pharmacys.add(pharmacy);
        return pharmacys;
    }

    public Pharmacys withOut(PharmacyData pharmacy) {
        Pharmacys pharmacys = new Pharmacys(this);
        pharmacys.remove(pharmacy);
        return pharmacys;
    }
}
