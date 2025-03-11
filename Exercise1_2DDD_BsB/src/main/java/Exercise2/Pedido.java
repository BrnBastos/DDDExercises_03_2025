package Exercise2;
import java.util.ArrayList;
import java.util.List;

class Pedido {
    private int numeroPedido;
    private String cliente;
    private List<Prato> listaDePratos;

    public Pedido(int numeroPedido, String cliente) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.listaDePratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        if (prato != null) {
            listaDePratos.add(prato);
            System.out.println("Prato adicionado: " + prato.getNome());
        } else {
            System.out.println("Prato inválido!");
        }
    }

    public void removerPrato(Prato prato) {
        if (listaDePratos.remove(prato)) {
            System.out.println("Prato removido: " + prato.getNome());
        } else {
            System.out.println("Prato não encontrado no pedido.");
        }
    }

    public double calcularTotal() {
        return listaDePratos.stream().mapToDouble(Prato::getPreco).sum();
    }

    public void exibirDetalhes() {
        System.out.println("\nPedido #" + numeroPedido + " - Cliente: " + cliente);
        if (listaDePratos.isEmpty()) {
            System.out.println("Nenhum prato no pedido.");
        } else {
            listaDePratos.forEach(System.out::println);
            System.out.printf("Total: R$ %.2f\n", calcularTotal());
        }
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Prato> getListaDePratos() {
        return new ArrayList<>(listaDePratos);
    }
}

