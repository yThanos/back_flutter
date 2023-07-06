package br.ufsm.csi.back_flutter.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufsm.csi.back_flutter.db.ProdutoDAO;
import br.ufsm.csi.back_flutter.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @PostMapping
    public void cadastrarProduto(@RequestBody Produto produto) {
        new ProdutoDAO().addProduto(produto);
    }

    @GetMapping
    public ArrayList<Produto> getProdutos() {
        return new ProdutoDAO().getProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable int id) {
        return new ProdutoDAO().getById(id);
    }
}
