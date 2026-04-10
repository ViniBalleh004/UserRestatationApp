# User Registration App

Este é um aplicativo Android para cadastro e listagem de usuários, utilizando a biblioteca **Room** para persistência de dados local.

## Atualizações Recentes

### 1. Camada de Dados (Persistência com Room)
- **Entidade User**: Implementação da classe `User` que representa a tabela no banco de dados. Contém campos para `id` (chave primária), `name`, `cpf`, `email` e `phone`.
- **Interface UserDao**: Criação do Data Access Object (DAO) com métodos para:
    - `insert(User user)`: Inserir novos usuários.
    - `getAllUsers()`: Buscar todos os usuários cadastrados.
- **UserDatabase (Singleton)**: Implementação completa da classe de banco de dados:
    - Uso do padrão **Singleton** para garantir uma única instância do banco.
    - Configuração de migração destrutiva (`fallbackToDestructiveMigration`).
    - Habilitação de consultas na thread principal (`allowMainThreadQueries`) para simplificação inicial.

### 2. Interface e Navegação
- **ReportActivity**: Criação da atividade destinada à exibição dos relatórios de usuários.
- **Layouts**: 
    - `activity_main.xml`: Estrutura inicial em `LinearLayout` preparada para formulário.
    - `activity_report.xml`: Layout com título e botão de retorno já configurados.

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Banco de Dados**: Room Database (SQLite)
- **UI**: XML / LinearLayout / Material Design

---

## Próximos Passos
- Implementar a lógica de salvamento (captura de dados dos campos e inserção no banco) na `MainActivity`.
- Configurar o `RecyclerView` na `ReportActivity` para listar os usuários do banco.
- Implementar a navegação entre as telas.
