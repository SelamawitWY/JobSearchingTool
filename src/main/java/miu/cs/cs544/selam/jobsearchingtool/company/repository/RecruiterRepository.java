package miu.cs.cs544.selam.jobsearchingtool.company.repository;

import miu.cs.cs544.selam.jobsearchingtool.company.model.Company;
import miu.cs.cs544.selam.jobsearchingtool.company.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {

}
