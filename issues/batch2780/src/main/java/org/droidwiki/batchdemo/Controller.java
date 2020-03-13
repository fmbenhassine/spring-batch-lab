package org.droidwiki.batchdemo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/jobs")
public class Controller {
    private final JobLauncher jobLauncher;
    private final Job demoJob;
//    private final ModelRepository modelRepository;

    Controller(JobLauncher jobLauncher, Job demoJob/*, ModelRepository modelRepository*/) {
        this.jobLauncher = jobLauncher;
        this.demoJob = demoJob;
//        this.modelRepository = modelRepository;
    }

    @PutMapping("/{id:[0-9]+}")
    public long put(@PathVariable long id) throws Exception {
//        Model model = new Model();
//        modelRepository.save(model);

        this.jobLauncher.run(demoJob, new JobParameters(Collections.singletonMap("ID", new JobParameter(id))));

        return id;
    }
}
