package com.fuse.bean;

import com.fuse.model.Student;
import org.apache.camel.Body;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MyBean {

    private static final Logger logger = LoggerFactory.getLogger(MyBean.class);

    public Student process(@Body Student student) throws Exception {
        student.setStatus(Status.getRandomStatus().toString());
        student.setRoom("jboss-fuse-0123");

        return student;
    }

    enum Status {
        Registered,
        Follow,
        Certified,
        Canceled;

        public static Status getRandomStatus() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }

    }


}
