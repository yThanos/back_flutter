package br.ufsm.csi.back_flutter.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.ufsm.csi.back_flutter.model.Produto;

public class ProdutoDAO {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sql;

    public ArrayList<Produto> getProdutos(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try(Connection connection = ConectaDB.getConexao()){
            this.sql = "SELECT * FROM produto";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                Produto produto = Produto.builder()
                    .codigo(this.resultSet.getInt("codigo"))
                    .nome(this.resultSet.getString("nome"))
                    .valor(this.resultSet.getDouble("valor"))
                    .build();
                produtos.add(produto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return produtos;
    }

    public void addProduto(Produto produto){
        try(Connection connection = ConectaDB.getConexao()){
            this.sql = "INSERT INTO produto (nome, valor) VALUES (?, ?)";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, produto.getNome());
            this.preparedStatement.setDouble(2, produto.getValor());
            this.preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Produto getById(int id){
        Produto produto = null;
        try(Connection connection = ConectaDB.getConexao()){
            this.sql = "SELECT * FROM produto WHERE codigo = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            while(this.resultSet.next()){
                produto = Produto.builder()
                    .codigo(this.resultSet.getInt("codigo"))
                    .nome(this.resultSet.getString("nome"))
                    .valor(this.resultSet.getDouble("valor"))
                    .build();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return produto;
    }
}
