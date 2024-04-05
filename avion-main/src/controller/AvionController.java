package controller;

import model.AvionModel;
import entity.Avion;

import javax.swing.*;

public class AvionController {


    public static void create() {
        AvionModel objavion = new AvionModel();
        String modelo = JOptionPane.showInputDialog("Ingrese el nombre del modelo del avion");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad del avion"));
        Avion avion = new Avion();
        avion.setCapacidad(capacidad);
        avion.setModelo(modelo);
        avion = (Avion) objavion.insert(avion);
        JOptionPane.showMessageDialog(null, avion.toString());

    }

    public static void findAll() {
        AvionModel objavion = new AvionModel();
        String ListAvion = "lista de aviones \n";
        for (Object avion : objavion.findAll()) {
            Avion obj = (Avion) avion;
            ListAvion = ListAvion + obj.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, ListAvion);
    }

    public static String getAllstring() {
        AvionModel objavion = new AvionModel();
        String ListAvion = "lista de aviones \n";
        for (Object avion : objavion.findAll()) {
            Avion obj = (Avion) avion;
            ListAvion = ListAvion + obj.toString() + "\n";

        }
        return ListAvion;


    }

    public static void update() {
        AvionModel objavionmodel = new AvionModel();
        String listaviones = getAllstring();
        int idUpdat = Integer.parseInt(JOptionPane.showInputDialog(listaviones + "ingresa el id del avion a modificar"));
        Avion objAvion = objavionmodel.findbyId(idUpdat);
        if (objAvion == null) {
            JOptionPane.showMessageDialog(null, "no se encontra el avion");
        } else {
            String modelo = JOptionPane.showInputDialog("Ingrese el nuevo modelo del avion", objAvion.getModelo());
            int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva capacidad del avion", objAvion.getCapacidad()));
            objAvion.setModelo(modelo);
            objAvion.setCapacidad(capacidad);
            objavionmodel.update(objAvion);


        }


    }

    public static void delete() {

        AvionModel avionModel = new AvionModel();
        String listaviones = getAllstring();
        int idUpdat = Integer.parseInt(JOptionPane.showInputDialog(listaviones + "ingresa el id del avion a modificar"));
        Avion objAvion = avionModel.findbyId(idUpdat);
        int confirm=1;
        if (objAvion == null) {
            JOptionPane.showMessageDialog(null, "no se encontra el avion");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar esta especialidad?\nEsta accion no se puede deshacer");
            if(confirm ==0) {avionModel.delete(objAvion);}



        }


    }


}
