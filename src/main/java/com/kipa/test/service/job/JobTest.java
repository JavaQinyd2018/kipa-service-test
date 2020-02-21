package com.kipa.test.service.job;

import com.kipa.job.JobOperationService;
import com.kipa.job.entity.JobBriefInfo;
import com.kipa.job.entity.JobSettings;
import com.kipa.job.entity.ServerBriefInfo;
import com.kipa.job.entity.ShardingInfo;
import com.kipa.test.base.TestNGSpringContextTests;
import com.kipa.test.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Collection;

public class JobTest extends TestNGSpringContextTests {

    @Autowired
    private JobOperationService jobOperationService;

    @Test
    public void testJob() {
        Collection<JobBriefInfo> allJobsBriefInfo = jobOperationService.getAllJobsBriefInfo("elastic-job-demo");
        System.out.println(allJobsBriefInfo);
    }

    @Test
    public void testJobSettings() {
        JobSettings demoSimpleJob = jobOperationService.getJobSettings("elastic-job-demo", "com.learn.springboot.springbootssmp.job.DemoSimpleJob");
        PrintUtils.println(demoSimpleJob);
    }

    @Test
    public void testJobsTotalCount() {
        int jobsTotalCount = jobOperationService.getJobsTotalCount("elastic-job-demo");
        PrintUtils.println(jobsTotalCount);
    }

    @Test
    public void testServersBriefInfo() {
        Collection<ServerBriefInfo> allServersBriefInfo = jobOperationService.getAllServersBriefInfo("elastic-job-demo");
        PrintUtils.println(allServersBriefInfo);
    }

    @Test
    public void testServersTotalCount() {
        int serversTotalCount = jobOperationService.getServersTotalCount("elastic-job-demo");
        PrintUtils.println(serversTotalCount);
    }

    @Test
    public void testShardingInfo() {
        Collection<ShardingInfo> shardingInfo = jobOperationService.getShardingInfo("elastic-job-demo", "com.learn.springboot.springbootssmp.job.DemoSimpleJob");
        System.out.println(shardingInfo);
    }

    @Test
    public void testTrigger() {
        jobOperationService.trigger("elastic-job-demo", "com.learn.springboot.springbootssmp.job.DemoSimpleJob");
    }
}
