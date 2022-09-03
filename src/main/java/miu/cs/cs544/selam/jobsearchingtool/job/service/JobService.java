package miu.cs.cs544.selam.jobsearchingtool.job.service;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Client;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.company.service.CompanyService;
import miu.cs.cs544.selam.jobsearchingtool.exception.NotFoundException;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.JobRepository;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.JobSpecification;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    CompanyService companyService;

    public Job addJob(int companyId, Job job){
        Client company = this.companyService.findClientById(companyId);
        job.setCompany(company);

        Job savedJob = this.jobRepository.save(job);
        return savedJob;
    }

    public List<Job> getJob(){
        return this.jobRepository.findAll();
    }

    public Job updateJob(int id, int companyId, Job job){
        Job currentJob = this.getJobById(id);
        currentJob.setSkills(job.getSkills());
        currentJob.setSalary(job.getSalary());
        currentJob.setTitle(job.getTitle());

        Client company = this.companyService.findClientById(companyId);
        currentJob.setCompany(company);

        Job updatedJob = this.jobRepository.save(currentJob);
        return updatedJob;
    }

    public void deleteJob(int id){
        getJobById(id);
        this.jobRepository.deleteById(id);
    }

    public Job getJobById(int jobID) {
        Optional<Job> job = this.jobRepository.findById(jobID);
        if(job.isPresent()){
            return job.get();
        } else {
            throw new NotFoundException("Job with id "+ jobID + " not found");
        }
    }

    public List<Skill> getJobSKillById(int jobID) {
        Optional<Job> job = this.jobRepository.findById(jobID);
        if(job.isPresent()){
            return job.get().getSkills();
        } else {
            throw new NotFoundException("Job with id "+ jobID + " not found");
        }
    }

    public List<Skill> addJobSKillById(int jobID, Skill skill) {
        Optional<Job> orgJob = this.jobRepository.findById(jobID);
        if(orgJob.isPresent()){
            Job job = orgJob.get();
            List<Skill> skills = job.getSkills();
            skills.add(skill);
            job.setSkills(skills);

            Job savedJob = this.jobRepository.save(job);
            return savedJob.getSkills();
        } else {
            throw new NotFoundException("Job with id "+ jobID + " not found");
        }
    }

    public void updateJobKillsById(int jobID, int skillId, Skill updatedSkill) {
        Optional<Job> job = this.jobRepository.findById(jobID);
        if(job.isPresent()){
            List<Skill> skills = job.get().getSkills();
            Optional<Skill> optionalSkill = this.skillRepository.findById(skillId);
            if(optionalSkill.isPresent() && skills.contains(optionalSkill.get())){
                Skill skill = optionalSkill.get();
                skill.setName(updatedSkill.getName());
                skill.setLanguage(updatedSkill.getLanguage());
                skill.setExperience(updatedSkill.getExperience());
                skill.setDescription(updatedSkill.getDescription());

                this.skillRepository.save(skill);
            }
            else{
                throw new NotFoundException("Skill with id "+ skillId + "not found in job id = " + jobID);
            }
        } else {
            throw new NotFoundException("Job with id "+ jobID + " not found");
        }
    }

    public List<Skill> deleteJobKillsById(int jobID, int skillId) {
        Optional<Job> job = this.jobRepository.findById(jobID);
        if(job.isPresent()){
            List<Skill> skills = job.get().getSkills();
            Optional<Skill> skill = this.skillRepository.findById(skillId);
            if(skill.isPresent() && skills.contains(skill.get())){
                this.skillRepository.deleteById(skillId);
                return job.get().getSkills();
            }
            else{
                throw new NotFoundException("Skill with id "+ skillId + "not found in job id = " + jobID);
            }
        } else {
            throw new NotFoundException("Job with id "+ jobID + " not found");
        }
    }

    public List<Job> getJobWthApplication(){
        return this.jobRepository.getJobWthApplication();
    }

    public List<Job>  getJobWithMoreThan2Interview(){
        return this.jobRepository.getJobWithMoreThan2Interview();
    }

    public List<Job>  getJobsBySalaryAndState(double salary, String state){
        return this.jobRepository.findAll(JobSpecification.hasSalaryAndCompanyState(salary, state));
    }

    public List<Job>  getJobsBySkill(String language){
        return this.jobRepository.getBySkillByLanguage(language);
    }


}
