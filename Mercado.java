package Mercado;

import java.util.*;

public class Mercado {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<produtos> produtos;
    static Map<produtos, Integer> carrinho;

    static void main(String[] args) {
        produtos = new ArrayList<produtos>();
        carrinho = new HashMap<produtos, Integer>();

        Mercado.Menu();
    }

    public static void Menu() {
        System.out.println("=======================================");
        System.out.println("==============Bem vindo(a)=============");
        System.out.println("==============Avança shop==============");
        System.out.println("=======================================");

        System.out.println("\nSelecione uma opção abaixo: ");

        System.out.println("1 - Cadastrar um produto");
        System.out.println("2 - listar produtos");
        System.out.println("3 - Comprar produtos");
        System.out.println("4 - Visualizar carrinho");
        System.out.println("5 - Sair do sistema");

        int opcao = 0;

        try {
            opcao = Integer.parseInt(Mercado.sc.nextLine());
        } catch (InputMismatchException e) {
            Mercado.Menu();
        } catch (NumberFormatException f) {
            Mercado.Menu();
        }

        switch (opcao) {
            case 1:
                Mercado.CadastrarProduto();
                break;
            case 2:
                Mercado.ListarProduto();
                break;
            case 3:
                Mercado.ComprarProduto();
                break;
            case 4:
                Mercado.VisualizarCarrinho();
                break;
            case 5:
                System.out.println("Volte sempre!");
                Utilitarios.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção invalidada");
                Utilitarios.pausar(2);
                break;
        }
    }

    public static void CadastrarProduto() {
        System.out.println("Cadastrando produto...");
        System.out.println("======================");

        System.out.print("Informe o nome do produto: ");
        String nome = Mercado.sc.nextLine();

        System.out.print("Informe o preço do produto: ");
        double preco = Mercado.sc.nextDouble();

        produtos produto = new produtos(nome, preco);

        Mercado.produtos.add(produto);

        System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso");

        Utilitarios.pausar(2);
        Mercado.Menu();

    }

    public static void ListarProduto() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("listagem de produtos");

            for (produtos p : Mercado.produtos) {
                System.out.println(p);
                System.out.println();
            }
        } else {
            System.out.println("Ainda não temos produtos cadastrados");
        }
        Utilitarios.pausar(2);
        Mercado.Menu();
    }

    public static void ComprarProduto() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("Informe o codigo do produto desejado: ");
            System.out.println();
            System.out.println("======================================");
            for (produtos p : Mercado.produtos) {
                System.out.println("-------------------------------------");


            }
            int codigo = Integer.parseInt(Mercado.sc.nextLine());
            boolean TemProduto = false;

            for (produtos p : Mercado.produtos){
                if (p.getcodigo() == codigo){
                    int quantidade = 0;
                    try{
                        quantidade = Mercado.carrinho.get(p);
                        //verificar se tem produto disponivle e atualizar a quantidade
                        Mercado.carrinho.put(p, quantidade + 1);
                    }catch (NullPointerException e){
                        Mercado.carrinho.put(p, 1);
                    }
                    System.out.println("O produto" + p.getNome() + " foi adicionado ao carrinho");
                    TemProduto = true;
                }
                if (TemProduto){
                    System.out.println("Deseja adicionar mais produtos ao carrinho?: ");
                    System.out.println("informe 1 para sim, 0 para não");
                    int resposta = Integer.parseInt(Mercado.sc.nextLine());

                    if (resposta == 1){
                        Mercado.ComprarProduto();
                    }else{
                        Utilitarios.pausar(2);
                        Mercado.Menu();
                    }
                    }else{
                    System.out.println("O produto não consta no sistema");
                    Utilitarios.pausar(2);
                    Mercado.Menu();
                }
            }
        } else {
            System.out.println("Ainda não existe produtos cadastrados no mercado");
            Utilitarios.pausar(2);
            Mercado.Menu();
        }

    }

    public static void VisualizarCarrinho() {
        if (Mercado.carrinho.size() > 0) {
            System.out.println("Produtos no carrinho: ");

            for (produtos p : Mercado.carrinho.keySet()) {
                System.out.println("Produto " + p + " \nQuantidade" + Mercado.carrinho.get(p));

            }
        } else {
            System.out.println("Ainda não existem produtos no carrinho");
        }
        Utilitarios.pausar(2);
        Mercado.FecharProduto();
        Mercado.Menu();

    }
    public static void  FecharProduto(){
        Double ValorTotal = 0.0;
        System.out.println("Produtos do carrinho");
        System.out.println("====================");
        for (produtos p : Mercado.carrinho.keySet()){
            int quant = Mercado.carrinho.get(p);
            ValorTotal +=p.getPreco() * quant;
            System.out.println(p);
            System.out.println("Quantidade: " + quant);
            System.out.println("=====================");
        }

        System.out.println("O valor da sua fatura é " + Utilitarios.doubleParaString(ValorTotal));
        Mercado.carrinho.clear();
        System.out.println("Obrigado por sua preferencia");
        Utilitarios.pausar(5);

        Mercado.Menu();
    }
}
