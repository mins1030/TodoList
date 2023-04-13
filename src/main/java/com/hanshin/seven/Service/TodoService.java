package com.hanshin.seven.Service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;
import com.hanshin.seven.Repository.MemberDao;
import com.hanshin.seven.Repository.TodoDao;

import jakarta.servlet.http.HttpSession;

@Service
public class TodoService {
	
	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	TodoDao todoDao;
	
	@Autowired
	MemberDao memberDao;
	
	public int insertTodo(HttpSession session, Todo todo){
		String seniorEmail = (String)(session.getAttribute("otm_email"));
		
		Member m = new Member();
		m.setEmail(seniorEmail);
		
		Member seniorMember = memberDao.selectMember(m).get(0);
		String todoId = UUID.randomUUID().toString(); 
		
		try {
			todo.setSeniorName(seniorMember.getName());
			todo.setSeniorDept(seniorMember.getDept());
			todo.setTodoId(todoId);
		}catch(Exception e) {
			logger.debug("exception in insertMember() ...");
		}
		
		return todoDao.insertTodo(todo);
	}
	public List<Todo> selectTodo (Todo todo) {
		return todoDao.selectTodo(todo);
	}
	
}
