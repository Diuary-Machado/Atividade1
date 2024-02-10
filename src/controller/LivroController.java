package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.LivroDAO;
import model.Livro;
import view.LivroView;

public class LivroController {

	private LivroView view = new LivroView();

	public LivroController() {

		MouseListener ouvinte2 = new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {

				if (e.getSource() == view.getTabela()) {

					int linha = view.getTabela().getSelectedRow();

					int idLivros = (int) view.getTabela().getValueAt(linha, 0);
					String Titulo = (String) view.getTabela().getValueAt(linha, 1);
					String Autor = (String) view.getTabela().getValueAt(linha, 2);
					String Ano = (String) view.getTabela().getValueAt(linha, 3);
					String Local = (String) view.getTabela().getValueAt(linha, 4);
					String Editora = (String) view.getTabela().getValueAt(linha, 5);
					view.getcidLivrosA().setText(String.format("%d", idLivros));
					view.getcTituloA().setText(Titulo);
					view.getcAutorA().setText(Autor);
					view.getcAno().setText(Ano);
					view.getcLocalA().setText(Local);
					view.getcEditoraA().setText(Editora);
					view.getbAlterar().setEnabled(true);
					view.getbExcluir().setEnabled(true);

				}

			}

		};

		ActionListener ouvinte = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == view.getbSalvar()) {

					// ================SALVAR===============//
					Livro livro = new Livro();
					livro.setTitulo(view.getcTitulo().getText());
					livro.setAutor(view.getcAutor().getText());
					livro.setAno(view.getcAno().getText());
					livro.setLocal(view.getcLocal().getText());
					livro.setEditora(view.getcEditora().getText());

					LivroDAO dao = new LivroDAO();
					dao.inserir(livro);

					JOptionPane.showMessageDialog(null, "!----SALVO----!");
					List<Livro> listaLivros = dao.consultar();
					view.CarregarTabela(listaLivros, ouvinte2);
					view.limparCampos();

				} else 

					if (e.getSource() == view.getbAlterar()) {

						// =================ALTERAR==================//
						Livro livro = new Livro();
						String id = view.getcidLivrosA().getText();

						if (!id.equals("")) {

							livro.setId(Integer.parseInt(id));
							livro.setTitulo(view.getcTituloA().getText());
							livro.setAutor(view.getcAutorA().getText());
							livro.setAno(view.getcAnoA().getText());
							livro.setLocal(view.getcLocalA().getText());
							livro.setEditora(view.getcEditoraA().getText());

							LivroDAO dao = new LivroDAO();
							dao.alterar(livro);

							JOptionPane.showMessageDialog(null, "!----ALTERADO----!");
							List<Livro> listaLivros = dao.consultar();
							view.CarregarTabela(listaLivros, ouvinte2);
							view.limparCampos();
						}

					} else 

						if (e.getSource() == view.getbExcluir()) {

							// ===============EXCLUIR===========//
							String id = view.getcidLivrosA().getText();

							if (!id.equals("")) {

								LivroDAO dao = new LivroDAO();
								dao.Excluir(Integer.parseInt(id));
								JOptionPane.showMessageDialog(null, "!----DELETADO----!");
								List<Livro> listaLivros = dao.consultar();
								view.CarregarTabela(listaLivros, ouvinte2);
								view.limparCampos();

							}

						}

					}

		};

		view.ConfgComponentes(ouvinte);

		LivroDAO dao = new LivroDAO();
		List<Livro> listaLivros = dao.consultar();
		view.CarregarTabela(listaLivros, ouvinte2);

	}

}
