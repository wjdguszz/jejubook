package com.map.biz;

import java.util.List;

import com.map.dao.SqlMapConfig;
import com.map.dao.mapDaoImpl;
import com.map.dto.mapDto;

public class mapBizImpl extends SqlMapConfig implements mapBiz {

	mapDaoImpl daoImpl = new mapDaoImpl();
	
	@Override
	public List<mapDto> select(int temaNo, String title) {
		return daoImpl.select(temaNo, title);
	}

}
