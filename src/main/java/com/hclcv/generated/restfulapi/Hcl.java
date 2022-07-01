package com.hclcv.generated.restfulapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hclcv.generated.mapper.BasicinfoMapper;
import com.hclcv.generated.model.Basicinfo;
import com.hclcv.generated.model.Education;
import com.hclcv.generated.model.Experiencesummary;
import com.hclcv.generated.model.Ohterprojectdeatils;
import com.hclcv.generated.model.Professionalsynopsis;
import com.hclcv.generated.model.Projectdetails;
import com.hclcv.generated.model.Skillsummary;
import com.hclcv.generated.service.BasicinfoService;
import com.hclcv.generated.service.EducationService;
import com.hclcv.generated.service.ExperiencesummaryService;
import com.hclcv.generated.service.OhterprojectdeatilsService;
import com.hclcv.generated.service.ProfessionalsynopsisService;
import com.hclcv.generated.service.ProjectdetailsService;
import com.hclcv.generated.service.SkillsummaryService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class Hcl {

	@Autowired
	private BasicinfoService basicinfoService;

	@Autowired
	BasicinfoMapper basicinfoMapper;

	@Autowired
	private EducationService educationService;

	@Autowired
	private ExperiencesummaryService experiencesummaryService;

	@Autowired
	private OhterprojectdeatilsService ohterprojectdeatilsService;

	@Autowired
	private ProfessionalsynopsisService professionalsynopsisService;
	
	@Autowired
	private ProjectdetailsService projectdetailsService;
	
	@Autowired
	private SkillsummaryService skillsummaryService;

	
	
	//public static void main(String[] args) throws DocumentException, MalformedURLException, IOException
	//{

	
	@RequestMapping(value = "/GenerateCV/{sapid}", method = RequestMethod.GET)
	public String pdfgenerate(@PathVariable String sapid) throws DocumentException, IOException, ParseException {

		// TODO Auto-generated method stub
		Basicinfo basicinfo=basicinfoService.getSapid(sapid);

		
		String pdfaddress=null;
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/STS WORKPLACE 2/HCLProject/src/main/resources/static/CV/"+basicinfo.getSapid()+"/"+basicinfo.getSapid()+"_"+basicinfo.getEmployeename()+".pdf"));
		document.open();
		Font f=new Font(FontFamily.TIMES_ROMAN,12, Font.BOLD,BaseColor.BLACK);
		Font email=new Font(FontFamily.TIMES_ROMAN,12, Font.UNDERLINE | Font.BOLD,BaseColor.BLUE);
		Font m=new Font(FontFamily.TIMES_ROMAN,10, Font.BOLD,BaseColor.BLACK);
		Font f1=new Font(FontFamily.TIMES_ROMAN,12,Font.NORMAL,BaseColor.BLACK);
		Font f1u=new Font(FontFamily.TIMES_ROMAN,12,Font.UNDERLINE | Font.BOLD ,BaseColor.BLACK);
		float[] columnWidths3 = {1f, 1f, 1f};

		Font underline=new Font(FontFamily.TIMES_ROMAN,8,Font.UNDERLINE | Font.BOLD ,BaseColor.BLACK);



		Image waterMarkImage = Image.getInstance("D://hcl.png");

		//  Image img = Image.getInstance("D://38Tulips.jpg");

		//Get width and height of whole page
		//        float pdfPageWidth = document.getPageSize().getWidth();
		//      float pdfPageHeight = document.getPageSize().getHeight();

		//Set waterMarkImage on whole page
		//        writer.getDirectContentUnder().addImage(waterMarkImage,
		//                   pdfPageWidth, 0, 0, pdfPageHeight, 0, 0);
		System.out.println("Writing Paragraph to PDF");


		Image hcl = Image.getInstance("D://hcl.png");
		//hcl.setAlignment(hcl.ALIGN_CENTER);

		hcl.scaleToFit(700,110);
		hcl.setAbsolutePosition(10, 730);

		document.add(hcl);

		//	hcl.setAbsolutePosition(1, 1);
		//		writer.getDirectContent().addImage(hcl);
		//		hcl.scaleAbsolute(550, 100);
		//document.add(hcl);

		
        Paragraph p=new Paragraph("\n \n  \n "+basicinfo.getEmployeename()+" ( "+basicinfo.getSapid()+" )",f);
    		p.setAlignment(Paragraph.ALIGN_LEFT);
    	//	p.setAbsolutePosition(10, 730);
    		p.setIndentationLeft(60);
    		document.add(p);


		Image card1 = Image.getInstance("D:/STS WORKPLACE 2/HCLProject/src/main/resources/static/CV/"+basicinfo.getSapid()+"/"+basicinfo.getPhotopath());
//		card1.hasAbsoluteX();
	//	card1.setPaddingTop(50);
		card1.scaleAbsolute(80, 80);
		//hcl.scaleToFit(80,80);
		card1.setAbsolutePosition(10, 730);
		document.add(card1);


        Paragraph p1=new Paragraph(" ",f);
        document.add(p1);

//		document.add(new LineSeparator());
		LineSeparator sep = new LineSeparator();
//		sep.setPadding(25);
		//sep.setOffset(10);
		document.add(sep);
		

		
        Paragraph currentworklocation=new Paragraph("Current Work location: "+basicinfo.getCurrentworklocation(),f);
        document.add(currentworklocation);

        
        Paragraph emailid = new Paragraph();
        emailid.add(new Phrase("Email ID: ",f));
        emailid.add(new Chunk(basicinfo.getEmailid(),email));
        document.add(emailid);
        
        Paragraph mobileno=new Paragraph("Mobile: "+basicinfo.getMobileno(),f);
        document.add(mobileno);

        Paragraph currentaddress=new Paragraph("Current Address: "+basicinfo.getCurrentaddress(),f);
        document.add(currentaddress);
		
        Paragraph p2=new Paragraph(" ",f);
        document.add(p2);
        
        LineSeparator sep2 = new LineSeparator();
		document.add(sep2);

        Paragraph professionalsynopsis=new Paragraph("Professional Synopsis",f);
        document.add(professionalsynopsis);
        
		List list = new List(List.UNORDERED);
		 list.setListSymbol("•");
		 list.add(new ListItem("  Currently part of HCL Technologies Limited, working as a Software Developer.",f1));

		 
		 
		 if(professionalsynopsisService.getSapid(sapid) !=null)
			{
				java.util.List<Professionalsynopsis> listofexp=professionalsynopsisService.getSapid(sapid);
				
			for(int i=0;i<listofexp.size();i++)
			{
		 list.add(new ListItem("  "+listofexp.get(i).getSynopsistext(),f1));
		 	}
			}
		 document.add(list);


		String sagar="sagar";		
		if(sagar.equals("sagar"))
		{
        Paragraph experiencesummary=new Paragraph("Experience Summary:",f);
        experiencesummary.setSpacingAfter(5);
        experiencesummary.setSpacingBefore(5);
        document.add(experiencesummary);

        PdfPTable table = new PdfPTable(4); // 3 columns.
		table.setWidthPercentage(95); //Width 100%
		table.setSpacingBefore(2f); //Space before table
		table.setSpacingAfter(2f); //Space after table


		PdfPCell Organisation = new PdfPCell(new Paragraph("Organisation",f));
		Organisation.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Organisation.setHorizontalAlignment(Element.ALIGN_LEFT);
		Organisation.setPaddingTop(4);
		Organisation.setPaddingBottom(4);
		//carddetails.setBorderColor(BaseColor.WHITE);
		table.addCell(Organisation);

		
		PdfPCell Designation = new PdfPCell(new Paragraph("Designation",f));
		Designation.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Designation.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Designation.setPaddingTop(4);
		Designation.setPaddingBottom(4);
		//Designation.setBorderColor(BaseColor.WHITE);
		table.addCell(Designation);

		PdfPCell From = new PdfPCell(new Paragraph("From",f));
		From.setVerticalAlignment(Element.ALIGN_MIDDLE);
		From.setHorizontalAlignment(Element.ALIGN_RIGHT);
		From.setPaddingTop(4);
		From.setPaddingBottom(4);
		//From.setBorderColor(BaseColor.WHITE);
		table.addCell(From);
		
		PdfPCell todate = new PdfPCell(new Paragraph("To",f));
		todate.setVerticalAlignment(Element.ALIGN_MIDDLE);
		todate.setHorizontalAlignment(Element.ALIGN_RIGHT);
		todate.setPaddingTop(4);
		todate.setPaddingBottom(4);
		//todate.setBorderColor(BaseColor.WHITE);
		table.addCell(todate);
		
		
		
		PdfPCell Organisationans = new PdfPCell(new Paragraph("HCL TECHNOLOGIES LTD.  ",f1));
		Organisationans.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Organisationans.setHorizontalAlignment(Element.ALIGN_LEFT);
		Organisationans.setPaddingTop(4);
		Organisationans.setPaddingBottom(4);
		//carddetails.setBorderColor(BaseColor.WHITE);
		table.addCell(Organisationans);

		
		PdfPCell Designationans = new PdfPCell(new Paragraph("SOFTWERE DEVELOPER ",f1));
		Designationans.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Designationans.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Designationans.setPaddingTop(4);
		Designationans.setPaddingBottom(4);
		//Designation.setBorderColor(BaseColor.WHITE);
		table.addCell(Designationans);

		PdfPCell Fromans = new PdfPCell(new Paragraph(basicinfo.getDateofjoining(),f1));
		Fromans.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Fromans.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Fromans.setPaddingTop(4);
		Fromans.setPaddingBottom(4);
		//From.setBorderColor(BaseColor.WHITE);
		table.addCell(Fromans);
		
		PdfPCell todateans2 = new PdfPCell(new Paragraph("Till",f1));
		todateans2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		todateans2.setHorizontalAlignment(Element.ALIGN_RIGHT);
		todateans2.setPaddingTop(4);
		todateans2.setPaddingBottom(4);
		//todate.setBorderColor(BaseColor.WHITE);
		table.addCell(todateans2);

		if(experiencesummaryService.getSapid(sapid) !=null)
		{
			java.util.List<Experiencesummary> listofexp=experiencesummaryService.getSapid(sapid);
			
		for(int i=0;i<listofexp.size();i++)
		{
		PdfPCell Organisationans3 = new PdfPCell(new Paragraph(listofexp.get(i).getOrganisationname(),f1));
		Organisationans3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Organisationans3.setHorizontalAlignment(Element.ALIGN_LEFT);
		Organisationans3.setPaddingTop(4);
		Organisationans3.setPaddingBottom(4);
		//carddetails.setBorderColor(BaseColor.WHITE);
		table.addCell(Organisationans3);

		
		PdfPCell Designationans3 = new PdfPCell(new Paragraph(listofexp.get(i).getDesignation(),f1));
		Designationans3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Designationans3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Designationans3.setPaddingTop(4);
		Designationans3.setPaddingBottom(4);
		//Designation.setBorderColor(BaseColor.WHITE);
		table.addCell(Designationans3);

		PdfPCell Fromans3 = new PdfPCell(new Paragraph(listofexp.get(i).getFormdate(),f1));
		Fromans3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Fromans3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Fromans3.setPaddingTop(4);
		Fromans3.setPaddingBottom(4);
		//From.setBorderColor(BaseColor.WHITE);
		table.addCell(Fromans3);
		
		PdfPCell todateans3 = new PdfPCell(new Paragraph(listofexp.get(i).getTodate(),f1));
		todateans3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		todateans3.setHorizontalAlignment(Element.ALIGN_RIGHT);
		todateans3.setPaddingTop(4);
		todateans3.setPaddingBottom(4);
		//todate.setBorderColor(BaseColor.WHITE);
		table.addCell(todateans3);
		}
		
		}		
		
		document.add(table);
		
		}

        
		if(sagar.equals("sagar"))
		{
        Paragraph skillsummary=new Paragraph("Skill Summary:",f);
        skillsummary.setSpacingAfter(5);
        skillsummary.setSpacingBefore(5);
        document.add(skillsummary);

        PdfPTable table = new PdfPTable(4); // 3 columns.
		table.setWidthPercentage(95); //Width 100%
		table.setSpacingBefore(2f); //Space before table
		table.setSpacingAfter(2f); //Space after table


		PdfPCell Stream = new PdfPCell(new Paragraph("Stream",f));
		Stream.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Stream.setHorizontalAlignment(Element.ALIGN_LEFT);
		Stream.setPaddingTop(4);
		Stream.setPaddingBottom(4);
		//carddetails.setBorderColor(BaseColor.WHITE);
		table.addCell(Stream);

		
		PdfPCell Skills = new PdfPCell(new Paragraph("Skills",f));
		Skills.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Skills.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Skills.setPaddingTop(4);
		Skills.setPaddingBottom(4);
		//Designation.setBorderColor(BaseColor.WHITE);
		table.addCell(Skills);

		PdfPCell SelfProficiency = new PdfPCell(new Paragraph("Self Proficiency",f));
		SelfProficiency.setVerticalAlignment(Element.ALIGN_MIDDLE);
		SelfProficiency.setHorizontalAlignment(Element.ALIGN_RIGHT);
		SelfProficiency.setPaddingTop(4);
		SelfProficiency.setPaddingBottom(4);
		//From.setBorderColor(BaseColor.WHITE);
		table.addCell(SelfProficiency);
		
		PdfPCell PrimarySkills = new PdfPCell(new Paragraph("Primary Skills",f));
		PrimarySkills.setVerticalAlignment(Element.ALIGN_MIDDLE);
		PrimarySkills.setHorizontalAlignment(Element.ALIGN_RIGHT);
		PrimarySkills.setPaddingTop(4);
		PrimarySkills.setPaddingBottom(4);
		//todate.setBorderColor(BaseColor.WHITE);
		table.addCell(PrimarySkills);
		
		if(skillsummaryService.getSapid(sapid) !=null)
		{
			java.util.List<Skillsummary> listofexp=skillsummaryService.getSapid(sapid);
			
		for(int i=0;i<listofexp.size();i++)
		{

			PdfPCell Stream1 = new PdfPCell(new Paragraph(listofexp.get(i).getStream(),f1));
			Stream1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Stream1.setHorizontalAlignment(Element.ALIGN_LEFT);
			Stream1.setPaddingTop(4);
			Stream1.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(Stream1);

			
			PdfPCell Skills1 = new PdfPCell(new Paragraph(listofexp.get(i).getSkills(),f1));
			Skills1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Skills1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Skills1.setPaddingTop(4);
			Skills1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(Skills1);

			PdfPCell SelfProficiency1 = new PdfPCell(new Paragraph(listofexp.get(i).getSelfproficiency(),f1));
			SelfProficiency1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			SelfProficiency1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			SelfProficiency1.setPaddingTop(4);
			SelfProficiency1.setPaddingBottom(4);
			//From.setBorderColor(BaseColor.WHITE);
			table.addCell(SelfProficiency1);
			
			PdfPCell PrimarySkills1 = new PdfPCell(new Paragraph(listofexp.get(i).getPrimaryskills(),f1));
			PrimarySkills1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			PrimarySkills1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			PrimarySkills1.setPaddingTop(4);
			PrimarySkills1.setPaddingBottom(4);
			//todate.setBorderColor(BaseColor.WHITE);
			table.addCell(PrimarySkills1);
			
		}
		

		}
		
		document.add(table);

		}
		

		
		
		
		if(sagar.equals("sagar"))
		{
        Paragraph education=new Paragraph("Education:",f);
        education.setSpacingAfter(5);
        education.setSpacingBefore(5);
        document.add(education);
        
        PdfPTable table = new PdfPTable(4); // 3 columns.
		table.setWidthPercentage(95); //Width 100%
		table.setSpacingBefore(2f); //Space before table
		table.setSpacingAfter(2f); //Space after table


		PdfPCell degree = new PdfPCell(new Paragraph("Degree/Certificate",f));
		degree.setVerticalAlignment(Element.ALIGN_MIDDLE);
		degree.setHorizontalAlignment(Element.ALIGN_LEFT);
		degree.setPaddingTop(4);
		degree.setPaddingBottom(4);
		//carddetails.setBorderColor(BaseColor.WHITE);
		table.addCell(degree);

		
		PdfPCell Discipline = new PdfPCell(new Paragraph("Course",f));
		Discipline.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Discipline.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Discipline.setPaddingTop(4);
		Discipline.setPaddingBottom(4);
		//Designation.setBorderColor(BaseColor.WHITE);
		table.addCell(Discipline);

		PdfPCell Institute = new PdfPCell(new Paragraph("Institute/University",f));
		Institute.setVerticalAlignment(Element.ALIGN_MIDDLE);
		Institute.setHorizontalAlignment(Element.ALIGN_RIGHT);
		Institute.setPaddingTop(4);
		Institute.setPaddingBottom(4);
		//From.setBorderColor(BaseColor.WHITE);
		table.addCell(Institute);
		
		PdfPCell yearofpassing = new PdfPCell(new Paragraph("Year of Passing ",f));
		yearofpassing.setVerticalAlignment(Element.ALIGN_MIDDLE);
		yearofpassing.setHorizontalAlignment(Element.ALIGN_RIGHT);
		yearofpassing.setPaddingTop(4);
		yearofpassing.setPaddingBottom(4);
		//todate.setBorderColor(BaseColor.WHITE);
		table.addCell(yearofpassing);
		

		////ds
		
		
		if(educationService.getSapid(sapid) !=null)
		{
			java.util.List<Education> listofexp=educationService.getSapid(sapid);
			
		for(int i=0;i<listofexp.size();i++)
		{
			PdfPCell degree1 = new PdfPCell(new Paragraph(listofexp.get(i).getDegreecertificate(),f1));
			degree1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			degree1.setHorizontalAlignment(Element.ALIGN_LEFT);
			degree1.setPaddingTop(4);
			degree1.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(degree1);

			
			PdfPCell Discipline1 = new PdfPCell(new Paragraph(listofexp.get(i).getDiscipline(),f1));
			Discipline1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Discipline1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Discipline1.setPaddingTop(4);
			Discipline1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(Discipline1);

			PdfPCell Institute1 = new PdfPCell(new Paragraph(listofexp.get(i).getInstituteoruniversity(),f1));
			Institute1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Institute1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Institute1.setPaddingTop(4);
			Institute1.setPaddingBottom(4);
			//From.setBorderColor(BaseColor.WHITE);
			table.addCell(Institute1);
			
			PdfPCell yearofpassing1 = new PdfPCell(new Paragraph(listofexp.get(i).getYearofpassing(),f1));
			yearofpassing1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			yearofpassing1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			yearofpassing1.setPaddingTop(4);
			yearofpassing1.setPaddingBottom(4);
			//todate.setBorderColor(BaseColor.WHITE);
			table.addCell(yearofpassing1);

		}
		}
		
		document.add(table);

        
		}
		
		if(sagar.equals("sagar"))
		{
        Paragraph projectdetails=new Paragraph("Project Details:",f);
        projectdetails.setSpacingAfter(5);
        projectdetails.setSpacingBefore(5);
        document.add(projectdetails);
        
        //projectdetailsService


		if(projectdetailsService.getSapid(sapid) !=null)
		{
			java.util.List<Projectdetails> listofexp=projectdetailsService.getSapid(sapid);
			
		for(int i=0;i<listofexp.size();i++)
		{
			float[] widths = { 20, 64};
		
	        PdfPTable table = new PdfPTable(widths); // 3 columns.
			table.setWidthPercentage(95); //Width 100%
			table.setSpacingBefore(15f); //Space before table
			table.setSpacingAfter(15f); //Space after table


			PdfPCell projectname = new PdfPCell(new Paragraph("Project ",f));
			projectname.setVerticalAlignment(Element.ALIGN_MIDDLE);
			projectname.setHorizontalAlignment(Element.ALIGN_LEFT);
			projectname.setPaddingTop(4);
			projectname.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(projectname);

			
			PdfPCell projectname1 = new PdfPCell(new Paragraph(listofexp.get(i).getProjectdetailsinfo(),f));
			projectname1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			projectname1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			projectname1.setPaddingTop(4);
			projectname1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(projectname1);

			

			PdfPCell Duration = new PdfPCell(new Paragraph("Duration",f));
			Duration.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Duration.setHorizontalAlignment(Element.ALIGN_LEFT);
			Duration.setPaddingTop(4);
			Duration.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(Duration);

			
			PdfPCell Duration1 = new PdfPCell(new Paragraph(listofexp.get(i).getDuration2(),f1));
			Duration1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			Duration1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Duration1.setPaddingTop(4);
			Duration1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(Duration1);

			
			PdfPCell TeamSize = new PdfPCell(new Paragraph("Team Size ",f));
			TeamSize.setVerticalAlignment(Element.ALIGN_MIDDLE);
			TeamSize.setHorizontalAlignment(Element.ALIGN_LEFT);
			TeamSize.setPaddingTop(4);
			TeamSize.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(TeamSize);

			
			PdfPCell TeamSize1 = new PdfPCell(new Paragraph(listofexp.get(i).getTeamsize(),f1));
			TeamSize1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			TeamSize1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			TeamSize1.setPaddingTop(4);
			TeamSize1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(TeamSize1);

			

			PdfPCell roleposition = new PdfPCell(new Paragraph("Role/Position ",f));
			roleposition.setVerticalAlignment(Element.ALIGN_MIDDLE);
			roleposition.setHorizontalAlignment(Element.ALIGN_LEFT);
			roleposition.setPaddingTop(4);
			roleposition.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(roleposition);

			
			PdfPCell roleposition1 = new PdfPCell(new Paragraph(listofexp.get(i).getRoleposition(),f1));
			roleposition1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			roleposition1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			roleposition1.setPaddingTop(4);
			roleposition1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(roleposition1);

			
			PdfPCell projectdescription = new PdfPCell(new Paragraph("Project Description ",f));
			projectdescription.setVerticalAlignment(Element.ALIGN_MIDDLE);
			projectdescription.setHorizontalAlignment(Element.ALIGN_LEFT);
			projectdescription.setPaddingTop(4);
			projectdescription.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(projectdescription);

			
			PdfPCell projectdescriptionans = new PdfPCell(new Paragraph(listofexp.get(i).getProjectdescription(),f1));
			projectdescriptionans.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			projectdescriptionans.setHorizontalAlignment(Element.ALIGN_RIGHT);
			projectdescriptionans.setPaddingTop(4);
			projectdescriptionans.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(projectdescriptionans);

			
			
			PdfPCell TechnicalEnvironment = new PdfPCell(new Paragraph("Technical Environment",f));
			TechnicalEnvironment.setVerticalAlignment(Element.ALIGN_MIDDLE);
			TechnicalEnvironment.setHorizontalAlignment(Element.ALIGN_LEFT);
			TechnicalEnvironment.setPaddingTop(4);
			TechnicalEnvironment.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(TechnicalEnvironment);

			
			PdfPCell TechnicalEnvironment1 = new PdfPCell(new Paragraph(listofexp.get(i).getTechnicalenvironment(),f1));
			TechnicalEnvironment1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			TechnicalEnvironment1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			TechnicalEnvironment1.setPaddingTop(4);
			TechnicalEnvironment1.setPaddingBottom(4);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(TechnicalEnvironment1);


			PdfPCell Responsibilities = new PdfPCell(new Paragraph("Responsibilities",f));
			Responsibilities.setVerticalAlignment(Element.ALIGN_MIDDLE);
			Responsibilities.setHorizontalAlignment(Element.ALIGN_LEFT);
			Responsibilities.setPaddingTop(4);
			Responsibilities.setPaddingBottom(4);
			//carddetails.setBorderColor(BaseColor.WHITE);
			table.addCell(Responsibilities);

			

			List list1 = new List(List.UNORDERED);
			 list1.setListSymbol("•");
			 list1.add(new ListItem(" list 1",f));
			 list1.add(new ListItem(" list 2",f));
			 list1.add(new ListItem(" list 3",f));

			
			PdfPCell Responsibilities1 = new PdfPCell(new Paragraph(listofexp.get(i).getResponsibility(),f1));
			Responsibilities1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			Responsibilities1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			Responsibilities1.setPaddingTop(4);
			Responsibilities1.setPaddingBottom(4);
			////////////////////Responsibilities1.addElement(list1);
			//Designation.setBorderColor(BaseColor.WHITE);
			table.addCell(Responsibilities1);

				
			
	        document.add(table);			
		}
	        
		}
        
        
		
		}

		if(sagar.equals("sagar"))
		{
        Paragraph otherprojectdetails=new Paragraph("Other Project Details:",f);
        otherprojectdetails.setSpacingAfter(5);
        otherprojectdetails.setSpacingBefore(5);
        document.add(otherprojectdetails);
        
		List list1 = new List(List.UNORDERED);
		 list1.setListSymbol("•");
			if(ohterprojectdeatilsService.getSapid(sapid) !=null)
			{
				java.util.List<Ohterprojectdeatils> listofexp=ohterprojectdeatilsService.getSapid(sapid);
				
			for(int i=0;i<listofexp.size();i++)
			{
		 list1.add(new ListItem("  "+listofexp.get(i).getOtherdetails(),f1));
			}
			}

		 document.add(list1);		 
		 
		}	
			 
			
		
        Paragraph otherprojectdetails=new Paragraph("Other Details:  ",f);
        otherprojectdetails.setSpacingAfter(5);
        otherprojectdetails.setSpacingBefore(5);
        document.add(otherprojectdetails);

		
        Paragraph domainexpert = new Paragraph();
        domainexpert.add(new Phrase("Domain Expertise: ",f));
        domainexpert.add(new Chunk(basicinfo.getDomainname(),email));
        document.add(domainexpert);

        //Location Preference: 

        Paragraph locationpreference = new Paragraph();
        locationpreference.add(new Phrase("Location Preference: ",f));
        locationpreference.add(new Chunk(basicinfo.getCurrentworklocation(),email));
        document.add(locationpreference);





		document.close();
		writer.close();

		   return "/CV/"+basicinfo.getSapid()+"/"+basicinfo.getSapid()+"_"+basicinfo.getEmployeename();


	}

}
