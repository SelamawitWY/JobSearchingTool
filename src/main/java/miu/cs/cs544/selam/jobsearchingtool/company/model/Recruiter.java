package miu.cs.cs544.selam.jobsearchingtool.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Recruiter")
public class Recruiter extends Company {
    @ManyToMany
    @JsonIgnore
    private List<Client> clients;

    public Recruiter() {
    }

    public Recruiter(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
