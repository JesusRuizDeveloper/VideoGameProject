package co.edu.uptc.cruds.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.Review;

public class CrudReview extends AbstractCrud<Review> {

    private ArrayList<Review> list;

    public CrudReview() {
        super("Resena");
        this.list = new ArrayList<>();
    }

    @Override
    protected Review createInstance() {
        String author = JOptionPane.showInputDialog(null,
                "Digite el nombre del autor:",
                "Registro de Resena", JOptionPane.INFORMATION_MESSAGE);
        if (author == null) return null;

        String scoreStr = JOptionPane.showInputDialog(null,
                "Digite la puntuacion (1-10):",
                "Registro de Resena", JOptionPane.INFORMATION_MESSAGE);
        if (scoreStr == null) return null;
        int score = Integer.parseInt(scoreStr);

        String comment = JOptionPane.showInputDialog(null,
                "Digite el comentario:",
                "Registro de Resena", JOptionPane.INFORMATION_MESSAGE);
        if (comment == null) return null;

        String dateStr = JOptionPane.showInputDialog(null,
                "Digite la fecha de la resena (dd/MM/yyyy):",
                "Registro de Resena", JOptionPane.INFORMATION_MESSAGE);
        Date reviewDate = parseDate(dateStr);

        int recOption = JOptionPane.showConfirmDialog(null,
                "Recomienda el juego?", "Registro de Resena", JOptionPane.YES_NO_OPTION);
        boolean recommended = (recOption == JOptionPane.YES_OPTION);

        return new Review(author, score, comment, reviewDate, recommended);
    }

    @Override
    protected boolean newRecord(Review record) {
        if (this.findRecordById(record.getId()) == null) {
            this.list.add(record);
            return true;
        }
        return false;
    }

    @Override
    protected Review findRecordById(int id) {
        for (Review review : this.list) {
            if (review.getId() == id) return review;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Review t) {
        for (Review review : this.list) {
            if (review.getId() == t.getId()) {
                if (t.getAuthor() != null) review.setAuthor(t.getAuthor());
                if (t.getComment() != null) review.setComment(t.getComment());
                if (t.getReviewDate() != null) review.setReviewDate(t.getReviewDate());
                review.setScore(t.getScore());
                review.setRecommended(t.isRecommended());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return this.list.removeIf(review -> review.getId() == id);
    }

    @Override
    protected String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Review review : this.list) {
            sb.append(review.toString()).append("\n");
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
