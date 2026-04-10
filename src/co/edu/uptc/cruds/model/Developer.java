package co.edu.uptc.cruds.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Developer extends BaseClass {
    private static int counter = 0;
    private String name;
    private String country;
    private Date foundedDate;
    private String website;
    private int employeeCount;

    public Developer() {
    }

    public Developer(String name, String country, Date foundedDate, String website, int employeeCount) {
        this.name = name;
        this.country = country;
        this.foundedDate = foundedDate;
        this.website = website;
        this.employeeCount = employeeCount;
        this.id = ++counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(Date foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = (foundedDate != null) ? sdf.format(foundedDate) : "N/A";
        return "ID: " + id + " | Nombre: " + name + " | Pais: " + country +
                " | Fundacion: " + date + " | Web: " + website +
                " | Empleados: " + employeeCount;
    }
}
