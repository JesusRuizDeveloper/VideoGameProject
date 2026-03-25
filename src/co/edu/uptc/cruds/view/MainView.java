package co.edu.uptc.cruds.view;

import javax.swing.JOptionPane;

import co.edu.uptc.cruds.data.CrudStudent;
import co.edu.uptc.cruds.data.CrudTeacher;

public class MainView {
	public static void main(String[] args) {
		CrudTeacher teacherRepository = new CrudTeacher();
		CrudStudent studentRepository = new CrudStudent();
		boolean flag = true;
		while(flag) {
			
			int numberCrud = Integer.parseInt(JOptionPane.showInputDialog(
		            null, 
		            "[1] Crud de estudiantes\n[2] Crud de profesores\n[3] Salir", 
		            "MENU PRINCIPAL", 
		            JOptionPane.INFORMATION_MESSAGE
		        ));
			switch(numberCrud) {
			case 1:
				studentRepository.menu();
				break;
			case 2:
				teacherRepository.menu();
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}
}
