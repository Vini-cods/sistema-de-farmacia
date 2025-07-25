# Sistema de Farmácia

## 📝 Descrição

Sistema de gerenciamento de medicamentos para farmácias, desenvolvido em Java com interface gráfica Swing. Permite o CRUD completo (Cadastrar, Ler, Atualizar e Deletar) de itens medicamentosos, armazenando os dados em um arquivo texto.

## 🛠️ Tecnologias

- **Linguagem**: Java 21
- **Interface**: Java Swing
- **Gerenciamento de Dependências**: Maven
- **Padrão de Projeto**: MVC (Model-View-Controller)

## 📦 Estrutura do Projeto

```
sistema-de-farmacia/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Main.java
│                   ├── controller/
│                   │   └── BancoDeDados.java
│                   ├── model/
│                   │   └── Item.java
│                   └── view/
│                       └── FarmaciaGUI.java
├── medicamentos.txt
├── pom.xml
└── .gitignore
```

## ✨ Funcionalidades

- ✅ Cadastro de novos medicamentos
- 🔍 Pesquisa por código do medicamento
- ✏️ Edição de medicamentos existentes
- 🗑️ Exclusão de medicamentos
- 📋 Listagem completa de todos os medicamentos
- 💾 Armazenamento persistente em arquivo texto

## 🚀 Como Executar

### Pré-requisitos
- JDK 21 instalado
- Maven instalado (opcional)

### Passos:

1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITORIO]
   cd sistema-de-farmacia
   ```

2. Compile e execute com Maven:
   ```bash
   mvn clean compile
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

3. Ou execute diretamente pela IDE:
   - Importe como projeto Maven
   - Execute a classe `Main.java`

## 🖥️ Interface do Usuário

<img width="584" height="488" alt="image" src="https://github.com/user-attachments/assets/517fc4eb-d9a3-406a-953c-2aaaccb84a2b" />


1. **Campos de Entrada**:
   - Código, Nome, Quantidade e Tipo do medicamento

2. **Botões de Ação**:
   - Adicionar: Cadastra novo medicamento
   - Editar: Atualiza medicamento existente
   - Pesquisar: Localiza medicamento por código
   - Excluir: Remove medicamento
   - Listar Medicamentos: Mostra todos cadastrados

3. **Área de Saída**:
   - Exibe lista de medicamentos e mensagens do sistema

## 📊 Armazenamento de Dados

Os medicamentos são armazenados no arquivo `medicamentos.txt` no formato:
```
Nome,Quantidade,Tipo
Dipirona 500mg,100,Caixa
Tilenol 200ml,300,Frasco
```

## 💡 Dicas Úteis
- Os dados são salvos automaticamente
- A listagem completa é atualizada após cada operação
- Use a pesquisa para verificar detalhes antes de editar

## 🛠️ Personalização
Você pode facilmente:
- Alterar o arquivo de armazenamento modificando `medicamentos.txt`
- Ajustar campos adicionais editando a classe `Item`
- Modificar o layout editando `FarmaciaGUI.java`

## 📌 Notas Importantes
- Sempre mantenha backup do arquivo `medicamentos.txt`
- O sistema não requer instalação adicional além do Java
- Projeto ideal para aprendizado e uso em pequenas farmácias
