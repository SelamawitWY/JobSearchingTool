package miu.cs.cs544.selam.jobsearchingtool.interview.repository;

import miu.cs.cs544.selam.jobsearchingtool.interview.model.ScreeningInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreeningInterviewRepository extends JpaRepository<ScreeningInterview, Integer> {
}
