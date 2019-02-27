package com.dyc.notification.controller;

import com.alibaba.fastjson.JSON;
import com.dyc.notification.dto.EmailDto;
import com.dyc.notification.dto.EventType;
import com.dyc.notification.model.Event;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class NotificationController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private final String TOPIC_SENDMAIL = "dyc.topic.sendmail";

    @GetMapping("/test")
    public String add() {
        Event event = new Event();
        event.setId("1234567");
        event.setType(EventType.SENDMAIL.name());

        EmailDto emailDto1 =new EmailDto(){};
        emailDto1.setFrom("casapr@gmail.com");
        emailDto1.setTo("lijiacheng@gmail.com");
        emailDto1.setSubject("test mail");
        emailDto1.setContent("testmail");

        event.setMsgObj(emailDto1);
        Destination destination = new ActiveMQTopic(TOPIC_SENDMAIL);
        jmsMessagingTemplate.convertAndSend(destination, JSON.toJSONString(event));
        return "success";
    }
}
