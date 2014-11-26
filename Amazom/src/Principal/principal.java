/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import Amazon.Amazon;
import Amazon.InstantVideo;
import Amazon.LojaOnline;
import Amazon.Webservices;
import Saraiva.Saraiva;
import Usuario.*;
import abstratas.Pessoa;
import interfaces.Servico;
import interfaces.Site;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author ELIETE
 */
public class principal {
    
    public static void menuAmazon(Amazon a) {

        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- Dar nota \n2- Ve detalhes ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    a.darNota();
                    break;
                case 2:
                    System.out.println(a);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 2 && 1 > escolha);

    }
    
    public static void menuIntantVideo(InstantVideo a){
        Scanner in = new Scanner(System.in);
        int escolha;
        do{
            System.out.println("###########MENU%%%%%%%%%%%\n1- Alugar \n2- comprar \n3- Adicionar ");
            escolha = in.nextInt();
            
            switch(escolha){
                case 1:
                    a.alugar();
                    break;
                case 2:
                    a.comprar();
                    break;
                case 3:
                    a.add();
                    break;
                default:
                    System.out.println("Digite um vvalor valido");
            }
        }while(escolha >3 && 1 > escolha);
    }
   
    public static void menulojaonline(LojaOnline a) {
        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- Comprar \n2- atualizar \n3- Adicionar \n4ver detahees ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    a.Comprar();
                    break;
                case 2:
                    a.atualizarLivro();
                    break;
                case 3:
                    a.addLivro();
                    break;
                case 4:
                    System.out.println(a);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 4 && 1 > escolha);
    }
    
    public static void menuWebservices(Webservices a) {
        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- mudar contrato \n2- ver detalhes ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    a.mudarContrato();
                    break;
                case 2:
                    System.out.println(a);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 2 && 1 > escolha);
    }
    
    public static void menuSaraiva(Saraiva a) {
        boolean esc;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("############SARAIVA############\n"
                    + "1- adicionar um produto (livro ou filme) \n"
                    + "2- para atualizar\n"
                    + "3- para comprar");
            switch (in.nextInt()) {
                case 1:
                    a.addProduto();
                    esc = false;
                    break;
                case 2:
                    a.atualizar();
                    esc = false;
                    break;
                case 3:
                    a.comprar();
                    esc = false;
                    break;
                default:
                    System.out.println("digite um valor valido !!!");
                    esc = true;
            }
        } while (esc);
    }
    
    public static void main(String[] args) {
        SistemaDeLogin sistema = new SistemaDeLogin();
        
        Servico serv[] = new Servico[5];
        Site site[] = new Site[2];
        Pessoa p[] = new Pessoa[2];
        
        site[0] = new Saraiva();
        site[1] = new LojaOnline();
        
        serv[0] = new Saraiva();
        serv[1] = new Amazon();
        serv[2] = new LojaOnline();
        serv[3] = new InstantVideo();
        serv[4] = new Webservices();
        
        p[0] = new Usuario();
        p[1] = new Administrador();
        
        JOptionPane telinha = new JOptionPane();
        
        JOptionPane.showMessageDialog(telinha,"Tipos de usuario: ");
        for (int i = 0; i < 2; i++) {
            if (p[i] instanceof Usuario){
                System.out.println(" este é um usuario comum ");
                SistemaDeLogin.cadastrar(sistema, p[i]);
            }else{
                System.out.println("este é um administrador ");
                SistemaDeLogin.cadastrar(sistema, p[i]);
            }
        }
        
        JOptionPane.showMessageDialog(telinha,"sites para acessar: ");
        
        for (int i = 0; i < 2; i++) {
            if (site[i] instanceof Saraiva ){
                System.out.println("bem vindo a Saraiva");
            }else{
                System.out.println("bem vindo a loja online da amazon ");
            }
            site[i].conectar();
        }
        
        JOptionPane.showMessageDialog(telinha,"Tipos de Serviços: ");
        
        for (int i = 0; i < 5; i++) {
            if (serv[i] instanceof Saraiva)
                menuSaraiva(((Saraiva) serv[i]));
            else if (serv[i] instanceof Amazon)
                menuAmazon((Amazon) serv[i]);
            else if (serv[i] instanceof LojaOnline)
                menulojaonline((LojaOnline) serv[i]);
            else if (serv[i] instanceof InstantVideo)
                menuIntantVideo((InstantVideo) serv[i]);
            else
                menuWebservices((Webservices) serv[i]);
        }
    }
    
    
    
}
