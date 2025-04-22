package sistemaGYM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroUI extends JFrame {
	private listClientes listClientes;
	private JTextField nomeField, dataNField, telefoneField, cpfField, emailField, enderecoField;
	private JComboBox<String> sexoComboBox;
	private JTextField buscaField;
	private JTextArea areaClientesCadastrados; // Área de texto para exibir alunos cadastrados
	// JCheckBox para selecionar o serviço
	private JCheckBox musculacaoBox;
	private JCheckBox jiuJitsuBox;
	private JCheckBox pilatesBox;
	private JCheckBox fitdanceBox;
	// Caminho da imagem de fundo
	private String caminhoImagemFundo = "/imagens/Alex_and_Jader_Magical_Forest.jpg"; // Atualizeconforme o caminho da sua imagem
	// Construtor que inicializa os componentes da interface gráfica
	
	public CadastroUI() {
	// Inicializa o a classe listClientes que armazena os Clientes
	listClientes = new listClientes();
	// Configurações da janela principal
	setTitle("Sistema de Cadastro de Clientes");
	setSize(1000, 700);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout(10, 10)); // Adiciona espaçamento externo
	
	// Painel superior para o cadastro de novos alunos
	JPanel painelCadastro = new JPanel();
	painelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de Alunos"));
	painelCadastro.setLayout(new GridLayout(5, 3, 5, 5));
	
	// Campo de texto para o nome completo do cliente
	painelCadastro.add(new JLabel("Nome completo:"));
	nomeField = new JTextField();
	painelCadastro.add(nomeField);
	
	// Campo de texto para a data de nascimento
	painelCadastro.add(new JLabel("Data de Nascimento:"));
	dataNField = new JTextField();
	painelCadastro.add(dataNField);
	
	// Campo de texto para o n de telefone
	painelCadastro.add(new JLabel("Telefone (11 dígitos, incluindo DDD):"));
	telefoneField = new JTextField();
	painelCadastro.add(telefoneField);
	
	// Campo de texto para o email
	painelCadastro.add(new JLabel("Email:"));
	emailField = new JTextField();
	painelCadastro.add(emailField);
	
	// Campo de texto para o CPF
	painelCadastro.add(new JLabel("CPF (11 dígitos):"));
	cpfField = new JTextField();
	painelCadastro.add(cpfField);
	
	// Campo de texto para o endereço
	painelCadastro.add(new JLabel("Endereço"));
	enderecoField = new JTextField();
	painelCadastro.add(enderecoField);
	
	// Opções de serviço com JCheckBox
	painelCadastro.add(new JLabel("Serviços desejados:"));
	JPanel painelServico= new JPanel();
	painelServico.setLayout(new FlowLayout());
	musculacaoBox = new JCheckBox("Musculação");
	jiuJitsuBox = new JCheckBox("Jiu-Jitsu");
	pilatesBox = new JCheckBox("Pilates");
	fitdanceBox = new JCheckBox("FitDance");

	
	painelServico.add(musculacaoBox);
	painelServico.add(jiuJitsuBox);
	painelServico.add(pilatesBox);
	painelServico.add(fitdanceBox);
	painelCadastro.add(painelServico);
	
	// Caixa suspensa (JComboBox) para selecionar o sexo
	painelCadastro.add(new JLabel("Sexo:"));
	sexoComboBox = new JComboBox<>(getSexo());
	painelCadastro.add(sexoComboBox);
	// Botão para cadastrar o aluno
	JButton cadastrarButton = new JButton("Cadastrar Cliente");
	cadastrarButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	cadastrarCliente();
	}
	});
	painelCadastro.add(cadastrarButton);
	// Adiciona o painel superior à interface gráfica com borda
	add(painelCadastro, BorderLayout.NORTH);
	// Área de texto para exibir alunos cadastrados com borda
	areaClientesCadastrados = new JTextArea();
	areaClientesCadastrados.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(areaClientesCadastrados);
	scrollPane.setBorder(BorderFactory.createTitledBorder("Clientes Cadastrados"));
	add(scrollPane, BorderLayout.CENTER); // Adiciona a área de texto na parte central
	// Painel inferior para a busca e ações adicionais
	JPanel painelAcoes = new JPanel();
	painelAcoes.setBorder(BorderFactory.createTitledBorder("Ações"));
	painelAcoes.setLayout(new GridLayout(3, 2, 5, 5));
	// Campo para buscar aluno por matrícula ou CPF
	painelAcoes.add(new JLabel("Buscar por Matrícula ou CPF:"));
	buscaField = new JTextField();
	painelAcoes.add(buscaField);
	// Botão para pesquisar o aluno
	JButton pesquisarButton = new JButton("Pesquisar");
	pesquisarButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	localizarCliente(); // Chama o método que pesquisa o aluno por matrícula ou CPF
	}
	});
	painelAcoes.add(pesquisarButton);
	// Botão para listar os alunos cadastrados
	JButton listarButton = new JButton("Listar Clientes Cadastrados");
	listarButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	listarClientes(); // Chama o método para listar os alunos
	}
	});
	painelAcoes.add(listarButton);
	// Botão para sair da aplicação
	
	JButton sairButton = new JButton("Sair");
	sairButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	System.exit(0); // Fecha a aplicação
	}
	});
	painelAcoes.add(sairButton);
	// Adiciona o painel inferior à interface gráfica
	add(painelAcoes, BorderLayout.SOUTH);
	// Adiciona padding ao frame
	((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
	}
	// Método para cadastrar um novo aluno
	private void cadastrarCliente() {
	String nome = nomeField.getText();
	String dataN = dataNField.getText();
	String telefone = telefoneField.getText();
	String cpf = cpfField.getText();
	String email = emailField.getText();
	String endereco = enderecoField.getText();
	String sexo = (String) sexoComboBox.getSelectedItem();
	// Verifica qual opção de sexo foi selecionada
	String servico = getServicoSelecionado();
	if (servico == null) {
	JOptionPane.showMessageDialog(this, "Por favor, selecione uma opção de serviço!", "Erro",
	JOptionPane.ERROR_MESSAGE);
	return;
	}
	try {
	// Cria um novo aluno e o adiciona ao DAO
	Cliente cliente = new Cliente(nome, dataN, telefone, cpf, email, endereco, sexo, servico);
	listClientes.adicionarCliente(cliente);
	// Limpa os campos de texto
	nomeField.setText("");
	cpfField.setText("");
	sexoComboBox.setSelectedIndex(0); // Reseta a seleção do ComboBox
	// Desmarcar todos os checkboxes
	musculacaoBox.setSelected(false);
	pilatesBox.setSelected(false);
	jiuJitsuBox.setSelected(false);
	fitdanceBox.setSelected(false);
	JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
	} catch (IllegalArgumentException e) {
	// Exibe mensagem de erro caso o CPF seja inválido
	JOptionPane.showMessageDialog(this, e.getMessage(), "Erro",
	JOptionPane.ERROR_MESSAGE);
	}
	}
	// Método para obter a opção de sexo selecionada
	private String getServicoSelecionado() {
	if (musculacaoBox.isSelected()) {
	return "Musculação";
	} else if (jiuJitsuBox.isSelected()) {
	return "Jiu-Jitsu";
	} else if (pilatesBox.isSelected()) {
	return "Pilates";
	} else if (fitdanceBox.isSelected()) {
	return "FitDance";
	
	} else {
	return null; // Nenhuma opção selecionada
	}
	}
	// Método para localizar cliente por CPF
	private void localizarCliente() {
	String busca = buscaField.getText();
	Cliente cliente = null;

	// Buscar Cliente por CPF
	if (cliente == null && busca.length() == 11) {
	cliente = buscarClientePorCpf(busca);
	}
	// Exibe o aluno encontrado ou uma mensagem de erro
	if (cliente != null) {
	JOptionPane.showMessageDialog(this, cliente.toString(), "Cliente Encontrado",
	JOptionPane.INFORMATION_MESSAGE);
	} 
	
	else {
	JOptionPane.showMessageDialog(this, "Cliente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);}
	}
	
	// Método para buscar um aluno pelo CPF
	private Cliente buscarClientePorCpf(String cpf) {
	for (Cliente cliente : listClientes.listarClientes()) {
	if (cliente.getCpf().equals(cpf)) {
	return cliente;
	}
	}
	return null;
	}
	// Método para listar todos os alunos cadastrados
	private void listarClientes() {
	areaClientesCadastrados.setText(""); // Limpa a área de texto
	for (Cliente cliente : listClientes.listarClientes()) {
	areaClientesCadastrados.append(cliente.toString() + "\n"); // Adiciona os dados dos alunos
	}
	}
	// Método que retorna a lista de cursos para o ComboBox
	private String[] getSexo() {
	
	return new String[]{
	"Masculino",
	"Feminino",
	"Outro",
	};
	}
	// Classe interna que desenha a imagem de fundo no JPanel (na área central)
	class PainelComImagem extends JPanel {
	private Image imagemFundo;
	// Carregamos a imagem de fundo no construtor
	public PainelComImagem() {
	try {
	// Carrega a imagem como recurso (certifique-se de que a imagem está no caminho correto)
	imagemFundo = new
	ImageIcon(getClass().getResource(caminhoImagemFundo)).getImage();
	} catch (Exception e) {
	// Exibe mensagem de erro caso a imagem não seja carregada
	System.err.println("Erro ao carregar a imagem de fundo: " + e.getMessage());
	imagemFundo = null; // Caso a imagem não seja carregada, não gera erro
	}
	}
	@Override
	protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	if (imagemFundo != null) {
	// Desenha a imagem no painel, cobrindo todo o tamanho da janela
	g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
	}
	}
	}
}