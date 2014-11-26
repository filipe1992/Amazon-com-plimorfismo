/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import abstratas.Pessoa;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author ELIETE
 */
public class Administrador extends Pessoa {
    private String cargo;
    private String login;
    private String senha;

    public Administrador(String cargo, String login, String senha) {
        super();
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    public Administrador() {
        super();
        this.cargo = " ";
        this.login = " ";
        this.senha = " ";
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return  "cargo=" + cargo + ", login=" + login + ", senha=" + senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrador other = (Administrador) obj;
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Pessoa outro) {
        if (this == outro)
            return 0;
        Administrador o = (Administrador)outro;
        if (this.cargo.compareTo(o.cargo)!=0){
            return this.cargo.compareTo(o.cargo);
        }
        if (this.cpf.compareTo(o.cpf)!=0)
            return this.cpf.compareTo(o.cpf);
        if (this.login.compareTo(o.login)!=0)
            return this.login.compareTo(o.login);
        if (this.nome.compareTo(o.nome)!=0)
            return this.nome.compareTo(o.nome);
        if (this.senha.compareTo(o.senha)!=0)
            return this.senha.compareTo(o.senha);
        
        return 0;
    }

    
    public void Cadastrar(){
        Scanner in = new Scanner(System.in);
        System.out.println("digite seu nome: ");
        String nome = in.next();
        System.out.println("digite seu digite seu login: ");
        String login = in.next();
        System.out.println("digite sua senha: ");
        String Senha = in.next();
        System.out.println("digite seu cargo: ");
        String cargo = in.next();
        setLogin(login);
        setCargo(cargo);
        super.setNome(nome);
        setSenha(senha);
        
    }

    @Override
    public void menu() {
        this.Cadastrar();
    }
    
}
