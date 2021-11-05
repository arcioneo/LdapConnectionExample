package com.example.demoLdap.beans;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(objectClasses = {"inetOrgPerson", "top", "person", "organizationalPerson"}, base = "ou=Users")
public class User {

	@Id
	private Name dn;
	
	@Attribute(name = "givenName")
	private String givenName;
	
	@Attribute(name = "employeeNumber")
	private Integer employeeNumber;
	
	@Attribute(name = "mail")
	private String mail;
	
	@Attribute(name = "cn")
	private String cn;
	
	@Attribute(name = "sn")
	private String sn;
	
	@Attribute(name = "ou")
	private String ou;
	

	public String getGivenName() {
		return givenName;
	}



	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}



	public Integer getEmployeeNumber() {
		return employeeNumber;
	}



	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getCn() {
		return cn;
	}



	public void setCn(String cn) {
		this.cn = cn;
	}



	public String getSn() {
		return sn;
	}



	public void setSn(String sn) {
		this.sn = sn;
	}



	public String getOu() {
		return ou;
	}



	public void setOu(String ou) {
		this.ou = ou;
	}
	

	public String getDn() {
		return dn.toString();
	}



	public void setDn(Name dn) {
		this.dn = dn;
	}



	@Override
	public String toString() {
		return "User [dn=" + String.valueOf(dn) + ", givenName=" + givenName + ", employeeNumber=" + employeeNumber + ", mail=" + mail
				+ ", cn=" + cn + ", sn=" + sn + ", ou=" + ou + "]";
	}

	
}
