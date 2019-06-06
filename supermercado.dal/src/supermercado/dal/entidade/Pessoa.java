package supermercado.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
//Coluna para identificar tipo de pessoa
@DiscriminatorColumn(name="tipo", discriminatorType = DiscriminatorType.CHAR)
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	
	private String nome;
	
	private Long cpf;
	
	@Transient
	@NotNull(message = "Informe o CPF")
	private String cpfMascara;
	
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@OneToMany(mappedBy="pessoa")
	private List<Venda> vendas;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public String getCpfMascara() {
		if(cpfMascara == null && cpf != null) {
			cpfMascara = cpf.toString();
			while(cpfMascara.length() != 11) {
				cpfMascara = "0" + cpfMascara;
			}
			
			cpfMascara = cpfMascara.substring(0,3)
					+ "."
					+ cpfMascara.substring(3, 6)
					+ "."
					+ cpfMascara.substring(6, 9)
					+ "-"
					+ cpfMascara.substring(9, 11);
			}
		
			return cpfMascara;
		}

	public void setCpfMascara(String cpfMascara) {
		this.cpfMascara = cpfMascara;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}
	
	
}
