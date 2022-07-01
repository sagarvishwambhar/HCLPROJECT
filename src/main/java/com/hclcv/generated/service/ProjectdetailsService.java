package com.hclcv.generated.service;
import java.util.*;
import com.hclcv.generated.model.Projectdetails;
import javax.annotation.Generated;


public interface ProjectdetailsService{


	Projectdetails getById(Integer id);
	
	List<Projectdetails> getSapid(String sapid);

	void deleteById(Integer id);


	List<Projectdetails> list();


}