package gestaopadaria.entities;

public abstract class Pessoa {
	
	private String name;
	private int idade;
	private String cpf;
	
	public Pessoa() {
		
	}
	
	
	
	public Pessoa(String name, int idade, String cpf) { 
		this.name = name;
		this.idade = idade;
		this.cpf = cpf;
	}



	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public String toString() {
		return "name=" + name + ",idade=" + idade + ",cpf=" + cpf ;
	}
	
	
	
}
