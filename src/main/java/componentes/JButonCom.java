package componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JButonCom extends JButton{

	public JButonCom() {
		super();
		setMinimumSize(new Dimension(140,140));
		setMaximumSize(new Dimension(140,140));
		setFont(new Font("Segoe UI", Font.BOLD,16));
		setForeground(new Color(240, 240, 240));
		setBackground(new Color(255, 255, 255, 180));
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setBorderPainted(false);
		setOpaque(true);
		setFocusable(false);
	}
	
	@Override
	public void setText(String text) {
		setIcono(text);
		super.setText(text);
	}
	
	
	private void setIcono(String icono) {
		try {
			URL url = JButonCom.class.getResource("/imagenes/"+ icono.toLowerCase().replace("","" ) +"32.png");
			this.setIcon(new ImageIcon(url));
		} catch (Exception e) {
			System.err.println("No se encontro el icono /imagenes/"+ icono + "32.png");
		}
	}

}
