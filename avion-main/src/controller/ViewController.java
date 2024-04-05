package controller;
import controller.AvionController;
import controller.VuelosController;
import javax.swing.*;

public class ViewController {
    public static void create(){


            String opcion=JOptionPane.showInputDialog("""
                    --Bienvenido a Create--
                    1.Gestionar Aviones
                    2.Gestionar Vuelos
                    3.Gestionar Reservas
                     
                    """);

            switch(opcion){

                case "1":
                    AvionController.create();
                    break;
                case "2":
                    VuelosController.create();
                    break;
                case "3":

                    break;


            }








    }
    public static void findAll(){

        String opcion=JOptionPane.showInputDialog("""
                  --Bienvenido a Create--
                    1.Gestionar Aviones
                    2.Gestionar Vuelos
                    3.Gestionar Reservas
                """);
            switch(opcion){
                case "1":
                    AvionController.findAll();
                    break;
                case "2":
                    String opcion1=JOptionPane.showInputDialog("""
                    1.Buscar todos los vuelos
                    2.Buscar los vuelos por el nombre
                    
                    """);
                    switch(opcion1){
                        case "1":
                            VuelosController.findAll();
                            break;
                        case "2":
                            VuelosController.findAllName();
                            break;
                    }
                    break;

            }
    }
    public static void update(){
        String opcion=JOptionPane.showInputDialog("""
                --Bienvenido a Update--
                1.Gestionar Aviones
                2.Gestionar Vuelos
                3.Gestionar Reservas
                """);
        switch(opcion){
            case "1":
                AvionController.update();
                break;
            case "2":
                VuelosController.update();
                break;
            case "3":
            break;

        }
    }
    public static void delete(){
        String opcion=JOptionPane.showInputDialog("""
                --Bienvenido a Delete--
                1.Gestionar Aviones
                2.Gestionar Vuelos
                3.Gestionar Reservas
                """);
        switch (opcion){
            case "1":
                AvionController.delete();
                break;
            case "2":
                VuelosController.delete();
                break;
            case "3":
            break;

        }
    }

}
