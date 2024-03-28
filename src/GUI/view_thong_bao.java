package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class view_thong_bao extends JFrame{
	private String title_view_thong_bao;
	private String content;
	private view_mouselisten view_mouselisten;
	private JLabel jl_n1,jl_n2, jl_yes, jl_no,jl_c2;
	private JPanel panel_north, panel_center,panel_n1, panel_n2, panel_c1,panel_c2,panel_c3;
	private int chieurong,chieucao;
	public Object container_to_view_thong_bao;
	public boolean status;
	public view_thong_bao(int chieurong,int chieucao,Object s,String content,String title) {
		container_to_view_thong_bao=s;
		status=false;
		this.content=content;
		this.chieurong=chieurong;
		this.chieucao=chieucao;
		this.setSize(chieurong,chieucao);
		this.title_view_thong_bao=title;
		
		this.setLayout(new BorderLayout());
		panel_north = new JPanel();
		
		Font f = new Font("Arial", Font.BOLD, 16);
		Font fys = new Font("Arial",Font.BOLD,20);
		Font x = new Font("Arial", ALLBITS, 20);
		
		
		
		panel_north.setPreferredSize(new Dimension(0,30));
		panel_north.setBackground(Color.decode("#0097A7"));panel_north.setOpaque(true);
		panel_north.setLayout(new GridLayout(1,2,0,0));
		
		
		
		panel_n2 = new JPanel();

		panel_n2.setLayout(new FlowLayout(2,0,0));
		
		
		panel_n1 = new JPanel();
		panel_n1.setLayout(new FlowLayout(0));

		
		
		jl_n1 = new JLabel(title_view_thong_bao);
		ImageIcon icon_tb = new  ImageIcon("./src/hinh_anh/thong_bao.png");
		jl_n1.setIcon(icon_tb);
		jl_n1.setFont(f);
		jl_n1.setForeground(Cacthuoctinh_phuongthuc_chung.darkness_blue);;
		
		jl_n2 = new JLabel(Cacthuoctinh_phuongthuc_chung.exit_icon,JLabel.CENTER);
		jl_n2.setPreferredSize(new Dimension(0,0));
		jl_n2.setFont(x); 
		jl_n2.setForeground(Color.white);
		jl_n2.setPreferredSize(new Dimension(40,30));
		
		
		
		panel_n2.add(jl_n2); 
		panel_n2.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
		panel_n1.add(jl_n1);
		panel_n1.setBackground(Cacthuoctinh_phuongthuc_chung.sky_blue);
		
		
		panel_north.add(panel_n1);
		panel_north.add(panel_n2);
		
		
			
		panel_center = new JPanel();
		panel_center.setLayout(new FlowLayout());
		
		
		panel_c1 = new JPanel();
		panel_c1.setPreferredSize(new Dimension(1500,50));
//		panel_c1.setBackground(Color.orange);
		
		
		
		panel_c2 = new JPanel();
		panel_c2.setPreferredSize(new Dimension(this.getWidth(),(this.getHeight()-30)/3));
		jl_c2 = new JLabel(content,JLabel.LEFT);
		jl_c2.setPreferredSize(new Dimension(panel_c2.getPreferredSize().width-panel_c2.getPreferredSize().width/3,panel_c2.getPreferredSize().height-panel_c2.getPreferredSize().height/3));
		jl_c2.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		panel_c2.setLayout(new FlowLayout(1));
		panel_c2.add(jl_c2);
		jl_c2.setBackground(Color.white);jl_c2.setOpaque(true);
		
		
		
		panel_c3 = new JPanel();
		panel_c3.setPreferredSize(new Dimension(this.getWidth(),(this.getHeight()-30)/3));
		jl_yes = new JLabel("yes", JLabel.CENTER);jl_yes.setFont(fys);
		jl_yes.setPreferredSize(new Dimension(100,25));
		jl_yes.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);jl_yes.setOpaque(true);
		jl_yes.setForeground(Color.WHITE);
		
		jl_no = new JLabel("no",JLabel.CENTER);jl_no.setFont(fys);
		jl_no.setPreferredSize(new Dimension(100,25));
		jl_no.setBackground(Cacthuoctinh_phuongthuc_chung.darkness_blue);jl_no.setOpaque(true);
		jl_no.setForeground(Color.WHITE);
		
		panel_c3.setLayout(new FlowLayout(1,60,5));
		panel_c3.add(jl_yes);
		panel_c3.add(jl_no);

		panel_center.add(panel_c1);
		panel_center.add(panel_c2);
		panel_center.add(panel_c3);
		
		view_mouselisten = new view_mouselisten(this,jl_n2,jl_yes,jl_no);
		jl_n2.addMouseListener(view_mouselisten);
		jl_yes.addMouseListener(view_mouselisten);
		jl_no.addMouseListener(view_mouselisten);
		
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_center, BorderLayout.CENTER);
		
		
       	
      	setLocationRelativeTo(null);
		setUndecorated(true);
        setVisible(true);
		
		
	}
	
}
