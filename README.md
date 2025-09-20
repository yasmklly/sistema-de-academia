# 🏋️‍♂️ Sistema de Academia - Cadastro de Alunos  

Este projeto é um **sistema de cadastro de clientes para academias**, desenvolvido em **Java com Swing**, voltado para o uso do **atendente**.  
O objetivo é registrar os alunos, gerenciar suas informações pessoais e os serviços contratados (como musculação, jiu-jitsu, pilates e fitdance).  

---

## 📌 Funcionalidades  

✔️ Cadastro de novos alunos com os seguintes dados:  
- Nome completo  
- Data de nascimento  
- Telefone  
- CPF  
- Email  
- Endereço  
- Sexo  
- Serviços contratados (Musculação, Jiu-Jitsu, Pilates, FitDance)  

✔️ Listagem de todos os alunos cadastrados.  
✔️ Busca de aluno pelo **CPF**.  
✔️ Exibição de dados do aluno encontrado.  
✔️ Interface gráfica amigável utilizando **Java Swing**.  
✔️ Possibilidade de sair do sistema diretamente pela interface.  

---

## 📂 Estrutura do Projeto  

``bash
sistemaGYM/
├── CadastroUI.java       # Classe principal da interface gráfica
├── Cliente.java          # Classe que representa o aluno/cliente
├── listClientes.java     # Classe responsável por armazenar e gerenciar a lista de clientes
└── imagens/              # Pasta com imagens de fundo (ex: Alex_and_Jader_Magical_Forest.jpg)

---

## 🛠️ Tecnologias Utilizadas  

- **Java 11+**  
- **Swing** (para interface gráfica)  

---

## 🚀 Como Executar o Projeto  

1. Certifique-se de ter o **Java JDK** instalado (versão 11 ou superior).  
   - Para verificar:  
     ```bash
     java -version
     ```

2. Clone este repositório ou baixe os arquivos:  
   ```bash
   git clone https://github.com/seu-usuario/sistemaGYM.git
   ## ▶️ Execução do Projeto  

3. Abra o projeto em uma **IDE Java** (Eclipse, IntelliJ, NetBeans ou VS Code com extensão).  

4. Compile e execute a classe principal:  

   ```bash
   CadastroUI.java
   
---

## 📖 Próximos Passos / Melhorias Futuras  

- Implementar persistência de dados em **banco de dados (MySQL/PostgreSQL)**.  
- Criar relatórios de clientes matriculados em cada modalidade.  
- Adicionar autenticação para diferentes níveis de acesso (**administrador/atendente**).  
- Melhorar o design da interface.  
