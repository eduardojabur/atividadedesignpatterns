package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

public class EmailColumn implements ColumnData<User> {
    @Override
    public String getTitle() {
        return "       E-MAIL       ";
    }

    @Override
    public String getValue(User user) {
        return user.email() == null || !user.email().contains("@") ? "INVÁLIDO" : user.email();
    }
}