package com.jwt.demo.middleware.kafka;

import kafka.admin.TopicCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestKafka {

    @Test
    public void createTopic() {
        String[] options = {
                "--bootstrap-server", "39.101.137.22:9092",
                "--create",
                "--topic", "topicViaJava"
        };
        TopicCommand.main(options);
    }
}
