package com.batch_file_writer.BatchFileWriter.batch;

import com.batch_file_writer.BatchFileWriter.entity.FileInput;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class BatchItemWriter  implements ItemWriter<FileInput> {


    public void write(List<? extends FileInput> files) throws Exception {
        System.out.println("i am in writer");
    }

//    @Override
//    public void write(Chunk<? extends FileInput> chunk) throws Exception {
//        System.out.println(chunk.getItems());
//    }
}
