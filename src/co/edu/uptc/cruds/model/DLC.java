package co.edu.uptc.cruds.model;

import java.util.Date;

public class DLC extends DigitalProduct {
    private static int counter = 0;
    private String baseGameName;
    private String contentType;

    public DLC() {
    }

    public DLC(String name, double price, Date releaseDate, String baseGameName, String contentType) {
        super(name, price, releaseDate);
        this.baseGameName = baseGameName;
        this.contentType = contentType;
        this.id = ++counter;
    }

    public String getBaseGameName() {
        return baseGameName;
    }

    public void setBaseGameName(String baseGameName) {
        this.baseGameName = baseGameName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Precio: $" + price +
                " | Fecha: " + getFormattedDate() + " | Juego Base: " + baseGameName +
                " | Tipo Contenido: " + contentType;
    }
}
