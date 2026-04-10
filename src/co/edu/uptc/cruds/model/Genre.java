package co.edu.uptc.cruds.model;

public class Genre extends BaseClass {
    private static int counter = 0;
    private String name;
    private String description;
    private int popularity;
    private boolean online;
    private int originYear;

    public Genre() {
    }

    public Genre(String name, String description, int popularity, boolean online, int originYear) {
        this.name = name;
        this.description = description;
        this.popularity = popularity;
        this.online = online;
        this.originYear = originYear;
        this.id = ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getOriginYear() {
        return originYear;
    }

    public void setOriginYear(int originYear) {
        this.originYear = originYear;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Descripcion: " + description +
                " | Popularidad: " + popularity + "/10 | Online: " + (online ? "Si" : "No") +
                " | Ano Origen: " + originYear;
    }
}
