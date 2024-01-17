package com.ankit.raj.datagen.pojo;

import java.util.List;

public class ColumnDataResponse {
    private String columnName;
    private List<String> values;

    public ColumnDataResponse() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
