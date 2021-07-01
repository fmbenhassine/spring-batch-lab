package com.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class processor implements ItemProcessor<String, String> {
    private Logger log = LoggerFactory.getLogger(processor.class);

    @Override
    public String process(String s) throws Exception {

        //some treatment on variable "FileName"
        //some treatment on variable "country"

        log.info("processing item " + s);
        return s;
    }


}