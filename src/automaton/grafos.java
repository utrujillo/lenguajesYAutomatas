package automaton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JLabel;

import com.sun.codemodel.internal.*;
import dk.brics.automaton.RegExp;
import dk.brics.automaton.Automaton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by codehero on 16/10/17.
 */
public class grafos {
    private JTextField txt_regexp;
    private JButton btn_graph;
    private JPanel panelMain;
    private JTextArea displayDot;
    private JPanel panelImage;
    private JLabel imageLogo;
    private JButton btn_clean;
    private JScrollPane JSP;


    private File filePath = new File("/Users/codehero/Desktop");
    private String automataFile = "automata.dot";

    public static void main(String[] args) {
        new grafos().createWindow();
    }

    public void createWindow() {
        JFrame mainframe = new JFrame("Automatas - App");
        mainframe.setContentPane(new grafos().panelMain);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(800, 400);

        mainframe.setVisible(true);
    }

    public grafos()
    {
        /*
            Listeners ======================================================================
         */
        btn_graph.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegExp regexp = new RegExp( txt_regexp.getText() );
                Automaton automata = regexp.toAutomaton();
                File archivo = new File( filePath, automataFile);

                Methods method = new Methods();
                // Creo el archivo dot
                method.createDot( archivo, automata.toDot() );
                // Muestro información del archivo dot
                displayDot.setText( automata.toDot() );
                // Creo el grafico
                method.createGraph( archivo );
                // Muestro la imagen

                try {
                    BufferedImage bufferImage= null;
                    bufferImage = ImageIO.read(new File(filePath +"/"+ automataFile +".png"));
                    ImageIcon imageLoad = new ImageIcon(bufferImage);
                    imageLogo.setHorizontalAlignment(JLabel.CENTER);
                    imageLogo.setVerticalAlignment(JLabel.CENTER);
                    imageLogo.setIcon(imageLoad);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }



            }
        });
        btn_clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageLogo.setIcon(null);
                displayDot.setText("");
            }
        });
    }

}
