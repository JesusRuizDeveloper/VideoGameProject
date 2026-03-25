package co.edu.uptc.cruds.data;


import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.BaseClass;

public abstract class AbstractCrud <T extends BaseClass> {
	private String nameEntity;
	
	public AbstractCrud(String nameEntity) {
		this.nameEntity = nameEntity;
	}
	
	public void menu() {
		boolean flag = true;
		while(flag) {
			int operacion = Integer.parseInt(JOptionPane.showInputDialog(
		            null, 
		            "[1] Crear "+ this.nameEntity + "\n[2] Buscar " + this.nameEntity 
					+ "\n[3] Actualizar " + this.nameEntity + "\n[4] Eliminar " + this.nameEntity + 
					"\n[5] Salir al menú principal", 
		            String.format(" ------- MENU DE %s -------", nameEntity.toUpperCase()), 
		            JOptionPane.INFORMATION_MESSAGE
		        ));
			switch(operacion) {
			case 1:
				T recordCreate = this.createInstance();
				if(this.newRecord(recordCreate)) {
					JOptionPane.showMessageDialog(null, "Se agregó el registro", 
							"Creación del registro", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "No se agregó el registro", 
							"Creación del registro", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 2:
				int idFind = Integer.parseInt(JOptionPane.showInputDialog(
			            null, 
			            "Digite el identificador del registro: ", 
			            String.format("Búsqueda de %s", this.nameEntity), 
			            JOptionPane.INFORMATION_MESSAGE ));
				T record = this.findRecordById(idFind);
				if(record != null) {
					JOptionPane.showMessageDialog(null, 
							"El producto encontrado fue: " + record, 
							String.format("Búsqueda de %s", this.nameEntity), 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "El registro no fue encontrado", 
							String.format("Búsqueda de %s", this.nameEntity), 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 3:
				int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(
			            null, 
			            "Digite el identificador del registro: ", 
			            String.format("Actualización de %s", this.nameEntity), 
			            JOptionPane.INFORMATION_MESSAGE ));
				T recordUpdate = this.findRecordById(idUpdate);
				if(recordUpdate != null) {
					T newRecord = createInstance();
					newRecord.setId(idUpdate);
					if(this.updateRecord(newRecord)) {
						JOptionPane.showMessageDialog(null, 
								"El producto fue actualizado", 
								String.format("Actualización de %s", this.nameEntity), 
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, 
								"El producto no fue actualizado", 
								String.format("Actualización de %s", this.nameEntity), 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, 
							"El registro no exite", 
							String.format("Actualización de %s", this.nameEntity), 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 4:
				int idDelete = Integer.parseInt(JOptionPane.showInputDialog(
			            null, 
			            "Digite el identificador del registro: ", 
			            String.format("Eliminación de %s", this.nameEntity), 
			            JOptionPane.INFORMATION_MESSAGE ));
				if(this.deleteRecord(idDelete)) {
					JOptionPane.showMessageDialog(null, 
							"Se pudo realizar la operación de eliminación con éxito.", 
							String.format("Eliminación de %s", this.nameEntity), JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, 
							"No se pudo eliminar el registro ya que no existe.", 
							String.format("Eliminación de %s", this.nameEntity), 
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}
	protected abstract boolean newRecord(T record);
	protected abstract T findRecordById(int id);
	protected abstract boolean updateRecord(T t);
	protected abstract T createInstance();
	protected abstract boolean deleteRecord(int id);
}
