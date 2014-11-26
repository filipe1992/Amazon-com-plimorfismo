/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Webservices extends Amazon {
    
    private String descricao;
    private float espacodearmazenamento;
    private float valor;

    public Webservices(String descreicao, float espacodearmazenamento, float valor) {
        this.descricao = descreicao;
        this.espacodearmazenamento = espacodearmazenamento;
        this.valor = valor;
    }

    public Webservices(String descreicao, float espacodearmazenamento, float valor, Nota satisfacaodocliente) {
        super(satisfacaodocliente);
        this.descricao = descreicao;
        this.espacodearmazenamento = espacodearmazenamento;
        this.valor = valor;
    }

    public Webservices() {
        this.descricao = " sem descreicao";
        this.espacodearmazenamento = 0;
        this.valor = 0;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descreicao) {
        this.descricao = descreicao;
    }

    public float getEspacodearmazenamento() {
        return espacodearmazenamento;
    }

    public void setEspacodearmazenamento(float espacodearmazenamento) {
        this.espacodearmazenamento = espacodearmazenamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return super.toString()+"\nWebservices{" + "descreicao=" + descricao + ", espacodearmazenamento=" + espacodearmazenamento + ", valor=" + valor + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Webservices other = (Webservices) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (Float.floatToIntBits(this.espacodearmazenamento) != Float.floatToIntBits(other.espacodearmazenamento)) {
            return false;
        }
        if (Float.floatToIntBits(this.valor) != Float.floatToIntBits(other.valor)) {
            return false;
        }
        return true;
    }
    
    public void mudarContrato(){
        Scanner in = new Scanner(System.in);
        float i;
        do{
            System.out.println("digite o novo espaco desejado[maior que 10 gb]  em gigabyte: ");
            i = in.nextFloat();
        }while(i < 10);
        this.valorDoContrato(i);
        
    }
    
    public void valorDoContrato(float i){
        this.valor=(float) (0.5 * i);
    }
    
    @Override
    public void menu() {
        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- mudar contrato \n2- ver detalhes ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    this.mudarContrato();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 2 && 1 > escolha);
    }
    
}
