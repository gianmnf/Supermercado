package supermercado.dal.entidade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Linha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idLinha;
	
	private String descricao;
	
	@OneToMany(mappedBy = "linha")
	private List<Produto> produtos;

	public Short getIdLinha() {
		return idLinha;
	}

	public void setIdLinha(Short idLinha) {
		this.idLinha = idLinha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLinha == null) ? 0 : idLinha.hashCode());
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
		Linha other = (Linha) obj;
		if (idLinha == null) {
			if (other.idLinha != null)
				return false;
		} else if (!idLinha.equals(other.idLinha))
			return false;
		return true;
	}

		
	
}
