package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Livro;



public class LivroView extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

	private JTable tabela;
	private JScrollPane painel;
	private JPanel pSalvar = new JPanel();
	private JPanel pAltExc = new JPanel();

	
	private JLabel Titulo = new JLabel("Titulo: ");
	private JTextField cTitulo = new JTextField(22);
	private JLabel Autor = new JLabel("Autor: ");
	private JTextField cAutor = new JTextField(22);
	private JLabel Ano = new JLabel("Ano: ");
	private JTextField cAno = new JTextField(22);
	private JLabel Local = new JLabel("Local: ");
	private JTextField cLocal = new JTextField(22);
	private JLabel Editora = new JLabel("Editora: ");
	private JTextField cEditora = new JTextField(20);
	private JButton bSalvar = new JButton("Salvar");


	private JLabel aidLivros = new JLabel("Id Livro: ");
	private JTextField cidLivrosA = new JTextField(20);
	private JLabel aTitulo = new JLabel("Título: ");
	private JTextField cTituloA = new JTextField(20);
	private JLabel aAutor = new JLabel("Autor: ");
	private JTextField cAutorA = new JTextField(20);
	private JLabel aAno = new JLabel("Ano: ");
	private JTextField cAnoA = new JTextField(20);
	private JLabel aLocal = new JLabel("Local: ");
	private JTextField cLocalA = new JTextField(20);
	private JLabel aEditora = new JLabel("Editora: ");
	private JTextField cEditoraA = new JTextField(20);
	private JButton bAlterar = new JButton("Alterar");
	private JButton bExcluir = new JButton("Excluir");

	public LivroView() {

		this.setSize(730, 550);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void ConfgComponentes(ActionListener ouvinte) {

		pSalvar.add(Titulo);
		pSalvar.add(cTitulo);
		pSalvar.add(Autor);
		pSalvar.add(cAutor);
		pSalvar.add(Ano);
		pSalvar.add(cAno);
		pSalvar.add(Local);
		pSalvar.add(cLocal);
		pSalvar.add(Editora);
		pSalvar.add(cEditora);
		bSalvar.addActionListener(ouvinte);
		pSalvar.add(bSalvar);
		pSalvar.setPreferredSize(new Dimension(300, 245));
		this.add(pSalvar);

		
		pAltExc.add(aidLivros);
		pAltExc.add(cidLivrosA);
		pAltExc.add(aTitulo);
		pAltExc.add(cTituloA);
		pAltExc.add(aAutor);
		pAltExc.add(cAutorA);
		pAltExc.add(aAno);
		pAltExc.add(cAnoA);
		pAltExc.add(aLocal);
		pAltExc.add(cLocalA);
		pAltExc.add(aEditora);
		pAltExc.add(cEditoraA);
		bAlterar.addActionListener(ouvinte);
		bExcluir.addActionListener(ouvinte);
		pAltExc.add(bAlterar);
		pAltExc.add(bExcluir);
		pAltExc.setPreferredSize(new Dimension(300, 235));
		this.add(pAltExc);

		this.limparCampos();
	}

	public void CarregarTabela(List<Livro> listaLivros, MouseListener ouvinte2) {

		if (painel != null)

			this.remove(painel);
		String[] nomeColunas = new String[] {

				"idLivros", "Titulo", "Autor", "Ano", "Local", "Editora" };

		Object[][] dados = new Object[listaLivros.size()][6];
		for (int i = 0; i < listaLivros.size(); i++) {

			dados[i][0] = listaLivros.get(i).getId();
			dados[i][1] = listaLivros.get(i).getTitulo();
			dados[i][2] = listaLivros.get(i).getAutor();
			dados[i][3] = listaLivros.get(i).getAno();
			dados[i][4] = listaLivros.get(i).getLocal();
			dados[i][5] = listaLivros.get(i).getEditora();
		}

		tabela = new JTable(dados, nomeColunas);
		painel = new JScrollPane(tabela);
		painel.setPreferredSize(new Dimension(400, 215));
		this.tabela.addMouseListener(ouvinte2);
		this.add(painel);
		this.revalidate();

	}

	public void limparCampos() {

		this.cidLivrosA.setText("");
		this.cTituloA.setText("");
		this.cAutorA.setText("");
		this.cAnoA.setText("");
		this.cLocalA.setText("");
		this.cEditoraA.setText("");
		this.bAlterar.setEnabled(false);
		this.bExcluir.setEnabled(false);
	}

	public JTextField getcTitulo() {

		return cTitulo;

	}

	public void setcTitulo(JTextField cAutor) {

		this.cAutor = cAutor;

	}

	public JTextField getcAutor() {

		return cAutor;

	}

	public void setcAutor(JTextField cAutor) {

		this.cAutor = cAutor;

	}

	public JTextField getcAno() {

		return cAno;

	}

	public void setcAno(JTextField cAno) {

		this.cAno = cAno;

	}

	public JTextField getcLocal() {

		return cLocal;

	}

	public void setcLocal(JTextField cLocal) {

		this.cLocal = cLocal;

	}

	public JTextField getcEditora() {

		return cEditora;

	}

	public void setcEditora(JTextField cEditora) {

		this.cEditoraA = cEditora;

	}

	public JButton getbSalvar() {

		return bSalvar;

	}

	public void setbSalvar(JButton bSalvar) {

		this.bSalvar = bSalvar;

	}

	public JButton getbAlterar() {

		return bAlterar;
	}

	public void setbAlterar(JButton bAlterar) {

		this.bAlterar = bAlterar;

	}

	public JButton getbExcluir() {

		return bExcluir;
	}

	public void setbExcluir(JButton bExcluir) {

		this.bExcluir = bExcluir;

	}

	public JTable getTabela() {

		return tabela;

	}

	public void setTabela(JTable Tabela) {

		this.tabela = Tabela;

	}

	public JTextField getcidLivrosA() {

		return cidLivrosA;

	}

	public void setcidLivrosA(JTextField cidLivrosA) {

		this.cidLivrosA = cidLivrosA;

	}

	public JTextField getcTituloA() {

		return cTituloA;

	}

	public void setcTituloA(JTextField cTituloA) {

		this.cTituloA = cTituloA;

	}

	public JTextField getcAutorA() {

		return cAutorA;

	}

	public void setcAutorA(JTextField cAutorA) {

		this.cAutorA = cAutorA;

	}

	public JTextField getcAnoA() {

		return cAnoA;

	}

	public void setcAnoA(JTextField cAnoA) {

		this.cAnoA = cAnoA;

	}

	public JTextField getcLocalA() {

		return cLocalA;

	}

	public void setcLocalA(JTextField cLocalA) {

		this.cLocalA = cLocalA;

	}

	public JTextField getcEditoraA() {

		return cEditoraA;

	}

	public void setcEditoraA(JTextField cEditoraA) {

		this.cEditoraA = cEditoraA;

	}
}