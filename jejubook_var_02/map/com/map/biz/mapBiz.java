package com.map.biz;

import java.util.List;

import com.map.dto.mapDto;

public interface mapBiz {
	public List<mapDto> select(int temaNo, String title);
}
