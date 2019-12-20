package com.ascending.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.resources.Messages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {


    //@Autowired
    private AmazonSQS sqsClient;
    @Autowired
    private Logger logger;

    private String queueUrl;

    public MessageService(@Autowired AmazonSQS amazonSQS, @Value("${aws.sqs.name}") String queueName){
        this.sqsClient=amazonSQS;
        try {
            queueUrl = queueUrl(queueName);
        }
        catch (Exception e) {
        e.printStackTrace();
        }

    }

    public void sendEvent(String message){
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(5);
        sqsClient.sendMessage(send_msg_request);
    }

    public String queueUrl(String queuename){
        GetQueueUrlResult result=sqsClient.getQueueUrl(queuename);
        return result.getQueueUrl();
    }

    public String getQueueUrl(String queueName) {
        GetQueueUrlResult getQueueUrlResult = sqsClient.getQueueUrl(queueName);
        logger.info("QueueUrl: " + getQueueUrlResult.getQueueUrl());
        return getQueueUrlResult.getQueueUrl();
    }

    public void sendMessage(String queueName, String msg) {
        Map<String, MessageAttributeValue> messageAttributes = new HashMap();
        MessageAttributeValue messageAttributeValue = new MessageAttributeValue();
        messageAttributeValue.withDataType("String").withStringValue("File URL in S3");
        messageAttributes.put("message", messageAttributeValue);
        String queueUrl = getQueueUrl(queueName);
        SendMessageRequest sendMessageRequest = new SendMessageRequest();
        sendMessageRequest.withQueueUrl(queueUrl)
                .withMessageBody(msg)
                .withMessageAttributes(messageAttributes);
        sqsClient.sendMessage(sendMessageRequest);
    }

    public List<Message> getMessages(String queueName) {
        String queueUrl = getQueueUrl(queueName);
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).getMessages();
        return messages;
    }
}
