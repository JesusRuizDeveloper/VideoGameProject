package co.edu.uptc.cruds.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.VideoGame;

public class CrudVideoGame extends AbstractCrud<VideoGame> {

    private ArrayList<VideoGame> list;

    public CrudVideoGame() {
        super("Videojuego");
        this.list = new ArrayList<>();
    }

    @Override
    protected VideoGame createInstance() {
        String name = JOptionPane.showInputDialog(null,
                "Digite el nombre del videojuego:",
                "Registro de Videojuego", JOptionPane.INFORMATION_MESSAGE);
        if (name == null) return null;

        String priceStr = JOptionPane.showInputDialog(null,
                "Digite el precio del videojuego:",
                "Registro de Videojuego", JOptionPane.INFORMATION_MESSAGE);
        if (priceStr == null) return null;
        double price = Double.parseDouble(priceStr);

        String dateStr = JOptionPane.showInputDialog(null,
                "Digite la fecha de lanzamiento (dd/MM/yyyy):",
                "Registro de Videojuego", JOptionPane.INFORMATION_MESSAGE);
        Date releaseDate = parseDate(dateStr);

        String genre = JOptionPane.showInputDialog(null,
                "Digite el genero del videojuego:",
                "Registro de Videojuego", JOptionPane.INFORMATION_MESSAGE);
        if (genre == null) return null;

        String developer = JOptionPane.showInputDialog(null,
                "Digite el nombre del desarrollador:",
                "Registro de Videojuego", JOptionPane.INFORMATION_MESSAGE);
        if (developer == null) return null;

        int multiOption = JOptionPane.showConfirmDialog(null,
                "Es multijugador?", "Registro de Videojuego", JOptionPane.YES_NO_OPTION);
        boolean multiplayer = (multiOption == JOptionPane.YES_OPTION);

        return new VideoGame(name, price, releaseDate, genre, developer, multiplayer);
    }

    @Override
    protected boolean newRecord(VideoGame record) {
        if (this.findRecordById(record.getId()) == null) {
            this.list.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected VideoGame findRecordById(int id) {
        for (VideoGame vg : this.list) {
            if (vg.getId() == id) return vg;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(VideoGame t) {
        for (VideoGame vg : this.list) {
            if (vg.getId() == t.getId()) {
                if (t.getName() != null) vg.setName(t.getName());
                if (t.getGenre() != null) vg.setGenre(t.getGenre());
                if (t.getDeveloperName() != null) vg.setDeveloperName(t.getDeveloperName());
                if (t.getReleaseDate() != null) vg.setReleaseDate(t.getReleaseDate());
                vg.setPrice(t.getPrice());
                vg.setMultiplayer(t.isMultiplayer());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.list.removeIf(vg -> vg.getId() == id);
    }

    @Override
    protected String listAll() {
        StringBuilder sb = new StringBuilder();
        for (VideoGame vg : this.list) {
            sb.append(vg.toString()).append("\n");
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
