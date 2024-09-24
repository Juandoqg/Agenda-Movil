package com.example.agenda;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MODIFICAR = 1;
   EditText cajaNombre, cajaApellido, cajaEmail, cajaTelefono, cajaDocumento, cajaEdad,cajaDireccion, cajaNacimiento;

   RadioGroup radioGroupGenero,radioGroupEstado;

   CheckBox checkCine, checkMusica, checkDeporte, checkViajes, checkComida, checkLibros;

   Spinner spinner;

   EditText cajaPelicula, cajaColor, cajaComida,cajaLibro, cajaCancion, cajaDescripcion;

   ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cajaNombre = findViewById(R.id.cajaNombre);
        cajaApellido = findViewById(R.id.cajaApellido);
        cajaEmail = findViewById(R.id.cajaEmail);
        cajaTelefono = findViewById(R.id.cajaTelefono);
        cajaDocumento = findViewById(R.id.cajaDocumento);
        cajaEdad = findViewById(R.id.cajaEdad);
        cajaDireccion = findViewById(R.id.cajaDireccion);
        cajaNacimiento = findViewById(R.id.cajaNacimiento);
        //////
        cajaPelicula= findViewById(R.id.cajaPelicula);
        cajaColor = findViewById(R.id.cajaColor);
        cajaComida = findViewById(R.id.cajaComida);
        cajaLibro = findViewById(R.id.cajaLibro);
        cajaCancion = findViewById(R.id.cajaCancion);
        cajaDescripcion = findViewById(R.id.cajaDescripcion);
        //////
        radioGroupEstado = findViewById(R.id.radioGroupEstado);
        radioGroupGenero = findViewById(R.id.radioGroupGenero);
        //////
        checkCine = findViewById(R.id.checkCine);
        checkMusica = findViewById(R.id.checkMusica);
        checkDeporte = findViewById(R.id.checkDeporte);
        checkViajes = findViewById(R.id.checkViajes);
        checkComida = findViewById(R.id.checkComida);
        checkLibros = findViewById(R.id.checkLibros);
        //////
        spinner = findViewById(R.id.spinner);
        ArrayList<String> items = new ArrayList<>();
        items.add("Barcelona");
        items.add("Real Madrid");
        items.add("Milan");
        items.add("Inter");
        items.add("Bayern");
        items.add("Paris");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }


    public void guardar(View view) {
        String nombre = cajaNombre.getText().toString();
        String apellido = cajaApellido.getText().toString();
        String documento = cajaDocumento.getText().toString();
        String edad = cajaEdad.getText().toString();
        String telefono = cajaTelefono.getText().toString();
        String direccion = cajaDireccion.getText().toString();
        String nacimiento = cajaNacimiento.getText().toString();
        String email = cajaEmail.getText().toString();
        boolean musica = checkMusica.isChecked();
        boolean cine = checkCine.isChecked();
        boolean deporte = checkDeporte.isChecked();
        boolean boxcomida = checkComida.isChecked();
        boolean viajes = checkViajes.isChecked();
        boolean libros = checkLibros.isChecked();
        String genero = "";
        String estado = "";
        String equipo = spinner.getSelectedItem().toString();
        String pelicula = cajaPelicula.getText().toString();
        String color = cajaColor.getText().toString();
        String comida = cajaComida.getText().toString();
        String libro = cajaLibro.getText().toString();
        String cancion = cajaCancion.getText().toString();
        String descripcion = cajaDescripcion.getText().toString();


        int selectedGeneroId = radioGroupGenero.getCheckedRadioButtonId();
        if (selectedGeneroId != -1) {
            RadioButton selectedGenero = findViewById(selectedGeneroId);
            genero = selectedGenero.getText().toString();
        }

        int selectedEstadoId = radioGroupEstado.getCheckedRadioButtonId();
        if (selectedEstadoId != -1) {
            RadioButton selectedEstado = findViewById(selectedEstadoId);
            estado = selectedEstado.getText().toString();
        }

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty() || genero.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
        } else {

            Usuario usuario = new Usuario(nombre, apellido, documento, edad, telefono,direccion, nacimiento ,email, estado,genero,cine,musica,deporte,boxcomida,viajes,libros,equipo,pelicula,color,comida,libro,cancion,descripcion);
            listaUsuarios.add(usuario);

            Toast.makeText(this, "Usuario guardado ", Toast.LENGTH_LONG).show();

            cajaNombre.setText("");
            cajaApellido.setText("");
            cajaDocumento.setText("");
            cajaEdad.setText("");
            cajaTelefono.setText("");
            cajaDireccion.setText("");
            cajaNacimiento.setText("");
            cajaEmail.setText("");
            radioGroupGenero.clearCheck();
            radioGroupEstado.clearCheck();
            spinner.setSelection(0);
            checkCine.setChecked(false);
            checkMusica.setChecked(false);
            checkDeporte.setChecked(false);
            checkComida.setChecked(false);
            checkLibros.setChecked(false);
            checkViajes.setChecked(false);
            cajaPelicula.setText("");
            cajaColor.setText("");
            cajaComida.setText("");
            cajaLibro.setText("");
            cajaCancion.setText("");
            cajaDescripcion.setText("");
        }
    }

    public void ver(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("listaUsuarios", listaUsuarios);  // Enviar la lista de usuarios
        startActivity(intent);
    }
    public void modificar(View view){
        Intent intent2 = new Intent(this, MainActivity3.class);
        intent2.putExtra("listaUsuarios", listaUsuarios);  // Enviar la lista de usuarios
        startActivityForResult(intent2, REQUEST_CODE_MODIFICAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MODIFICAR && resultCode == RESULT_OK) {
            if (data != null) {
                // Recibir el ArrayList de usuarios modificado
                listaUsuarios = (ArrayList<Usuario>) data.getSerializableExtra("listaUsuarios");
                // Aquí puedes actualizar la UI o hacer lo que necesites con la lista actualizada
            }
        }
    }
}
