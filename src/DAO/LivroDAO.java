package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Livro;

public class LivroDAO {
	
	private ConexaoBd conexao;

	public LivroDAO() {

		this.conexao = new ConexaoBd();
	}

	public void inserir(Livro livro) {
	    String sql = "INSERT INTO livros(titulo,autor,ano,local,editora) VALUES (?,?,?,?,?)";

	    try {
	        if (this.conexao != null && !this.conexao.getCon().isClosed()) {
	            Connection conexao = this.conexao.getCon();
	            System.out.println("Conexão estabelecida com sucesso.");
	            
	            PreparedStatement sentenca = conexao.prepareStatement(sql);
	            System.out.println("Inserindo os seguintes dados:");
	            System.out.println("Título: " + livro.getTitulo());
	            System.out.println("Autor: " + livro.getAutor());
	            System.out.println("Ano: " + livro.getAno());
	            System.out.println("Local: " + livro.getLocal());
	            System.out.println("Editora: " + livro.getEditora());
	            
	            sentenca.setString(1, livro.getTitulo());
	            sentenca.setString(2, livro.getAutor());
	            sentenca.setString(3, livro.getAno());          
	            sentenca.setString(4, livro.getLocal());
	            sentenca.setString(5, livro.getEditora());

	            sentenca.execute();
	            sentenca.close();
	            conexao.close();
	            
	            System.out.println("Inserção realizada com sucesso.");
	        } else {
	            System.out.println("Conexão não está disponível ou fechada.");
	        }
	    } catch (Exception ex) {
	        System.err.println("Erro ao inserir no banco de dados: " + ex.getMessage());
	        ex.printStackTrace();
	        throw new RuntimeException(ex);
	    }
	}



	public void alterar(Livro livro) {

		String sql = "UPDATE livros SET titulo = ?, autor = ?, ano = ?, local = ?, editora = ? where idLivros = ?";

		try {

			if (this.conexao != null && !this.conexao.getCon().isClosed()) {

				Connection conexao = this.conexao.getCon();
				PreparedStatement sentenca = conexao.prepareStatement(sql);

				sentenca.setString(1, livro.getTitulo());
				sentenca.setString(2, livro.getAutor());
				sentenca.setString(3, livro.getAno());
				sentenca.setString(4, livro.getLocal());
				sentenca.setString(5, livro.getEditora());
				sentenca.setInt(6, livro.getId());

				sentenca.execute();
				sentenca.close();
				conexao.close();
			}

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	public void Excluir(int id) {

		String sql = "DELETE FROM livros WHERE idLivros = ?";

		try {

			if (this.conexao != null && !this.conexao.getCon().isClosed()) {

				Connection conexao = this.conexao.getCon();
				PreparedStatement sentenca = conexao.prepareStatement(sql);

				sentenca.setInt(1, id);

				sentenca.execute();
				sentenca.close();
				conexao.close();
			}

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	public ArrayList<Livro> consultar() {

		ArrayList<Livro> listarLivros = new ArrayList<Livro>();

		String sql = "SELECT a.idlivros,a.titulo,a.autor,a.ano,a.local,a.editora " + "FROM livros AS a "
				+ "ORDER BY a.idlivros";

		try {

			if (this.conexao != null && !this.conexao.getCon().isClosed()) {

				Connection conexao = this.conexao.getCon();
				PreparedStatement sentenca = conexao.prepareStatement(sql);
				ResultSet resultado = sentenca.executeQuery();

				while (resultado.next()) {

					Livro livro = new Livro();

					livro.setId(resultado.getInt("idLivros"));
					livro.setTitulo(resultado.getString("titulo"));
					livro.setAutor(resultado.getString("autor"));
					livro.setAno(resultado.getString("ano"));
					livro.setLocal(resultado.getString("local"));
					livro.setEditora(resultado.getString("editora"));

					listarLivros.add(livro);
				}

				sentenca.close();
				conexao.close();

			}

			return listarLivros;

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

}
