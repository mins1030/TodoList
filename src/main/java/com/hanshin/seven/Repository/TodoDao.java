package com.hanshin.seven.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;



@Repository
public class TodoDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	public List<Todo> selectTodo(Todo todo) {
		logger.debug("Todo[selectTodo in dao] : " + todo);
		return sqlSession.selectList("TodoMapper.selectTodo", todo);
	}
	public Todo selectTodoInfo(String todoId) {
		return sqlSession.selectOne("TodoMapper.selectTodoInfo", todoId);
	}
	
	
	public int insertTodo(Todo todo) {
		return sqlSession.insert("TodoMapper.insertTodo",todo); 
		//insert한 개수 반환
	}
	
	public List<Todo> findAllTodo(){
		return sqlSession.selectList("TodoMapper.findAllTodo");
	}
	
	public int updateTodo(Todo todo) {
		return sqlSession.update("TodoMapper.updateTodo",todo);
		//update한 개수 반환
	}
	
	public int deleteTodo(Todo todo) {
		return sqlSession.delete("TodoMapper.deleteTodo",todo);
		//delete한 개수 반환
	}
}
