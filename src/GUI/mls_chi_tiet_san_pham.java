package GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;

public class mls_chi_tiet_san_pham implements MouseListener{
	private JLabel[] jl;
	private view_chi_tiet_san_pham p;
	private JLabel soluong;
	public mls_chi_tiet_san_pham(JLabel[] jl,view_chi_tiet_san_pham p, JLabel soluong) {
		this.jl = jl;
		this.p = p;
		this.soluong = soluong;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == jl[0]) {
			p.dispose();
		}
		if (e.getSource() == jl[1]) {
			
		}
		if (e.getSource() == jl[2]) {
			
		}
		if (e.getSource() == jl[3]) {
			
		}
		if (e.getSource() == jl[8]) {
			soluong.setText(p.tang_sl()+"");
		}
		
		if (e.getSource() == jl[7]) {
			soluong.setText(p.giam_sl()+"");
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == jl[0]) {
			jl[0].setBackground(Color.red); jl[0].setOpaque(true);
		}
		if (e.getSource() == jl[1]) {
			
		}
		if (e.getSource() == jl[2]) {
			
		}
		if (e.getSource() == jl[3]) {
			
		}
		for (int i = 4; i< 10; i++) {
			if (e.getSource() == jl[i]) {
				jl[i].setBorder(BorderFactory.createLineBorder(Color.decode("#3498db"),2));
			}
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == jl[0]) {
			jl[0].setBackground(null); jl[0].setOpaque(true);
		}
		if (e.getSource() == jl[1]) {
			
		}
		if (e.getSource() == jl[2]) {
			
		}
		if (e.getSource() == jl[3]) {
			
		}
		for (int i = 4; i< 10; i++) {
			if (e.getSource() == jl[i]) {
				jl[i].setBorder(BorderFactory.createEmptyBorder());
			}
		}
		
		
	}

}
