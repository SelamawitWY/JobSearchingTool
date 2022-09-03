package miu.cs.cs544.selam.jobsearchingtool.interview.repository;

import miu.cs.cs544.selam.jobsearchingtool.interview.model.Question;
import miu.cs.cs544.selam.jobsearchingtool.interview.model.TechnicalInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalInterviewRepository extends JpaRepository<TechnicalInterview, Integer>  {

    @Query("Select T from Question T order by T.status desc")
    public List<Question> getQuestions();
}
