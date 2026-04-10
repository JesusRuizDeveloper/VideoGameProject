package co.edu.uptc.cruds.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DigitalProduct extends BaseClass {
    protected String name;
    protected double price;
    protected Date releaseDate;

    public DigitalProduct() {
    }

    public DigitalProduct(String name, double price, Date releaseDate) {
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFormattedDate() {
        if (releaseDate == null) return "N/A";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(releaseDate);
    }
}
