package co.edu.uptc.cruds.data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import co.edu.uptc.cruds.model.Student;

public class CrudStudent extends AbstractCrud<Student>{
	
	private List<Student> listaStudent;
	public CrudStudent() {
		super("Student");
		this.listaStudent = new ArrayList<Student>();
	}

	@Override
	protected Student createInstance() {
		String nameStudent = JOptionPane.showInputDialog(
	            null, 
	            "Digite el nombre del estudiante : ", 
	            "Agregar registro de estudiante", 
	            JOptionPane.INFORMATION_MESSAGE );
		String id = JOptionPane.showInputDialog(
	            null, 
	            "Digite el número de identificación del estudiante : ", 
	            "Agregar registro de estudiante", 
	            JOptionPane.INFORMATION_MESSAGE );
		
		String code = JOptionPane.showInputDialog(
	            null, 
	            "Digite el código del estudiante: ", 
	            "Agregar registro de estudiante", 
	            JOptionPane.INFORMATION_MESSAGE );
		
		
		/* Fechas */
		JDateChooser dateChooser = new JDateChooser();
		int option = JOptionPane.showConfirmDialog(
			    null,
			    dateChooser,
			    "Seleccione una fecha",
			    JOptionPane.OK_CANCEL_OPTION
			);
		
		Date birthdate = null;
		if (option == JOptionPane.OK_OPTION) {
		    birthdate = dateChooser.getDate();
		    System.out.println(birthdate);
		}
		
		
		return new Student(nameStudent, id, code, birthdate);
	}
	
	@Override
	protected boolean newRecord(Student record) {
		if(this.findRecordById(record.getId()) == null) {
			this.listaStudent.add(record);
			return true;
		}
		return false;
	}

	@Override
	protected Student findRecordById(int id) {
		return this.listaStudent.stream().filter(s -> s.getId() == id)
				.findAny().orElse(null);
	}

	@Override
	protected boolean updateRecord(Student t) {
		for(Student student : this.listaStudent) {
			if(student.getId() == t.getId()) {
				if(t.getCode() != null) {
					student.setCode(t.getCode());
				}
				if(t.getName() != null) {
					student.setName(t.getName());
				}
				if(t.getNumberID() != null) {
					student.setNumberID(t.getNumberID());
				}
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean deleteRecord(int id) {
		return this.listaStudent.removeIf(student -> student.getId() == id);
	}

}
