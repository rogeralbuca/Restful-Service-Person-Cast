package br.com.castgroup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
 
@Table(name="tb_person")
@Entity
public class PersonModel implements Serializable {
    
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_person")
	private int id;
 
	@NotEmpty(message="Name can not be empty")
	@Column(name="ds_name")
	private String name;
	
	@NotEmpty(message="Address can not be empty")
	@Column(name="ds_address")
	private String address;
	
	@NotEmpty(message="Cellphone can not be empty")
	@Column(name="ds_cellphone")
	private String cellphone;
	
	@NotEmpty(message="Email can not be empty")
	@Email(message="Enter a valid email address")
	@Column(name="ds_email")
	private String email;
 	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public PersonModel() {
		super();
	}

	public PersonModel(String name, String address, String cellphone, String email) {
		super();
		this.name = name;
		this.address = address;
		this.cellphone = cellphone;
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
