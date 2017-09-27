package expresiones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by codehero on 25/09/17.
 */
public class expresionesRegulares {
    private JTextField txt_regexp;
    private JButton btnEvaluar;
    private JTextField txt_text;
    public JPanel panelMain;

    public expresionesRegulares()
    {
        btnEvaluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cregexp expresion = new cregexp();

                String regexp = txt_regexp.getText();
                String match = txt_text.getText();

                if ( regexp.length() > 0 && match.length() > 0 )
                {
                    expresion.evaluarExpresion( regexp, match );
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Ingresar expresion regular y texto a comparar",
                            "- Expresiones Regulares -",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args)
    {
        new expresionesRegulares().createWindow();
    }

    public void createWindow()
    {
        JFrame mainframe = new JFrame("Expresiones Regulares - App");
        mainframe.setContentPane( new expresionesRegulares().panelMain );
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(400, 150);

        mainframe.setVisible(true);
    }
}
