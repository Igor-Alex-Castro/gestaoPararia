import java.util.Locale;
import java.util.Scanner;

import excepetions.DomainExecepetions;
import gestaopadaria.controllers.FuncionarioController;
import gestaopadaria.entities.Funcionario;
import gestaopadaria.entities.Pessoa;

public class Application {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// name;
		// idade;
		// cpf;
		 //funcao;
		//cargaHoraria;
		//escala;
		//salario;
		
		Pessoa funcionario = 
				new Funcionario("Alex",
						18, 
						"48826144444", 
						"caixa", 
						40.00, 
						3, 
						1800.00);
		
		FuncionarioController funcionarioController = new FuncionarioController();
		try {
			//funcionarioController.addFuncionario(funcionario);
			funcionarioController.deleteFuncionario(funcionario);
		} catch (DomainExecepetions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		//funcionarioController.listFuncionario();
	}
}
