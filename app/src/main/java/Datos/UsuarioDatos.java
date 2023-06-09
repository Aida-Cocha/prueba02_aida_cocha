package Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import DB_Helper.DbHelper_Usuarios;

public class UsuarioDatos extends DbHelper_Usuarios {

Context context;


    public UsuarioDatos(@Nullable Context context) {
        super(context);

        this.context=context;
    }



    public long insertarUsuario(String cedula,String nombre,String apellido, String correo,String clave){

        long id=0;

        try {
            DbHelper_Usuarios dbHelper_usuarios=new DbHelper_Usuarios(context);
            SQLiteDatabase db=dbHelper_usuarios.getWritableDatabase();

            ContentValues values=new ContentValues();
            values.put("cedula",cedula);
            values.put("nombres",nombre);
            values.put("apellido",apellido);
            values.put("correo",correo);
            values.put("clave",clave);

            id=db.insert(TABLE_NOMBRE,null,values);


        }catch (Exception e){
            e.toString();
        }
        return  id;

    }







}
