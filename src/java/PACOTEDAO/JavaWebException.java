package PACOTEDAO;

public class JavaWebException extends Exception {
     public JavaWebException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public JavaWebException(String mensagem) {
        super(mensagem);
    }
}
