package Mercado;

public class produtos {
    private int codigo;
    private String nome;
    private double preco;
    private static int contador = 1;

    //construtor que recebe um nome e um preco e dentro dele o codigo recebe o valor do contador
    //depois o contador aumenta em 1
    public produtos(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = produtos.contador;
        produtos.contador++;
    }

    //get e set nome e preco
    public int getcodigo(){return this.codigo;}
    public String getNome(){return this.nome;}
    public double getPreco(){return this.preco;}
    public static int getContador() {return contador;}

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String toString(){
        return "código: " + this.getcodigo() +
                "\nnome: " + this.getNome() +
                "\npreço; " + Utilitarios.doubleParaString( this.getPreco());
    }

}
