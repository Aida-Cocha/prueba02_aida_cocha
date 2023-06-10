package Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import DB_Helper.DbHelper_Usuarios;
import Entidades.Usuario;

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





public Usuario login(String correo,String clave){
        DbHelper_Usuarios dbHelper_usuarios=new DbHelper_Usuarios(context);
        SQLiteDatabase db=dbHelper_usuarios.getWritableDatabase();

        Usuario usuario=null;

    Cursor cursorUsuario=db.rawQuery("SELECT * FROM " + TABLE_NOMBRE + " WHERE correo = '" + correo + "' and clave = '" + clave + "' LIMIT 1", null);

if(cursorUsuario.moveToFirst()){
    usuario=new Usuario();
    usuario.setId(cursorUsuario.getInt(0));
    usuario.setCedula(cursorUsuario.getString(1));
    usuario.setNombre(cursorUsuario.getString(2));
    usuario.setApellido(cursorUsuario.getString(3));
    usuario.setCorreo(cursorUsuario.getString(4));
    usuario.setClave(cursorUsuario.getString(5));






}

cursorUsuario.close();
return  usuario;



}




}
