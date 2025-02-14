package gestaopadaria.entities;

import java.math.BigDecimal;

import gestaopadaria.enums.Tipo;

public class Produto {
	
	private BigDecimal cod;
	private String nome;
	private Double valorPorItem;
	private Double quantidade;
	private Tipo tipo;
	
	public Produto() {
		
	}
	
	public Produto(BigDecimal cod, String nome, double valorPorItem, double quantidade, Tipo tipo ) {
		
		this.cod = cod;
		this.nome = nome;
		this.valorPorItem = valorPorItem;
		this.quantidade = quantidade;
		this.tipo = tipo;
	}
	
	

	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValorPorItem() {
		return valorPorItem;
	}

	public void setValorPorItem(Double valorPorItem) {
		this.valorPorItem = valorPorItem;
	}

	

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "id=" + cod + ",nome=" + nome + ",valor=" + valorPorItem + ",quantidade=" + quantidade +
				",tipo=" + tipo;
	}
	
	
	
}
