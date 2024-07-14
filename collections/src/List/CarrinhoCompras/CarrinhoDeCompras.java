package List.CarrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinhoList;

    public CarrinhoDeCompras() {
        this.carrinhoList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinhoList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!carrinhoList.isEmpty()) {
        for (Item i : carrinhoList) {
            if (i.getNome().equalsIgnoreCase(nome)) {
            itensParaRemover.add(i);
            }
        }
        carrinhoList.removeAll(itensParaRemover);
        } else {
        System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!carrinhoList.isEmpty()) {
            for (Item i : carrinhoList) {
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            System.out.println("A lista está vazia!");
            return 0;
        }
    }

    public void exibirItens() {
        if (!carrinhoList.isEmpty()) {
          System.out.println(carrinhoList);
        } else {
          System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Produto 1", 20.49, 2);
        carrinhoDeCompras.adicionarItem("Produto 2", 9.99, 5);
        carrinhoDeCompras.adicionarItem("Produto 3", 14.99, 3);

        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total do carrinho é: " + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.removerItem("Produto 2");
        carrinhoDeCompras.exibirItens();
    }
    
}
