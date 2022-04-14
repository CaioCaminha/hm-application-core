package com.home.manager.hmapplicationcore.publisher;

import com.google.gson.Gson;
import com.home.manager.hmapplicationcore.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsPublisher {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.sqs.end-point.uri}")
    private String endpoint;

    @Scheduled(fixedRate = 1000)
    public void sendMessage(Message message){
        Gson gson = new Gson();
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(gson.toJson(message)).build());
        //queueMessagingTemplate.convertAndSend(endpoint, new Pojo("SomeRandomValue"));
    }

}
