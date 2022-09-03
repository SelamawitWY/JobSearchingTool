package miu.cs.cs544.selam.jobsearchingtool.interview.service;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.service.ApplicationService;
import miu.cs.cs544.selam.jobsearchingtool.exception.NotFoundException;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.*;
import miu.cs.cs544.selam.jobsearchingtool.interview.repository.HiringInterviewRepository;
import miu.cs.cs544.selam.jobsearchingtool.interview.repository.InterviewRepository;
import miu.cs.cs544.selam.jobsearchingtool.interview.repository.ScreeningInterviewRepository;
import miu.cs.cs544.selam.jobsearchingtool.interview.repository.TechnicalInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InterviewService {
    @Autowired
    InterviewRepository interviewRepository;
    @Autowired
    ScreeningInterviewRepository screeningInterviewRepository;

    @Autowired
    TechnicalInterviewRepository technicalInterviewRepository;

    @Autowired
    HiringInterviewRepository hiringInterviewRepository;

    @Autowired
    ApplicationService applicationService;

    public List<Interview> getInterview(){
        return this.interviewRepository.findAll();
    }

    public ScreeningInterview addScreeningInterview(int applicationID, ScreeningInterview interview){
        Application application = this.applicationService.getByID(applicationID);
        interview.setApplication(application);

        ScreeningInterview savedInterview= this.screeningInterviewRepository.save(interview);
        return savedInterview;
    }

    public List<ScreeningInterview> getScreeningInterview(){
        return this.screeningInterviewRepository.findAll();
    }

    public ScreeningInterview updateScreeningInterview(int id, ScreeningInterview interview){
        ScreeningInterview updatedApplication = this.screeningInterviewRepository.save(interview);
        return updatedApplication;
    }

    public void deleteScreeningInterview(int id){
        this.screeningInterviewRepository.deleteById(id);
    }



    public TechnicalInterview addTechnicalInterview(int applicationID, TechnicalInterview interview){
        Application application = this.applicationService.getByID(applicationID);
        interview.setApplication(application);

        TechnicalInterview savedInterview= this.technicalInterviewRepository.save(interview);
        return savedInterview;
    }

    public List<TechnicalInterview> getTechnicalInterview(){
        return this.technicalInterviewRepository.findAll();
    }

    public TechnicalInterview updateTechnicalInterview(int id, TechnicalInterview interview){
        TechnicalInterview updatedApplication = this.technicalInterviewRepository.save(interview);
        return updatedApplication;
    }

    public void deleteTechnicalInterview(int id){
        this.technicalInterviewRepository.deleteById(id);
    }



    public HiringManagerInterview addHiringManagerInterview(int applicationID, HiringManagerInterview interview){
        Application application = this.applicationService.getByID(applicationID);
        interview.setApplication(application);

        HiringManagerInterview savedInterview= this.hiringInterviewRepository.save(interview);
        return savedInterview;
    }

    public List<HiringManagerInterview> getHiringManagerInterview(){
        return this.hiringInterviewRepository.findAll();
    }

    public HiringManagerInterview updateHiringManagerInterview(int id, HiringManagerInterview interview){
        HiringManagerInterview updatedApplication = this.hiringInterviewRepository.save(interview);
        return updatedApplication;
    }

    public void deleteHiringManagerInterview(int id){
        this.hiringInterviewRepository.deleteById(id);
    }


    public List<Question> getQuestions(){
        return this.technicalInterviewRepository.getQuestions();
    }

    public List<Interview> filterInterviewsByDate(Date fromDate, Date toDate){
        return this.interviewRepository.filterInterviewsByDate(fromDate, toDate);
    }
}
