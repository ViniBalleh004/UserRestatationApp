package com.joaofelipe.vinicius.userregistationapp;

// O Dara Acess Object é o componente que serve para persisitência de dados. Serve para definit as operações que podem ser feitas no banco de dados com relação a entidade User

// Importa as notações do Room necessárias para definir o DAO
//(Data Acess Object)

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    //metodo para inserir um usuário na tabela do BD
    // A anotação @insert informa à room que este metodo deve ser usada para inserir dado

    @Insert
    void insert(User user);

    // metodo para buscar todos os usuarios cadasdtrados no BD
    // a anotação @Querry permite definirt uma consulta SQL personalizadas

    @Query("SELECT * FROM user")
    list<User> getAllUsers();
}