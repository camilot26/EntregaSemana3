package model;

import database.CRUD;
import database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Vuelo;

public class VueloModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vuelo objVuelo = (Vuelo) obj;
        try {
            String sql = "INSERT INTO vuelo(destino,fecha_salida,hora_salida,id_avion)values (?,?,?,?);";
            PreparedStatement objprepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objprepare.setString(1, objVuelo.getDestino());
            objprepare.setString(2, objVuelo.getFecha_salida());
            objprepare.setString(3, objVuelo.getHora_salida());
            objprepare.setInt(4, objVuelo.getId_avion());
            objprepare.execute();
            ResultSet objresult = objprepare.getGeneratedKeys();
            while (objresult.next()) {
                objVuelo.setId_vuelo(objresult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "se ha asignado el vuelo correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }


        return objVuelo;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listVuelo = new ArrayList<Object>();
        Connection objconection = ConfigDB.openConnection();
        try {
            String sql = "select * from vuelo;";
            PreparedStatement objprepare = objconection.prepareStatement(sql);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Vuelo objVuelo = new Vuelo();
                objVuelo.setId_vuelo(objresult.getInt(1));
                objVuelo.setDestino(objresult.getString(2));
                objVuelo.setFecha_salida(objresult.getString(3));
                objVuelo.setHora_salida(objresult.getString(4));
                objVuelo.setId_avion(objresult.getInt(5));
                listVuelo.add(objVuelo);

            }


        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }

        return listVuelo;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vuelo objVuelo = (Vuelo) obj;
        boolean update = false;

        try {

            String sql = "UPDATE vuelo set destino=?, fecha_salida=?,hora_salida=?,id_avion=?";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, objVuelo.getDestino());
            objprepare.setString(2, objVuelo.getFecha_salida());
            objprepare.setString(3, objVuelo.getHora_salida());
            objprepare.setInt(4, objVuelo.getId_avion());
            int totalarrow = objprepare.executeUpdate();
            if (totalarrow == 0) {
                update = true;
                JOptionPane.showMessageDialog(null, "se actualizo la informacion del vuelo");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        return update;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vuelo objVuelo = (Vuelo) obj;
        boolean delete = false;
        try {
            String sql = "delete from vuelo where id_vuelo=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, objVuelo.getId_vuelo());
            int totalarrow = objprepare.executeUpdate();
            if (totalarrow > 0) {
                delete = true;
                JOptionPane.showMessageDialog(null, "se ha eliminado el vuelo correctamente");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


        } finally {
            ConfigDB.closeConnection();
        }


        return delete;
    }

    public List<Object> findAllName(String destino) {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaNombre = new ArrayList<>();
        try {
            String sql = "select * from vuelo where destino like ?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setString(1, "%" + destino + "%");
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                Vuelo objvuelo = new Vuelo();
                objvuelo.setId_vuelo(objresult.getInt(1));
                objvuelo.setDestino(objresult.getString(2));
                objvuelo.setFecha_salida(objresult.getString(3));
                objvuelo.setHora_salida(objresult.getString(4));
                objvuelo.setId_avion(objresult.getInt(5));
                listaNombre.add(objvuelo);


            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }


        return listaNombre;
    }

    public Vuelo findbyId(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Vuelo objVuelo = null;
        try {
            String sql = "select * from vuelo where id_vuelo=?;";
            PreparedStatement objprepare = objConnection.prepareStatement(sql);
            objprepare.setInt(1, id);
            ResultSet objresult = objprepare.executeQuery();
            while (objresult.next()) {
                objVuelo = new Vuelo();
                objVuelo.setId_vuelo(objresult.getInt(1));
                objVuelo.setDestino(objresult.getString(2));
                objVuelo.setFecha_salida(objresult.getString(3));
                objVuelo.setHora_salida(objresult.getString(4));
                objVuelo.setId_avion(objresult.getInt(5));
            }
        }catch (Exception e){

            JOptionPane.showMessageDialog(null,e.getMessage());

        }finally {
            ConfigDB.closeConnection();
        }
        return objVuelo;
    }
}
