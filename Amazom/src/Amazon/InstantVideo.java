/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import Produtos.Filmes;
import interfaces.Produto;
import interfaces.Site;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ELIETE
 */
public class InstantVideo extends Amazon implements Site {

    @Override
    public void conectar() {
        this.menu();
    }
    
    protected enum Tipodenegocio {ALUGAR , COMPRAR, INDEFINIDOO};
    
    protected Tipodenegocio negocio;
    protected static ArrayList<Produto> filmes;
    //protected static int quantidadeefilmes;
    protected ArrayList<Produto> filmesalugados;
    protected ArrayList<Produto> filmescomprados;

    public InstantVideo(Tipodenegocio negocio, ArrayList<Produto> filmes, ArrayList<Produto> filmesalugados) {
        this.negocio = negocio;
        InstantVideo.filmes = filmes;
        this.filmesalugados = filmesalugados;
    }

    public InstantVideo() {
        super();
        this.negocio= Tipodenegocio.INDEFINIDOO;
        InstantVideo.filmes = new ArrayList<>();
        this.filmesalugados= new ArrayList<>(3);
        this.filmescomprados = new ArrayList<>();
    }

    public Tipodenegocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Tipodenegocio negocio) {
        this.negocio = negocio;
    }

    public ArrayList<Produto> getFilmes() {
        return filmes;
    }

    public void setFilmes(ArrayList<Produto> filmes) {
        InstantVideo.filmes = filmes;
    }
   
    private boolean verificar(Filmes filme){
        Scanner in = new Scanner(System.in);
        if (InstantVideo.filmes.contains(filme)){
            System.out.println("você ja possui esse Filme!!");
            return true;
        }else if (this.filmesalugados.contains(filme)){
            System.out.println("Voce alugou este filme!!");
            System.out.println("deseja Compra-lo[Y/N]: ");
            String val = in.next();
            if (val.equalsIgnoreCase("Y"))
                comprar(InstantVideo.filmes.indexOf(filme));
            
            return true;
        }else 
            return false;
        }
 
    
    private void mostrar(){
        for (int i = 0; i < InstantVideo.filmes.size(); i++) {
            System.out.println("codigo: "+i);
            System.out.println(InstantVideo.filmes.get(i));
        }
    }
    
    public void add(){
        Scanner in = new Scanner(System.in);
        System.out.println("digite o nome do Filme: ");
        String nome = in.next();
        System.out.println("Digite o preço: ");
        float preco = in.nextFloat();
        System.out.println("Digite o numero de duração: ");
        int duracao = in.nextInt();
        Filmes filme = new Filmes(preco,nome,duracao);
        
        if (InstantVideo.filmes.add(filme)){
            System.out.println("LIVRO ADCIONADO COM SUCESSO!!!");
            System.out.println(filmes.get(filmes.size()-1));
        }else
            System.out.println("LIVRO << NÃO >> ADCIONADO!!!");   
        InstantVideo.filmes.add(filme);
    }
    
    public void alugar(){
        Scanner in =new Scanner(System.in);
        System.out.println("digite o codigo do filme a ser comprado");
        int codigo = in.nextInt();
        this.filmesalugados.add(filmes.get(codigo));
    }
    
    @Override
    public void comprar(){
        Scanner in =new Scanner(System.in);
        this.mostrar();
        System.out.println("digite o codigo do filme: ");
        int codigo = in.nextInt();
        if (this.verificar(((Filmes)InstantVideo.filmes.get(codigo))))
            this.filmescomprados.add(InstantVideo.filmes.get(codigo));        
    }
    
    public void comprar(int i){
        this.filmescomprados.add(InstantVideo.filmes.get(i));
    }
    
    @Override
    public void menu(){
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("###########MENU%%%%%%%%%%%\n1- Alugar \n2- comprar \n3- Adicionar ");
            escolha = in.nextInt();
            
            switch(escolha){
                case 1:
                    this.alugar();
                    break;
                case 2:
                    this.comprar();
                    break;
                case 3:
                    this.add();
                    break;
                default:
                    System.out.println("Digite um vvalor valido");
            }
        }while(escolha >3 && 1 > escolha);
    }

    @Override
    public String toString() {
        return super.toString()+"InstantVideo{" + "negocio=" + negocio + ", filmesalugados=" + filmesalugados + ", filmescomprados=" + filmescomprados + '}';
    }
    
    
}
