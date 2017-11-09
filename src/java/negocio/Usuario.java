package negocio;

public class Usuario {
    private String usuario;
    private String passwd;
    
    public Usuario(String usuario, String passwd){
        this.usuario = usuario;
        this.passwd = passwd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
