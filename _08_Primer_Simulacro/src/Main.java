import controller.EspecialidadController;
import controller.MedicoController;
import database.ConfigDB;
import entity.Especialidad;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String option = "";
        String option2 = "";

        do {

            option = JOptionPane.showInputDialog("""
                    1. Gestionar Especialidades
                    2. Gestionar Medicos
                    3. Gestionar Pacientes
                    4. Gestionar Citas
                    5. Salir
                    """);

            switch (option){

                case "1":
                    do {

                        option2 = JOptionPane.showInputDialog("""
                                1. Crear Especialidad
                                2. Mostrar Especialidades
                                3. Editar Especialidad
                                4. Eliminar Especialidad
                                5. Salir
                                """);

                        switch (option2){

                            case "1":
                                EspecialidadController.create();
                                break;
                            case "2":
                                EspecialidadController.getAll();
                                break;
                            case "3":
                                EspecialidadController.update();
                                break;
                            case "4":
                                EspecialidadController.delete();
                                break;

                        }

                    }while(!option2.equals("5"));

                break;
            case "2":
                option2 = JOptionPane.showInputDialog("""
                                1. Crear Medico
                                2. Mostrar Medico
                                3. Editar Medico
                                4. Eliminar Medico
                                5. Salir
                                """);

                switch (option2){

                    case "1":
                        MedicoController.create();
                        break;
                    case "2":
                        MedicoController.getAll();
                        break;
                    case "3":
                        MedicoController.update();
                        break;
                    case "4":
                        MedicoController.delete();
                        break;

                }
            }

        } while (!option.equals("5"));

    }
}