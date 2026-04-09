# User Registration App

Este é um aplicativo Android para cadastro e listagem de usuários, utilizando a biblioteca **Room** para persistência de dados local.

## Atualizações Recentes

### 1. Camada de Dados (Persistência com Room)
- **Entidade User**: Implementação da classe `User` que representa a tabela no banco de dados. Contém campos para `id` (chave primária), `name`, `cpf`, `email` e `phone`.
- **Interface UserDao**: Criação do Data Access Object (DAO) com métodos para:
    - `insert(User user)`: Inserir novos usuários.
    - `getAllUsers()`: Buscar todos os usuários cadastrados.
- **UserDatabase**: Estrutura inicial criada para a configuração do banco de dados Room.

### 2. Interface e Navegação
- **ReportActivity**: Criação da atividade destinada à exibição dos relatórios de usuários.
- **Layouts**: 
    - `activity_main.xml`: Layout principal para entrada de dados (em desenvolvimento).
    - `activity_report.xml`: Layout base para a listagem de usuários.

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Banco de Dados**: Room Database (SQLite)
- **UI**: XML / ConstraintLayout / LinearLayout

---

## Próximos Passos
- Finalizar a implementação do `UserDatabase` (Singleton).
- Implementar a lógica de salvamento na `MainActivity`.
- Configurar o `RecyclerView` na `ReportActivity` para exibir os dados.
