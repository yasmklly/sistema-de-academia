package sistemaGYM;

public class Cliente {

	private String nome;
	private String dataN;
	private String telefone;
	private String cpf; 
	private String email;
	private String endereco;
	private String sexo;
	private String servico;
	
	// Construtor padrão
	public Cliente(String nome, String dataN, String telefone, String cpf, String email, String endereco, String sexo, String servico) throws IllegalArgumentException {
	this.nome = nome;
	this.dataN = dataN;
	setTelefone(telefone);
	setCpf(cpf); // Valida e define o CPF
	this.email = email;
	this.endereco = endereco;
	this.sexo = sexo;
	this.servico = servico;
	
	}
	
	// Validação do CPF: deve ter exatamente 11 caracteres
	public void setCpf(String cpf) throws IllegalArgumentException {
	if (cpf.length() != 11 || !cpf.matches("\\d+")) {
	throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos.");
	}
	
	this.cpf = cpf;
	}
	
	public void setTelefone(String telefone) throws IllegalArgumentException {
	if (telefone.length() != 11 || !telefone.matches("\\d+")) {
	throw new IllegalArgumentException("O telefone deve conter exatamente 11 dígitos numéricos (incluindo o DDD regional).");
	}
	
	this.telefone = telefone;
	}
	
	public String getNome() {
	return nome;
	}
	
	public String getDataN() {
	return dataN;
	}
	
	public String getTelefone() {
	return telefone;
	}
	
	public String getCpf() {
	return cpf;
	}
	
	public String getEmail() {
	return email;
	}
	
	public String getEndereco() {
	return endereco;
	}
}
