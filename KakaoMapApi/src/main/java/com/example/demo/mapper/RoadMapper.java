package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.RoadVO;

public interface RoadMapper {

	public List<RoadVO> getRoadData();
	public Integer updateRoadXY( RoadVO roadVO );
}