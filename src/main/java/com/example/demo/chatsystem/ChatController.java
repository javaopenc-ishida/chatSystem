package com.example.demo.chatsystem;

import java.util.List;

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
		this.chatdao = chatdao;
	}

	@RequestMapping()
	public String chat() {
		System.out.println("index");
		return "index";
	}

	@RequestMapping("/view")
	public String view(Model model,Chat chat) {
		System.out.println("/complete1"+chat.getComment1());
		EntChat entchat = new EntChat();
		entchat.setId(chat.getId1());
		entchat.setName(chat.getName1());
		entchat.setComment(chat.getComment1());
		chatdao.insertDb(entchat);
		List<EntChat> list = chatdao.searchDb();
		model.addAttribute("dbList1", list);
		model.addAttribute("title", "一覧ページ");
		return "view";
		
}
	@RequestMapping("/complete")
	public String complete(Chat chat,Model model) {
		System.out.println("/complete"+chat.getComment1());
//		+chat.getName1()+chat.getComment1());
		EntChat entchat = new EntChat();
		entchat.setId(chat.getId1());
		entchat.setName(chat.getName1());
		entchat.setComment(chat.getComment1());
		chatdao.insertDb(entchat);
		List<EntChat> list = chatdao.searchDb();
		model.addAttribute("dbList1", list);
		model.addAttribute("title", "一覧ページ");
		
		return "view";
	}
	

	//	public String view(Model model) {
	//		List<EntChat> list = chatdao.searchDb();
	//		model.addAttribute("dbList1", list);
	//		model.addAttribute("title", "一覧ページ");
	//		return "view";
}

//public String view(Chat chat,Model model){
//	EntChat entchat = new EntChat();
//	entchat.setName(chat.getName1());
//	chatdao.insertDb(entchat);
//	System.out.println("view");
//	return "view";
//	