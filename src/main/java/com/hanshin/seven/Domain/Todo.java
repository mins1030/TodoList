package com.hanshin.seven.Domain;

import java.time.LocalDateTime;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString

public class Todo {
	private String todoId;
	private String seniorName;
	private String seniorDept;
	private String juniorName;
	private String juniorDept;
	private String task;
	private LocalDateTime startDate;
	private LocalDateTime deadDate;;
	private int importance;
	
	
	
	public Todo() {
		super();
	}

	public Todo(String todoId, String seniorName, String seniorDept, String juniorName, String juniorDept, 
			String task, LocalDateTime startDate, LocalDateTime deadDate, int importance) {
		super();
		this.todoId = todoId;
		this.seniorName = seniorName;
		this.seniorDept = seniorDept;
		this.juniorName = juniorName;
		this.juniorDept = juniorDept;
		this.task = task;
		this.startDate = startDate;
		this.deadDate = deadDate;
		this.importance = importance;
	}

	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", seniorName=" + seniorName + ", seniorDept=" + seniorDept + ", "
				+ "juniorName=" + juniorName + ", juniorDept=" + juniorDept 
				+ ", task=" + task + "startDate=" + startDate +"deadDate=" + deadDate +"importance=" + importance +"]";
	}
	
	public String getTodoId() {
		return todoId;
	}
	public void setTodoId(String todoId) {
		this.todoId = todoId;
	}
	public String getSeniorName() {
		return seniorName;
	}
	public void setSeniorName(String seniorName) {
		this.seniorName = seniorName;
	}
	public String getSeniorDept() {
		return seniorDept;
	}
	public void setSeniorDept(String seniorDept) {
		this.seniorDept = seniorDept;
	}
	public String getJuniorName() {
		return juniorName;
	}
	public void setJuniorName(String juniorName) {
		this.juniorName = juniorName;
	}
	public String getJuniorDept() {
		return juniorDept;
	}
	public void setJuniorDept(String juniorDept) {
		this.juniorDept = juniorDept;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getDeadDate() {
		return deadDate;
	}
	public void setDeadDate(LocalDateTime deadDate) {
		this.deadDate = deadDate;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	
	
	
}
