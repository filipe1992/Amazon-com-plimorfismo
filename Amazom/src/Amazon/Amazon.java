/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import abstratas.ServicoDeVendas;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Amazon extends ServicoDeVendas {

    @Override
    public void comprar() {
        System.out.println("realizando a compra!!");
    }


    //declaração da classe NOTA

    protected enum Nota {

        Ruim, Bom, Exelente, Indefinida
    };

    protected final static String CNPJ = "15.436.940/0001-03";
    protected Nota satisfacaodocliente;

    public Amazon() {
        this.satisfacaodocliente = Nota.Indefinida;
    }

    public Amazon(Nota satisfacaodocliente) {
        this.satisfacaodocliente = satisfacaodocliente;
    }

    public Nota getSatisfacaodocliente() {
        return satisfacaodocliente;
    }

    public void setSatisfacaodocliente(Nota satisfacaodoccliente) {
        this.satisfacaodocliente = satisfacaodoccliente;
    }

    @Override
    public String toString() {
        String out1, out2, out3;
        out1 = ("##############AMAZOM.COM##############");
        out2 = ("com o CNPJ: " + CNPJ);
        out3 = ("E com a nota definida por você: " + this.satisfacaodocliente.name());
        return out1 + "\n" + out2 + "\n" + out3 + "\n";
    }

    @Override
    public void menu() {

        Scanner in = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("###########MENU%%%%%%%%%%%\n1- Dar nota \n2- Ve detalhes ");
            escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    this.darNota();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }

        } while (escolha > 2 && 1 > escolha);

    }

    public void darNota() {
        Scanner in = new Scanner(System.in);
        int escolha;
        System.out.println("digite um valor de 1 a 3 para nota do serviço:");
        do {
            System.out.println("onde:\n1- RUIM\n2- BOM\n3- EXELENTE");
            escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    this.satisfacaodocliente = Nota.Ruim;
                    break;
                case 2:
                    this.satisfacaodocliente = Nota.Bom;
                    break;
                case 3:
                    this.satisfacaodocliente = Nota.Exelente;
                    break;
                default:
                    System.out.println("Digite um valor valido!!!!");
            }
        } while (escolha < 0 || escolha > 5);
    }

}
