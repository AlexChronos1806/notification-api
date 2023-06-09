package com.java.challenge.notificationapi.resource;

import com.java.challenge.notificationapi.domain.notification.service.NotificationService;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {

    private Logger logger = LoggerFactory.getLogger(NotificationResource.class);

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public List<ResponseDTO> postMessage(@RequestBody RequestDTO requestDTO) {
        logger.info("Incoming request: {}", requestDTO);

        List<ResponseDTO> responseDTOS = notificationService.processRequest(requestDTO);

        responseDTOS.forEach(responseDTO -> logger.info("Output response: {}", responseDTO));

        return responseDTOS;
    }
}
