package com.home.manager.hmapplicationcore.consumer;

import com.amazonaws.services.sqs.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SqsConsumer {

    @SqsListener(value = "home-manager",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(String message){
        System.out.println(message);
    }

}
