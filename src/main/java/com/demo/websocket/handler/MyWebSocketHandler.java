package com.demo.websocket.handler;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.demo.websocket.model.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyWebSocketHandler implements WebSocketHandler {

	public static final Map<Long, WebSocketSession> userSocketSessionMap;
	static {
		userSocketSessionMap = new HashMap<Long, WebSocketSession>();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Long uid = (Long)session.getAttributes().get("uid");
		if (userSocketSessionMap.get(uid) == null) {
			userSocketSessionMap.put(uid, session);
		}

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
			throws Exception {
		if (message.getPayloadLength() == 0)
			return;
		Message msg = new Gson().fromJson(message.getPayload().toString(), Message.class);
		msg.setDate(new Date());
		sendMessageToUser(msg.getTo(), new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable paramThrowable) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
			.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				log.debug("Socket会话已经移除:用户ID{}", entry.getKey());
				break;
			}
		}

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus paramCloseStatus)
			throws Exception {
		log.debug("Websocket:{}已经关闭", session.getId());
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
			.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				log.debug("Socket会话已经移除:用户ID{}", entry.getKey());
				break;
			}
		}

	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(final TextMessage message) throws IOException {
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap
			.entrySet().iterator();

		// 多线程群发
		while (it.hasNext()) {

			final Entry<Long, WebSocketSession> entry = it.next();

			if (entry.getValue().isOpen()) {
				// entry.getValue().sendMessage(message);
				new Thread(new Runnable() {

					public void run() {
						try {
							if (entry.getValue().isOpen()) {
								entry.getValue().sendMessage(message);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}).start();
			}

		}
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param userName
	 * @param message
	 * @throws IOException
	 */
	public void sendMessageToUser(Long uid, TextMessage message)
			throws IOException {
		WebSocketSession session = userSocketSessionMap.get(uid);
		if (session != null && session.isOpen()) {
			session.sendMessage(message);
		}
	}

}
