package miu.cs.cs544.selam.jobsearchingtool.application.controller;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.application.model.ApplicationDTO;
import miu.cs.cs544.selam.jobsearchingtool.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping(value = "/applications")
    public Application addApplication(@RequestBody ApplicationDTO appDTO){
        Application application = appDTO.getApplication();
        return this.applicationService.addApplication(appDTO.getJobId(), application);
    }

    @GetMapping(value = "/applications")
    public List<Application> getApplications(){
        return this.applicationService.getApplication(false);
    }

    @DeleteMapping(value = "/applications/{id}")
    public void deleteApplication(@PathVariable int id){
        this.applicationService.deleteApplication(id);
    }

    @PutMapping(value = "/applications/{id}")
    public Application updateApplication(@PathVariable int id, @RequestBody ApplicationDTO applicationDTO){
        return this.applicationService.updateApplication(id, applicationDTO.getJobId(), applicationDTO.getApplication());
    }

}
