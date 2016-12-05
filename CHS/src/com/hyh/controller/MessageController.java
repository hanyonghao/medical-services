package com.hyh.controller;

import com.hyh.annotation.Autowired;
import com.hyh.annotation.RequestMapping;
import com.hyh.common.BaseController;
import com.hyh.entity.MessageEntity;
import com.hyh.entity.UserEntity;
import com.hyh.service.MessageService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@RequestMapping("Message")
public class MessageController extends BaseController {

	@Autowired
	private MessageService messageService;

	public void index() throws ServletException, IOException {
        if(hasLogin()){
            UserEntity user = (UserEntity) session.getAttribute("user");
            messageService.clearViewTips(user.getId());
            List<MessageEntity> messages = messageService.findAllMessageByUser(user.getId());
            request.setAttribute("messages",messages);
            display("Message/index.jsp");
        }else {
            redirect("User/login");
        }

	}

	private boolean hasLogin(){
		Object user = session.getAttribute("user");
		if(user != null){
			return true;
		}
		return false;
	}
}
