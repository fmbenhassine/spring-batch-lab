package com.example.demo;

import java.sql.Date;
import java.util.Objects;

public class DAOUser {

    private String email, fullname, matricule, password, username;
    private java.sql.Date dateIntegration;

    public DAOUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDateIntegration() {
        return dateIntegration;
    }

    public void setDateIntegration(Date dateIntegration) {
        this.dateIntegration = dateIntegration;
    }

    @Override
    public String toString() {
        return "DAOUser{" +
                "email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", matricule='" + matricule + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", dateIntegration=" + dateIntegration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DAOUser DAOUser = (DAOUser) o;
        return Objects.equals(email, DAOUser.email) && Objects.equals(fullname, DAOUser.fullname) && Objects.equals(matricule, DAOUser.matricule) && Objects.equals(password, DAOUser.password) && Objects.equals(username, DAOUser.username) && Objects.equals(dateIntegration, DAOUser.dateIntegration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, fullname, matricule, password, username, dateIntegration);
    }
}