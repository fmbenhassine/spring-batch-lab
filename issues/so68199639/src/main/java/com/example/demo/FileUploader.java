package com.example.demo;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class FileUploader implements ItemWriter<Person1> {
    @Override
    public void write(List<? extends Person1> list) throws Exception {
        for (Person1 p : list) {
            System.out.println("Writing person " + p.getFirstname() + Thread.currentThread().getName());
        }
    }
}