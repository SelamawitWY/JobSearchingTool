package miu.cs.cs544.selam.jobsearchingtool.application.repository;

import miu.cs.cs544.selam.jobsearchingtool.application.model.Application;
import miu.cs.cs544.selam.jobsearchingtool.job.model.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    @Query(value = "Select DISTINCT A.* from application A " +
            "JOIN job J ON A.job_id = J.id " +
            "JOIN skill S on S.job_id = J.id " +
            "Where S.language = :language ", nativeQuery = true)
    public List<Application> getByJobSkill(String language);

   @Query("Select A from Application A where A.job.salary >= :salary")
   public List<Application> findApplicationBySalary(double salary);

   public List<Application> findAllByJob_CompanyId(int id);
}
