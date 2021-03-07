package alef.apolinario.service;

import alef.apolinario.domain.entity.Pedido;
import alef.apolinario.domain.enums.StatusPedido;
import alef.apolinario.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );

    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
