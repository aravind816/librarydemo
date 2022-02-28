package com.dxc.cba.librarydemo.controller;

import com.dxc.cba.librarydemo.service.BookService;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.jboss.logging.Logger;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
@Validated
public class MessageController {
        Logger logger = LoggerFactory.logger(BookController.class);

        @Autowired
        private BookService bookService;

        @Operation(summary = "This method will send a message to kafka topic")
        @PostMapping("/sendmessage")
        @ResponseStatus(HttpStatus.OK)
        public @ResponseBody String sendMessage(
                        @RequestParam("message") String message) {
                logger.info("####Posting a message to kafka >>> " + message);
                bookService.sendMessage(message);
                return "Your message is posted to Kafk topic";
        }

}


