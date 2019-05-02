package supermercado.dal.entidade;

import javax.persistence.*;

@Entity
//Herdando de pessoa
@Inheritance(strategy= InheritanceType.JOINED)
//Inserindo tipo de pessoa - F - funcionário
@DiscriminatorValue(value = "F")
//PFK
@PrimaryKeyJoinColumn(name="idFuncionarioPessoa", referencedColumnName="idPessoa")
public class Funcionario extends Pessoa{
	private Double salario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
