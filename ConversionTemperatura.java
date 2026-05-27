import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConversionTemperatura extends JFrame implements ActionListener {

    JTextField txtValor;
    JLabel lblResultado;
    JButton btnCelsiusFahrenheit, btnFahrenheitCelsius, btnLimpiar;

    public ConversionTemperatura() {
        setTitle("Conversion de Temperatura");
        setSize(430, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 8, 8));

        add(new JLabel("Valor de temperatura:"));
        txtValor = new JTextField();
        add(txtValor);

        btnCelsiusFahrenheit = new JButton("Celsius a Fahrenheit");
        btnFahrenheitCelsius = new JButton("Fahrenheit a Celsius");
        btnLimpiar = new JButton("Limpiar");

        add(btnCelsiusFahrenheit);
        add(btnFahrenheitCelsius);

        add(new JLabel("Resultado:"));
        lblResultado = new JLabel("");
        add(lblResultado);

        add(btnLimpiar);

        btnCelsiusFahrenheit.addActionListener(this);
        btnFahrenheitCelsius.addActionListener(this);
        btnLimpiar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            limpiar();
            return;
        }

        if (txtValor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un valor en el campo temperatura.");
            return;
        }

        try {
            double valor = Double.parseDouble(txtValor.getText().trim());
            double resultado;

            if (e.getSource() == btnCelsiusFahrenheit) {
                resultado = (valor * 9 / 5) + 32;
                lblResultado.setText(valor + " °C = " + resultado + " °F");
            } else if (e.getSource() == btnFahrenheitCelsius) {
                resultado = (valor - 32) * 5 / 9;
                lblResultado.setText(valor + " °F = " + resultado + " °C");
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
        new ConversionTemperatura().setVisible(true);
    }
}
