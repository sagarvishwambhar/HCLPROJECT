package com.hclcv.generated.service;
import java.util.*;
import com.hclcv.generated.model.Education;
import javax.annotation.Generated;

@Generated(
	value = {
		"https://github.com/coolcooldee/sloth",
		"Sloth version:1.0"
	},
	comments = "This class is generated by Sloth"
)
public interface EducationService{


	Education getById(Integer id);
	
	List<Education> getSapid(String sapid);

	void deleteById(Integer id);


	List<Education> list();


}