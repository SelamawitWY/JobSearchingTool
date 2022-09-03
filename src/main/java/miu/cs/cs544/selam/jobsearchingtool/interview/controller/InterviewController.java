package miu.cs.cs544.selam.jobsearchingtool.interview.controller;

import io.swagger.models.auth.In;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.*;
import miu.cs.cs544.selam.jobsearchingtool.interview.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {

    @Autowired
    InterviewService interviewService;

    @PostMapping(value = "/screeningInterviews")
    public ScreeningInterview addScreeningInterview(@RequestBody ScreeningInterviewDTO interview){
        ScreeningInterview screeningInterview = interview.getScreeningInterview();
        return this.interviewService.addScreeningInterview(interview.getApplicationId(), screeningInterview);
    }

    @GetMapping(value = "/screeningInterviews")
    public List<ScreeningInterview> getScreeningInterview(){
        return this.interviewService.getScreeningInterview();
    }

    @DeleteMapping(value = "/screeningInterviews/{id}")
    public void deleteScreeningInterview(@PathVariable int id){
        this.interviewService.deleteScreeningInterview(id);
    }

    @PutMapping(value = "/screeningInterviews/{id}")
    public ScreeningInterview updateScreeningInterview(@PathVariable int id, ScreeningInterview screeningInterview){
        return this.interviewService.updateScreeningInterview(id, screeningInterview);
    }

    @PostMapping(value = "/technicalInterviews")
    public TechnicalInterview addTechnicalInterview(@RequestBody TechnicalInterviewDTO interview){
        TechnicalInterview technicalInterview = interview.getTechnicalInterview();
        return this.interviewService.addTechnicalInterview(interview.getApplicationId(), technicalInterview);
    }

    @GetMapping(value = "/technicalInterviews")
    public List<TechnicalInterview> getTechnicalInterview(){
        return this.interviewService.getTechnicalInterview();
    }

    @DeleteMapping(value = "/technicalInterviews/{id}")
    public void deleteTechnicalInterview(@PathVariable int id){
        this.interviewService.deleteTechnicalInterview(id);
    }

    @PutMapping(value = "/technicalInterviews/{id}")
    public TechnicalInterview updateTechnicalInterview(@PathVariable int id, TechnicalInterview technicalInterview){
        return this.interviewService.updateTechnicalInterview(id, technicalInterview);
    }


    @PostMapping(value = "/hiringManagerInterviews")
    public HiringManagerInterview addHiringManagerInterview(@RequestBody HiringManagerInterviewDTO interview){
        HiringManagerInterview hiringManagerInterview = interview.getHiringManagerInterview();
        return this.interviewService.addHiringManagerInterview(interview.getApplicationId(), hiringManagerInterview);
    }

    @GetMapping(value = "/hiringManagerInterviews")
    public List<HiringManagerInterview> getHiringManagerInterview(){
        return this.interviewService.getHiringManagerInterview();
    }

    @DeleteMapping(value = "/hiringManagerInterviews/{id}")
    public void deleteHiringManagerInterview(@PathVariable int id){
        this.interviewService.deleteHiringManagerInterview(id);
    }

    @PutMapping(value = "/hiringManagerInterviews/{id}")
    public HiringManagerInterview updateScreeningInterview(@PathVariable int id, HiringManagerInterview hiringManagerInterview){
        return this.interviewService.updateHiringManagerInterview(id, hiringManagerInterview);
    }



    @GetMapping(value = "/interviews")
    public List<Interview> getInterviews(){
        return this.interviewService.getInterview();
    }


}
