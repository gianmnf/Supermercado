package supermercado.dal.entidade;

import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
  /Não usar a coluna na inserção
	@Column(name="idUsuarioPessoa", insertable = false, updatable = false)
	// Não é auto incremento - não usa generated value
	private Integer idUsuarioPessoa;
	
	private String login;
	
	private String senha;
	
	@OneToOne
	@JoinColumn(name="idUsuarioPessoa", referencedColumnName="idFuncionarioPessoa")
	private Funcionario funcionario;
	

	public Integer getIdPessoaUsuario() {
		return idPessoaUsuario;
	}

	public void setIdPessoaUsuario(Integer idPessoaUsuario) {
		this.idPessoaUsuario = idPessoaUsuario;
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
	
}

