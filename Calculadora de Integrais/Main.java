// codigo feito com a ajuda de @EduCamelo (GitHub)


import javax.swing.JOptionPane;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String in = JOptionPane.showInputDialog("Digite a função (por exemplo, x^2): ");
        double a = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite inferior da integral: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite superior da integral: "));
        int inter = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de intervalos para a aproximação: "));

        Function<Double, Double> funcao = x -> seila(in, x);

        double larg = (b - a) / inter;

        double result = 0.0;

        StringBuilder resultText = new StringBuilder("<html><table><tr><th>Intervalo</th><th>X1</th><th>Área Parcial</th><th>Resultado Parcial</th></tr>");

        for (int i = 0; i < inter; i++) {
            double x1 = a + i * larg;
            double area = funcao.apply(x1) * larg;
            result += area;

            resultText.append(String.format("<tr><td>%d</td><td>%.2f</td><td>%.2f</td><td>%.2f</td></tr>", (i + 1), x1, area, result));
        }

        resultText.append("</table><br>Resultado da integral definida: ").append(result).append("</html>");

        JOptionPane.showMessageDialog(null, resultText.toString());
    }

    public static double seila(String expression, double x) {
        return -(Math.pow(x, 2)) + 4;
    }
}
