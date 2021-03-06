package com.hclcv.generated.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import com.hclcv.generated.mapper.EducationMapper;
import com.hclcv.generated.model.Education;
import com.hclcv.generated.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Generated;


@Generated(
	value = {
		"https://github.com/coolcooldee/sloth",
		"Sloth version:1.0"
	},
	comments = "This class is generated by Sloth"
)
@Service
public  class EducationServiceImpl implements EducationService{

	Logger logger = LoggerFactory.getLogger(EducationService.class);

	@Autowired
	private EducationMapper educationMapper;


	@Override
	public Education getById(Integer id){
		return educationMapper.getById1(id);
	}
	
	@Override
	public List<Education> getSapid(String sapid){
		return educationMapper.getSapid(sapid);
	}
	
	
	@Override
	public void deleteById(Integer id){
		educationMapper.deleteById1(id);
	}


	@Override
	public List<Education> list(){
		return educationMapper.list();
	}

	
}