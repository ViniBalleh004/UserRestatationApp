package com.joaofelipe.vinicius.userregistationapp;

// Imporatções de componentes de UI, intenções e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.room.Room;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReportActivity extends AppCompatActivity {
    // Campo de texto onde os dados do banco serão exibidos
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Define o layout XML dessa tela de relatório
        setContentView((R.layout.activity_report));
        //Mapeamento do TextViem do XML para o java
        textViewReport = findViewById(R.id.textViewReport);
        //encontra o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        // O botão de retorno utilizando expressão lamdda
        btnVoltar.setOnClickListener(View  -> voltarParaCadastro());

        /*
        conexão com o banco de dados
        1- Cria uma instância do banco "user-database"
        2- .allowMainThreadQueries(): Serve para liberar operações de consulta feitas em threads da UI.
        Por padrão, ROOM proibe isso. O correto seria fazer consultas em threads separadas.
        */

        UserDatabase db = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "user-database").allowMainThreadsQueries().Build();

        //Obtém o objeto DAO(Data Acess Obeject) que contém as queries SQL
        UserDao userDao = db.userDao();
        //Recupera todos os usuários salvos no BD e armazena numa lista

        List<User> userList = userDao.getAllUsers();
        //StringBuilder: forma eficiente de construir uma String longa dentro de um laço (loop)
        StringBuilder report = new StringBuilder();

        //Loop "for-each" para percorrer cada obejto User dentro da listas reparada
        for (User user : userList){
            Report.append("Nome: ").append(user.getName()).append("\n").append("CPF: ").append(user.getCpf()).append("\n\n");
        }
        // Exibe o relatório final montado na TextViem da tela
        textViewReport.setText(report.toString());
    }

    //Metodo responsavel pela navegação entre telas do app

    public void voltarParaCadastro();{
        //Intenção para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        //Fecha a tela de relatório para não acumular na pilha de tarefas
        finish();

    }
}
