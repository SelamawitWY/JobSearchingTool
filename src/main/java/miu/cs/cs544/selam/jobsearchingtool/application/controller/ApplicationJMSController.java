package miu.cs.cs544.selam.jobsearchingtool.application.controller;

import miu.cs.cs544.selam.jobsearchingtool.application.JMS.ApplicationSender;
import miu.cs.cs544.selam.jobsearchingtool.application.model.ApplicationDTO;
import miu.cs.cs544.selam.jobsearchingtool.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jms")
public class ApplicationJMSController {

    @Autowired
    ApplicationService applicationService;

    @Autowired
    ApplicationSender applicationSender;

    @PostMapping(value = "/applications")
    public void addApplication(@RequestBody ApplicationDTO appDTO){
        applicationSender.requestSender(RequestMethod.POST.name(), appDTO, 0);
    }

    @GetMapping(value = "/applications")
    public void  getApplications() {
        applicationSender.requestSender(RequestMethod.GET.name(), null, 0);
    }

    @DeleteMapping(value = "/applications/{id}")
    public void deleteApplication(@PathVariable int id){
        applicationSender.requestSender(RequestMethod.DELETE.name(), null, id);
    }

    @PutMapping(value = "/applications/{id}")
    public void updateApplication(@PathVariable int id, @RequestBody ApplicationDTO application){
        applicationSender.requestSender(RequestMethod.PUT.name(), application, id);
    }

}
