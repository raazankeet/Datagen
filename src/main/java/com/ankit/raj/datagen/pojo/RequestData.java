package com.ankit.raj.datagen.pojo;

import java.util.List;

public class RequestData {

    private int numRecords;
    private String locale;
    private List<ColumnData> columnsData;

    public RequestData() {
    }

    public int getNumRecords() {
        return numRecords;
    }

    public void setNumRecords(int numRecords) {
        this.numRecords = numRecords;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<ColumnData> getColumnsData() {
        return columnsData;
    }

    public void setColumnsData(List<ColumnData> columnsData) {
        this.columnsData = columnsData;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "numRecords=" + numRecords +
                ", locale='" + locale + '\'' +
                ", columnsData=" + columnsData +
                '}';
    }
}
