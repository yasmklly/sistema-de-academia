package sistemaGYM;

import java.util.ArrayList;
import java.util.List;
/**
* Classe AlunoDAO responsável por armazenar e gerenciar a lista de alunos cadastrados.
*/
public class listClientes {
// Lista para armazenar os alunos cadastrados
private List<Cliente> clientes;
// Construtor que inicializa a lista de alunos
public listClientes() {
clientes = new ArrayList<>();
}
// Método para adicionar um novo aluno à lista
public void adicionarCliente(Cliente cliente) {
clientes.add(cliente);
}
// Método para retornar a lista de alunos cadastrados
public List<Cliente> listarClientes() {
return clientes;
}
}