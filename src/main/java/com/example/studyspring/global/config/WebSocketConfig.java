package com.example.studyspring.global.config;

import com.example.studyspring.global.socket.MatchWebSokcetHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final MatchWebSokcetHandler webSokcetHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(webSokcetHandler, "/chat").setAllowedOrigins("*");
    }
}
