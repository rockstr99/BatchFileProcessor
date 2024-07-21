package com.batch_file_writer.BatchFileWriter.entity;

import java.io.Serializable;

public class FileInput implements Serializable {
    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String refKey1;

    private String refKey2;

    public FileInput() {
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getRefKey1() {
        return refKey1;
    }

    public void setRefKey1(String refKey1) {
        this.refKey1 = refKey1;
    }

    public String getRefKey2() {
        return refKey2;
    }

    public void setRefKey2(String refKey2) {
        this.refKey2 = refKey2;
    }

    @Override
    public String toString() {
        return "FileInput{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", refKey1='" + refKey1 + '\'' +
                ", refKey2='" + refKey2 + '\'' +
                '}';
    }
}
