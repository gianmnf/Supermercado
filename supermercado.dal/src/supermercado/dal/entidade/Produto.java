package supermercado.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.*;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	
	@NotNull(message="Informe o nome")
	private String nome;
	
	@NotNull(message="Informe o preço")
	private Double preco;
	
	@NotNull(message="Informe a quantidade em estoque")
	private Integer qtdeEstoque;
	
	@NotNull(message="Informe o peso")
	private Double peso;
	
	@ManyToOne
	@JoinColumn(name="idLinha")
	@NotNull(message="Informe a linha")
	private Linha linha;
	
	@ManyToOne
	@JoinColumn(name="idFornecedor")
	@NotNull(message="Informe o fornecedor")
	private Fornecedor fornecedor;
	
	@ManyToMany
	@JoinTable(name="idCategoria",
		joinColumns= @JoinColumn(name="idProduto"),
		inverseJoinColumns = @JoinColumn(name="idCategoria"))
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "produto")
	private List<VendaProduto> vendaprodutos;
	
	
	public List<VendaProduto> getVendaprodutos() {
		return vendaprodutos;
	}

	public void setVendaprodutos(List<VendaProduto> vendaprodutos) {
		this.vendaprodutos = vendaprodutos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}
	
	
}
