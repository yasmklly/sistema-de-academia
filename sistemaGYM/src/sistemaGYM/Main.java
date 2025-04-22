package sistemaGYM;

/**
* Classe Principal para iniciar a aplicação.
/**
* Classe Principal para iniciar a aplicação com a tela de login.
*/
public class Main {
	public static void main(String[] args) {
	// Executa a interface gráfica na thread principal
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	@Override
	public void run() {
	// Inicializa a tela de login
	
    LoginUI loginUI = new LoginUI();
	loginUI.setVisible(true);
	}
	});
	}
}