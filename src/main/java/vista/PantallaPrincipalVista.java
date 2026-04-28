package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class PantallaPrincipalVista extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PantallaPrincipalVista frame = new PantallaPrincipalVista();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PantallaPrincipalVista() {
        setTitle("Biblioteca Virtual - Panel Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // --- PANEL LATERAL (MENU) ---
        JPanel panelMenu = new JPanel();
        panelMenu.setBackground(new Color(93, 64, 55));
        contentPane.add(panelMenu, BorderLayout.WEST);
        panelMenu.setLayout(new GridLayout(5, 1, 0, 10)); // 5 filas para botones

        String[] botones = {"Catálogo", "Préstamos", "Usuarios", "Reportes", "Salir"};
        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFocusPainted(false);
            btn.setBackground(new Color(121, 85, 72));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
            panelMenu.add(btn);
        }

        // --- PANEL CENTRAL (CONTENIDO) ---
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(new Color(250, 243, 224)); // Crema
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(130, 65, 0));
        panel.setForeground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 446, 673);
        panelCentro.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(130, 65, 0));
        panel_1.setBounds(0, 0, 1184, 81);
        panelCentro.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblWelcome = new JLabel("Bienvenido al Sistema de Gestión");
        lblWelcome.setBounds(811, 23, 350, 30);
        panel_1.add(lblWelcome);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tahoma", Font.ITALIC, 18));
    }
}