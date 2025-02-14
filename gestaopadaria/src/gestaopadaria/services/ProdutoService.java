package gestaopadaria.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gestaopadaria.entities.Produto;
import gestaopadaria.enums.Tipo;
import gestaopadaria.interfaces.ProdutoInterface;

public class ProdutoService implements ProdutoInterface {

	@Override
	public void addProduto(Produto produto) {
		// TODO Auto-generated method stub
		String path = "C:\\files\\produto.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

			bw.write(produto.toString());
			bw.write("\n");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Produto> listProduto() {
		String path = "C:\\files\\produto.txt";
		List<Produto> produtos = new ArrayList<Produto>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String[] line = br.readLine().split("[,=]");

			while (line != null) {

				BigDecimal id = new BigDecimal(line[1]);
				String nome = line[3];
				Double valor = Double.parseDouble(line[5]);
				Double quantidade = Double.parseDouble(line[7]);
				Tipo tipo = Tipo.valueOf(line[9]);

				Produto produto1 = new Produto(id, nome, valor, quantidade, tipo);
				produtos.add(produto1);

				try {
					line = br.readLine().split("[,=]");
				} catch (NullPointerException e) {
					// line = null;
					throw new NullPointerException("line is null because file is over");
					// System.out.println(e.getMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return produtos;

	}

	@Override
	public Produto findProduto(String id) {

		// TODO Auto-generated method stub
		BigDecimal cod = new BigDecimal(id);
		List<Produto> produtos = listProduto();

		for (Produto produto : produtos) {
			if (produto.getCod().compareTo(cod) == 0) {
				return produto;
			}
		}

		return null;

	}

}
