package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.CRUD;
import database.ConfigDB;
import entity.Avion;

public class AvionModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objconection = ConfigDB.openConnection();
        Avion objavion = (Avion) obj;
        try {
            String sql = "INSERT INTO avion(modelo,capacidad) values(?,?);";
            PreparedStatement objprepare = objconection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objprepare.setString(1, objavion.getModelo());
            objprepare.setInt(2, objavion.getCapacidad());
            objprepare.execute();
            ResultSet objresult = objprepare.getGeneratedKeys();
            while (objresult.next()) {
                objavion.setId_avion(objresult.getInt(1));


            }
            JOptionPane.showMessageDialog(null, "se ha creado correctamente el avion");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return objavion;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listAvion = new ArrayList<Object>();
        Connection objconection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM avion;";
            PreparedStatement objprepare = objconection.prepareStatement(sql);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Avion objavion = new Avion();
                objavion.setId_avion(objresult.getInt(1));
                objavion.setModelo(objresult.getString(2));
                objavion.setCapacidad(objresult.getInt(3));
                listAvion.add(objavion);
            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            ConfigDB.closeConnection();
        }

        return listAvion;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Avion objavion = (Avion) obj;
        boolean Isuptaded = false;
        try {
            String sql = "update avion set modelo=?, set capacidad=? where id_avion?";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, objavion.getModelo());
            objprepare.setInt(2, objavion.getCapacidad());
            objprepare.setInt(3, objavion.getId_avion());
            int totalArrow = objprepare.executeUpdate();
            if (totalArrow > 0) {
                JOptionPane.showMessageDialog(null, "se ha actualizado correctamente la informacion del avion");
                Isuptaded = true;
            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return Isuptaded;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Avion objavion=(Avion) obj;
        try {
            String sql= "delete from avion where id_avion=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, objavion.getId_avion());
            int totalArrow = objprepare.executeUpdate();
            if (totalArrow > 0) {
                JOptionPane.showMessageDialog(null, "se ha eliminado correctamente el avion");
                return true;
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally {
            ConfigDB.closeConnection();
        }






        return false;
    }

    public Avion findbyId(int id) {
        Connection objconn = ConfigDB.openConnection();
        Avion objAvion = null;
        try {
            String sql = "select * from avion where id_avion=?;";
            PreparedStatement objprepare = objconn.prepareStatement(sql);
            objprepare.setInt(1, id);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                objAvion = new Avion();
                objAvion.setId_avion(objresult.getInt(1));
                objAvion.setModelo(objresult.getString(2));
                objAvion.setCapacidad(objresult.getInt(3));
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


        }
            ConfigDB.closeConnection();


        return objAvion;
    }


}
