package co.edu.uptc.cruds.data;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.BaseClass;

public abstract class AbstractCrud<T extends BaseClass> {
    private String nameEntity;

    public AbstractCrud(String nameEntity) {
        this.nameEntity = nameEntity;
    }

    public void menu() {
        boolean flag = true;
        while (flag) {
            String input = JOptionPane.showInputDialog(
                    null,
                    "[1] Crear " + this.nameEntity +
                    "\n[2] Buscar " + this.nameEntity +
                    "\n[3] Actualizar " + this.nameEntity +
                    "\n[4] Eliminar " + this.nameEntity +
                    "\n[5] Listar todos" +
                    "\n[6] Salir al menu principal",
                    String.format(" ------- MENU DE %s -------", nameEntity.toUpperCase()),
                    JOptionPane.INFORMATION_MESSAGE);

            if (input == null) {
                flag = false;
                break;
            }

            int operacion = Integer.parseInt(input);

            switch (operacion) {
                case 1:
                    T recordCreate = this.createInstance();
                    if (recordCreate != null && this.newRecord(recordCreate)) {
                        JOptionPane.showMessageDialog(null, "Se agrego el registro exitosamente.",
                                "Creacion del registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo agregar el registro.",
                                "Creacion del registro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    String idFindStr = JOptionPane.showInputDialog(null,
                            "Digite el ID del registro:",
                            String.format("Busqueda de %s", this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE);
                    if (idFindStr != null) {
                        int idFind = Integer.parseInt(idFindStr);
                        T record = this.findRecordById(idFind);
                        if (record != null) {
                            JOptionPane.showMessageDialog(null,
                                    "Registro encontrado:\n" + record,
                                    String.format("Busqueda de %s", this.nameEntity),
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El registro no fue encontrado.",
                                    String.format("Busqueda de %s", this.nameEntity),
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 3:
                    String idUpdateStr = JOptionPane.showInputDialog(null,
                            "Digite el ID del registro a actualizar:",
                            String.format("Actualizacion de %s", this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE);
                    if (idUpdateStr != null) {
                        int idUpdate = Integer.parseInt(idUpdateStr);
                        T recordUpdate = this.findRecordById(idUpdate);
                        if (recordUpdate != null) {
                            T newRecord = createInstance();
                            if (newRecord != null) {
                                newRecord.setId(idUpdate);
                                if (this.updateRecord(newRecord)) {
                                    JOptionPane.showMessageDialog(null,
                                            "El registro fue actualizado exitosamente.",
                                            String.format("Actualizacion de %s", this.nameEntity),
                                            JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "No se pudo actualizar el registro.",
                                            String.format("Actualizacion de %s", this.nameEntity),
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "El registro no existe.",
                                    String.format("Actualizacion de %s", this.nameEntity),
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 4:
                    String idDeleteStr = JOptionPane.showInputDialog(null,
                            "Digite el ID del registro a eliminar:",
                            String.format("Eliminacion de %s", this.nameEntity),
                            JOptionPane.INFORMATION_MESSAGE);
                    if (idDeleteStr != null) {
                        int idDelete = Integer.parseInt(idDeleteStr);
                        if (this.deleteRecord(idDelete)) {
                            JOptionPane.showMessageDialog(null,
                                    "Registro eliminado exitosamente.",
                                    String.format("Eliminacion de %s", this.nameEntity),
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo eliminar, el registro no existe.",
                                    String.format("Eliminacion de %s", this.nameEntity),
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;
                case 5:
                    String allRecords = this.listAll();
                    if (allRecords.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay registros.",
                                String.format("Lista de %s", this.nameEntity),
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, allRecords,
                                String.format("Lista de %s", this.nameEntity),
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                case 6:
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
    protected abstract String listAll();
}
