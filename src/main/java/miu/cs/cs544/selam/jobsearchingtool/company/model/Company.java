package miu.cs.cs544.selam.jobsearchingtool.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE", discriminatorType=DiscriminatorType.STRING,length=20)
@DiscriminatorValue("Com")
@NamedQuery(name="Company.getJobByCompanyAddress",
        query="SELECT C.jobs from Client C Where C.address.state = :state")

@NamedQuery(name="Company.getCompanyByJobSalary",
        query="SELECT C from Client C Join Job J on J.company.id = C.id where J.salary > :salary")

@NamedNativeQuery(name = "Company.getListOfRecruiterWithJobSalary",
 query = "Select DISTINCT  cm.* from  client C " +
         "    JOIN job J ON J.company_id = C.id " +
         "    JOIN recruiter_clients RC ON RC.clients_id = C.id " +
         "    JOIN recruiter R ON RC.recruiter_id = R.id " +
         "    Join company cm on R.id = cm.id" +
         "    WHERE J.salary > :amount ",
   resultClass = Company.class)

public abstract class Company  implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Version private int version;
   private String name;
   @Embedded
   private Address address;

   public Company() {
   }

   @OneToMany(targetEntity = Job.class, cascade = CascadeType.REMOVE, mappedBy = "company")
   private List<Job> jobs;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public List<Job> getJobs() {
      return jobs;
   }

   public void setJobs(List<Job> jobs) {
      this.jobs = jobs;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}


