package Saraiva;

import Produtos.Filmes;
import Produtos.Livros;
import abstratas.ServicoDeVendas;
import interfaces.Produto;
import interfaces.Site;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ELIETE
 */
public class Saraiva extends ServicoDeVendas implements Site {

    protected enum PREMIOS {

        LIVRO, DESCONTO, CARRO, VIAGEM, NAO_FOI_DESTA_VEZ
    };
    private static final String CNPJ = "xxxxxxx-xxxxxxx-xxxxxx-xx";
    private static ArrayList<Produto> produtos;
    private static int quantidadedeprodutos;
    private PREMIOS premio;
    private int numerodecompras;

    public Saraiva(PREMIOS premio, int numerodecompras) {
        this.premio = premio;
        this.numerodecompras = numerodecompras;

    }

    public Saraiva() {
        this.premio = PREMIOS.NAO_FOI_DESTA_VEZ;
        this.numerodecompras = 0;
        quantidadedeprodutos = 0;
        produtos = new ArrayList<>();
    }
    
    public Saraiva(Saraiva s){
        this.lembretesDeCompras=s.lembretesDeCompras;
        this.numerodecompras=s.numerodecompras;
        this.premio=s.premio;
    }

    public static ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(ArrayList<Produto> produtos) {
        Saraiva.produtos = produtos;
    }

    public static int getQuantidadedeprodutos() {
        return quantidadedeprodutos;
    }

    public static void setQuantidadedeprodutos(int quantidadedeprodutos) {
        Saraiva.quantidadedeprodutos = quantidadedeprodutos;
    }

    public PREMIOS getPremio() {
        return premio;
    }

    public void setPremio(PREMIOS premio) {
        this.premio = premio;
    }

    public int getNumerodecompras() {
        return numerodecompras;
    }

    public void setNumerodecompras(int numerodecompras) {
        this.numerodecompras = numerodecompras;
    }

    @Override
    public String toString() {
        return "Saraiva{" + "premio=" + premio + ", numerodecompras=" + numerodecompras + '}';
    }

    //funções uteis 
    public void addProduto() {
        boolean esc;
        Scanner in = new Scanner(System.in);
        Produto prod = null;
        do {
            System.out.println("qual o produto a ser adicionado ??\n"
                    + "1- livro\n"
                    + "2- filme:");
            switch (in.nextInt()) {
                case 1:
                    prod = new Livros();
                    esc = false;
                    break;
                case 2:
                    prod = new Filmes();
                    esc = false;
                    break;
                default:
                    System.out.println("digite um valor valido !!!");
                    esc = true;
            }
        } while (esc);

        prod.atualizar();

        quantidadedeprodutos++;

    }

    private void verCodigo() {
        System.out.println("LIVROS");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("codigo: " + i);
            if (produtos.get(i) instanceof Livros) {
                System.out.println(produtos.get(i));
            }
        }
        System.out.println("\n\nFILMES");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("codigo: " + i);
            if (produtos.get(i) instanceof Filmes) {
                System.out.println(produtos.get(i));
            }
        }
    }

    public void atualizar() {
        Scanner in = new Scanner(System.in);
        this.verCodigo();
        System.out.println("Digite o codigo do produto a ser atualizado: ");
        int i = in.nextInt();
        System.out.println("faça as alterações");
        produtos.get(i).atualizar();
    }

    @Override
    public void comprar() {
        this.verCodigo();
        System.out.println("A CADA 10 ITEMS COMPRADOS VOCÊ COMCORRE A PREMIOS COMO CARRO, LIVROS, VIAGENS\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do produto: ");
        int i = in.nextInt();
        produtos.get(i).comprar();
        this.numerodecompras++;

        if (this.numerodecompras % 10 == 0) {
            sorteio();
        }
    }

    public void sorteio() {
        Random rand = new Random();

        switch (rand.nextInt(5)) {
            case 0:
                this.premio = PREMIOS.CARRO;
                break;
            case 1:
                this.premio = PREMIOS.DESCONTO;
                break;
            case 2:
                this.premio = PREMIOS.LIVRO;
                break;
            case 3:
                this.premio = PREMIOS.VIAGEM;
                break;
            case 4:
                this.premio = PREMIOS.NAO_FOI_DESTA_VEZ;
                break;
        }
        System.out.println("parabens seu premio é :" + this.premio.name());

    }

    @Override
    public void menu() {
        boolean esc;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("############SARAIVA############\n"
                    + "1- adicionar um produto (livro ou filme) \n"
                    + "2- para atualizar\n"
                    + "3- para comprar");
            switch (in.nextInt()) {
                case 1:
                    this.addProduto();
                    esc = false;
                    break;
                case 2:
                    this.atualizar();
                    esc = false;
                    break;
                case 3:
                    this.comprar();
                    esc = false;
                    break;
                default:
                    System.out.println("digite um valor valido !!!");
                    esc = true;
            }
        } while (esc);
    }
    
    @Override
    public void conectar(){
        this.menu();
    } 

}
