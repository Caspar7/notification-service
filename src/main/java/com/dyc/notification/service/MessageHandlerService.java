package com.dyc.notification.service;

import com.alibaba.fastjson.JSON;
import com.dyc.notification.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageHandlerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandlerService.class);

    @JmsListener(destination = "dyc.topic.sendmail")
    public void receiveQueueObj(String txtMsg) {
        Event event = JSON.parseObject(txtMsg, Event.class);
        LOGGER.info("received msg: {}", JSON.toJSONString(event));
    }
}
