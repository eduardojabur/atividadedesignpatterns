package br.pucpr.table.model;

public class PaginatedTableData extends AbstractTableData {
    private final TableData source;
    private final int pageSize;
    private int currentPage;

    public PaginatedTableData(TableData source, int pageSize) {
        this.source = source;
        this.pageSize = pageSize;
        this.currentPage = 0;
        this.source.addObserver(this::notifyObservers);
    }

    public void setPage(int page) {
        int maxPage = getTotalPages() - 1;
        this.currentPage = Math.max(0, Math.min(page, maxPage));
        notifyObservers();
    }

    public void nextPage() {
        if (currentPage < getTotalPages() - 1) {
            currentPage++;
            notifyObservers();
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
            notifyObservers();
        }
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) source.rowCount() / pageSize);
    }

    public int getCurrentPage() {
        return currentPage + 1;
    }

    @Override
    public int colCount() {
        return source.colCount();
    }

    @Override
    public String header(int columnIndex) {
        return source.header(columnIndex);
    }

    @Override
    public int rowCount() {
        int totalRows = source.rowCount();
        int offset = currentPage * pageSize;

        if (offset >= totalRows) {
            return 0;
        }
        return Math.min(pageSize, totalRows - offset);
    }

    @Override
    public String get(int row, int col) {
        int originalRowIndex = (currentPage * pageSize) + row;
        return source.get(originalRowIndex, col);
    }
}