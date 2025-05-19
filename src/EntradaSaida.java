import javax.swing.*;

public class EntradaSaida {
    public static String lerString(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    public static int lerInteiro(String mensagem) {
        try {
            return Integer.parseInt(lerString(mensagem));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número inteiro.");
            return lerInteiro(mensagem);
        }
    }

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
