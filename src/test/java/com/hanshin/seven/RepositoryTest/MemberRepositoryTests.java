package com.hanshin.seven.RepositoryTest;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MemberRepositoryTests {
	  @Autowired
	  private MemberDao memberDao;
	
	  @Test
	  public void testA() throws Exception {
		  Member member = memberDao.selectMemberInfo(5130);
		  Assert.assertEquals(member.getName(), "김민서");
	  }
	  
	  @Test
	  public void testB() throws Exception {
		  Member insertMember = new Member("testName","testEmail","testPwd","testDept","testPos", 1234); 
		  memberDao.insertMember(insertMember);  
		  Member member = memberDao.selectMemberInfo(1234); 
		  Assert.assertEquals("testEmail", member.getEmail());
		  
	  }
	  
	  @Test
	  public void testC() throws Exception {
		  Member updateMember = new Member("testName","testEmail2","testPwd","testDept","testPos", 1234); 
		  memberDao.updateMember(updateMember);  
		  Member member = memberDao.selectMemberInfo(1234); 
		  Assert.assertEquals("testEmail2", member.getEmail());
		  
	  }
	  @Test
	  public void testD() throws Exception {
		  Member member = new Member();
		  member.setEmail("testEmail2");
		  List<Member> selectMemberList = memberDao.selectMember(member);
		  
		  String selectMembersPwd = selectMemberList.get(0).getPwd();
		  String expectedPwd = "testPwd";
		  
		  Assert.assertEquals(selectMembersPwd, expectedPwd);
	  }
	  
	  @Test
	  public void testZ() throws Exception{
		  Member deleteMember = new Member("testName","testEmail","testPwd","testDept","testPos", 1234); 
		  memberDao.deleteMember(deleteMember);  
		  Member checkMember = memberDao.selectMemberInfo(1234); 
		  System.out.println("Member : " + checkMember); 
		  Assert.assertNull(checkMember);
	  }
	  
}