package co.edu.uptc.cruds.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Review extends BaseClass {
    private static int counter = 0;
    private String author;
    private int score;
    private String comment;
    private Date reviewDate;
    private boolean recommended;

    public Review() {
    }

    public Review(String author, int score, String comment, Date reviewDate, boolean recommended) {
        this.author = author;
        this.score = score;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.recommended = recommended;
        this.id = ++counter;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = (reviewDate != null) ? sdf.format(reviewDate) : "N/A";
        return "ID: " + id + " | Autor: " + author + " | Puntuacion: " + score +
                "/10 | Comentario: " + comment + " | Fecha: " + date +
                " | Recomendado: " + (recommended ? "Si" : "No");
    }
}
