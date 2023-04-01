package com.hanshin.seven.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanshin.seven.Domain.Member;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Member> selectMember(Member member) {
		return sqlSession.selectList("MemberMapper.selectMember", member);
	}
	
	public Member selectMemberInfo(int empNum) {
		return sqlSession.selectOne("MemberMapper.selectMemberInfo", empNum);
	}
	
	
	public int insertMember(Member member) {
		return sqlSession.insert("MemberMapper.insertMember",member); 
		//insert한 개수 반환
	}
	
	public List<Member> findAllMembers(){
		return sqlSession.selectList("MemberMapper.findAllMembers");
	}
	
	public int updateMember(Member member) {
		return sqlSession.update("MemberMapper.updateMember",member);
		//update한 개수 반환
	}
	
	public int deleteMember(Member member) {
		return sqlSession.delete("MemberMapper.deleteMember",member);
		//delete한 개수 반환
	}
}
