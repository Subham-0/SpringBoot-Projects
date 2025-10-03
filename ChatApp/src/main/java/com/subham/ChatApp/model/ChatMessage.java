package com.subham.ChatApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {  //represent a particular message

    private Long id;
    private String sender;
    private String content;

}
