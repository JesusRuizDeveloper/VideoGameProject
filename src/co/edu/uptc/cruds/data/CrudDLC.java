package co.edu.uptc.cruds.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.DLC;

public class CrudDLC extends AbstractCrud<DLC> {

    private ArrayList<DLC> list;

    public CrudDLC() {
        super("DLC");
        this.list = new ArrayList<>();
    }

    @Override
    protected DLC createInstance() {
        String name = JOptionPane.showInputDialog(null,
                "Digite el nombre del DLC:",
                "Registro de DLC", JOptionPane.INFORMATION_MESSAGE);
        if (name == null) return null;

        String priceStr = JOptionPane.showInputDialog(null,
                "Digite el precio del DLC:",
                "Registro de DLC", JOptionPane.INFORMATION_MESSAGE);
        if (priceStr == null) return null;
        double price = Double.parseDouble(priceStr);

        String dateStr = JOptionPane.showInputDialog(null,
                "Digite la fecha de lanzamiento (dd/MM/yyyy):",
                "Registro de DLC", JOptionPane.INFORMATION_MESSAGE);
        Date releaseDate = parseDate(dateStr);

        String baseGame = JOptionPane.showInputDialog(null,
                "Digite el nombre del juego base:",
                "Registro de DLC", JOptionPane.INFORMATION_MESSAGE);
        if (baseGame == null) return null;

        String contentType = JOptionPane.showInputDialog(null,
                "Digite el tipo de contenido (Expansion, Skin, Mapa, etc.):",
                "Registro de DLC", JOptionPane.INFORMATION_MESSAGE);
        if (contentType == null) return null;

        return new DLC(name, price, releaseDate, baseGame, contentType);
    }

    @Override
    protected boolean newRecord(DLC record) {
        if (this.findRecordById(record.getId()) == null) {
            this.list.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected DLC findRecordById(int id) {
        for (DLC dlc : this.list) {
            if (dlc.getId() == id) return dlc;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(DLC t) {
        for (DLC dlc : this.list) {
            if (dlc.getId() == t.getId()) {
                if (t.getName() != null) dlc.setName(t.getName());
                if (t.getBaseGameName() != null) dlc.setBaseGameName(t.getBaseGameName());
                if (t.getContentType() != null) dlc.setContentType(t.getContentType());
                if (t.getReleaseDate() != null) dlc.setReleaseDate(t.getReleaseDate());
                dlc.setPrice(t.getPrice());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.list.removeIf(dlc -> dlc.getId() == id);
    }

    @Override
    protected String listAll() {
        StringBuilder sb = new StringBuilder();
        for (DLC dlc : this.list) {
            sb.append(dlc.toString()).append("\n");
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
