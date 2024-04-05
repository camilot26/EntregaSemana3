package controller;

import model.VueloModel;
import entity.Vuelo;
import model.AvionModel;
import controller.AvionController;

import javax.swing.*;
import java.util.List;

public class VuelosController {

    public static void create() {
        VueloModel vuelo = new VueloModel();
        String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo");
        String fecha_salida = JOptionPane.showInputDialog("Ingrese la fecha de salida del vuelo");
        String hora_salida = JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo");
        String lista = AvionController.getAllstring();
        int id_avion = Integer.parseInt(JOptionPane.showInputDialog(lista + "ingresa el id del avion"));
        Vuelo Objvuelo = new Vuelo();
        Objvuelo.setDestino(destino);
        Objvuelo.setFecha_salida(fecha_salida);
        Objvuelo.setHora_salida(hora_salida);
        Objvuelo.setId_avion(id_avion);
        Objvuelo = (Vuelo) vuelo.insert(Objvuelo);
        JOptionPane.showMessageDialog(null, Objvuelo.toString());


    }

    public static void findAll() {
        VueloModel vuelo = new VueloModel();
        String ListVuelo = "lista de vuelos \n";
        for (Object vuelo1 : vuelo.findAll()) {
            Vuelo obj = (Vuelo) vuelo1;
            ListVuelo = ListVuelo + obj.toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, ListVuelo);
    }

    public static void findAllName() {
        VueloModel vuelo = new VueloModel();
        String ListVuelo = "lista de vuelos \n";
        String destino = JOptionPane.showInputDialog("Ingrese el destino de los vuelos a buscar");
        if (vuelo.findAllName(destino) == null) {
            JOptionPane.showMessageDialog(null, "no se encontra el vuelo");
        } else {
            for (Object iterador : vuelo.findAllName(destino)) {
                Vuelo objvuelo = (Vuelo) iterador;
                ListVuelo += objvuelo.toString() + "\n";


            }
            JOptionPane.showMessageDialog(null, ListVuelo);
        }


    }

    public static String getAllstring() {
        VueloModel vuelo = new VueloModel();
        String ListVuelo = "lista de vuelos \n";
        for (Object vuelo1 : vuelo.findAll()) {
            Vuelo obj = (Vuelo) vuelo1;
            ListVuelo += obj.toString() + "\n";

        }
        return ListVuelo;
    }

    public static void update() {
        VueloModel objvuelo = new VueloModel();
        String listaviones = getAllstring();
        int idUpdat = Integer.parseInt(JOptionPane.showInputDialog(listaviones + "ingresa el id del vuelo a modificar"));
        Vuelo objVuelo = objvuelo.findbyId(idUpdat);
        if (objVuelo == null) {
            JOptionPane.showMessageDialog(null, "no se encontra el vuelo");
        } else {
            String destino = JOptionPane.showInputDialog("Ingrese el destino del vuelo", objVuelo.getDestino());
            String fecha_salida = JOptionPane.showInputDialog("Ingrese la fecha de salida del vuelo", objVuelo.getFecha_salida());
            String hora_salida = JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo", objVuelo.getHora_salida());
            String lista = AvionController.getAllstring();
            int id_avion = Integer.parseInt(JOptionPane.showInputDialog(lista + "ingresa el id del avion a cambiar"));
            objVuelo.setDestino(destino);
            objVuelo.setFecha_salida(fecha_salida);
            objVuelo.setHora_salida(hora_salida);
            objVuelo.setId_avion(id_avion);
            objvuelo.update(objVuelo);


        }


    }
    public static void delete(){
        VueloModel objmodel= new VueloModel();
        String listaviones = getAllstring();
        int idUpdat = Integer.parseInt(JOptionPane.showInputDialog(listaviones + "ingresa el id del vuelo a modificar"));
        Vuelo objVuelo = objmodel.findbyId(idUpdat);
        int confirm=1;
        if (objVuelo == null) {
            JOptionPane.showMessageDialog(null, "no se encontra el vuelo");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar este vuelo?\nEsta accion no se puede deshacer");
            if(confirm ==0) {objmodel.delete(objVuelo);}
        }



    }


}
