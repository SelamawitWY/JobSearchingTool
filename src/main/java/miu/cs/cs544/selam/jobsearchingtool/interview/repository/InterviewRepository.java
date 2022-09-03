package miu.cs.cs544.selam.jobsearchingtool.interview.repository;

import miu.cs.cs544.selam.jobsearchingtool.interview.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    @Query("Select i from Interview i where i.date > :fromDate and i.date <= :toDate")
    public List<Interview> filterInterviewsByDate(Date fromDate, Date toDate);

}
