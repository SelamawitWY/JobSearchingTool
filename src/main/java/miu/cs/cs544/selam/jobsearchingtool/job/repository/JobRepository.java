package miu.cs.cs544.selam.jobsearchingtool.job.repository;

import miu.cs.cs544.selam.jobsearchingtool.interview.model.Interview;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {
    public List<Job> getJobWthApplication();

    public List<Job>  getJobWithMoreThan2Interview();

    @Query(value = "Select DISTINCT J.* from job J  " +
            "JOIN skill S on S.job_id = J.id " +
            "Where S.language = :language ", nativeQuery = true)
    List<Job> getBySkillByLanguage(String language);
}
