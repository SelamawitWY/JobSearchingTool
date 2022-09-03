package miu.cs.cs544.selam.jobsearchingtool.job.repository;

import miu.cs.cs544.selam.jobsearchingtool.job.model.LanguageEnum;
import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    @Query("SELECT S.language FROM Skill S GROUP BY S.language" +
            " ORDER BY COUNT(S.id) DESC")
    public List<String> getTopWantedLanguage();
}
