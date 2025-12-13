package de.openaqua.batchdemo.config;

import de.openaqua.batchdemo.domain.Customer;
import de.openaqua.batchdemo.domain.RecordFieldSetMapper;
import de.openaqua.batchdemo.domain.Transaction;
import de.openaqua.batchdemo.main.CustomItemProcessor;
import de.openaqua.batchdemo.processor.CustomerProcessorRouter;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.net.MalformedURLException;
import java.util.List;

@Profile("spring")
@Configuration
public class SpringBatchConfig {
    @Value("${file.input}")
    private Resource inputCsv;

    @Value("${file.input-error}")
    private Resource invalidInputCsv;

    @Value("${file.output}")
    private WritableResource outputXml;

    @Bean
    public ItemReader<Transaction> itemReader() throws UnexpectedInputException, ParseException {
        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<Transaction>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        String[] tokens = {"username", "userid", "transactiondate", "amount"};
        tokenizer.setNames(tokens);
        reader.setResource(inputCsv);
        DefaultLineMapper<Transaction> lineMapper = new DefaultLineMapper<Transaction>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new RecordFieldSetMapper());
        reader.setLineMapper(lineMapper);
        return reader;
    }



    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .<String, String>chunk(2, transactionManager)
                .reader(flatFileItemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<String> flatFileItemReader() {
        return new FlatFileItemReaderBuilder<String>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .lineMapper(new PassThroughLineMapper())
                .saveState(true)
                .build();
    }

    @Bean
    public RestartItemProcessor itemProcessor() {
        return new RestartItemProcessor();
    }

    static class RestartItemProcessor implements ItemProcessor<String, String> {
        private boolean failOnItem3 = true;

        public void setFailOnItem3(boolean failOnItem3) {
            this.failOnItem3 = failOnItem3;
        }

        @Override
        public String process(String item) throws Exception {
            System.out.println("Processing: " + item + " (failOnItem3=" + failOnItem3 + ")");
            if (failOnItem3 && item.equals("Item3")) {
                throw new RuntimeException("Simulated failure on Item3");
            }
            return "PROCESSED " + item;
        }
    }

    @Bean
    public ItemWriter<String> itemWriter() {
        return items -> {
            System.out.println("Writing items:");
            for (String item : items) {
                System.out.println("- " + item);
            }
        };
    }

    @Bean
    public Job simpleJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("simpleJob", jobRepository)
                .start(step1(jobRepository, transactionManager))
                //.preventRestart()
                .build();
    }
}
