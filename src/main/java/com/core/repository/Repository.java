package com.core.repository;

import java.util.List;

public interface Repository<T> {
    void inserer(T data);
    List<T> selectionnerTout();
}