package com.subham.ChatApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")               // WebSocket endpoint for clients to connect
                .setAllowedOrigins("http://localhost:5173") //prevent unauthorized messages coming to our app
                .withSockJS();                              //add compatibility for more accessible
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        //Messages with destination /topic/** will be broadcast to all subscribed clients (handled by broker).

        registry.setApplicationDestinationPrefixes("/app");
        //Messages starting with /app/** go to your server-side controller methods (@MessageMapping).

    }
}
