package com.subham.ChatApp.controller;

import com.subham.ChatApp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")             //When a client sends a STOMP message to /app/sendMessage this method is called.
    @SendTo("/topic/messages")                  //returned message is broadcast to all clients subscribed to /topic/messages
    public ChatMessage sendMessage(ChatMessage message){
        return  message;
    }

    @GetMapping("/chat")                        //load the default page
    public String chat(){
        return "chat";
    }
}
