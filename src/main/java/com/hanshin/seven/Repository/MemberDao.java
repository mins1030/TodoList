package com.hanshin.seven.Repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanshin.seven.Domain.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member selectMemberInfo(String email) {
		return sqlSession.selectOne("MemberMapper.selectMemberInfo", email);
	}
}
