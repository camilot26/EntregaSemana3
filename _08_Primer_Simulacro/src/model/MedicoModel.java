package model;

import database.CRUD;
import database.ConfigDB;
import entity.Especialidad;
import entity.Medico;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class MedicoModel implements CRUD {

    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Medico objmedico = (Medico) obj;

        try {
            String sql = "INSERT INTO medico(nombre_medico,apellido_medico,id_especialidad) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objmedico.getNombre());
            objPrepare.setString(2, objmedico.getApellidos());
            objPrepare.setInt(3, objmedico.getIdEspecialidad());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objmedico.setId_medico(objResult.getInt(1));

            }

            JOptionPane.showMessageDialog(null, "Especialidad Creada Satisfactoriamente");


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        ConfigDB.closeConnection();
        return objmedico;
    }

    @Override
    public List<Object> findAll() {

        List<Object> result = new ArrayList<Object>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM medico;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                Medico objMedico = new Medico();
                objMedico.setId_medico(objResult.getInt("id_medico"));
                objMedico.setNombre(objResult.getString("nombre_medico"));
                objMedico.setApellidos(objResult.getString("apellido_medico"));
                objMedico.setIdEspecialidad(objResult.getInt("id_especialidad"));
                result.add(objMedico);
            }

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, error.getMessage());

        }

        ConfigDB.closeConnection();
        return result;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) obj;
        boolean isUpdate = false;
        try {
            String sql = "UPDATE medico SET nombre_medico=?, apellido_medico=?,id_especialidad=? where id_medico=?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objMedico.getNombre());
            objPrepare.setString(2, objMedico.getApellidos());
            objPrepare.setInt(3, objMedico.getIdEspecialidad());
            objPrepare.setInt(4, objMedico.getId_medico());
            int affected = objPrepare.executeUpdate();
            if (affected > 0) {

                isUpdate = true;
                JOptionPane.showMessageDialog(null, "La informacion del medico ha sido actualizada correctamente");

            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();

        }


        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {


        Connection objConnection = ConfigDB.openConnection();
        Medico objMedico = (Medico) obj;
        boolean isDeleted = false;
        try {
        String sql="delete from medico where id_medico=?;";
        PreparedStatement objPrepare=objConnection.prepareStatement(sql);
        objPrepare.setInt(1,objMedico.getId_medico());
        int affected=objPrepare.executeUpdate();
        if(affected>0){
            isDeleted=true;
            JOptionPane.showMessageDialog(null, "El medico ha sido eliminado correctamente");
        }




        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();

        }


        return false;
    }

    public Medico findById(int id) {

        Connection objConnection = ConfigDB.openConnection();

        Medico objmedico = null;

        try {

            String sql = "SELECT * FROM medico WHERE id_medico = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult = objPrepare.executeQuery();

            if (objResult.next()) {
                objmedico = new Medico();
                objmedico.setNombre(objResult.getString("nombre_medico"));
                objmedico.setApellidos(objResult.getString("apellido_medico"));
                objmedico.setId_medico(objResult.getInt("id_medico"));
                objmedico.setIdEspecialidad(objResult.getInt("id_especialidad"));

            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }

        ConfigDB.closeConnection();
        return objmedico;
    }


}
