package com.joaofelipe.vinicius.userregistationapp;
//impota as anotações e classes da biblioteca Room e do Android
import android.content.Context;// classe que representa o contexto da aplicação(necessario pra acesar recursos)

import androidx.room.Database;//Anotação para marcar a classe como um banco de dados Room
import androidx.room.Room;
import androidx.room.RoomDatabase;// Classe base que representa o BD

/*
Anotação @Database define que a classe representa o banco de daddos Room a especifica as entidades(tabelas) qu8e banco irá conter e a versão do BD
*/
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    //Instância unica (singleton) do BD
    private static  UserDatabase instancie;
    //metodo abstrato que será implementado pelo Room
    // serve para acessar as operações do BD definidas na UserDao
    public abstract UserDao userDao();

    //metodo que retorna a instância do BD
    // O uso do 'sychronized' garante que apenas uma thread possa acessar este metodo por sua vez, evitando que duas instâncias do BD sejam criadas acidentalmente
    public static synchronized UserDatabase getInstance(Context context){
        // verificar se já existe uma istância de BD
        if ((instancie == null)){
            //cria a instância do BD usando Room
            //usa o contexto da aplicação para evitarvazamento de memoria)
            //fallbackToDestrutiveMigration - se houver mudança da versão e não houver migração, o BD será recriado do zero
            instancie = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        //retorna a instância criada
        return instancie;
    }


}
