package miu.cs.cs544.selam.jobsearchingtool.company.repository;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    public List<Job> getJobByCompanyAddress(String state);

    public List<Company> getCompanyByJobSalary(double salary);
    public List<Company> getListOfRecruiterWithJobSalary(double amount);
}
