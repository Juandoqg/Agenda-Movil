package com.example.agenda;

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

public class MainActivity2 extends AppCompatActivity {

    EditText cajaBuscar, cajaNombreVer, cajaApellidoVer, cajaEmailVer, cajaTelefonoVer, cajaDocumentoVer, cajaEdadVer,cajaDireccionVer, cajaNacimientoVer;

    RadioGroup radioGroupGeneroVer,radioGroupEstadoVer;

    RadioButton cajaMasculinoVer, cajaFemeninoVer, cajaSolteroVer, cajaCasadoVer;

    CheckBox checkCineVer, checkMusicaVer, checkDeporteVer, checkViajesVer, checkComidaVer, checkLibrosVer;

    Spinner spinnerVer;

    EditText cajaPeliculaVer, cajaColorVer, cajaComidaVer,cajaLibroVer, cajaCancionVer, cajaDescripcionVer;
    ArrayList<Usuario> listaUsuarios;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cajaBuscar = findViewById(R.id.cajaBuscar);
        cajaNombreVer = findViewById(R.id.cajaNombreVer);
        cajaApellidoVer = findViewById(R.id.cajaApellidoVer);
        cajaEmailVer = findViewById(R.id.cajaEmailVer);
        cajaTelefonoVer = findViewById(R.id.cajaTelefonoVer);
        cajaDocumentoVer = findViewById(R.id.cajaDocumentoVer);
        cajaEdadVer = findViewById(R.id.cajaEdadVer);
        cajaDireccionVer = findViewById(R.id.cajaDireccionVer);
        cajaNacimientoVer = findViewById(R.id.cajaNacimientoVer);
        //////
        cajaPeliculaVer= findViewById(R.id.cajaPeliculaVer);
        cajaColorVer = findViewById(R.id.cajaColorVer);
        cajaComidaVer = findViewById(R.id.cajaComidaVer);
        cajaLibroVer = findViewById(R.id.cajaLibroVer);
        cajaCancionVer = findViewById(R.id.cajaCancionVer);
        cajaDescripcionVer = findViewById(R.id.cajaDescripcionVer);
        //////
        radioGroupEstadoVer = findViewById(R.id.radioGroupEstadoVer);
        cajaSolteroVer = findViewById(R.id.cajaSolteroVer);
        cajaCasadoVer = findViewById(R.id.cajaCasadoVer);
        //
        radioGroupGeneroVer = findViewById(R.id.radioGroupGeneroVer);
        cajaMasculinoVer = findViewById(R.id.cajaMasculinoVer);
        cajaFemeninoVer = findViewById(R.id.cajaFemeninoVer);
        //////
        checkCineVer = findViewById(R.id.checkCineVer);
        checkMusicaVer = findViewById(R.id.checkMusicaVer);
        checkDeporteVer = findViewById(R.id.checkDeporteVer);
        checkViajesVer = findViewById(R.id.checkViajesVer);
        checkComidaVer = findViewById(R.id.checkComidaVer);
        checkLibrosVer = findViewById(R.id.checkLibrosVer);
        //////
        spinnerVer = findViewById(R.id.spinnerVer);
        ArrayList<String> items = new ArrayList<>();
        items.add("Barcelona");
        items.add("Real Madrid");
        items.add("Milan");
        items.add("Inter");
        items.add("Bayern");
        items.add("Paris");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerVer.setAdapter(adapter);
        listaUsuarios = (ArrayList<Usuario>) getIntent().getSerializableExtra("listaUsuarios");
    }


    public void Buscar(View view) {
        String emailBuscado = cajaBuscar.getText().toString();
        Usuario usuarioEncontrado = buscarUsuarioPorEmail(emailBuscado);

        if (usuarioEncontrado != null) {
            cajaNombreVer.setText(usuarioEncontrado.getNombre());
            cajaApellidoVer.setText(usuarioEncontrado.getApellido());
            cajaDocumentoVer.setText(usuarioEncontrado.getDocumento());
            cajaEdadVer.setText(usuarioEncontrado.getEdad());
            cajaTelefonoVer.setText(usuarioEncontrado.getTelefono());
            cajaDireccionVer.setText(usuarioEncontrado.getDireccion());
            cajaNacimientoVer.setText(usuarioEncontrado.getNacimiento());
            cajaEmailVer.setText(usuarioEncontrado.getEmail());
            //seteo de radiogrouo
            String genero = usuarioEncontrado.getGenero();
            String estado = usuarioEncontrado.getEstado();
            if (genero.equals("Masculino")) {
                radioGroupGeneroVer.check(R.id.cajaMasculinoVer);
            } else if (genero.equals("Femenino")) {
                radioGroupGeneroVer.check(R.id.cajaFemeninoVer);
            }

            if (estado.equals("Casado")) {
                radioGroupEstadoVer.check(R.id.cajaCasadoVer);
            } else if (estado.equals("Soltero")) {
                radioGroupEstadoVer.check(R.id.cajaSolteroVer);
            }
            //
            checkMusicaVer.setChecked(usuarioEncontrado.isCheckMusica());
            checkDeporteVer.setChecked(usuarioEncontrado.isCheckDeporte());
            checkCineVer.setChecked(usuarioEncontrado.isCheckCine());
            checkViajesVer.setChecked(usuarioEncontrado.isCheckViajes());
            checkComidaVer.setChecked(usuarioEncontrado.isCheckComida());
            checkLibrosVer.setChecked(usuarioEncontrado.isCheckLibros());
            //seteo de spinner
            String equipo = usuarioEncontrado.getEquipo();
            int position = adapter.getPosition(equipo);
            if (position >= 0) {
                spinnerVer.setSelection(position);  // Setear la selección en la posición encontrada
            } else {
                // Si el equipo no está en la lista, puedes manejarlo aquí (opcional)
                Toast.makeText(this,"Equipo no encontrado", Toast.LENGTH_SHORT).show();
            }

            //
            cajaPeliculaVer.setText(usuarioEncontrado.getPelicula());
            cajaColorVer.setText(usuarioEncontrado.getColor());
            cajaComidaVer.setText(usuarioEncontrado.getComida());
            cajaLibroVer.setText(usuarioEncontrado.getLibro());
            cajaCancionVer.setText(usuarioEncontrado.getCancion());
            cajaDescripcionVer.setText(usuarioEncontrado.getDescripcion());

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
    public void volver(View view){
        finish();
    }
}
