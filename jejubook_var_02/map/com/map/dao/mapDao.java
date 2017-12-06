package com.map.dao;

import java.util.List;

import com.map.dto.mapDto;

public interface mapDao {
	public List<mapDto> select(int temaNo, String title);
}
