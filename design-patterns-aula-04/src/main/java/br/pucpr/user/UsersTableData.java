package br.pucpr.user;

import br.pucpr.table.model.ColumnTableData;
import java.util.ArrayList;
import java.util.List;

public class UsersTableData extends ColumnTableData<User> {
  private final CpfColumn cpfColumn;

  // Construtor privado para inicializar a instância da coluna antes da chamada do super()
  private UsersTableData(ArrayList<User> users, CpfColumn cpfColumn) {
    super(users, List.of(
            new IdColumn(),
            new NameColumn(),
            cpfColumn,
            new EmailColumn()
    ));
    this.cpfColumn = cpfColumn;
  }

  public UsersTableData(ArrayList<User> users, boolean maskCpf) {
    this(users, new CpfColumn(maskCpf));
  }

  public UsersTableData(ArrayList<User> users) {
    this(users, true);
  }

  public boolean isMaskCpf() {
    return cpfColumn.isMaskCpf();
  }

  public void setMaskCpf(boolean maskCpf) {
    cpfColumn.setMaskCpf(maskCpf);
  }
}