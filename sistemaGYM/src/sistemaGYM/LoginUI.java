package sistemaGYM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Classe LoginUI que representa a interface gráfica para a tela de login.*/

public class LoginUI extends JFrame {
	private JTextField loginField;
	private JPasswordField senhaField;
	// Construtor que inicializa os componentes da interface gráfica
	public LoginUI() {
	// Configurações da janela principal
	setTitle("Tela de Login");
	setSize(300, 150);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new GridLayout(3, 2, 5, 5));
	// Campo de texto para o login
	add(new JLabel("Painel de Login:"));
	loginField = new JTextField();
	add(loginField);
	// Campo de senha para a senha
	add(new JLabel("Senha:"));
	senhaField = new JPasswordField();
	add(senhaField);
	// Botão para entrar
	JButton entrarButton = new JButton("Entrar");
	entrarButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	verificarCredenciais();
	}
	});
	add(entrarButton);
	// Botão para sair
	JButton sairButton = new JButton("Sair");
	sairButton.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	System.exit(0); // Fecha a aplicação
	}
	});
	add(sairButton);
	}
	// Método para verificar as credenciais de login e senha
	private void verificarCredenciais() {
	String login = loginField.getText();
	String senha = new String(senhaField.getPassword());
	// Verifica se o login e a senha estão corretos
	if (login.equals("Gym") && senha.equals("1")) {
	// Credenciais corretas, abre a tela de cadastro de alunos
	
	JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
	abrirTelaCadastro();
	} else {
	// Credenciais incorretas, exibe mensagem de erro
	JOptionPane.showMessageDialog(this, "Login ou senha incorretos!", "Erro",
	JOptionPane.ERROR_MESSAGE);
	}
	}
	// Método para abrir a tela de cadastro de alunos
	private void abrirTelaCadastro() {
	CadastroUI cadastroAtendentUI = new CadastroUI();
	cadastroAtendentUI.setVisible(true);
	dispose(); // Fecha a tela de login
	}
}