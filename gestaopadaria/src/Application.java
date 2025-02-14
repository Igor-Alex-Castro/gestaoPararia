import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import excepetions.DomainExecepetions;
import gestaopadaria.controllers.FuncionarioController;
import gestaopadaria.controllers.ProdutoController;
import gestaopadaria.entities.CaixaVenda;
import gestaopadaria.entities.Funcionario;
import gestaopadaria.entities.Pessoa;
import gestaopadaria.entities.Produto;
import gestaopadaria.entities.ProdutoTotal;
import gestaopadaria.enums.ModoPagamento;
import gestaopadaria.enums.Tipo;

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
		
//		Pessoa funcionario = 
//				new Funcionario("Alex",
//						23, 
//						"48826144447", 
//						"caixa", 
//						40.00, 
//						3, 
//						1800.00);
//		
//		FuncionarioController funcionarioController = new FuncionarioController();
//		try {
//			//funcionarioController.addFuncionario(funcionario);
//			funcionarioController.atualizarFuncionario(funcionario);
//		} catch (DomainExecepetions e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
		//funcionarioController.listFuncionario();
		
		//Produto produto = new Produto(new BigDecimal(1), "pao de sal", 0.50, 100.0, Tipo.UNIDADE);
		//ProdutoController produtoController =  new ProdutoController();
		
		//produtoController.addProdutos(produto);
		
		
		Boolean coninue = true;
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		ProdutoController produtoController = new ProdutoController();
		
		
		
		String opt;
		do {
			
			
			System.out.println("[1] FUNCIONARIO ");
			System.out.println("[2] PRODUTO ");
			System.out.println("[3] VENDA");
			String menu = scanner.nextLine();
		
			CaixaVenda caixaVenda = new CaixaVenda();			
			if(menu.equals("3")) {
				System.out.println("--- INICIO VENDA ---");
				Boolean isitem = true;
				
				int cont = 1;
				
				
				do{
					 scanner.nextLine();
					System.out.print("Digite o id do produto " + cont  + "°: ");
					String id = scanner.nextLine();
					
					
					 Produto produto = produtoController.findProduto(id);
					
					
					System.out.println("id - " + id + " / " + produto.getNome());
					System.out.println();
					
					int quantidade = 0;
					if(produto.getTipo() == Tipo.UNIDADE) {
						System.out.print("Quantidade:  ");
						 quantidade = scanner.nextInt();
						 System.out.println();
					}
					
					Double valorItem = quantidade*produto.getValorPorItem();
					
					ProdutoTotal produtoTotal = new ProdutoTotal(new BigDecimal(id), produto.getNome(),
							produto.getValorPorItem(), quantidade, produto.getTipo(), valorItem);
				
					caixaVenda.addItemVenda(produtoTotal);
					System.out.println("-----LISTA DE PRODUTOS----");
					System.out.println();
					for (ProdutoTotal prod : caixaVenda.getItensVenda()) {
						
						
						
						System.out.println(prod.getCod() + " -- " + prod.getNome() + " -- " + prod.getQuantidade() + " -- " + prod.getTotalItem());
					}
					System.out.println();
					scanner.nextLine();
					System.out.println("Deseja inserir mais produtos [S/N]:");
					opt = scanner.nextLine();
					

					if(opt.equalsIgnoreCase("s")){
						coninue =  true;
					}else {
						coninue = false;
					}
					
				}while(coninue);
				
				//System.out.println("Digite o codigo do produto");
			}
			
			System.out.println("Deseja continuar [S/N]: ");
			 opt = scanner.nextLine();
			
			if(opt.equalsIgnoreCase("s")){
				coninue =  false;
			}else {
				coninue = true;
			}
			
		} while (coninue);
		
	}
}
