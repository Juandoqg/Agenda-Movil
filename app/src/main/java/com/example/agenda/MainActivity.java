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
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    //Trabajo realizado por Juan David Quintero Garcia y Juan Jose Ospina

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
        if (!validarCampos()) return;

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
        boolean boxComida = checkComida.isChecked();
        boolean viajes = checkViajes.isChecked();
        boolean libros = checkLibros.isChecked();
        String genero = obtenerGeneroSeleccionado();
        String estado = obtenerEstadoSeleccionado();
        String equipo = spinner.getSelectedItem().toString();
        String pelicula = cajaPelicula.getText().toString();
        String color = cajaColor.getText().toString();
        String comida = cajaComida.getText().toString();
        String libro = cajaLibro.getText().toString();
        String cancion = cajaCancion.getText().toString();
        String descripcion = cajaDescripcion.getText().toString();

        Usuario usuario = new Usuario(nombre, apellido, documento, edad, telefono, direccion, nacimiento, email, estado, genero, cine, musica, deporte, boxComida, viajes, libros, equipo, pelicula, color, comida, libro, cancion, descripcion);
        listaUsuarios.add(usuario);

        Toast.makeText(this, "Usuario guardado", Toast.LENGTH_LONG).show();
        limpiarCampos();
    }

    private String obtenerGeneroSeleccionado() {
        int selectedId = radioGroupGenero.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedGenero = findViewById(selectedId);
            return selectedGenero.getText().toString();
        }
        return ""; // O puedes lanzar un error si es necesario
    }

    private String obtenerEstadoSeleccionado() {
        int selectedId = radioGroupEstado.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedEstado = findViewById(selectedId);
            return selectedEstado.getText().toString();
        }
        return ""; // O puedes lanzar un error si es necesario
    }

    private void limpiarCampos() {
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

    private boolean validarCampos() {
        String nacimiento = cajaNacimiento.getText().toString().trim();

        if (cajaNombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo nombre es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaApellido.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo apellido es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaDocumento.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo documento es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cajaTelefono.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo teléfono es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaTelefono.getText().length() < 10) {
            Toast.makeText(this, "El teléfono debe tener al menos 10 dígitos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!nacimiento.matches("\\d{2}\\d{2}\\d{4}")) { // Comprueba si el formato es ddmmyyyy
            Toast.makeText(this, "El formato de nacimiento debe ser ddmmyyyy", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaEdad.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo edad es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaDireccion.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo dirección es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaNacimiento.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo nacimiento es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaEmail.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo email es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(cajaEmail.getText().toString()).matches()) {
            Toast.makeText(this, "El email ingresado no es válido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (cajaPelicula.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo película es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaColor.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo color es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaComida.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo comida es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaLibro.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo libro es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaCancion.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo canción es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (cajaDescripcion.getText().toString().isEmpty()) {
            Toast.makeText(this, "El campo descripción es obligatorio", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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

    public void calculadora(View view){
        Intent intent3 = new Intent(this, MainActivity4.class);
        startActivity(intent3);
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
