package br.pucpr.table.model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTableData implements TableData {
    private final List<TableDataObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(TableDataObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (TableDataObserver observer : observers) {
            observer.onDataChanged();
        }
    }
}