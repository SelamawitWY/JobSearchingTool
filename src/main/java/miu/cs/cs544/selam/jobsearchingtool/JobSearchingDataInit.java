package miu.cs.cs544.selam.jobsearchingtool;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.repository.ApplicationRepository;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Address;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Client;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import miu.cs.cs544.selam.jobsearchingtool.company.repository.CompanyRepository;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.*;
import miu.cs.cs544.selam.jobsearchingtool.interview.repository.InterviewRepository;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.LanguageEnum;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class JobSearchingDataInit implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    JobRepository jobRepository;


    static Instant now = Instant.now();

    @Override
    public void run(String... args) throws Exception {
       init();
    }


    public void init(){

        Client PrincipalFG = new Client("Premier global investment group","Full stack development using react", "https://www.principal.com");
        PrincipalFG.setAddress(new Address("US","IA","Des Moines"));
        PrincipalFG.setName("Principal Financial Group");

        Client Infosys = new Client("Business consulting, information technology and outsourcing ","Web development using angauler", "https://www.infosys.com");
        Infosys.setAddress(new Address("US","TX","Plano"));
        Infosys.setName("Infosys");

        Recruiter turing = new Recruiter();
        turing.setAddress(new Address("US","IA","Fairfiled"));
        turing.setName("Turing");
        turing.setClients(Arrays.asList(PrincipalFG,Infosys));

        Job job1 = new Job("Software Engineer - Java and remote!",178000, PrincipalFG,
                Arrays.asList(new Skill[] {
                        new Skill("Programming skill",2, "Programming language",LanguageEnum.JAVA),
                        new Skill("Programming skill",1, "Programming language",LanguageEnum.REACT)}));


        Job job2 = new Job("Java Frontend Developer", 118000, Infosys, Arrays.asList(new Skill[] {
                new Skill("Programming skill",4, "Programming language",LanguageEnum.NODE),
                new Skill("Programming skill",3, "Programming language",LanguageEnum.JAVASCRIPT),
                new Skill("Programming skill",1, "Programming language",LanguageEnum.ANGULAR)}));

        Application app1 = new Application(Date.from(now.minus(Duration.ofDays(30))), 1, job1);
        Application app2 = new Application(Date.from(now.minus(Duration.ofDays(10))), 2, job2);


        ScreeningInterview screeningInterview = new ScreeningInterview("Phase 1", "pass");
        screeningInterview.setDate(Date.from(now.minus(Duration.ofDays(1))));
        screeningInterview.setEmail("testuser@gmail.com");
        screeningInterview.setPhoneNumber("208301297");
        screeningInterview.setApplication(app2);

        ScreeningInterview screeningInterview_1 = new ScreeningInterview("Phase 2","pass");
        screeningInterview_1.setDate(Date.from(now.minus(Duration.ofDays(10))));
        screeningInterview_1.setEmail("testuser@gmail.com");
        screeningInterview_1.setPhoneNumber("208301299");
        screeningInterview_1.setApplication(app1);

        TechnicalInterview technicalInterview = new TechnicalInterview(60, LocationEnum.IN_PERSON, Arrays.asList(new Question[] {
                new Question("What is JPA?",QuestionStatusEnum.ANSWERED),
                new Question("Explain how spring boot works?", QuestionStatusEnum.ANSWERED),
                new Question("What is the difference between hashtable and hashmap?",QuestionStatusEnum.NOT_SURE)}));
        technicalInterview.setDate(Date.from(now.minus(Duration.ofDays(7))));
        technicalInterview.setEmail("testuser@gmail.com");
        technicalInterview.setPhoneNumber("208301299");
        technicalInterview.setApplication(app1);

        HiringManagerInterview hiringManagerInterview = new HiringManagerInterview(12, Date.from(now.plus(Duration.ofDays(4))));
        hiringManagerInterview.setDate(Date.from(now.minus(Duration.ofDays(4))));
        hiringManagerInterview.setEmail("testuser@gmail.com");
        hiringManagerInterview.setPhoneNumber("251909192");
        hiringManagerInterview.setApplication(app1);


        companyRepository.save(PrincipalFG);
        companyRepository.save(Infosys);

        companyRepository.save(turing);
        jobRepository.save(job1);
        jobRepository.save(job2);

        applicationRepository.save(app1);
        applicationRepository.save(app2);

        interviewRepository.save(screeningInterview);
        interviewRepository.save(screeningInterview_1);
        interviewRepository.save(technicalInterview);
        interviewRepository.save(hiringManagerInterview);

    }
}
