package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.RoadMapper;
import com.example.demo.model.RoadVO;

@Service
public class RoadService extends BaseService{
	
	@Autowired
	private RoadMapper roadMapper;
	
	public List<RoadVO> getRoadData(){
		return roadMapper.getRoadData();
	}
	
	public Integer updateRoadXY( RoadVO roadVO ){
		
		return roadMapper.updateRoadXY( roadVO );
	}
	
}