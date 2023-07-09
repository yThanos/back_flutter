package br.ufsm.csi.back_flutter.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufsm.csi.back_flutter.model.Pedido;

public class PedidoDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    public ArrayList<Pedido> getPedidos(){
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try(Connection con = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM PEDIDOS";
        } catch(Exception e){
            e.printStackTrace();
        }
        return pedidos;
    }
}
