package experiment;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener, MouseListener{
	
	JPanel panel = new JPanel();
	
	JPanel rank = new JPanel();
	boolean isOpen = false;
	JScrollPane jsp;
	JList jl = new JList();
	
	JPanel jp_cover = new JPanel();
	JLabel jl_cover_name = new JLabel("请输入游戏昵称:");
	JTextField jt_cover_name = new JTextField();
	JLabel jl_cover_rank = new JLabel("查看排名");
	JLabel jl_cover_title = new JLabel("猜数字游戏");
	JButton jb_cover_start = new JButton("开始游戏");
	
	
	JPanel jp_one = new JPanel();
	JPanel jp_two = new JPanel();
	JPanel jp_three = new JPanel();
	JPanel jp_four = new JPanel();
	
	JTextField jt_guessField = new JTextField(4);
	JButton jb_guess = new JButton("确认");
	JButton jb_getAnswer = new JButton("获取答案");
	JLabel jl_num = new JLabel("次数：");
	JLabel jl_value = new JLabel("0");
	JButton jb_restart = new JButton("重新开始");
	JButton jb_back = new JButton("Back");
	Number N = new Number();
	int count;
	User user;
	
	public GUI() {
		super("猜数字游戏");
		init();
	}
	
	private void init() {
		setSize(500, 350);
		setLayout(null);
		setLocationRelativeTo(null);
		
		panel.setBounds(0, 0, 500, 350);
		panel.setLayout(null);
		
		ImageIcon igIcon = new ImageIcon(getClass().getResource("/res/null.jpg"));
		igIcon.setImage(igIcon.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		JLabel jl_image = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image2 = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image3 = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image4 = new JLabel(igIcon,JLabel.CENTER);
		
//		jp_one.setLayout(null);
//		jp_two.setLayout(null);
//		jp_three.setLayout(null);
//		jp_four.setLayout(null);
		
		jp_one.setBounds(21, 50, 90, 120);
		jp_two.setBounds(139, 50, 90, 120);
		jp_three.setBounds(256, 50, 90, 120);
		jp_four.setBounds(374, 50, 90, 120);
		
		jp_one.setBorder(BorderFactory.createLoweredBevelBorder());
		jp_two.setBorder(BorderFactory.createLoweredBevelBorder());
		jp_three.setBorder(BorderFactory.createLoweredBevelBorder());
		jp_four.setBorder(BorderFactory.createLoweredBevelBorder());
		
		
//		jp_one.paintComponents(getGraphics());
		jp_one.add(jl_image);
		jp_two.add(jl_image2);
		jp_three.add(jl_image3);
		jp_four.add(jl_image4);
//		jl_image.setBounds(0, 0, 2, 80);
		jl_image.setOpaque(true);
//		jp_one.add(jt_guessField);
		panel.add(jp_one);
		panel.add(jp_two);
		panel.add(jp_three);
		panel.add(jp_four);
		
		
		jt_guessField.setBounds(205, 250, 90, 20);
		panel.add(jt_guessField);
		jb_guess.setBounds(205, 280, 90, 25);
		panel.add(jb_guess);
		jb_guess.addActionListener(this);
		jb_getAnswer.setBounds(21, 13, 90, 25);
		panel.add(jb_getAnswer);
		jb_getAnswer.addActionListener(this);
		jb_restart.setBounds(139, 13, 90, 25);
		panel.add(jb_restart);
		jb_restart.addActionListener(this);
		jb_back.setBounds(400, 13, 64, 25);
		panel.add(jb_back);
		jb_back.addActionListener(this);
		
		jl_num.setBounds(21, 190, 45, 25);
		panel.add(jl_num);
		jl_value.setBounds(66, 190, 45, 25);
		panel.add(jl_value);
		add(panel);
		panel.setVisible(false);
		
		jp_cover.setBounds(0, 0, 500, 350);
		jp_cover.setLayout(null);
		
		jl_cover_title.setFont(new Font("猜数字游戏", Font.BOLD, 40));
		jp_cover.add(jl_cover_title);
		jl_cover_title.setBounds(145, 30, 210, 40);
		
		jp_cover.add(jb_cover_start);
		jb_cover_start.setBounds(205, 250, 90, 25);
		jb_cover_start.addActionListener(this);
		
		jp_cover.add(jl_cover_rank);
		jl_cover_rank.addMouseListener(this);
		jl_cover_rank.setBounds(430, 10, 60, 20);
		
		jp_cover.add(jl_cover_name);
		jl_cover_name.setBounds(160, 150, 90, 20 );
		
		jp_cover.add(jt_cover_name);
		jt_cover_name.setBounds(250, 150, 90, 20);
		
		rank.setLayout(null);
		String[] list = {"王老五","苏幕遮","李四","苏幕遮","李四","苏幕遮","李四","苏幕遮","李四","苏幕遮","李四","苏幕遮","李四","苏幕遮","李四"};

		jl = new JList();
		jl.setListData(list);
		jsp = new JScrollPane(jl);
		jsp.setBounds(5, 5, 90, 190);
//		rank.add(jl);
		rank.add(jsp);
		
//		rank.add(new JLabel("这是表格"));
//		JScrollPane jp=new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//		jp.setViewportView(rank);
//		rank.setPreferredSize(new Dimension(150,200));
		rank.setBounds(385, 112, 100, 200);
		rank.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		add(rank);
		rank.setVisible(false);
		
		
		
		JLayeredPane jlp = new JLayeredPane();
		jlp.setPosition(jp_cover, -1);
//		jlp.setPosition(rank, 0);
//		add(jp);
		add(jp_cover);
//		jp_cover.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jb_guess) {
			String VALUE = jt_guessField.getText();
			if(VALUE == null && !isInteger(VALUE))return;
			char[] v = VALUE.toCharArray();
			if(v.length != 4)return;
			int[] value = new int[4];
			int i = 0;
			for(char item:v) {
				value[i] = Integer.parseInt(item + "");
				i++;
			}
			System.out.println(VALUE);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					showTip(value);
					
				}
			}).start();
			
			count++;
			jl_value.setText(count + "");
		}
		
		if(e.getSource() == jb_getAnswer) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					showAnswer();
				}
			}).start();
		}
		
		if(e.getSource() == jb_restart) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					restart();
				}
			}).start();
		}
		
		if(e.getSource() == jb_cover_start) {
			
			String name = jt_cover_name.getText();
			System.out.println("用户的名字：" + name);
			if(name.trim().equals("")) {
				JOptionPane.showMessageDialog(this, "请输入你的游戏名！", "",JOptionPane.WARNING_MESSAGE); 
				return;
			}
			user = new User(name.trim());
			if(N.judge(user)) {
				N.add(user);
			}else {
				JOptionPane.showMessageDialog(this, "该昵称已存在，请重新输入！", "",JOptionPane.WARNING_MESSAGE); 
				jt_cover_name.setText("");
				return;
			}
			jt_cover_name.setText("");
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					jp_cover.setVisible(false);
					panel.setVisible(true);
					restart();
					revalidate();
				}
			}).start();
			
			repaint();
			revalidate();
		}
		
		if(e.getSource() == jb_back) {
			
			int n = JOptionPane.showConfirmDialog(null, "是否保存战绩？", "",JOptionPane.YES_NO_OPTION);
			
			System.out.println(n);
			
			if(n == 0) {
				user.setScore(count);
				N.saveScore(user);
			}
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					restart();
					panel.setVisible(false);
					jp_cover.setVisible(true);
				}
			}).start();
			repaint();
			revalidate();
		}
		
	}
	
	//判断字符串是否是整数
	private boolean isInteger(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	public void showTip(int[] value) {
		int[] tip = N.tip(value);
		
		if(tip[0] == 4) {
			JOptionPane.showMessageDialog(this, "恭喜成功猜对数字，猜测次数：" + count + "次" , "标题",JOptionPane.DEFAULT_OPTION); 
		}
		
		jp_one.removeAll();
		jp_one.repaint();
		jp_two.removeAll();
		jp_two.repaint();
		jp_three.removeAll();
		jp_three.repaint();
		jp_four.removeAll();
		jp_four.repaint();
		
		ImageIcon igIcon_n = new ImageIcon(getClass().getResource("/res/" + tip[0] + ".jpg"));
		ImageIcon igIcon_A = new ImageIcon(getClass().getResource("/res/A.jpg"));
		ImageIcon igIcon_m= new ImageIcon(getClass().getResource("/res/" + tip[1] + ".jpg"));
		ImageIcon igIcon_B = new ImageIcon(getClass().getResource("/res/B.jpg"));
		
		igIcon_n.setImage(igIcon_n.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_A.setImage(igIcon_A.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_m.setImage(igIcon_m.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_B.setImage(igIcon_B.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		
		JLabel jl_image = new JLabel(igIcon_n,JLabel.CENTER);
		JLabel jl_image2 = new JLabel(igIcon_A,JLabel.CENTER);
		JLabel jl_image3 = new JLabel(igIcon_m,JLabel.CENTER);
		JLabel jl_image4 = new JLabel(igIcon_B,JLabel.CENTER);
		
		jp_one.add(jl_image);
		jp_two.add(jl_image2);
		jp_three.add(jl_image3);
		jp_four.add(jl_image4);
		
		
		revalidate();	
		System.out.println("卡住了？");
	}
	
	public void showAnswer(){
		int[] answer = N.getAnswer();
		
		for(int item:answer) {
			System.out.print(item + "  ");
		}
		
		jp_one.removeAll();
		jp_one.repaint();
		jp_two.removeAll();
		jp_two.repaint();
		jp_three.removeAll();
		jp_three.repaint();
		jp_four.removeAll();
		jp_four.repaint();
		
		ImageIcon igIcon_n = new ImageIcon(getClass().getResource("/res/" + answer[0] + ".jpg"));
		ImageIcon igIcon_A = new ImageIcon(getClass().getResource("/res/" + answer[1] + ".jpg"));
		ImageIcon igIcon_m= new ImageIcon(getClass().getResource("/res/" + answer[2] + ".jpg"));
		ImageIcon igIcon_B = new ImageIcon(getClass().getResource("/res/" + answer[3] + ".jpg"));
		
		igIcon_n.setImage(igIcon_n.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_A.setImage(igIcon_A.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_m.setImage(igIcon_m.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		igIcon_B.setImage(igIcon_B.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		
		JLabel jl_image = new JLabel(igIcon_n,JLabel.CENTER);
		JLabel jl_image2 = new JLabel(igIcon_A,JLabel.CENTER);
		JLabel jl_image3 = new JLabel(igIcon_m,JLabel.CENTER);
		JLabel jl_image4 = new JLabel(igIcon_B,JLabel.CENTER);
		
		jp_one.add(jl_image);
		jp_two.add(jl_image2);
		jp_three.add(jl_image3);
		jp_four.add(jl_image4);
		
		revalidate();
	}
	
	public void restart() {
		N.getNumber();
		count = 0;
		jl_value.setText(count + "");
		jt_guessField.setText("");
		
		jp_one.removeAll();
		jp_one.repaint();
		jp_two.removeAll();
		jp_two.repaint();
		jp_three.removeAll();
		jp_three.repaint();
		jp_four.removeAll();
		jp_four.repaint();
		
		ImageIcon igIcon = new ImageIcon(getClass().getResource("/res/null.jpg"));
		igIcon.setImage(igIcon.getImage().getScaledInstance(76,107, Image.SCALE_DEFAULT));
		JLabel jl_image = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image2 = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image3 = new JLabel(igIcon,JLabel.CENTER);
		JLabel jl_image4 = new JLabel(igIcon,JLabel.CENTER);
		
		jp_one.add(jl_image);
		jp_two.add(jl_image2);
		jp_three.add(jl_image3);
		jp_four.add(jl_image4);
		
		add(jp_one);
		add(jp_two);
		add(jp_three);
		add(jp_four);
		
		revalidate();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jl_cover_rank) {
			System.out.println("查看排名");
			if(isOpen) {
				rank.setVisible(false);
				isOpen = false;
			} else {
				rank.removeAll();
				String[] list = N.getRank();
				jl = new JList();
				jl.setListData(list);
				jsp = new JScrollPane(jl);
				jsp.setBounds(5, 5, 90, 190);
//				rank.add(jl);
				rank.add(jsp);
				rank.setVisible(true);
				isOpen = true;
			}
				
			revalidate();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
