package com.prafull.poc.socketnotificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class NotificationController {
    @MessageMapping("/notify")
    @SendTo("/topic/notification")
    public Notification notification(Message message) throws Exception {
        log.info("Received Message : {}", message.getMessage());
        return new Notification("Message : " + message.getMessage() + "!");
    }
}
