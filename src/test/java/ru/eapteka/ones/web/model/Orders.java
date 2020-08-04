package ru.eapteka.ones.web.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Orders extends ForwardingSet<OrderData> {

    private Set<OrderData> delegate;

    public Orders(Orders orders) {
        this.delegate = new HashSet<OrderData>(orders.delegate);
    }

    public Orders(Collection<OrderData> orders) {
        this.delegate = new HashSet<OrderData>(orders);
    }


    @Override
    protected Set<OrderData> delegate() {
        return delegate;
    }

    public Orders() {
        this.delegate = new HashSet<>();
    }

    public Orders withAdded(OrderData order) {
        Orders groups = new Orders(this);
        groups.add(order);
        return groups;
    }

    public Orders withOut(OrderData order) {
        Orders orders = new Orders(this);
        orders.remove(order);
        return orders;
    }
}
