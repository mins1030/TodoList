package com.hanshin.seven.RepositoryTest;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;
import com.hanshin.seven.Repository.TodoDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TodoRepositoryTests {

	  @Autowired
	  private TodoDao todoDao;
	
	  @Test
	  public void testA() throws Exception {
		  Todo todo = todoDao.selectTodoInfo("4dd30501-469c-4b39-b686-a5c1b120480b");
		  System.out.println(todo.getTask());
		  System.out.println("todo : " + todo);
		  Assert.assertEquals(todo.getTask(), "문서 정리");
	  }
	  
	  @Test
	  public void testB() throws Exception {
		  //String todoId = UUID.randomUUID().toString();
		  Todo insertTodo = new Todo("testTodoId","testSeniorName","testSeniorDept","testJuniorName","testJuniorDept",
				  "testTask",LocalDateTime.now(), LocalDateTime.now(),1); 
		  todoDao.insertTodo(insertTodo);  
		  Todo todo = todoDao.selectTodoInfo("testTodoId"); 
		  System.out.println("Todo : " + todo); 
		  Assert.assertEquals("testTask", todo.getTask());
		  
	  }
	  
	  @Test
	  public void testC() throws Exception {
		  Todo updateTodo = new Todo("testTodoId","testSeniorName","testSeniorDept","testJuniorName","testJuniorDept",
				  "testTask",LocalDateTime.now(),LocalDateTime.now(),1); 
		  todoDao.updateTodo(updateTodo);  
		  Todo todo = todoDao.selectTodoInfo("testTodoId"); 
		  System.out.println("Todo : " + todo); 
		  Assert.assertEquals("testTask2", todo.getTask());
		  
	  }
	  @Test
	  public void testD() throws Exception {
		  Todo deleteTodo = new Todo("testTodoId","testSeniorName","testSeniorDept","testJuniorName","testJuniorDept",
				  "testTask",LocalDateTime.now(),LocalDateTime.now(),1);
		  todoDao.deleteTodo(deleteTodo);  
		  Todo checkTodo = todoDao.selectTodoInfo("testTodoId"); 
		  System.out.println("Todo : " + checkTodo); 
		  Assert.assertNull(checkTodo);
		  
	  }
	  
}