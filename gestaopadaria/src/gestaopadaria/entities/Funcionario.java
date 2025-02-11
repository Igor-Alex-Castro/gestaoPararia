package gestaopadaria.entities;

public class  Funcionario extends Pessoa {
	
	private String funcao;
	private Double cargaHoraria;
	private int escala;
	private Double salario;
	
	
	public Funcionario() {
		
	}
	
	public Funcionario(String name, int idade, String cpf, String funcao, Double cargaHoraria, int escala,
			Double salario) {
		super(name, idade, cpf);
		this.funcao = funcao;
		this.cargaHoraria = cargaHoraria;
		this.escala = escala;
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public Double getCargaHoraria() {
		return cargaHoraria;
	}
	
	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public int getEscala() {
		return escala;
	}
	
	public void setEscala(int escala) {
		this.escala = escala;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		
		return "name=" + getName() +",idade=" + getIdade() + ",cpf=" + getCpf() + ",funcao=" + funcao + ",cargaHoraria=" + cargaHoraria + ",escala=" + escala + ",salario="
				+ salario;
	}


	
	
	
}
