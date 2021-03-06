package com.hclcv.generated.controller.webpage;

import java.util.*;
import com.hclcv.generated.model.Basicinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hclcv.generated.service.BasicinfoService;
import javax.annotation.Generated;
import org.springframework.web.servlet.ModelAndView;

@Generated(
		value = {
				"https://github.com/coolcooldee/sloth",
				"Sloth version:1.0"
		},
		comments = "This class is generated by Sloth"
		)
@RestController
@RequestMapping(value = "/")
public class MasterPageController {

	@Autowired
	private BasicinfoService basicinfoService;



	@RequestMapping(value={"/","/SAPID"}, method= RequestMethod.GET)
	public ModelAndView SAPID() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("HCL/SapidSearch");
		return mav;
	}

	
	@RequestMapping(value = "/Download/{sapid}", method= RequestMethod.GET)
	public ModelAndView Download(@PathVariable String sapid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sapid", sapid);
		mav.addObject("basicrow", basicinfoService.getSapid(sapid));
		mav.setViewName("HCL/Download");
		return mav;
	}

















}
