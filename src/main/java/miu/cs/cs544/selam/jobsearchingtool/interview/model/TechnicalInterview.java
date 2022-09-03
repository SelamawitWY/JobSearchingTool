package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Technical-I")
public class TechnicalInterview extends Interview {
     private long duration;
     private LocationEnum location;

     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "INTERVIEW_ID")
     private List<Question> questions;

     public List<Question> getQuestions() {
          return questions;
     }

     public void setQuestions(List<Question> questions) {
          this.questions = questions;
     }

     public TechnicalInterview() {
     }

     public TechnicalInterview(long duration, LocationEnum location, List<Question> questions) {
          this.duration = duration;
          this.location = location;
          this.questions = questions;
     }

     public long getDuration() {
          return duration;
     }

     public void setDuration(long duration) {
          this.duration = duration;
     }

     public LocationEnum getLocation() {
          return location;
     }

     public void setLocation(LocationEnum location) {
          this.location = location;
     }
}
