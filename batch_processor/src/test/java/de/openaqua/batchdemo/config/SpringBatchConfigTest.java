package de.openaqua.batchdemo.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpringBatchConfigTest {

    void basicTest(Object o) {
        assertNotNull(o);
    }

    @Test
    void testSomeBeans() {
        SpringBatchConfig appConfiguration = new SpringBatchConfig();
        basicTest(appConfiguration.flatFileItemReader());
    }

/*
    @Test
    public void givenItems_whenFailed_thenRestartFromFailure() throws Exception {
        // Given
        createTestFile("Item1\nItem2\nItem3\nItem4");

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        // When
        JobExecution firstExecution = jobLauncherTestUtils.launchJob(jobParameters);
        assertEquals(BatchStatus.FAILED, firstExecution.getStatus());

        Long executionId = firstExecution.getId();

        itemProcessor.setFailOnItem3(false);

        // Then
        JobExecution restartedExecution = jobLauncherTestUtils.launchJob(jobParameters);

        assertEquals(BatchStatus.COMPLETED, restartedExecution.getStatus());

        assertEquals(
                firstExecution.getJobInstance().getInstanceId(),
                restartedExecution.getJobInstance().getInstanceId()
        );
    }

 */
}