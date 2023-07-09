package br.ufsm.csi.back_flutter.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufsm.csi.back_flutter.model.Comanda;

public class ComandaDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    public ArrayList<Comanda> getComandas(){
        ArrayList<Comanda> comandas = new ArrayList<>();
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM COMANDAS";
            this.preparedStatement = con.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                Comanda coma = new Comanda();
                coma.setCodigo(this.resultSet.getInt("codigo"));
                coma.setNome(this.resultSet.getString("nome"));
                coma.setMesa(this.resultSet.getInt("mesa"));
                comandas.add(coma);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return comandas;
    }

    public Comanda getById(int id){
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM COMANDAS WHERE CODIGO = ?";
            this.preparedStatement = con.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                Comanda coma = new Comanda();
                coma.setCodigo(this.resultSet.getInt("codigo"));
                coma.setNome(this.resultSet.getString("nome"));
                coma.setMesa(this.resultSet.getInt("mesa"));
                return coma;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void addComanda(Comanda comanda){
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO COMANDA (NOME, MESA) values (?, ?)";
            this.preparedStatement = con.prepareStatement(this.sql);
            this.preparedStatement.setString(1, comanda.getNome());
            this.preparedStatement.setInt(2, comanda.getMesa());
            this.preparedStatement.execute();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateComanda(Comanda comanda, int id){
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "UPDATE COMANDA SET NOME = ?, MESA = ? WHERE CODIGO = ?";
            this.preparedStatement = con.prepareStatement(this.sql);
            this.preparedStatement.setString(1, comanda.getNome());
            this.preparedStatement.setInt(2, comanda.getMesa());
            this.preparedStatement.setInt(3, id);
            this.preparedStatement.execute();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteComanda(int id){
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "UPDATE COMANDA SET ATIVO = false WHERE CODIGO = ?";
            this.preparedStatement = con.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
