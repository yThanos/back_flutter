package br.ufsm.csi.back_flutter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comanda {
    private int codigo;
    private String nome;
    private int mesa;
}
