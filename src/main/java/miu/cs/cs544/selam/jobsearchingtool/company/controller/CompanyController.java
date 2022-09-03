package miu.cs.cs544.selam.jobsearchingtool.company.controller;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Client;
import miu.cs.cs544.selam.jobsearchingtool.company.model.ClientDTO;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import miu.cs.cs544.selam.jobsearchingtool.company.model.RecruiterDTO;
import miu.cs.cs544.selam.jobsearchingtool.company.service.CompanyService;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.model.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService clientService;

    @PostMapping(value = "/clients")
    public Client addClient(@RequestBody ClientDTO client){
        return this.clientService.addClient(client.getClient());
    }

    @GetMapping(value = "/clients")
    public List<Client> getClients(){
        return this.clientService.getClients();
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable int id){
        this.clientService.deleteClient(id);
    }

    @PutMapping(value = "/clients/{id}")
    public Client updateClient(@PathVariable int id, @RequestBody ClientDTO client){
        return this.clientService.updateClient(id, client.getClient());
    }

    @PutMapping(value = "/clients/{id}/jobs")
    public Client addClientJob(@PathVariable int id, @RequestBody JobDTO job){
        return this.clientService.addClientJob(id, job.getJob());
    }

    @GetMapping(value = "/clients/{id}/jobs")
    public List<Job> getClientJob(@PathVariable int id){
        return this.clientService.getClientJobs(id);
    }


    @PostMapping(value = "/recruiters")
    public Recruiter addRecruiter(@RequestBody RecruiterDTO recruiter){
        return this.clientService.addRecruiter(recruiter.getRecruiter());
    }

    @GetMapping(value = "/recruiters")
    public List<Recruiter> getRecruiters(){
        return this.clientService.getRecruiters();
    }

    @DeleteMapping(value = "/recruiters/{id}")
    public void deleteRecruiter(@PathVariable int id){
        this.clientService.deleteRecruiter(id);
    }

    @PutMapping(value = "/recruiters/{id}")
    public Recruiter updateRecruiter(@PathVariable int id, @RequestBody RecruiterDTO recruiter){
        return this.clientService.updateRecruiter(id, recruiter.getRecruiter());
    }

    @PutMapping(value = "/recruiters/{id}/clients/{clientID}")
    public Recruiter addRecruiterClient(@PathVariable int id, @PathVariable int clientID){
        return this.clientService.addRecruiterClient(id, clientID);
    }

    @GetMapping(value = "/recruiters/{id}/clients")
    public List<Client> getRecruiterClients(@PathVariable int id){
        return this.clientService.getRecruiterClients(id);
    }
}
