package miu.cs.cs544.selam.jobsearchingtool.job.controller;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.model.ApplicationDTO;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.JobDTO;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import miu.cs.cs544.selam.jobsearchingtool.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @PostMapping(value = "/jobs")
    public Job addJob(@RequestBody JobDTO jobDTO){
        return this.jobService.addJob(jobDTO.getCompanyId(), jobDTO.getJob());
    }

    @GetMapping(value = "/jobs")
    public List<Job> getJobs(){
        return this.jobService.getJob();
    }

    @DeleteMapping(value = "/jobs/{id}")
    public void deleteJob(@PathVariable int id){
        this.jobService.deleteJob(id);
    }

    @PutMapping(value = "/jobs/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody JobDTO jobDTO){
        return this.jobService.updateJob(id, jobDTO.getCompanyId(),  jobDTO.getJob());
    }

    @PostMapping (value = "/jobs/{id}/skills")
    public List<Skill> addJobSkill(@PathVariable int id, Skill skill){
        return this.jobService.addJobSKillById(id, skill);
    }

    @GetMapping(value = "/jobs/{id}/skills")
    public List<Skill> getJobSkills(@PathVariable int id){
        return this.jobService.getJobSKillById(id);
    }

    @PutMapping(value = "/jobs/{id}/skills/{skillId}")
    public void updateJobSkill(@PathVariable int id,@PathVariable int skillId, Skill skill){
         this.jobService.updateJobKillsById(id, skillId, skill);
    }

    @DeleteMapping(value = "/jobs/{id}/skills/{skillId}")
    public List<Skill> deleteJobSkill(@PathVariable int id,@PathVariable int skillId){
        return this.jobService.deleteJobKillsById(id, skillId);
    }
}
