package supermercado.dal.entidade;

import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
   //N�o usar a coluna na inser��o
	@Column(name="idUsuarioPessoa", insertable = false, updatable = false)
	// N�o � auto incremento - n�o usa generated value
	private Integer idUsuarioPessoa;
	
	private String login;
	
	private String senha;
	
	@OneToOne
	@JoinColumn(name="idUsuarioPessoa", referencedColumnName="idFuncionarioPessoa")
	private Funcionario funcionario;

	public Integer getIdUsuarioPessoa() {
		return idUsuarioPessoa;
	}

	public void setIdUsuarioPessoa(Integer idUsuarioPessoa) {
		this.idUsuarioPessoa = idUsuarioPessoa;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}

