import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OperacionesMatematicas extends JFrame implements ActionListener {

    JTextField txtNumero1, txtNumero2;
    JLabel lblResultado;
    JButton btnSumar, btnRestar, btnMultiplicar, btnDividir, btnLimpiar;

    public OperacionesMatematicas() {
        setTitle("Operaciones Matematicas");
        setSize(430, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 8, 8));

        add(new JLabel("Numero 1:"));
        txtNumero1 = new JTextField();
        add(txtNumero1);

        add(new JLabel("Numero 2:"));
        txtNumero2 = new JTextField();
        add(txtNumero2);

        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnDividir = new JButton("Dividir");
        btnLimpiar = new JButton("Limpiar");

        add(btnSumar);
        add(btnRestar);
        add(btnMultiplicar);
        add(btnDividir);

        add(new JLabel("Resultado:"));
        lblResultado = new JLabel("");
        add(lblResultado);

        add(btnLimpiar);

        btnSumar.addActionListener(this);
        btnRestar.addActionListener(this);
        btnMultiplicar.addActionListener(this);
        btnDividir.addActionListener(this);
        btnLimpiar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            limpiar();
            return;
        }

        if (txtNumero1.getText().trim().isEmpty() || txtNumero2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No deje campos vacios.");
            return;
        }

        try {
            double n1 = Double.parseDouble(txtNumero1.getText().trim());
            double n2 = Double.parseDouble(txtNumero2.getText().trim());
            double resultado = 0;

            if (e.getSource() == btnSumar) {
                resultado = n1 + n2;
            } else if (e.getSource() == btnRestar) {
                resultado = n1 - n2;
            } else if (e.getSource() == btnMultiplicar) {
                resultado = n1 * n2;
            } else if (e.getSource() == btnDividir) {
                if (n2 == 0) {
                    JOptionPane.showMessageDialog(this, "No se puede dividir entre cero.");
                    return;
                }
                resultado = n1 / n2;
            }

            lblResultado.setText(String.valueOf(resultado));

        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Ingrese solo numeros validos.");
        }
    }

    public void limpiar() {
        txtNumero1.setText("");
        txtNumero2.setText("");
        lblResultado.setText("");
    }

    public static void main(String[] args) {
        new OperacionesMatematicas().setVisible(true);
    }
}
