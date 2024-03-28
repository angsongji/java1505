package GUI;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class view_mouselisten implements MouseListener {
	private JLabel jl_x,jl_yes,jl_no;
	private view_thong_bao view_thong_bao; 
	public view_mouselisten(view_thong_bao view_thong_bao,JLabel jl_x,JLabel jl_yes, JLabel jl_no) {
		this.jl_x = jl_x;
		this.jl_yes = jl_yes;
		this.jl_no = jl_no;
		this.view_thong_bao = view_thong_bao; 
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == jl_x ) {
			view_thong_bao.dispose();
			
		}
		if (e.getSource() == jl_yes) {
			LoginUI l= new LoginUI();
			view_thong_bao.dispose();
			JFrame c=(JFrame) view_thong_bao.container_to_view_thong_bao;
			c.dispose();
			
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
		
		 if (e.getSource() == jl_yes) {
			jl_yes.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
			jl_yes.setOpaque(true);
		}
		 if (e.getSource() == jl_no) {
			jl_no.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);jl_no.setOpaque(true);
		}
		 if (e.getSource() == jl_x ) {
				jl_x.setBackground(Color.red);
				jl_x.setOpaque(true);
				
			}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == jl_x) {
			jl_x.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
			jl_x.setOpaque(true);
		}
		if (e.getSource() == jl_yes) {
			jl_yes.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);jl_yes.setOpaque(true);
		}
		if (e.getSource() == jl_no) {
			jl_no.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);jl_no.setOpaque(true);
		}
	}

}
