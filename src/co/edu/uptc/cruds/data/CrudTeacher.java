package co.edu.uptc.cruds.data;

import co.edu.uptc.cruds.model.Teacher;

public class CrudTeacher extends AbstractCrud<Teacher> {

	public CrudTeacher() {
		super("Teacher");
	}

	@Override
	public boolean newRecord(Teacher record) {
		System.out.println("Agregar registro de profesor");
		System.out.println("Ingrese el codigo del profesor:");
		return false;
	}

	@Override
	public Teacher findRecordById(int id) {
		System.out.println("Buscar registro de profesor");
		return null;
	}

	@Override
	public boolean updateRecord(Teacher t) {
		System.out.println("Actualizar registro de profesor");
		return false;
	}

	@Override
	public Teacher createInstance() {
		System.out.println("Nuevo registro a actualizar");
		return null;
	}

	@Override
	public boolean deleteRecord(int id) {
		System.out.println("Eliminar registro");
		return false;
	}

}
