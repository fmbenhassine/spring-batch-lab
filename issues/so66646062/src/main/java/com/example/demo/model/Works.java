package com.example.demo.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

@XStreamAlias("works")
public class Works {

   @XStreamImplicit(itemFieldName = "Work")
    private List<Work> Work;

    public List<Work> getWorks() {
        return Work;
    }

    public void setWorks(List<Work> works) {
        this.Work = works;
    }

    @Override
    public String toString() {
        return "Works{" +
                "Work=" + Work +
                '}';
    }
}