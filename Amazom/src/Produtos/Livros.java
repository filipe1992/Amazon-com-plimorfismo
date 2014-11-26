/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;

import interfaces.Produto;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Livros implements Produto {
    
    protected enum Genero {ROMANCE,AVENTURA,FICCAO_CIENTIFICA,OUTROS};
    
    private float preco;
    private String nome;
    private Genero tiposdelivros ;
    private int numerodepaginas;
    private int numerodeexemplares;

    public Livros(float preco, String nome, int numerodepaginas,int numerodeexemplares) {
        setPreco(preco);
        setNome(nome);
        setTiposdelivros();
        setNumerodepaginas(numerodepaginas);
        setNumerodeexemplares(numerodeexemplares);

    }

    public Livros() {
        this.preco = 00;
        this.nome = "sem nome";
        this.tiposdelivros = Genero.OUTROS;
        this.numerodepaginas = 0;
    }

    public float getPreco() {
        return preco;
    }

    public final void setPreco(float preco) {
        if (preco < 0){
            this.preco = 00;
        }else
            this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getTiposdelivros() {
        return tiposdelivros;
    }

    public final void setTiposdelivros() {
        Scanner in =new Scanner(System.in);
        int escolha;       
        System.out.println("ESCOLHA O GENERO DE FILME: ");
        do{
            System.out.println("1- ROMANCE\n2- AVENTURA\n3FICCAO_CIENTIFICA");
            escolha = in.nextInt();
            switch(escolha){
                case 1:
                    this.tiposdelivros=Genero.ROMANCE;
                    break;
                case 2:
                    this.tiposdelivros=Genero.AVENTURA;
                    break;
                case 3:
                    this.tiposdelivros=Genero.FICCAO_CIENTIFICA;
                    break;
                case 4:
                    this.tiposdelivros=Genero.OUTROS;
                    break;
                default :
                    System.out.println("Digite um valor valido");
            }
        }while(escolha < 4 || escolha < 1);
    }

    public int getNumerodepaginas() {
        return numerodepaginas;
    }

    public final void setNumerodepaginas(int numerodepaginas) {
        if (numerodepaginas < 0){
            this.numerodepaginas=0;
        }else
            this.numerodepaginas = numerodepaginas;
    }

    public int getNumerodeexemplares() {
        return numerodeexemplares;
    }

    public final void setNumerodeexemplares(int numerodeexemplares) {
        if (numerodeexemplares < 0){
            this.numerodeexemplares=0;
        }else
            this.numerodeexemplares = numerodeexemplares;
    }
    
    
//funções ulteis
    @Override
    public boolean comprar(){
        if (getNumerodeexemplares()>0){
            System.out.println("Livro comprado com sucesso!!!");
            int valor=getNumerodeexemplares()-1;
            setNumerodeexemplares(valor);
            return true;
        }else{
            System.out.println("livro em falta!!");
            return false;
        }
            
    }
    
    @Override
    public void atualizar(){
        Scanner in= new Scanner(System.in);
        
        System.out.println("deseja mudar o numero de exemplares do livro [Y/N]:");
        String escolha = in.next();
        if (escolha.equalsIgnoreCase("y")){
            System.out.println("Digite o novo numero de exemplares: ");
            int valor = in.nextInt();
            setNumerodeexemplares(valor);
        }
        
        System.out.println("deseja mudar o nome do livro [Y/N]:");
        escolha = in.next();
        if (escolha.equalsIgnoreCase("y")){
            System.out.println("Digite o novo nome: ");
            String valor = in.next();
            setNome(valor);
        }
        
        System.out.println("deseja mudar o preço do livro [Y/N]:");
        escolha = in.next();
        if (escolha.equalsIgnoreCase("y")){
            System.out.println("Digite o novo preço: ");
            float valor = in.nextInt();
            setPreco(valor);
        }
        
        System.out.println("deseja mudar o numero de paginas do livro [Y/N]:");
        escolha = in.next();
        if (escolha.equalsIgnoreCase("y")){
            System.out.println("Digite o novo numero de paginas: ");
            int valor = in.nextInt();
            setNumerodepaginas(valor);
        }
        
        System.out.println("deseja mudar o genero do livro [Y/N]:");
        escolha = in.next();
        if (escolha.equalsIgnoreCase("y")){
            System.out.println("Digite o novo numero de exemplares: ");
            setTiposdelivros();
        }
    }
    
    @Override
    public String toString(){
        String out,out1,out2,out3,out4;
        out = "################## "+this.nome+" ##################";
        out1 = "com: "+this.numerodepaginas+" paginas.";
        out2 = "do genero: "+this.tiposdelivros.name()+".";
        out3 = "com: "+this.numerodeexemplares+" exemplares no estoque";
        out4 = "No valor de "+this.preco+" R$";
        return out +"\n"+ out1+"\n"+out2+"\n"+out3+"\n"+out4;
    }  
    
    public void Menu(){
            
        Scanner in = new Scanner(System.in);
            int escolha;
            do{
                System.out.println("###########MENU%%%%%%%%%%%\n1- Alugar \n2- comprar \n3- Adicionar ");
                escolha = in.nextInt();

                switch(escolha){
                    case 1:
                        this.comprar();
                        break;
                    case 2:
                        this.atualizar();
                        break;
                    default:
                        System.out.println("Digite um valor valido!!");
                }
            }while(escolha >2 && 1 > escolha);
    }

}
