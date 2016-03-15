package com.demo.websocket.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.demo.websocket.Interceptor.WebSocketInterceptor;
import com.demo.websocket.handler.MyWebSocketHandler;

@Configuration
@EnableWebSocketMessageBroker
@EnableWebSocket
public class AppWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer implements WebSocketConfigurer {

	@Resource
	private MyWebSocketHandler handler;

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/hello").withSockJS();
		registry.addEndpoint("/add").withSockJS();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/ws").addInterceptors(new WebSocketInterceptor());
		registry.addHandler(handler, "/ws/sockjs").addInterceptors(new WebSocketInterceptor()).withSockJS();
	}
}
