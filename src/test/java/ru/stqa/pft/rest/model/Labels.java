package ru.stqa.pft.rest.model;


import com.google.common.collect.ForwardingSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Labels extends ForwardingSet<LabelData> {

    private Set<LabelData> delegate;

    public Labels(Labels labels) {
        this.delegate = new HashSet<LabelData>(labels.delegate);
    }

    public Labels(Collection<LabelData> labels) {
        this.delegate = new HashSet<LabelData>(labels);
    }


    @Override
    protected Set<LabelData> delegate() {
        return delegate;
    }

    public Labels() {
        this.delegate = new HashSet<>();
    }

    public Labels withAdded(LabelData label) {
        Labels labels = new Labels(this);
        labels.add(label);
        return labels;
    }

    public Labels withOut(LabelData label) {
        Labels labels = new Labels(this);
        labels.remove(label);
        return labels;
    }
}
