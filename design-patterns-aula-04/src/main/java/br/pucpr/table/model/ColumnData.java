package br.pucpr.table.model;

import br.pucpr.user.User;

public interface ColumnData<T> {
  String getTitle();

  String getValue(User user);

  String header();

  String get(T object);
}
