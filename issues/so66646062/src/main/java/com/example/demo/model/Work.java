package com.example.demo.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Work")
public class Work {

    @XStreamAlias("workCompany")
    private String workCompany;
    @XStreamAlias("workMission")
    private String workMission;

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    public String getWorkMission() {
        return workMission;
    }

    public void setWorkMission(String workMission) {
        this.workMission = workMission;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workCompany='" + workCompany + '\'' +
                ", workMission='" + workMission + '\'' +
                '}';
    }
}