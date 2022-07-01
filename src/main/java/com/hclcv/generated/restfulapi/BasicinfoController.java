package com.hclcv.generated.restfulapi;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.hclcv.generated.mapper.BasicinfoMapper;
import com.hclcv.generated.model.Basicinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.hclcv.generated.service.BasicinfoService;
import javax.annotation.Generated;
import javax.annotation.Generated;

@Generated(
		value = {
				"https://github.com/coolcooldee/sloth",
				"Sloth version:1.0"
		},
		comments = "This class is generated by Sloth"
		)
@RestController
@RequestMapping(value = "/basicinfo")
public class BasicinfoController {

	String uploadpath="D:/STS WORKPLACE 2/HCLProject/src/main/resources/static/CV/";


	@Autowired
	private BasicinfoService basicinfoService;

	@Autowired
	BasicinfoMapper basicinfoMapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(@ModelAttribute Basicinfo basicinfo) {
		return "success";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@ModelAttribute Basicinfo basicinfo) {


		Basicinfo mainbasicinfo=new Basicinfo();
		mainbasicinfo.setId(basicinfo.getId());
		mainbasicinfo.setSapid(basicinfo.getSapid());
		mainbasicinfo.setEmployeename(basicinfo.getEmployeename());
		mainbasicinfo.setCurrentworklocation(basicinfo.getCurrentworklocation());
		mainbasicinfo.setEmailid(basicinfo.getEmailid());
		mainbasicinfo.setMobileno(basicinfo.getMobileno());
		mainbasicinfo.setCurrentaddress(basicinfo.getCurrentaddress());
		mainbasicinfo.setDateofjoining(basicinfo.getDateofjoining());
		mainbasicinfo.setDomainname(basicinfo.getDomainname());
		mainbasicinfo.setDatetime(basicinfo.getDatetime());
		mainbasicinfo.setStatus(basicinfo.getStatus());
		mainbasicinfo.setPhotopath(basicinfo.getPhotopath());
		//		mainbasicinfo.setImage11(basicinfo.getImage11());


		System.out.println("Hello ");

		String filePath1 = null;
		try
		{
			filePath1 = uploadpath+basicinfo.getSapid()+"/";
			File FileFoldercreate = new File(filePath1);
			if (!FileFoldercreate.exists()) {
				FileFoldercreate.mkdir();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		ArrayList<String> fileNames = null;
		if(basicinfo.getImage11().length>0) {

			String upload_dir = filePath1;

			fileNames = new ArrayList<String>();
			for(MultipartFile file:basicinfo.getImage11()) {

				if (file.isEmpty()) {
					//   	model.put("message", "Please select a file to upload");
				}
				else
				{
					try {
						int p=0,j=0;
						File folder = new File(filePath1);
						File[] listOfFiles = folder.listFiles();
						j=listOfFiles.length+1;
						String filename2 = j+file.getOriginalFilename();
						file.transferTo(new File(upload_dir + filename2));
						fileNames.add(file.getOriginalFilename());
						String image1=file.getOriginalFilename();
						//<img src=>
						String upimg="";
						String image11=upimg+filename2;
						mainbasicinfo.setPhotopath(image11);
						//  documentofdue.setDocumentfilename(image11);
						//  documentofdue.setDocumentpath(filePath+image11);
						// MultipartFile[] f1=form.getProductimage1();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		basicinfoMapper.save(mainbasicinfo);
		//		basicinfoService.save(basicinfo);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public void  delete(@PathVariable Integer id) {
		basicinfoService.deleteById(id);
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Basicinfo  view(@PathVariable Integer id) {
		return basicinfoService.getById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@ModelAttribute Basicinfo basicinfo) {

		Basicinfo mainbasicinfo=new Basicinfo();
		mainbasicinfo.setId(basicinfo.getId());
		mainbasicinfo.setSapid(basicinfo.getSapid());
		mainbasicinfo.setEmployeename(basicinfo.getEmployeename());
		mainbasicinfo.setCurrentworklocation(basicinfo.getCurrentworklocation());
		mainbasicinfo.setEmailid(basicinfo.getEmailid());
		mainbasicinfo.setMobileno(basicinfo.getMobileno());
		mainbasicinfo.setCurrentaddress(basicinfo.getCurrentaddress());
		mainbasicinfo.setDateofjoining(basicinfo.getDateofjoining());
		mainbasicinfo.setDomainname(basicinfo.getDomainname());
		mainbasicinfo.setDatetime(basicinfo.getDatetime());
		mainbasicinfo.setStatus(basicinfo.getStatus());
		mainbasicinfo.setPhotopath(basicinfo.getPhotopath());
		//		mainbasicinfo.setImage11(basicinfo.getImage11());


		System.out.println("Hello ");

		String filePath1 = null;
		try
		{
			filePath1 = uploadpath+basicinfo.getSapid()+"/";
			File FileFoldercreate = new File(filePath1);
			if (!FileFoldercreate.exists()) {
				FileFoldercreate.mkdir();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		ArrayList<String> fileNames = null;
		if(basicinfo.getImage11().length>0) {

			String upload_dir = filePath1;

			fileNames = new ArrayList<String>();
			for(MultipartFile file:basicinfo.getImage11()) {

				if (file.isEmpty()) {
					//   	model.put("message", "Please select a file to upload");
				}
				else
				{
					try {
						int p=0,j=0;
						File folder = new File(filePath1);
						File[] listOfFiles = folder.listFiles();
						j=listOfFiles.length+1;
						String filename2 = j+file.getOriginalFilename();
						file.transferTo(new File(upload_dir + filename2));
						fileNames.add(file.getOriginalFilename());
						String image1=file.getOriginalFilename();
						//<img src=>
						String upimg="";
						String image11=upimg+filename2;
						mainbasicinfo.setPhotopath(image11);
						//  documentofdue.setDocumentfilename(image11);
						//  documentofdue.setDocumentpath(filePath+image11);
						// MultipartFile[] f1=form.getProductimage1();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		basicinfoMapper.save(mainbasicinfo);


		//		basicinfoService.update(basicinfo);
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Basicinfo> list() {
		return basicinfoService.list();
	}



}