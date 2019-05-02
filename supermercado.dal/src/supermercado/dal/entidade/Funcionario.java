package supermercado.dal.entidade;

import javax.persistence.*;

@Entity
//Herdando de pessoa
@Inheritance(strategy= InheritanceType.JOINED)
//Inserindo F no tipo
@DiscriminatorValue(value = "F")
public class Funcionario extends Pessoa{
	private Double salario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
