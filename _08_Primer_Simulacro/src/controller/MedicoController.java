package controller;

import entity.Medico;
import entity.Especialidad;
import model.MedicoModel;
import model.EspecialidadModel;
import controller.EspecialidadController;

import javax.swing.*;


public class MedicoController {
    public static void create() {

        MedicoModel m = new MedicoModel();

        String name = JOptionPane.showInputDialog("Ingrese el nombre del medico");
        String lastName = JOptionPane.showInputDialog("Ingrese apellidos del medico");
        EspecialidadController.getAll();
        int idEspecialidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la especialidad"));
        Medico objMedico = new Medico();
        objMedico.setNombre(name);
        objMedico.setApellidos(lastName);
        objMedico.setIdEspecialidad(idEspecialidad);
        objMedico = (Medico) m.insert(objMedico);
        JOptionPane.showMessageDialog(null, objMedico.toString());


    }

    public static void getAll() {


        MedicoModel m = new MedicoModel();

        String listMedicos = "LISTA DE MEDICOS \n";
        for (Object medico : m.findAll()) {

            Medico objMedico = (Medico) medico;
            listMedicos += objMedico.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, listMedicos);
    }

    public static void update() {

        MedicoModel m = new MedicoModel();
        String listMedicos = getAllString();
        String listEspecialidad = EspecialidadController.getAllString();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico que desea editar"));
        Medico objmedico = m.findById(idUpdate);
        if (objmedico == null) {
            JOptionPane.showMessageDialog(null, "No se encontro el medico");
        } else {
            String nombre = JOptionPane.showInputDialog(null, "ingrese el nombre a cambiar ", objmedico.getNombre());
            String apellidos = JOptionPane.showInputDialog(null, "ingrese apellidos a cambiar ", objmedico.getApellidos());
            int id_especialidad = Integer.parseInt(JOptionPane.showInputDialog(null, listEspecialidad + "\n ingrese el id a modificar", objmedico.getIdEspecialidad()));
            objmedico.setNombre(nombre);
            objmedico.setApellidos(apellidos);
            objmedico.setIdEspecialidad(id_especialidad);
            m.update(objmedico);
            JOptionPane.showMessageDialog(null, objmedico.toString());

        }
    }

    public static String getAllString() {

        MedicoModel objmodel = new MedicoModel();
        String listMedicos = "LISTAS DE MEDICO \n";

        for (Object medico : objmodel.findAll()) {
            Medico objmedico = (Medico) medico;
            listMedicos += objmedico.toString() + "\n";
        }

        return listMedicos;
    }
    public static void delete(){

        MedicoModel model = new MedicoModel();

        String listmedicos = getAllString();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(listmedicos+"\n ingresa el id del medico que desea eliminar"));

        Medico objmedico = model.findById(idDelete);

        int confirm = 1;

        if (objmedico== null){
            JOptionPane.showMessageDialog(null,"No se encontro el id del medico");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar esta especialidad?\nEsta accion no se puede deshacer");

            if (confirm == 0) model.delete(objmedico);
        }

    }




}
