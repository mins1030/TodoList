package com.hanshin.seven.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanshin.seven.Domain.Todo;



@Repository
public class TodoDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
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
