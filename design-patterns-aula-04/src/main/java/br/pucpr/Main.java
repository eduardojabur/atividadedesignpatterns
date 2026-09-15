package br.pucpr;

import br.pucpr.planet.Planet;
import br.pucpr.planet.PlanetsTableData;
import br.pucpr.planet.PlanetType;
import br.pucpr.table.Table;
import br.pucpr.table.model.PaginatedTableData;
import br.pucpr.table.model.TableData;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Planet> planets = new ArrayList<>();

    TableData baseData = new PlanetsTableData(planets);
    PaginatedTableData paginatedData = new PaginatedTableData(baseData, 3);
    Table table = new Table(paginatedData);

    System.out.println("=== PÁGINA " + paginatedData.getCurrentPage() + " DE " + paginatedData.getTotalPages() + " ===");
    table.print();

    paginatedData.nextPage();
    System.out.println("\n=== PÁGINA " + paginatedData.getCurrentPage() + " DE " + paginatedData.getTotalPages() + " ===");
    table.print();
  }
}