package dosports.dosports;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends ActionBarActivity {

    EditText etu,etp;//campos de formulario: nombre de usuario y password
    Button bLogin;
    String usuario,pass;//cadenas donde almacenar los campos nombre de usuario y password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etu=(EditText)findViewById(R.id.etu);
        etp=(EditText)findViewById(R.id.etp1Mod);
        bLogin=(Button)findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logearse();
            }
        });
    }

    public void logearse(){
        usuario=etu.getText().toString();
        pass=etp.getText().toString();

     //   if (usuario.equals("admin") && pass.equals("admin")) {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
            finish();
       /* } else {
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos ... ", Toast.LENGTH_LONG).show();
        }*/
    }

}
