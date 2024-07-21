package com.batch_file_writer.BatchFileWriter.configuration;

import com.batch_file_writer.BatchFileWriter.entity.FileInput;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Bean
    public Job getJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                      ItemReader<FileInput> itemReader, ItemProcessor<FileInput, FileInput> itemProcessor,
                      ItemWriter<FileInput> itemWriter) {
        Step step = stepBuilderFactory.get("Batch-file-reader")
                .<FileInput, FileInput>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("Batch-file-processor")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<FileInput> fileReader(@Value("${input.file}") Resource resource) {
        FlatFileItemReader<FileInput> fileReader = new FlatFileItemReader<>();
        fileReader.setResource(new FileSystemResource("src/main/resources/input.csv"));
        fileReader.setName("File-Reader");
        fileReader.setLinesToSkip(1);
        fileReader.setLineMapper(lineMapper());
        return fileReader;
    }

    @Bean
    public LineMapper<FileInput> lineMapper() {
        DefaultLineMapper<FileInput> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("field1", "field2", "field3", "field4", "field5", "refkey1", "refkey2");

        BeanWrapperFieldSetMapper<FileInput> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(FileInput.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        return defaultLineMapper;
    }

}
