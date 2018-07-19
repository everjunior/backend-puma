package com.puma.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
@Table (name = "app_user")
public class User extends AbstractEntity{
        
	@NotEmpty
    private String name;

	@NotEmpty
	@Digits(fraction = 0, integer = 11)
	private String cpf;
    
	@NotEmpty
    @Digits(fraction = 0, integer = 11)
    private String phone1;
    
    @Digits(fraction = 0, integer = 11)
    private String phone2;

    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String degree;
    
    @NotEmpty
    private String profession;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getphone1() {
		return phone1;
	}

	public void setphone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getphone2() {
		return phone2;
	}

	public void setphone2(String phone2) {
		this.phone2 = phone2;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public String getdegree() {
		return degree;
	}

	public void setdegree(String degree) {
		this.degree = degree;
	}

	public String getProfissao() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
}
