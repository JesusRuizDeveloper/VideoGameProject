package co.edu.uptc.cruds.view;

import javax.swing.JOptionPane;

import co.edu.uptc.cruds.data.CrudVideoGame;
import co.edu.uptc.cruds.data.CrudDLC;
import co.edu.uptc.cruds.data.CrudDeveloper;
import co.edu.uptc.cruds.data.CrudGenre;
import co.edu.uptc.cruds.data.CrudReview;

public class MainView {
    public static void main(String[] args) {
        CrudVideoGame videoGameRepository = new CrudVideoGame();
        CrudDLC dlcRepository = new CrudDLC();
        CrudDeveloper developerRepository = new CrudDeveloper();
        CrudGenre genreRepository = new CrudGenre();
        CrudReview reviewRepository = new CrudReview();

        boolean flag = true;
        while (flag) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "[1] Gestionar Videojuegos\n" +
                    "[2] Gestionar DLCs\n" +
                    "[3] Gestionar Desarrolladores\n" +
                    "[4] Gestionar Generos\n" +
                    "[5] Gestionar Resenas\n" +
                    "[6] Salir",
                    "MENU PRINCIPAL - SISTEMA DE VIDEOJUEGOS",
                    JOptionPane.INFORMATION_MESSAGE);

            if (input == null) {
                flag = false;
                break;
            }

            int option = Integer.parseInt(input);

            switch (option) {
                case 1:
                    videoGameRepository.menu();
                    break;
                case 2:
                    dlcRepository.menu();
                    break;
                case 3:
                    developerRepository.menu();
                    break;
                case 4:
                    genreRepository.menu();
                    break;
                case 5:
                    reviewRepository.menu();
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }
    }
}
