package co.edu.uptc.cruds.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.Developer;

public class CrudDeveloper extends AbstractCrud<Developer> {

    private ArrayList<Developer> list;

    public CrudDeveloper() {
        super("Desarrollador");
        this.list = new ArrayList<>();
    }

    @Override
    protected Developer createInstance() {
        String name = JOptionPane.showInputDialog(null,
                "Digite el nombre del desarrollador:",
                "Registro de Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        if (name == null) return null;

        String country = JOptionPane.showInputDialog(null,
                "Digite el pais del desarrollador:",
                "Registro de Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        if (country == null) return null;

        String dateStr = JOptionPane.showInputDialog(null,
                "Digite la fecha de fundacion (dd/MM/yyyy):",
                "Registro de Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        Date foundedDate = parseDate(dateStr);

        String website = JOptionPane.showInputDialog(null,
                "Digite el sitio web:",
                "Registro de Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        if (website == null) return null;

        String empStr = JOptionPane.showInputDialog(null,
                "Digite el numero de empleados:",
                "Registro de Desarrollador", JOptionPane.INFORMATION_MESSAGE);
        if (empStr == null) return null;
        int employeeCount = Integer.parseInt(empStr);

        return new Developer(name, country, foundedDate, website, employeeCount);
    }

    @Override
    protected boolean newRecord(Developer record) {
        if (this.findRecordById(record.getId()) == null) {
            this.list.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Developer findRecordById(int id) {
        for (Developer dev : this.list) {
            if (dev.getId() == id) return dev;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Developer t) {
        for (Developer dev : this.list) {
            if (dev.getId() == t.getId()) {
                if (t.getName() != null) dev.setName(t.getName());
                if (t.getCountry() != null) dev.setCountry(t.getCountry());
                if (t.getFoundedDate() != null) dev.setFoundedDate(t.getFoundedDate());
                if (t.getWebsite() != null) dev.setWebsite(t.getWebsite());
                dev.setEmployeeCount(t.getEmployeeCount());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.list.removeIf(dev -> dev.getId() == id);
    }

    @Override
    protected String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Developer dev : this.list) {
            sb.append(dev.toString()).append("\n");
        }
        return sb.toString();
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }
}
