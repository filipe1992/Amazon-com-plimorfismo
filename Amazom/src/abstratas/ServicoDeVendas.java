/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstratas;

import interfaces.Servico;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public abstract class ServicoDeVendas implements Servico{

    protected String lembretesDeCompras;

    @Override
    public String toString(){
        return "seu lembrete: "+this.lembretesDeCompras+".\n";
    }
    
    public void lembrete(){
        Scanner in=new Scanner(System.in);
        String text;
        System.out.println("digite seu lembrete: ");
        text =in.nextLine();
        setLembretesDeCompras(text);
        
    } 

    public ServicoDeVendas() {
         this.lembretesDeCompras = "SEM LEMBRETE";
    }

    public String getLembretesDeCompras() {
        return lembretesDeCompras;
    }

    public void setLembretesDeCompras(String lembretesDeCompras) {
        this.lembretesDeCompras = lembretesDeCompras;
    }

    public ServicoDeVendas(String lembretesDeCompras) {
        this.lembretesDeCompras = lembretesDeCompras;
    }
    @Override
    public void realizarServico(){
        this.menu();
    }
    
    public abstract void comprar();

    public abstract void menu();
}
