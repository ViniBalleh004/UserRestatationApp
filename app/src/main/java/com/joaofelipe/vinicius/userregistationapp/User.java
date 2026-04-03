package com.joaofelipe.vinicius.userregistationapp;
// Importa anotações do Room necessários para mapear esta classe como uma entidade do banco de dados
import android.hardware.camera2.CameraExtensionSession;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User{
    //Define o campo 'id' como chave primária da tabela e configura para ser gerado automaticamente

    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campus quie representam as colunas da tabela para armazenar os dados do usuário

    private String name; //Nome do usuário
    private String cpf; // CPF do usuário
    private  String email; // Email do usuário
    private String phone; // Fone do usuario

    // Construtor de classe que usado para criar novo objeto User
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    //Mètodos getter e setter para acessar e modificar os dados do obejetos User
    public int getId(){return id;}

    //Define o ID do usário (usado pelo Room para preencher automaticamente)
    public void setId(int id){this.id = id;}

    //Retorna o nome do Usário
    public String getName(){return name;}

    //Retorna o Cpf do usuário
    public String getCpf(){return cpf;}

    //Retorna o email do usuário
    public String getEmail(){return email;}

    //Retorna o Fone do usuário
    public String getPhone(){return phone;}

}