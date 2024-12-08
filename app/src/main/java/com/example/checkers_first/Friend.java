package com.example.checkers_first;

public class Friend {
    private String nombre;
    private boolean status;
    public Friend(String nombre, boolean status) {
        this.nombre = nombre;
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
