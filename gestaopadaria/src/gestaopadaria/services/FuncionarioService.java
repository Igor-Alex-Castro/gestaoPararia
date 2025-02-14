package gestaopadaria.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		List<Pessoa> listFuncionario = new ArrayList<Pessoa>();
			listFuncionario.addAll(listFunionario());
		String cpfFuncionario = funcionario.toString().split("[,=]")[5];
		
		for (Pessoa func : listFuncionario) {
			if(func.getCpf().equals(cpfFuncionario)) {
				//throw new DomainExecepetions("CPF ja esta cadastrado");
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public List<Pessoa> listFunionario() {
		String path = "C:\\files\\out.txt";
		List<Pessoa> listFuncionarios = new ArrayList<Pessoa>();
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
	
	
	@Override
	public Pessoa deleteFuncionario(Pessoa funcionario) throws DomainExecepetions {
		// TODO Auto-generated method stub
		List<Pessoa> list =  listFunionario();
		
		for (Pessoa func : list) {
			if(func.getCpf().equals(funcionario.getCpf())) {
				list.remove(func);
				System.out.println(func.getName() +  " " +  func.getCpf() + " - foi removido" );
				addVariosFuncionarios(list);
				return func;
			}
		}
		
		throw new DomainExecepetions("Nenhum funcionario foi encontrado para este cpf " + funcionario.getCpf());
		
	}
	
	
	
	public void addVariosFuncionarios(List<Pessoa> funcionarios) {
		List<Pessoa> list = funcionarios;
		
		String path = "C:\\files\\out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (Pessoa funcionario2 : list) {
				
				bw.write(funcionario2.toString());	
				bw.write("\n");
			}
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
}
