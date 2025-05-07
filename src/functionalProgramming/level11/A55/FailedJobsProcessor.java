package functionalProgramming.level11.A55;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FailedJobsProcessor {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("DataImport", "SUCCESS"),
                new Job("Cleanup", "FAILED"),
                new Job("ReportGeneration", "FAILED"),
                new Job("Backup", "SUCCESS"),
                new Job("ArchiveOldLogs", "FAILED")
        );

        List<String> failedJobNames = jobs.stream()
                .filter(job -> job.getStatus().equalsIgnoreCase("FAILED"))
                .map(job -> job.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Failed Jobs: " + failedJobNames);
    }
}
