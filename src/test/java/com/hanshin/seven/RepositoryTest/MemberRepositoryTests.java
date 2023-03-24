package com.hanshin.seven.RepositoryTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Repository.MemberDao;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTests {

	  @Autowired
	  private MemberDao memberDao;
	
	  @Test
	  public void test_selectMemberInfo() throws Exception {
		  Member member = memberDao.selectMemberInfo(5130);
		  System.out.println(member.getName());
		  System.out.println("member : " + member);
		  Assert.assertEquals(member.getName(), "김민서");
	  }
}