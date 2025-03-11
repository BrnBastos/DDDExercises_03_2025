package Exercise2;

public class SistemaRestaurante {
    public static void main(String[] args) {
        // Criando pratos
        Prato prato1 = new Prato("Hamburguer", 25.0, "Hamburguer artesanal");
        Prato prato2 = new Prato("Pizza", 45.0, "Pizza de calabresa");
        Prato prato3 = new Prato("Salada", 20.0, "Salada fresca com molhos");

        // Criando pedido
        Pedido pedido = new Pedido(1, "João");

        // Adicionando pratos ao pedido
        pedido.adicionarPrato(prato1);
        pedido.adicionarPrato(prato2);
        pedido.adicionarPrato(prato3);

        // Exibindo detalhes do pedido
        pedido.exibirDetalhes();

        // Removendo um prato
        pedido.removerPrato(prato1);

        // Exibindo detalhes atualizados
        pedido.exibirDetalhes();
    }
}

