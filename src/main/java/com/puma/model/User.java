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
    private String telefone1;
    
    @NotEmpty
    @Digits(fraction = 0, integer = 11)
    private String telefone2;

    @Digits(fraction = 0, integer = 11)
    private String telefone3;

    @NotEmpty
    @Email
    private String email;
    
//    @NotEmpty
//    private String escolaridade;
    
    @NotEmpty
    private String profissao;
    
    
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
*/
	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
