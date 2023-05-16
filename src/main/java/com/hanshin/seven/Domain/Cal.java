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
	private String calId;
	private LocalDateTime calDate;
	private String contents;
	
	
	
	public Cal() {
		super();
	}

	public Cal(String calId,LocalDateTime calDate,String contents) {
		super();
		this.calId = calId;
		this.calDate = calDate;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Cal [calId=" + calId + "calDate=" + calDate +"contents=" + contents +"]";
	}
	
	public String getcalId() {
		return calId;
	}
	public void setcalId(String calId) {
		this.calId = calId;
	}
	public LocalDateTime getcalDate() {
		return calDate;
	}
	public void setcalDate(LocalDateTime calDate) {
		this.calDate = calDate;
	}
	public String getcontents() {
		return contents;
	}
	public void setcontents(String contents) {
		this.contents = contents;
	}
	
	
	
}
