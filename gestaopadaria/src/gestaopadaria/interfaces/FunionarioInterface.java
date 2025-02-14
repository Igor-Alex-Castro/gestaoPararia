package gestaopadaria.interfaces;

import java.util.List;

import excepetions.DomainExecepetions;
import gestaopadaria.entities.Funcionario;
import gestaopadaria.entities.Pessoa;

public interface FunionarioInterface  {

	public void addFunionario(Pessoa funcionario) throws DomainExecepetions ;
	public List<Pessoa> listFunionario();
	public  boolean existFuncionario(Pessoa funcionario) throws DomainExecepetions;
	public Pessoa deleteFuncionario(Pessoa funcionario)  throws DomainExecepetions;

}
