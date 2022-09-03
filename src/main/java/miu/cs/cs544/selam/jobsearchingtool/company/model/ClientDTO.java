package miu.cs.cs544.selam.jobsearchingtool.company.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

public class ClientDTO  {
    private String mission;
    private String reason;
    private String website;

    private String name;

    private Address address;

    public ClientDTO() {
    }

    public ClientDTO(String mission, String reason, String website, String name, Address address) {
        this.mission = mission;
        this.reason = reason;
        this.website = website;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Client getClient() {
        Client client = new Client(mission, reason, website);
        client.setName(name);
        client.setAddress(address);

        return client;
    }
}
