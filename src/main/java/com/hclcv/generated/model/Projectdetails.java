package com.hclcv.generated.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Projectdetails")
public class Projectdetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String projectdetailsinfo;
	private String duration2;
	private String teamsize;
	private String roleposition;
	private String projectdescription;
	private String technicalenvironment;
	private String responsibility;
	private String sapid;
	private Integer employeeid;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public String getProjectdetailsinfo() {
		return projectdetailsinfo;
	}
	public void setProjectdetailsinfo(String projectdetailsinfo) {
		this.projectdetailsinfo = projectdetailsinfo;
	}
	public String getDuration2() {
		return duration2;
	}
	public void setDuration2(String duration2) {
		this.duration2 = duration2;
	}
	public String getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(String teamsize) {
		this.teamsize = teamsize;
	}
	public String getRoleposition() {
		return roleposition;
	}
	public void setRoleposition(String roleposition) {
		this.roleposition = roleposition;
	}
	public String getProjectdescription() {
		return projectdescription;
	}
	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}
	public String getTechnicalenvironment() {
		return technicalenvironment;
	}
	public void setTechnicalenvironment(String technicalenvironment) {
		this.technicalenvironment = technicalenvironment;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getSapid() {
		return sapid;
	}
	public void setSapid(String sapid) {
		this.sapid = sapid;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	
	

}
