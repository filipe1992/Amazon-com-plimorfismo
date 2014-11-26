/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import Produtos.Livros;
import interfaces.Produto;
import interfaces.Site;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public final class LojaOnline extends Amazon implements Site{

   

    public enum Tipodecompra {

        BOLETO_BAMCARIO, CARTAO_DE_CREDITO
    };

    protected Tipodecompra formadepagamento;
    protected static int quantidadedelivros = 0;
    protected int livrosccomprados;
    protected ArrayList<Produto> livros;

    public LojaOnline(Tipodecompra formadepagamento) {
        super();
        setFormadepagamento(formadepagamento);
        setLivros();
        setLivrosccomprados(0);
    }

    public LojaOnline() {
        super();
        setFormadepagamento(Tipodecompra.CARTAO_DE_CREDITO);
        setLivros();
        setLivrosccomprados(0);
    }

    public Tipodecompra getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(Tipodecompra formadepagamento) {
        Scanner in = new Scanner(System.in);
        int escolha;
        System.out.println("ESCOLHA FORMA DE PAGAMENTO: ");
        do {
            System.out.println("1- BOLETO BANCARIO\n2- CARTÃO DE CRÉDITO");
            escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    this.formadepagamento = Tipodecompra.BOLETO_BAMCARIO;
                    break;
                case 2:
                    this.formadepagamento = Tipodecompra.CARTAO_DE_CREDITO;
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
        } while (escolha < 4 || escolha < 1);
    }

    public static int getQuantidadedelivros() {
        return quantidadedelivros;
    }

    public static void setQuantidadedelivros(int quantidadedelivros) {
        LojaOnline.quantidadedelivros = quantidadedelivros;
    }

    public ArrayList getLivros() {
        return livros;
    }

    public void setLivros() {
        this.livros = new ArrayList<>();
    }

    public int getLivrosccomprados() {
        return livrosccomprados;
    }

    public void setLivrosccomprados(int livrosccomprados) {
        this.livrosccomprados = livrosccomprados;
    }

    public void addLivro() {
        Scanner in = new Scanner(System.in);
        System.out.println("digite o nome do livro: ");
        String nome = in.next();
        System.out.println("Digite o numero de paginas: ");
        int numerodepaginas = in.nextInt();
        System.out.println("Digite o numero de exemplares: ");
        int exemplatres = in.nextInt();
        System.out.println("Digite o preço: ");
        float preco = in.nextFloat();
        Livros livro = new Livros(preco, nome, numerodepaginas, exemplatres);

        if (this.livros.add(livro)) {
            System.out.println("LIVRO ADCIONADO COM SUCESSO!!!");
            System.out.println(this.livros.get(this.livros.size()));
        } else {
            System.out.println("LIVRO << NÃO >> ADCIONADO!!!");
        }
    }

    public void atualizarLivro() {
        Produto livro = this.livros.remove(codigo());
        livro.atualizar();
        this.livros.add(livro);
    }

    public void mostrarLivros() {
        if (this.livros.isEmpty()) {
            System.out.println("A lista esta vazia");
        } else {
            for (Produto iterador : this.livros) {
                System.out.println();
                System.out.println(iterador);
                System.out.println();
            }
        }
    }

    private int codigo() {
        for (int i = 0; i < this.livros.size(); i++) {
            System.out.println("-------codigo do livro: " + i + "-------");
            System.out.println(this.livros.get(i));
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o codigo do livro: ");
        int codigo = in.nextInt();
        return codigo;
    }

    public void Comprar() {
        Produto livro = this.livros.remove(codigo());
        livro.comprar();
        this.livros.add(livro);

    }

    private int totalDeExemplares() {
        int total = 0;
        for (Produto livro : this.livros) {
            total += ((Livros) livro).getNumerodeexemplares();
        }
        return total;
    }

    @Override
    public String toString() {
        String out, out1, out2, out3, out4, out5;
        out = super.toString();
        out1 = ("-------Loja Online-------");
        out2 = ("voce escolheu pagar com: " + this.formadepagamento.name() + ".");
        out3 = ("voce ja comprou: " + this.livrosccomprados + " livros.");
        out4 = ("a loja possui: " + quantidadedelivros + " Livros diferemtes.");
        out5 = ("E um total de: " + totalDeExemplares());
        return out + "\n" + out1 + "\n" + out2 + "\n" + out3 + "\n" + out4 + "\n" + out5 + "\n";
    }

    @Override
    public void menu() {
        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- Comprar \n2- atualizar \n3- Adicionar \n4ver detahees ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    this.Comprar();
                    break;
                case 2:
                    this.atualizarLivro();
                    break;
                case 3:
                    this.addLivro();
                    break;
                case 4:
                    System.out.println(this);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 4 && 1 > escolha);
    }
    
    @Override
    public void conectar() {
        this.menu();
    }
}
