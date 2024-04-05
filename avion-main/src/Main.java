import database.ConfigDB;
import controller.ViewController;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        String opcion1="";
        do {
           opcion1 = JOptionPane.showInputDialog("""
                    Ingrese una opcion:
                    1. Crear 
                    2. Modificar 
                    3. Eliminar 
                    4. Consultar
                    5. Salir
                    """);
            switch (opcion1) {
                case "1":
                    ViewController.create();

                    break;
                case "2":
                    ViewController.update();
                    break;
                case "3":
                    ViewController.delete();
                    break;
                case "4":
                    ViewController.findAll();
                    break;

            }


        } while(!opcion1.equals("5"));


    }
}

