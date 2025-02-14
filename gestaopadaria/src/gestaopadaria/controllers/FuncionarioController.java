
package gestaopadaria.controllers;

import java.util.List;

import excepetions.DomainExecepetions;
import gestaopadaria.entities.Funcionario;
import gestaopadaria.entities.Pessoa;
import gestaopadaria.services.FuncionarioService;

public class FuncionarioController {
	
	FuncionarioService funcionarioService =  new FuncionarioService();
	
	public void addFuncionario(Pessoa funcionario) throws DomainExecepetions {
		
		funcionarioService.addFunionario(funcionario);
	}
	
	public List<Pessoa> listFuncionario(){
		return funcionarioService.listFunionario();
	}
	
	public Pessoa deleteFuncionario(Pessoa funcionario) throws DomainExecepetions {
		return funcionarioService.deleteFuncionario(funcionario);
	}
	
}
