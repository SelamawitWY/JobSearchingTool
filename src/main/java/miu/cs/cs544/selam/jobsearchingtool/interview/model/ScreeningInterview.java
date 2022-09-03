package miu.cs.cs544.selam.jobsearchingtool.interview.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Screen-I")
public class ScreeningInterview extends Interview {
    private String name;

    private String result;

    public ScreeningInterview() {
    }

    public ScreeningInterview(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
