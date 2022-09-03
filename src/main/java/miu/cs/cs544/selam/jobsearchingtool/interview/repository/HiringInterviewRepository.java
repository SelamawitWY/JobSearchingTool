package miu.cs.cs544.selam.jobsearchingtool.interview.repository;

import miu.cs.cs544.selam.jobsearchingtool.interview.model.HiringManagerInterview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringInterviewRepository extends JpaRepository<HiringManagerInterview, Integer> {
}
