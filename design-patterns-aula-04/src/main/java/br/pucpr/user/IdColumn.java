package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

public class IdColumn implements ColumnData<User> {
  @Override
  public String getTitle() {
    return "  ID";
  }

  @Override
  public String getValue(User user) {
    return user.id() != null ? "%4d".formatted(user.id()) : "-";
  }
}