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
public final class Usuario extends Pessoa {
    private String Login,senha;

    public Usuario(String nome, String Login,String senha) {
        super(nome, " ");
        setLoguin(Login);
        setSenha(senha);
    }

    public Usuario() {

        setLoguin("sem nome");
        setSenha("");

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return Login;
    }

    public void setLoguin(String Loguin) {
        this.Login = Loguin;
    }
    
    public void Cadastrar(){
        Scanner in = new Scanner(System.in);
        System.out.println("digite seu nome: ");
        String nome = in.next();
        System.out.println("digite seu digite seu login: ");
        String login = in.next();
        System.out.println("digite sua senha: ");
        String Senha = in.next();
        setLoguin(Login);
        super.setNome(nome);
        setSenha(senha);
        
    }

    public boolean equals(Usuario obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Login, other.Login)) {
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
        Usuario o = (Usuario) outro;
        if (this.senha.compareTo(o.senha)!=0)
            return this.senha.compareTo(o.senha);
        if (this.cpf.compareTo(o.cpf)!=0)
            return this.cpf.compareTo(o.cpf);
        if (this.nome.compareTo(o.nome)!=0)
            return this.nome.compareTo(o.nome);
        if (this.senha.compareTo(o.senha)!=0)
            return this.senha.compareTo(o.senha);
        return 0;
    }

    @Override
    public String toString() {
        return"Loguin=" + Login + ", senha=" + senha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public void menu() {
        this.Cadastrar();
    }
    
    
    
}
