package br.pucpr.user;

import br.pucpr.table.model.ColumnData;

public class CpfColumn implements ColumnData<User> {
    private boolean maskCpf;

    public CpfColumn(boolean maskCpf) {
        this.maskCpf = maskCpf;
    }

    public boolean isMaskCpf() {
        return maskCpf;
    }

    public void setMaskCpf(boolean maskCpf) {
        this.maskCpf = maskCpf;
    }

    @Override
    public String getTitle() {
        return "       CPF      ";
    }

    @Override
    public String getValue(User user) {
        String cpf = user.cpf();
        if (cpf == null || cpf.length() != 11) {
            return "CPF INVÁLIDO";
        }
        if (maskCpf) {
            return "***." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-**";
        }
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

    @Override
    public String header() {
        return "";
    }

    @Override
    public String get(User object) {
        return "";
    }
}