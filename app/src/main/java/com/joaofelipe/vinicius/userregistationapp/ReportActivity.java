package com.joaofelipe.vinicius.userregistationapp;

// Imporatções de componentes de UI, intenções e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.room.Room;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

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
