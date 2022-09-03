package miu.cs.cs544.selam.jobsearchingtool.company.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

public class RecruiterDTO  {

    private String name;

    private Address address;

    public RecruiterDTO() {
    }

    public RecruiterDTO(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Recruiter getRecruiter(){
        Recruiter recruiter = new Recruiter();
        recruiter.setName(name);
        recruiter.setAddress(address);

        return recruiter;
    }
}
