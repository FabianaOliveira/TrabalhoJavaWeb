
package Classe;

public class VerLogin {
    public boolean verificaLogin(Usuario usuario) {

        if("fabi".equals(usuario.getUsuario()) && "fabi".equals(usuario.getSenha())) {
            return true;
        }
        return false;
    }
}
