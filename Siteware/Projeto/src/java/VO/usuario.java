/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VO;

/**
 *
 * @author Pichau
 */
public class usuario {
    
    private Integer idUsuario;
    private String login;
    private String senha;
    private boolean tipo;
    
    public usuario(){
        
    }
    
    public usuario(Integer idUsuario, String login, String senha, boolean tipo){
        this.idUsuario = idUsuario;
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
    
}
