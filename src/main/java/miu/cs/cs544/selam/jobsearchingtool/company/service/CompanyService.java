package miu.cs.cs544.selam.jobsearchingtool.company.service;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Client;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import miu.cs.cs544.selam.jobsearchingtool.company.repository.ClientRepository;
import miu.cs.cs544.selam.jobsearchingtool.company.repository.CompanyRepository;
import miu.cs.cs544.selam.jobsearchingtool.company.repository.RecruiterRepository;
import miu.cs.cs544.selam.jobsearchingtool.exception.NotFoundException;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.JobRepository;
import miu.cs.cs544.selam.jobsearchingtool.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RecruiterRepository recruiterRepository;

    @Autowired
    JobRepository jobRepository;

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Client addClient(Client client){
        Client savedClient = this.clientRepository.save(client);
        return savedClient;
    }

    public List<Client> getClients(){
        return this.clientRepository.findAll();
    }

    public Client updateClient(int id, Client client){
        Client updatedClient = this.clientRepository.save(client);
        return updatedClient;
    }

    public Client addClientJob(int id, Job job){

        Optional<Client> client = this.clientRepository.findById(id);
        if(client.isPresent()){
            Client updatedClient = client.get();
            List<Job> clientJob = updatedClient.getJobs();
            job.setCompany(updatedClient);

            clientJob.add(job);
            updatedClient.setJobs(clientJob);

            this.jobRepository.save(job);
            this.clientRepository.save(updatedClient);
            return updatedClient;
        } else
            throw new NotFoundException("Client with id " + id + " does not exists!");

    }

    public Client findClientById(int id){

        Optional<Client> client = this.clientRepository.findById(id);
        if(client.isPresent()){
            return client.get();
        } else
            throw new NotFoundException("Client with id " + id + " does not exists!");

    }
    public void deleteClient(int id){
        Client client = this.findClientById(id);

        List<Recruiter> recruiters = client.getRecruiter();
        for(Recruiter r : recruiters){
            List<Client> clients = r.getClients();
            clients.remove(client);
            r.setClients(clients);
            this.recruiterRepository.save(r);
        }

        this.clientRepository.deleteById(id);
    }

    // Recruiter

    public Recruiter addRecruiter(Recruiter recruiter){
        Recruiter savedRecruiter = this.recruiterRepository.save(recruiter);
        return savedRecruiter;
    }

    public List<Recruiter> getRecruiters(){
        return this.recruiterRepository.findAll();
    }

    public Recruiter updateRecruiter(int id, Recruiter recruiter){
        Recruiter updatedRecruiter = this.recruiterRepository.save(recruiter);
        return updatedRecruiter;
    }

    public Recruiter addRecruiterClient(int id, int clientId){

        Optional<Recruiter> recruiter = this.recruiterRepository.findById(id);
        Optional<Client> client = this.clientRepository.findById(id);
        if(client.isPresent() && recruiter.isPresent()){
            Recruiter updatedRecruiter = recruiter.get();
            Client addedClient = client.get();
            List<Client> recruiterClients = updatedRecruiter.getClients();
            recruiterClients.add(addedClient);
            updatedRecruiter.setClients(recruiterClients);

            this.recruiterRepository.save(updatedRecruiter);
            return updatedRecruiter;
        } else
            throw new NotFoundException("Recruiter with id " + id + " does not exists!");

    }
    public void deleteRecruiter(int id){
        findRecruiterById(id);
        this.recruiterRepository.deleteById(id);
    }


    public List<Job> getClientJobs(int id) {
        Client client = this.findClientById(id);

        return client.getJobs();
    }

    public List<Client> getRecruiterClients(int id) {
        Recruiter recruiter = this.findRecruiterById(id);
        return  recruiter.getClients();
    }

    private Recruiter findRecruiterById(int id) {
        Optional<Recruiter> recruiter = this.recruiterRepository.findById(id);
        if(recruiter.isPresent()){
            return recruiter.get();
        } else
            throw new NotFoundException("Recruiter with id " + id + " does not exists!");
    }

    public List<Job> getJobByCompanyAddress(String state){
        return this.companyRepository.getJobByCompanyAddress(state);
    }

    public List<Company> getCompanyByJobSalary(double salary){
        return this.companyRepository.getCompanyByJobSalary(salary);
    }
    public List<Company> getListOfRecruiterWithJobSalary(double amount){
        return this.companyRepository.getListOfRecruiterWithJobSalary(amount);
    }
}
