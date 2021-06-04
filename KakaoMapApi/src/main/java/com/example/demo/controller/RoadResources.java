package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.RoadVO;
import com.example.demo.service.RoadService;

@RestController
public class RoadResources extends BaseResource {
	protected final Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private RoadService roadService;
	
	@GetMapping(value = "/road")
	public ResponseEntity<List<RoadVO>> getAllMember()
	      throws Exception {
		log.info("# 도로명 전체 조회하기" );
	    List<RoadVO> list = roadService.getRoadData();
	    return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/road")
	public Integer updateXY( RoadVO roadVO )
	      throws Exception {
		log.info("도로명으로 좌표업데이트 하기");
		log.info( roadVO.toString() );
		return roadService.updateRoadXY( roadVO );
	}
	
}
