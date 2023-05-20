package com.hanshin.seven.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanshin.seven.Controller.MainController;
import com.hanshin.seven.Domain.Cal;
import com.hanshin.seven.Domain.Member;
import com.hanshin.seven.Domain.Todo;



@Repository
public class CalDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	public List<Cal> selectCal(Cal cal) {
		logger.debug("Member[selectMember in dao] : " + cal);
		return sqlSession.selectList("CalMapper.selectCal", cal);
	}
	
	
	public int insertCal(Cal cal) {
		return sqlSession.insert("CalMapper.insertCal",cal); 
		//insert한 개수 반환
	}
	
	public int updateCal(Cal cal) {
		return sqlSession.update("CalMapper.updateCal",cal);
		//update한 개수 반환
	}
	
	public int deleteCal(Cal cal) {
		return sqlSession.delete("CalMapper.deleteCal",cal);
		//delete한 개수 반환
	}
}
