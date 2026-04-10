package co.edu.uptc.cruds.model;

import java.util.Date;

public class VideoGame extends DigitalProduct {
    private static int counter = 0;
    private String genre;
    private String developerName;
    private boolean multiplayer;

    public VideoGame() {
    }

    public VideoGame(String name, double price, Date releaseDate, String genre, String developerName, boolean multiplayer) {
        super(name, price, releaseDate);
        this.genre = genre;
        this.developerName = developerName;
        this.multiplayer = multiplayer;
        this.id = ++counter;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public boolean isMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Precio: $" + price +
                " | Fecha: " + getFormattedDate() + " | Genero: " + genre +
                " | Desarrollador: " + developerName + " | Multijugador: " + (multiplayer ? "Si" : "No");
    }
}
