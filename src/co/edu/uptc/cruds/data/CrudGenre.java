package co.edu.uptc.cruds.data;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.Genre;

public class CrudGenre extends AbstractCrud<Genre> {

    private ArrayList<Genre> list;

    public CrudGenre() {
        super("Genero");
        this.list = new ArrayList<>();
    }

    @Override
    protected Genre createInstance() {
        String name = JOptionPane.showInputDialog(null,
                "Digite el nombre del genero:",
                "Registro de Genero", JOptionPane.INFORMATION_MESSAGE);
        if (name == null) return null;

        String description = JOptionPane.showInputDialog(null,
                "Digite la descripcion del genero:",
                "Registro de Genero", JOptionPane.INFORMATION_MESSAGE);
        if (description == null) return null;

        String popStr = JOptionPane.showInputDialog(null,
                "Digite la popularidad (1-10):",
                "Registro de Genero", JOptionPane.INFORMATION_MESSAGE);
        if (popStr == null) return null;
        int popularity = Integer.parseInt(popStr);

        int onlineOption = JOptionPane.showConfirmDialog(null,
                "Es un genero online?", "Registro de Genero", JOptionPane.YES_NO_OPTION);
        boolean online = (onlineOption == JOptionPane.YES_OPTION);

        String yearStr = JOptionPane.showInputDialog(null,
                "Digite el ano de origen del genero:",
                "Registro de Genero", JOptionPane.INFORMATION_MESSAGE);
        if (yearStr == null) return null;
        int originYear = Integer.parseInt(yearStr);

        return new Genre(name, description, popularity, online, originYear);
    }

    @Override
    protected boolean newRecord(Genre record) {
        if (this.findRecordById(record.getId()) == null) {
            this.list.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Genre findRecordById(int id) {
        for (Genre genre : this.list) {
            if (genre.getId() == id) return genre;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Genre t) {
        for (Genre genre : this.list) {
            if (genre.getId() == t.getId()) {
                if (t.getName() != null) genre.setName(t.getName());
                if (t.getDescription() != null) genre.setDescription(t.getDescription());
                genre.setPopularity(t.getPopularity());
                genre.setOnline(t.isOnline());
                genre.setOriginYear(t.getOriginYear());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.list.removeIf(genre -> genre.getId() == id);
    }

    @Override
    protected String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Genre genre : this.list) {
            sb.append(genre.toString()).append("\n");
        }
        return sb.toString();
    }
}
