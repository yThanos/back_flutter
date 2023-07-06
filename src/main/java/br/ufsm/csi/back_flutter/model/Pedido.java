package br.ufsm.csi.back_flutter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
    private int codigo;
    private int codigoComanda;
    private int codigoProduto;
    private int quantidade;
}
