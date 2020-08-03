package ru.eapteka.ones.web.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Pages extends ForwardingSet<PageData> {

    private Set<PageData> delegate;

    public Pages(Pages pages) {
        this.delegate = new HashSet<PageData>(pages.delegate);
    }

    public Pages(Collection<PageData> pages) {
        this.delegate = new HashSet<PageData>(pages);
    }


    @Override
    protected Set<PageData> delegate() {
        return delegate;
    }

    public Pages() {
        this.delegate = new HashSet<>();
    }

    public Pages withAdded(PageData pageData) {
        Pages pages = new Pages(this);
        pages.add(pageData);
        return pages;
    }

    public Pages withOut(PageData pageData) {
        Pages pages = new Pages(this);
        pages.remove(pageData);
        return pages;
    }
}
