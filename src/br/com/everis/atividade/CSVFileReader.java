package br.com.everis.atividade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Pedro Augusto
 *
 */
public class CSVFileReader {

	/**
	 * Classe para Varrer arquivo passado por parametro, no qual monta objetos da
	 * Classe Book e o colocar em um HashSet e imprime o Set com Iterator
	 *
	 */
	public void read(String fileName) {
		String linha = "";
		String[] atributos = null;
		BufferedReader ler;
		Set<Book> books = new HashSet<Book>();

		try {
			ler = new BufferedReader(new FileReader(fileName));

			while ((linha = ler.readLine()) != null) {
				// System.out.println(linha);
				// System.out.println(linha.length());
				try {
					atributos = linha.split(",");
					books.add(new Book(atributos[atributos.length - atributos.length], atributos[atributos.length - 3],
							atributos[atributos.length - 2], Integer.parseInt(atributos[atributos.length - 1])));
				} catch (Exception e) {
					System.out.println("Texto do Arquivo insuficiente para montar objetos book");
				}

				// System.out.println(linha);

			}
			// System.out.println(books);

			Iterator<Book> itr = books.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + "\n");
			}

			ler.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo: " + fileName + " n�o encontrado. ");
		} catch (IOException e) {
			System.out.println("Encontramos o erro: " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Erro encontrado: " + e.getStackTrace());
		}

	}

	public static void main(String[] args) {
		CSVFileReader c = new CSVFileReader();

		c.read("livraria.txt");
	}

}