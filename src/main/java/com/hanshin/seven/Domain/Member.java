package com.hanshin.seven.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
	private String name;
	private String email;
	private String pwd;
	private String dept;
	private String pos;
	private int empNum;
}
