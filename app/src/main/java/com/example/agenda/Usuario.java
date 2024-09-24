package com.example.agenda;
import java.io.Serializable;

public class Usuario implements Serializable {

    private String nombre;
    private String apellido;
    private String email;
    private String documento;

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    private String edad;
    private String direccion;
    private String nacimiento;
    private String telefono;
    //
    private String estado;
    private String genero;
    //
    private boolean checkCine;
    private boolean checkMusica;
    private boolean checkDeporte;
    private boolean checkComida;
    private boolean checkViajes;
    private boolean checkLibros;
    //
    private String equipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }



    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        direccion = direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isCheckCine() {
        return checkCine;
    }

    public void setCheckCine(boolean checkCine) {
        this.checkCine = checkCine;
    }

    public boolean isCheckMusica() {
        return checkMusica;
    }

    public void setCheckMusica(boolean checkMusica) {
        this.checkMusica = checkMusica;
    }

    public boolean isCheckDeporte() {
        return checkDeporte;
    }

    public void setCheckDeporte(boolean checkDeporte) {
        this.checkDeporte = checkDeporte;
    }

    public boolean isCheckComida() {
        return checkComida;
    }

    public void setCheckComida(boolean checkComida) {
        this.checkComida = checkComida;
    }

    public boolean isCheckLibros() {
        return checkLibros;
    }

    public void setCheckLibros(boolean checkLibros) {
        this.checkLibros = checkLibros;
    }

    public boolean isCheckViajes() {
        return checkViajes;
    }

    public void setCheckViajes(boolean checkViajes) {
        this.checkViajes = checkViajes;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    private String pelicula;
    private String color;
    private String comida;
    private String libro;
    private String cancion;
    private String descripcion;



    public Usuario(String nombre, String apellido, String documento , String edad, String telefono, String direccion, String nacimiento,String email,
                   String estado, String genero, boolean checkCine, boolean checkMusica, boolean checkDeporte,
                   boolean checkComida, boolean checkViajes, boolean checkLibros,String equipo, String pelicula,
                   String color, String comida, String libro, String cancion, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.documento = documento;
        this.edad = edad;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.estado = estado;
        this.genero = genero;

        this.checkCine = checkCine;
        this.checkMusica = checkMusica;
        this.checkDeporte = checkDeporte;
        this.checkComida = checkComida;
        this.checkViajes = checkViajes;
        this.checkLibros = checkLibros;

        this.equipo = equipo;
        this.pelicula = pelicula;
        this.color = color;
        this.comida = comida;
        this.libro = libro;
        this.cancion = cancion;
        this.descripcion = descripcion;
    }

}
