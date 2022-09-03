package miu.cs.cs544.selam.jobsearchingtool.job.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Version private int version;
    private String name;
    private int experience;
    private String description;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    public Skill() {
    }

    public Skill(String name, int experience, String description, LanguageEnum language) {
        this.name = name;
        this.experience = experience;
        this.description = description;
        this.language = language;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }
}
