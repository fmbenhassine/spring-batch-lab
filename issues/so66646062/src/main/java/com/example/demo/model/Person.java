package com.example.demo.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;


import java.util.List;

@XStreamAlias("Person")
public class Person {
    @XStreamAlias("personId")
    private Integer personId;
    @XStreamAlias("firstName")
    private String firstName;
    @XStreamAlias("lastName")
    private String lastName;
    @XStreamAlias("email")
    private String email;
    @XStreamAlias("age")
    private Integer age;
    @XStreamAlias("contactDetails")
    private List<String> contactDetails;
    @XStreamAlias("works")
    private Works works;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getPersonId() {
        return personId;
    }
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(List<String> contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Works getWorks() {
        return works;
    }

    public void setWorks(Works works) {
        this.works = works;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", contactDetails=" + contactDetails +
                ", works=" + works +
                '}';
    }
}