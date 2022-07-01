package com.hclcv.generated.controller.webpage;

import java.util.*;

import com.hclcv.generated.mapper.EducationMapper;
import com.hclcv.generated.model.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hclcv.generated.service.BasicinfoService;
import com.hclcv.generated.service.EducationService;
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
public class EducationPageController {
	
	@Autowired
	private BasicinfoService basicinfoService;

	@Autowired
	private EducationService educationService;
	
	@Autowired
	EducationMapper educationMapper;

	
	@RequestMapping(value = "/EducationSummary/{sapid}", method= RequestMethod.GET)
	public ModelAndView EducationSummary(@PathVariable String sapid) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sapid", sapid);
		mav.addObject("basicrow", basicinfoService.getSapid(sapid));
		mav.addObject("row", educationService.getSapid(sapid));
		mav.setViewName("HCL/EducationSummary");
		return mav;
	}
	
	
	@RequestMapping(value = "/EducationSummaryEdit/{sapid}/{id}", method= RequestMethod.GET)
	public ModelAndView EducationSummaryEdit(@PathVariable String sapid,@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sapid", sapid);
		mav.addObject("basicrow", basicinfoService.getSapid(sapid));
		mav.addObject("row", educationService.getSapid(sapid));
		mav.addObject("edurow", educationService.getById(id));
		mav.setViewName("HCL/EducationSummaryEdit");
		return mav;
	}

	
	/*
	 * @RequestMapping(value = "/list", method= RequestMethod.GET) public
	 * ModelAndView list(@RequestParam(value = "p", required = false) Integer
	 * pageNo) { ModelAndView mav = new ModelAndView(); mav.addObject("rows",
	 * educationService.list()); mav.setViewName("/EducationList"); return mav; }
	 * 
	 * @RequestMapping(value = "/detail/{id}", method= RequestMethod.GET) public
	 * ModelAndView detail(@PathVariable Integer id) { ModelAndView mav = new
	 * ModelAndView(); mav.addObject("row", educationService.getById(id));
	 * mav.setViewName("/EducationDetail"); return mav; }
	 * 
	 * @RequestMapping(value = "/create", method= RequestMethod.GET) public
	 * ModelAndView create() { ModelAndView mav = new ModelAndView();
	 * mav.setViewName("/EducationCreate"); return mav; }
	 */
}
