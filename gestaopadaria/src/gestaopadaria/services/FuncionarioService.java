package gestaopadaria.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import excepetions.DomainExecepetions;
import gestaopadaria.entities.Funcionario;
import gestaopadaria.entities.Pessoa;
import gestaopadaria.interfaces.FunionarioInterface;

public class FuncionarioService  implements FunionarioInterface {
	
	
	@Override
	public void addFunionario(Pessoa funcionario) throws DomainExecepetions {
	
		String path = "C:\\files\\out.txt";
	
		if(existFuncionario(funcionario)) {
			throw new DomainExecepetions("Cpf ja esta cadastrado no sistema");
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
				
				bw.write(funcionario.toString());	
				bw.write("\n");
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			};
		
		
		
		
	}
	
	@Override
	public boolean existFuncionario(Pessoa funcionario) throws DomainExecepetions {
		List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
			listFuncionario.addAll(listFunionario());
		String cpfFuncionario = funcionario.toString().split("[,=]")[5];
		
		for (Funcionario func : listFuncionario) {
			if(func.getCpf().equals(cpfFuncionario)) {
				//throw new DomainExecepetions("CPF ja esta cadastrado");
				return true;
			}
		}
		
		return false;
	}
	@Override
	public List<Funcionario> listFunionario() {
		String path = "C:\\files\\out.txt";
		List<Funcionario> listFuncionarios = new ArrayList<Funcionario>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String[] line = br.readLine().split("[,=]");
			
			while(line != null) {
				
				String name = line[1];
				int idade = Integer.parseInt(line[3]);
				String cpf = line[5];
				String funcao = line[7];
				Double cargarHoraria = Double.parseDouble(line[9]);
				int escala = Integer.parseInt(line[11]);
				Double salario = Double.parseDouble(line[13]);
				
				Funcionario funcionario = 
						new Funcionario(name, idade, cpf, funcao, cargarHoraria, escala, salario);
				
				listFuncionarios.add(funcionario);
		
				try {
						line = br.readLine().split("[,=]");
				}catch (NullPointerException e) {
						//line = null;
						throw new NullPointerException("line is null because file is over");
						//System.out.println(e.getMessage());
				}
					
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listFuncionarios;
	}
	

	
	
	
}
