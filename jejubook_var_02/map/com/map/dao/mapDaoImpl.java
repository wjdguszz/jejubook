package com.map.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.map.dto.mapDto;

public class mapDaoImpl extends SqlMapConfig implements mapDao {

	@Override
	public List<mapDto> select(int temaNo, String title) {
		System.out.println("dao 왔다");
		List<mapDto> res = new ArrayList<mapDto>();
		mapDto dto = new mapDto();
		dto.setTemaNo(temaNo);
		dto.setTitle(title);
		
		System.out.println("dao : "+dto.getTemaNo());
		System.out.println("dao : "+dto.getTitle());
		
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);
		res = session.selectList("map", dto);
		System.out.println("dao 나간다");
		return res;
	}
}
