import javax.swing.JOptionPane;

public class SairEntrar {
    public static String lerString(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static int lerInteiro(String mensagem) {
        try {
            return Integer.parseInt(lerString(mensagem));
        } catch (Exception var2) {
            return 0;
        }
    }

    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
