package com.repository.list;

import java.util.ArrayList;
import java.util.List;

import com.core.repository.Repository;

public class RepositoryListImpl<T> implements Repository<T> {
    protected List<T> list = new ArrayList<>();

    @Override
    public void inserer(T data) {
        list.add(data);
    }

    @Override
    public List<T> selectionnerTout() {
        return new ArrayList<>(list);
    }
}