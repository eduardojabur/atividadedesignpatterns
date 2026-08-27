package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

public class NameColumn implements ColumnData<User> {
    @Override
    public String getTitle() {
        return "          NOME           ";
    }

    @Override
    public String getValue(User user) {
        return user.name() == null || user.name().isEmpty() ? "NÃO INFORMADO" : user.name();
    }
}