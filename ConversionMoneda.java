import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversionMoneda extends JFrame implements ActionListener {

    JTextField txtValor;
    JLabel lblResultado;
    JButton btnUsdCop, btnCopUsd, btnLimpiar;

    final double TASA = 3800;

    public ConversionMoneda() {
        setTitle("Conversion de Moneda");
        setSize(430, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 8, 8));

        add(new JLabel("Valor de moneda:"));
        txtValor = new JTextField();
        add(txtValor);

        btnUsdCop = new JButton("USD a COP");
        btnCopUsd = new JButton("COP a USD");
        btnLimpiar = new JButton("Limpiar");

        add(btnUsdCop);
        add(btnCopUsd);

        add(new JLabel("Resultado:"));
        lblResultado = new JLabel("");
        add(lblResultado);

        add(new JLabel("Tasa fija: 1 USD = 3800 COP"));
        add(btnLimpiar);

        btnUsdCop.addActionListener(this);
        btnCopUsd.addActionListener(this);
        btnLimpiar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            limpiar();
            return;
        }

        if (txtValor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText().trim());

            if (valor < 0) {
                JOptionPane.showMessageDialog(this, "No se permiten valores negativos en moneda.");
                return;
            }

            double resultado;

            if (e.getSource() == btnUsdCop) {
                resultado = valor * TASA;
                lblResultado.setText(valor + " USD = " + resultado + " COP");
            } else if (e.getSource() == btnCopUsd) {
                resultado = valor / TASA;
                lblResultado.setText(valor + " COP = " + resultado + " USD");
            }

        } catch (NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Ingrese solo numeros validos.");
        }
    }

    public void limpiar() {
        txtValor.setText("");
        lblResultado.setText("");
    }

    public static void main(String[] args) {
        new ConversionMoneda().setVisible(true);
    }
}
//"se hace el modelo de operaciones matemáticas "