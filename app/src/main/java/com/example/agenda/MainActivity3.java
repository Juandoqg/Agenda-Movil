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


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    EditText cajaBuscarModi, cajaNombreModi, cajaApellidoModi, cajaEmailModi, cajaTelefonoModi, cajaDocumentoModi, cajaEdadModi,cajaDireccionModi, cajaNacimientoModi;

    RadioGroup radioGroupGeneroModi,radioGroupEstadoModi;

    RadioButton cajaMasculinoModi, cajaFemeninoModi, cajaSolteroModi, cajaCasadoModi;

    CheckBox checkCineModi, checkMusicaModi, checkDeporteModi, checkViajesModi, checkComidaModi, checkLibrosModi;

    Spinner spinnerModi;

    EditText cajaPeliculaModi, cajaColorModi, cajaComidaModi,cajaLibroModi, cajaCancionModi, cajaDescripcionModi;
    ArrayList<Usuario> listaUsuarios;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cajaBuscarModi = findViewById(R.id.cajaBuscarModi);
        cajaNombreModi = findViewById(R.id.cajaNombreModi);
        cajaApellidoModi = findViewById(R.id.cajaApellidoModi);
        cajaEmailModi = findViewById(R.id.cajaEmailModi);
        cajaTelefonoModi = findViewById(R.id.cajaTelefonoModi);
        cajaDocumentoModi = findViewById(R.id.cajaDocumentoModi);
        cajaEdadModi = findViewById(R.id.cajaEdadModi);
        cajaDireccionModi = findViewById(R.id.cajaDireccionModi);
        cajaNacimientoModi = findViewById(R.id.cajaNacimientoModi);
        //////
        cajaPeliculaModi= findViewById(R.id.cajaPeliculaModi);
        cajaColorModi = findViewById(R.id.cajaColorModi);
        cajaComidaModi = findViewById(R.id.cajaComidaModi);
        cajaLibroModi = findViewById(R.id.cajaLibroModi);
        cajaCancionModi = findViewById(R.id.cajaCancionModi);
        cajaDescripcionModi = findViewById(R.id.cajaDescripcionModi);
        //////
        radioGroupEstadoModi = findViewById(R.id.radioGroupEstadoModi);
        cajaSolteroModi = findViewById(R.id.cajaSolteroModi);
        cajaCasadoModi = findViewById(R.id.cajaCasadoModi);
        //
        radioGroupGeneroModi = findViewById(R.id.radioGroupGeneroModi);
        cajaMasculinoModi = findViewById(R.id.cajaMasculinoModi);
        cajaFemeninoModi = findViewById(R.id.cajaFemeninoModi);
        //////
        checkCineModi = findViewById(R.id.checkCineModi);
        checkMusicaModi = findViewById(R.id.checkMusicaModi);
        checkDeporteModi = findViewById(R.id.checkDeporteModi);
        checkViajesModi = findViewById(R.id.checkViajesModi);
        checkComidaModi = findViewById(R.id.checkComidaModi);
        checkLibrosModi = findViewById(R.id.checkLibrosModi);
        //////
        spinnerModi = findViewById(R.id.spinnerModi);
        ArrayList<String> items = new ArrayList<>();
        items.add("Barcelona");
        items.add("Real Madrid");
        items.add("Milan");
        items.add("Inter");
        items.add("Bayern");
        items.add("Paris");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerModi.setAdapter(adapter);
        listaUsuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("listaUsuarios");
    }


    public void BuscarUsuario(View view) {
        String emailBuscado = cajaBuscarModi.getText().toString();
        Usuario usuarioEncontrado = buscarUsuarioPorEmail(emailBuscado);

        if (usuarioEncontrado != null) {
            cajaNombreModi.setText(usuarioEncontrado.getNombre());
            cajaApellidoModi.setText(usuarioEncontrado.getApellido());
            cajaDocumentoModi.setText(usuarioEncontrado.getDocumento());
            cajaEdadModi.setText(usuarioEncontrado.getEdad());
            cajaTelefonoModi.setText(usuarioEncontrado.getTelefono());
            cajaDireccionModi.setText(usuarioEncontrado.getDireccion());
            cajaNacimientoModi.setText(usuarioEncontrado.getNacimiento());
            cajaEmailModi.setText(usuarioEncontrado.getEmail());
            //seteo de radiogrouo
            String genero = usuarioEncontrado.getGenero();
            if (genero.equals("Masculino")) {
                radioGroupGeneroModi.check(R.id.cajaMasculinoModi);
            } else if (genero.equals("Femenino")) {
                radioGroupGeneroModi.check(R.id.cajaFemeninoModi);
            }

            String estado = usuarioEncontrado.getEstado();
            if (estado.equals("Casado")) {
                radioGroupEstadoModi.check(R.id.cajaCasadoModi);
            } else if (estado.equals("Soltero")) {
                radioGroupEstadoModi.check(R.id.cajaSolteroModi);
            }
            //
            checkMusicaModi.setChecked(usuarioEncontrado.isCheckMusica());
            checkDeporteModi.setChecked(usuarioEncontrado.isCheckDeporte());
            checkCineModi.setChecked(usuarioEncontrado.isCheckCine());
            checkViajesModi.setChecked(usuarioEncontrado.isCheckViajes());
            checkComidaModi.setChecked(usuarioEncontrado.isCheckComida());
            checkLibrosModi.setChecked(usuarioEncontrado.isCheckLibros());
            //seteo de spinner
            String equipo = usuarioEncontrado.getEquipo();
            int position = adapter.getPosition(equipo);
            if (position >= 0) {
                spinnerModi.setSelection(position);  // Setear la selección en la posición encontrada
            } else {
                // Si el equipo no está en la lista, puedes manejarlo aquí (opcional)
                Toast.makeText(this,"Equipo no encontrado", Toast.LENGTH_SHORT).show();
            }

            //
            cajaPeliculaModi.setText(usuarioEncontrado.getPelicula());
            cajaColorModi.setText(usuarioEncontrado.getColor());
            cajaComidaModi.setText(usuarioEncontrado.getComida());
            cajaLibroModi.setText(usuarioEncontrado.getLibro());
            cajaCancionModi.setText(usuarioEncontrado.getCancion());
            cajaDescripcionModi.setText(usuarioEncontrado.getDescripcion());

        } else {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    private Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public void modificarUsuario(View view) {
        String nombre = cajaNombreModi.getText().toString();
        String apellido = cajaApellidoModi.getText().toString();
        String documento = cajaDocumentoModi.getText().toString();
        String edad = cajaEdadModi.getText().toString();
        String telefono = cajaTelefonoModi.getText().toString();
        String direccion = cajaDireccionModi.getText().toString();
        String nacimiento = cajaNacimientoModi.getText().toString();
        String email = cajaEmailModi.getText().toString();
        boolean musica = checkMusicaModi.isChecked();
        boolean cine = checkCineModi.isChecked();
        boolean deporte = checkDeporteModi.isChecked();
        boolean boxcomida = checkComidaModi.isChecked();
        boolean viajes = checkViajesModi.isChecked();
        boolean libros = checkLibrosModi.isChecked();
        String genero = "";
        String estado = "";
        String equipo = spinnerModi.getSelectedItem().toString();
        String pelicula = cajaPeliculaModi.getText().toString();
        String color = cajaColorModi.getText().toString();
        String comida = cajaComidaModi.getText().toString();
        String libro = cajaLibroModi.getText().toString();
        String cancion = cajaCancionModi.getText().toString();
        String descripcion = cajaDescripcionModi.getText().toString();

        int selectedGeneroId = radioGroupGeneroModi.getCheckedRadioButtonId();
        if (selectedGeneroId != -1) {
            RadioButton selectedGenero = findViewById(selectedGeneroId);
            genero = selectedGenero.getText().toString();
        }

        int selectedEstadoId = radioGroupEstadoModi.getCheckedRadioButtonId();
        if (selectedEstadoId != -1) {
            RadioButton selectedEstado = findViewById(selectedEstadoId);
            estado = selectedEstado.getText().toString();
        }

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty() || genero.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            boolean usuarioModificado = false;

            for (int i = 0; i < listaUsuarios.size(); i++) {
                Usuario usuario = listaUsuarios.get(i);
                // Comparar con el email buscado
                if (usuario.getEmail().equals(cajaBuscarModi.getText().toString())) {
                    // Actualizar los datos del usuario existente
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    usuario.setEdad(edad);
                    usuario.setTelefono(telefono);
                    usuario.setDireccion(direccion);
                    usuario.setNacimiento(nacimiento);
                    usuario.setEmail(email);
                    usuario.setGenero(genero);
                    usuario.setEstado(estado);
                    usuario.setCheckCine(cine);
                    usuario.setCheckMusica(musica);
                    usuario.setCheckDeporte(deporte);
                    usuario.setCheckComida(boxcomida);
                    usuario.setCheckViajes(viajes);
                    usuario.setCheckLibros(libros);
                    usuario.setEquipo(equipo);
                    usuario.setPelicula(pelicula);
                    usuario.setColor(color);
                    usuario.setComida(comida);
                    usuario.setLibro(libro);
                    usuario.setCancion(cancion);
                    usuario.setDescripcion(descripcion);

                    // Actualizar la lista con el usuario modificado
                    listaUsuarios.set(i, usuario);

                    usuarioModificado = true;
                    break;  // Detener la búsqueda una vez que se encontró el usuario
                }
            }

            if (usuarioModificado) {
                Toast.makeText(this, "Usuario modificado correctamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void volver(View view){
        Intent intent3 = new Intent();
        intent3.putExtra("listaUsuarios", listaUsuarios);
        setResult(RESULT_OK, intent3);
        finish();

    }
}
