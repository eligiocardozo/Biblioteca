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

import javax.swing.BorderFactory;
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
        setLocationRelativeTo(null); 

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); 
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

       
        Color colorMenuLateral = new Color(11, 63, 49);    
        Color colorFondoCentro = new Color(241, 245, 249); 
        Color colorTextoMenu   = Color.WHITE;             
        Font fuente = new Font("Segoe UI", Font.BOLD, 14);

       
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(colorFondoCentro);
        contentPane.add(panelCentro, BorderLayout.CENTER);
        panelCentro.setLayout(null); 

  
        JPanel panelLateral = new JPanel();
        panelLateral.setBackground(colorMenuLateral);
        panelLateral.setBounds(0, 0, 280, 681);
        panelLateral.setBorder(new EmptyBorder(120, 0, 0, 0));
        panelCentro.add(panelLateral);
        panelLateral.setLayout(new GridLayout(8, 1, 0, 10)); 

       
        
        JButton btnCategoria = new JButton("Catálogo");
        btnCategoria.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\catalogo.png"));
        btnCategoria.setFont(fuente);
        btnCategoria.setForeground(colorTextoMenu);
        btnCategoria.setHorizontalAlignment(SwingConstants.LEFT);
        btnCategoria.setIconTextGap(15);
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.setBorderPainted(false);
        btnCategoria.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelLateral.add(btnCategoria);

        JButton btnPrestamo = new JButton("Préstamos");
        btnPrestamo.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\prestamos.png"));
        btnPrestamo.setFont(fuente);
        btnPrestamo.setForeground(colorTextoMenu);
        btnPrestamo.setHorizontalAlignment(SwingConstants.LEFT);
        btnPrestamo.setIconTextGap(15);
        btnPrestamo.setContentAreaFilled(false);
        btnPrestamo.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelLateral.add(btnPrestamo);

        JButton btnUsuarios = new JButton("Usuarios");
        btnUsuarios.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\usuarios.png"));
        btnUsuarios.setFont(fuente);
        btnUsuarios.setForeground(colorTextoMenu);
        btnUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
        btnUsuarios.setIconTextGap(15);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelLateral.add(btnUsuarios);

        JButton btnReportes = new JButton("Reportes");
        btnReportes.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\reportes.png"));
        btnReportes.setFont(fuente);
        btnReportes.setForeground(colorTextoMenu);
        btnReportes.setHorizontalAlignment(SwingConstants.LEFT);
        btnReportes.setIconTextGap(15);
        btnReportes.setContentAreaFilled(false);
        btnReportes.setBorderPainted(false);
        btnReportes.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelLateral.add(btnReportes);

        JButton btnNewButton = new JButton("Configuración");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\ajustes.png"));
        btnNewButton.setFont(fuente);
        btnNewButton.setForeground(colorTextoMenu);
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton.setIconTextGap(15);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        panelLateral.add(btnNewButton);

        JPanel panelBarraSuperior = new JPanel();
        panelBarraSuperior.setBackground(Color.WHITE); 
        panelBarraSuperior.setBounds(280, 0, 984, 65);
        panelCentro.add(panelBarraSuperior);
        panelBarraSuperior.setLayout(null);

        
        JPanel panelBuscadorContenedor = new JPanel();
        panelBuscadorContenedor.setBackground(new Color(241, 245, 249)); 
        panelBuscadorContenedor.setBounds(30, 12, 400, 40);
        panelBarraSuperior.add(panelBuscadorContenedor);
        panelBuscadorContenedor.setLayout(null);

        JLabel lblBuscarHint = new JLabel("Buscar libros, autores, códigos...");
        lblBuscarHint.setForeground(new Color(148, 163, 184)); 
        lblBuscarHint.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblBuscarHint.setBounds(15, 0, 330, 40);
        panelBuscadorContenedor.add(lblBuscarHint);

        
        JButton btnLupa = new JButton("");
        btnLupa.setIcon(new ImageIcon("C:\\Users\\ELIGIO ANDRES\\Desktop\\LenguajeII\\Bibliotec\\src\\main\\resources\\imagenes\\lupa.png"));
        btnLupa.setContentAreaFilled(false);
        btnLupa.setBorderPainted(false);
        btnLupa.setFocusPainted(false);
        btnLupa.setBounds(350, 0, 50, 40);
        panelBuscadorContenedor.add(btnLupa);      
        
    }

}