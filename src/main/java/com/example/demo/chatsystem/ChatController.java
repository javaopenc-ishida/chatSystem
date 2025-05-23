package com.example.demo.chatsystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.chatdao.ChatDao;
import com.example.demo.chatform.Chat;
import com.example.demo.entity.EntChat;

@Controller
public class ChatController {
	public final ChatDao chatdao;
	public ChatController(ChatDao chatdao) {
		this.chatdao=chatdao;
	}
	
	@RequestMapping()
	public String chat(){
		System.out.println("index");
		return "index";
	}
		
	@RequestMapping("/view")
	public String view(Chat chat,Model model){
		EntChat entchat = new EntChat();
		entchat.setName(chat.getName1());
		chatdao.insertDb(entchat);
		System.out.println("view");
		return "view";
		
	}

}
