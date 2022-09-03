package miu.cs.cs544.selam.jobsearchingtool.job.service;

import miu.cs.cs544.selam.jobsearchingtool.job.model.Skill;
import miu.cs.cs544.selam.jobsearchingtool.job.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public List<Skill> getSkills(){
        return this.skillRepository.findAll();
    }

    public List<String> getTopWantedLanguage(){
      return this.skillRepository.getTopWantedLanguage();
    }
}
