package com.demo.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.websocket.model.CalcInput;
import com.demo.websocket.model.Result;

@Controller
public class WebSocketController {

	@RequestMapping("/{view}.html")
	public String showView(@PathVariable String view) {
		return view;
	}

	@MessageMapping("/add")
	@SendTo("/topic/showResult")
	public Result addNum(CalcInput input) throws Exception {
		Thread.sleep(2000);
		Result result = new Result(input.getNum1() + "+" + input.getNum2() + "=" + (input.getNum1() + input.getNum2()));
		return result;
	}

}
