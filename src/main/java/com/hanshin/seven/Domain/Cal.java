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

public class Cal {
	private String id;
	private int memId;
	private String calId;
	private String title;
	private String category;
	private String dueDateClass;
	private LocalDateTime calStart;
	private LocalDateTime calEnd;
	
	
	
	public Cal() {
		super();
	}

	public Cal(String id,int memId,String calId,String title,String category,String dueDateClass,LocalDateTime calStart,LocalDateTime calEnd) {
		super();
		this.id = id;
		this.memId = memId;
		this.calId = calId;
		this.title = title;
		this.category = category;
		this.dueDateClass = dueDateClass;
		this.calStart = calStart;
		this.calEnd = calEnd;
	}

	@Override
	public String toString() {
		return "Cal [id=" + id + "memId=" + memId +"calId=" + calId +"title=" + title +"category=" + category +"dueDateClass=" + dueDateClass +"calStart=" + calStart +"calEnd=" + calEnd +"]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	public String getCalId() {
		return calId;
	}
	public void setCalId(String calId) {
		this.calId = calId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDueDateClass() {
		return dueDateClass;
	}
	public void setDueDateClass(String dueDateClass) {
		this.dueDateClass = dueDateClass;
	}
	public LocalDateTime getCalStart() {
		return calStart;
	}
	public void setCalStart(LocalDateTime calStart) {
		this.calStart = calStart;
	}
	public LocalDateTime getCalEnd() {
		return calEnd;
	}
	public void setCalEnd(LocalDateTime calEnd) {
		this.calEnd = calEnd;
	}
	
	
	
}
