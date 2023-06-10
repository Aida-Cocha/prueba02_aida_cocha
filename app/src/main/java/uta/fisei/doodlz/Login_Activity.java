package uta.fisei.doodlz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Datos.UsuarioDatos;
import Entidades.Usuario;

public class Login_Activity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextContrasenia;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextNombre=findViewById(R.id.editText_nombre);
        editTextContrasenia=findViewById(R.id.editText_password);

    }

    public void Ingresar(View view){
        UsuarioDatos usuarioDatos=new UsuarioDatos(this);
      //Creacion de los usuarios con su contrasenia
        Usuario usuario=new Usuario("ac","123");
        Usuario usuario1=new Usuario("em","1234");


        if(usuario != null)
        {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("nombre", (usuario.getCorreo()));
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_LONG).show();
    }






    }





