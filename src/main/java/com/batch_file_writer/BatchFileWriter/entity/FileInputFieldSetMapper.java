package com.batch_file_writer.BatchFileWriter.entity;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class FileInputFieldSetMapper implements FieldSetMapper<FileInput> {

    @Override
    public FileInput mapFieldSet(FieldSet fieldSet) {
        FileInput fileInput = new FileInput();
        fileInput.setField1(fieldSet.readString(0));
        fileInput.setField2(fieldSet.readString(1));
        fileInput.setField3(fieldSet.readString(2));
        fileInput.setField4(fieldSet.readString(3));
        fileInput.setField5(fieldSet.readString(4));
        fileInput.setRefKey1(fieldSet.readString(5));
        fileInput.setRefKey2(fieldSet.readString(6));

        return fileInput;
    }
}
