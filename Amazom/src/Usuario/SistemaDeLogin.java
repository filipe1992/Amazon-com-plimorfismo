/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Saraiva.Saraiva;
import Amazon.Amazon;
import Amazon.InstantVideo;
import Amazon.LojaOnline;
import Amazon.Webservices;
import abstratas.Pessoa;
import abstratas.ServicoDeVendas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class SistemaDeLogin {

    private ArrayList<Pessoa> usuarios;
    private ArrayList<ServicoDeVendas> amazon;
    private static int numerodecadastros;

    public SistemaDeLogin() {
        this.usuarios = new ArrayList<>();
        this.amazon = new ArrayList<>();
        numerodecadastros = 0;
    }

    public SistemaDeLogin(ArrayList<Pessoa> usuarios, ArrayList<ServicoDeVendas> amazon) {
        this.usuarios = usuarios;
        this.amazon = amazon;
    }

    public ArrayList<Pessoa> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Pessoa> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<ServicoDeVendas> getAmazon() {
        return amazon;
    }

    public void setAmazon(ArrayList<ServicoDeVendas> amazon) {
        this.amazon = amazon;
    }

    public static int getNumerodecadastros() {
        return numerodecadastros;
    }

    public static void setNumerodecadastros(int numerodecadastros) {
        SistemaDeLogin.numerodecadastros = numerodecadastros;
    }

    @Override
    public String toString() {
        return "SistemaDeLogin{" + "usuarios=" + usuarios + ", amazon=" + amazon + '}';
    }

    public void fazerLogin() {
        Scanner in = new Scanner(System.in);

        System.out.println("");
        String login = in.next();
        System.out.println("");
        String senha = in.next();
        for (int i = 0; i < numerodecadastros; i++) {
            if (this.usuarios.get(i) instanceof Usuario) {
                if (((Usuario) this.usuarios.get(i)).getLogin().equals(login)) {
                    if (((Usuario) this.usuarios.get(i)).getSenha().equals(senha)) {
                        System.out.println("accesso permitido");
                        //acesso aqui
                        break;
                    } else {
                        System.out.println("Senha incorreta!!");
                    }
                } else {
                    System.out.println("Usuario inexitente");
                }
            } else {
                if (((Administrador) this.usuarios.get(i)).getLogin().equals(login)) {
                    if (((Administrador) this.usuarios.get(i)).getSenha().equals(senha)) {
                        System.out.println("accesso permitido");
                        //acesso aqui
                        break;
                    } else {
                        System.out.println("Senha incorreta!!");
                    }
                } else {
                    System.out.println("Usuario inexitente");
                }
            }
        }
    }

    public static void cadastrar(SistemaDeLogin sistema, Pessoa usuario) {
        int escolha;
        ServicoDeVendas servico;
        Scanner in = new Scanner(System.in);
        if (sistema.usuarios.contains(usuario)) {
            System.out.println("Este usuario ja existe!!!");
        } else {
            do {
                System.out.println("deseja usar os servicos da amazon ou da saraiva: \n1- Amazon \n2-Saraiva");
                escolha = in.nextInt();
                if (escolha == 1) {
                    servico = new Amazon();
                } else {
                    servico = new Saraiva();
                }
            } while (escolha != 1 && escolha != 2);
            if (servico instanceof Amazon) {
                do {
                    System.out.println("voce seseja usar qual servico da amazon: \n1-loja de livros \n2-loja de filmes\n3- amazon webservice");
                    escolha = in.nextInt();
                } while (escolha != 1 && escolha != 2);

                if (escolha == 1) {
                    servico = new LojaOnline();
                } else if (escolha == 2) {
                    servico = new InstantVideo();
                } else {
                    servico = new Webservices();
                }
            }

            sistema.usuarios.add(sistema.usuarios.size(), usuario);
            sistema.amazon.add(sistema.amazon.size(), servico);
            System.out.println("o usuario: " + usuario.getNome() + " foi cadastrado!!!");
        }
    }

    public static void deletar(SistemaDeLogin sistema) {
        Scanner in = new Scanner(System.in);
        int posicao = -1;
        do {
            System.out.println("Digire o login: ");
            String login = in.next();
            System.out.println("Digite a senha");
            String senha = in.next();
            for (int i = 0; i < numerodecadastros; i++) {
                if (sistema.usuarios.get(i) instanceof Usuario) {
                    if (((Usuario)sistema.usuarios.get(i)).getLogin().equals(login)) {
                        if (((Usuario)sistema.usuarios.get(i)).getSenha().equals(senha)) {
                            System.out.println("accesso permitido");
                            posicao = i;
                            break;
                        } else {
                            System.out.println("Senha incorreta!!");
                        }
                    } else {
                        System.out.println("Usuario inexitente");
                    }
                }else
                   if (((Administrador)sistema.usuarios.get(i)).getLogin().equals(login)) {
                        if (((Administrador)sistema.usuarios.get(i)).getSenha().equals(senha)) {
                            System.out.println("accesso permitido");
                            posicao = i;
                            break;
                        } else {
                            System.out.println("Senha incorreta!!");
                        }
                    } else {
                        System.out.println("Usuario inexitente");
                    } 
            }
        } while (posicao != -1);
        //remove
        sistema.usuarios.remove(posicao);
        sistema.amazon.remove(posicao);
        System.out.println("Usuario removido com sucesso!!");

    }

    public static void menu(SistemaDeLogin sistema) {
        Scanner in = new Scanner(System.in);
        int escolha;
        Pessoa usuario=null;
        do {
            System.out.println("##############MENU###############\n1- Para fazer login\n2- Para fazer seu cadastro \n3- Para deletar usuario:");
            escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    sistema.fazerLogin();
                    break;
                case 2:
                    System.out.println("digite 1 para Usuario e 2 para Administrador");
                    switch (in.nextByte()){
                        case 1:
                            usuario = new Usuario();
                            break;
                        case 2:
                            usuario = new Administrador();
                            break;
                        default:
                            System.out.println("valor invalido !!!!");
                    }
                    if (usuario instanceof Usuario)
                        ((Usuario) usuario).Cadastrar();
                    else
                        ((Administrador) usuario).Cadastrar();
                    
                    cadastrar(sistema, usuario);
                    break;
                case 3:
                    deletar(sistema);
                    break;
                default:
                    System.out.println("Digite um valor valido");
            }
        } while (escolha > 3 && escolha < 1);
    }
}
