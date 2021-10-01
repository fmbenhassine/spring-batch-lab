package io.spring;

public class MyService {

    public User putUser(User user, String role) {
        System.out.println("MyService.putUser " + user + "|" +  role);
        return user;
    }

//    public User putUser(User user) {
//        System.out.println("MyService.putUser " + user);
//        return user;
//    }

}
