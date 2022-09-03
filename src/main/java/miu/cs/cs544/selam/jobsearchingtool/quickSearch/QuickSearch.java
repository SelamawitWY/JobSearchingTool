package miu.cs.cs544.selam.jobsearchingtool.quickSearch;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.service.ApplicationService;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import miu.cs.cs544.selam.jobsearchingtool.company.service.CompanyService;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.Interview;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.Question;
import miu.cs.cs544.selam.jobsearchingtool.interview.service.InterviewService;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.LanguageEnum;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.JobSpecification;
import miu.cs.cs544.selam.jobsearchingtool.job.service.JobService;
import miu.cs.cs544.selam.jobsearchingtool.job.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/quickSearch/")
public class QuickSearch {
    @Autowired
    SkillService skillService;
    @Autowired
    JobService jobService;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    CompanyService companyService;

    @Autowired
    InterviewService interviewService;

    @GetMapping(value = "/jobs")
    public List<Job> getJobs(){
        return this.jobService.getJob();
    }

    @GetMapping(value = "/skills")
    public List<Skill> getSkills(){
        return this.skillService.getSkills();
    }

    @GetMapping(value = "/jobs/{id}/applications")
    public List<Application> getApplicationsById(@PathVariable int id){
        Job job = jobService.getJobById(id);
        return job.getApplication();
    }

    @GetMapping(value = "/applicationsBySkillLanguage/{language}")
    public List<Application> getByJobSkill(@PathVariable LanguageEnum language){
        return this.applicationService.getByJobSkill(language);
    }

    @GetMapping(value = "/applicationsByJobSalary/{salary}")
    public List<Application> findApplicationBySalary(@PathVariable  double salary){
        return this.applicationService.findApplicationBySalary(salary);
    }

    @GetMapping(value = "/applicationsByCompany/{id}")
    public List<Application> findAllByJob_CompanyId(@PathVariable int id){
        return this.applicationService.findAllByJob_CompanyId(id);
    }

    @GetMapping(value = "/jobsByCompanyAddress/{state}")
    public List<Job> getJobByCompanyAddress(@PathVariable String state){
        return this.companyService.getJobByCompanyAddress(state);
    }

    @GetMapping(value = "/companiesByJobSalary/{salary}")
    public List<Company> getCompanyByJobSalary(@PathVariable double salary){
        return this.companyService.getCompanyByJobSalary(salary);
    }

    @GetMapping(value = "/recruitersByJobSalary/{amount}")
    public List<Company> getListOfRecruiterWithJobSalary(double amount){
        return this.companyService.getListOfRecruiterWithJobSalary(amount);
    }

    @GetMapping(value = "/technicalInterviews/questions")
    public List<Question> getQuestions(){
        return this.interviewService.getQuestions();
    }

    @GetMapping(value = "/interviewsByDate")
    public List<Interview> filterInterviewsByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                                  @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate){
        return this.interviewService.filterInterviewsByDate(date, toDate );
    }

    @GetMapping(value = "/interviews")
    public List<Interview> getInterviews(){
        return this.interviewService.getInterview();
    }

    @GetMapping(value = "/getTopWantedLanguages")
    public List<String> getTopWantedLanguage(){
        return this.skillService.getTopWantedLanguage();
    }

    @GetMapping(value = "/getJobsWthApplication")
    public List<Job> getJobWthApplication(){
        return this.jobService.getJobWthApplication();
    }

    @GetMapping(value = "/getJobsWithMoreThan2Interview")
    public List<Job>  getJobWithMoreThan2Interview(){
        return this.jobService.getJobWithMoreThan2Interview();
    }

    @GetMapping(value = "/getJobsByStateAndSalary/{salary}/{state}")
    public List<Job>  getJobsBySalaryAndState(@PathVariable double salary, @PathVariable String state){
        return this.jobService.getJobsBySalaryAndState(salary, state);
    }

    @GetMapping(value = "/getJobsBySkill/{language}")
    public List<Job>  getJobsBySkill(@PathVariable LanguageEnum language){
        return this.jobService.getJobsBySkill(language.name());
    }
}
