package com.hclcv.generated.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Generated(
	value = {
	"https://github.com/coolcooldee/sloth",
	"Sloth version:1.0"
	},
	comments = "This class is generated by Sloth"
)


@Entity
@Table(name="Ohterprojectdeatils")
public class Ohterprojectdeatils {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String otherdetails;
	private String otherdetails2;
	private String otherdetails3;
	private String otherdetails4;
	private String otherdetails5;
	private String sapid;
	private Integer employeeid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	} 
	public String getOtherdetails() {
		return otherdetails;
	}

	public void setOtherdetails(String otherdetails) {
		this.otherdetails = otherdetails;
	} 
	public String getOtherdetails2() {
		return otherdetails2;
	}

	public void setOtherdetails2(String otherdetails2) {
		this.otherdetails2 = otherdetails2;
	} 
	public String getOtherdetails3() {
		return otherdetails3;
	}

	public void setOtherdetails3(String otherdetails3) {
		this.otherdetails3 = otherdetails3;
	} 
	public String getOtherdetails4() {
		return otherdetails4;
	}

	public void setOtherdetails4(String otherdetails4) {
		this.otherdetails4 = otherdetails4;
	} 
	public String getOtherdetails5() {
		return otherdetails5;
	}

	public void setOtherdetails5(String otherdetails5) {
		this.otherdetails5 = otherdetails5;
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