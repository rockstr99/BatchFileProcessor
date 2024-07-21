package com.batch_file_writer.BatchFileWriter.batch;

import com.batch_file_writer.BatchFileWriter.entity.FileInput;
import org.springframework.stereotype.Component;

@Component
public class ItemProcessor implements org.springframework.batch.item.ItemProcessor<FileInput,FileInput> {



    @Override
    public FileInput process(FileInput item) throws Exception {
        System.out.println(item.toString());
        return null;
    }
}
