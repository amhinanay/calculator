import java.awt.*;
import javax.swing.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class calculator {
	private String num;
	private JFrame frmCalculator;
	private JTextField textField;
	private JButton btnc;
	private JButton btnerase;
	private JButton btnce;
	private JButton btnper;
	private JButton btn1x;
	private JButton btnx;
	private JButton btn2sx;
	private JLabel lblNewLabel;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btnmultiply;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btnminus;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btnadd;
	private JButton btnplusminus;
	private JButton btn0;
	private JButton btndot;
	private JButton btnequal;
	double first = 0;
	double second = 0;
	double result = 0;
	boolean isSecond = false;
	boolean usedEqual = true;
	boolean hasZero = true;
	boolean hasDecimal = false;
	String sign;
	String operation;
	String answer;
	private JTextField textField_1;
	private JList list;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnInfo;
	private JMenu mnNewMenu_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculator window = new calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});}

	/**
	 * Create the application.
	 */
	public calculator() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setMaximizedBounds(new Rectangle(2, 2, 2, 2));
		frmCalculator.setMinimumSize(new Dimension(350, 505));
		frmCalculator.setBackground(SystemColor.windowBorder);
		frmCalculator.getContentPane().setBackground(UIManager.getColor("CheckBox.darkShadow"));
		frmCalculator.setTitle("Calculator");
		frmCalculator.setForeground(Color.GRAY);
		frmCalculator.setBounds(100, 100, 310, 505);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnper = new JButton("%");
		btnper.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
		btnper.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnper.setForeground(SystemColor.inactiveCaptionBorder);
		btnper.setBackground(Color.DARK_GRAY);
		btnper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usedEqual) {					
					usedEqual = true;
				}
				first=Double.parseDouble(textField.getText());
				sign = "%";
				operation = sign;
				isSecond = true;
				textField_1.setText(first+" "+sign);				
				}
		});
		
		textField = new JTextField();
		textField.setText("0");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField.setCaretColor(UIManager.getColor("CheckBox.darkShadow"));
		textField.setForeground(SystemColor.inactiveCaptionBorder);
		textField.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		textField.setColumns(10);
		
		btnce = new JButton("CE");
		btnce.setBorder(new CompoundBorder());
		btnce.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnce.setForeground(SystemColor.inactiveCaptionBorder);
		btnce.setBackground(Color.DARK_GRAY);
		btnce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hasZero = true;
				hasDecimal = false;
				textField.setText("0");
			}
		});
		btnc = new JButton("C");
		btnc.setBorder(new CompoundBorder());
		btnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hasZero = true;
				first = 0;
				second = 0;
				result = 0;
				textField.setText("0");
				textField_1.setText(null);
			}
		});
		btnc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnc.setForeground(SystemColor.inactiveCaptionBorder);
		btnc.setBackground(Color.DARK_GRAY);
		
		btnerase = new JButton("\u232B");
		btnerase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>1)
				{
					StringBuilder str=new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length()-1);
					textField.setText(str.toString());				
				}else {
					hasZero = true;
					textField.setText("0");	
				}				
			}
		});
		
		btnerase.setBorder(new CompoundBorder());
		btnerase.setForeground(SystemColor.inactiveCaptionBorder);
		btnerase.setBackground(Color.DARK_GRAY);
		
		btn1x = new JButton("1/x");
		btn1x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=1/(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);				
			}
		});
		btn1x.setBorder(new CompoundBorder());
		btn1x.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn1x.setForeground(SystemColor.inactiveCaptionBorder);
		btn1x.setBackground(Color.DARK_GRAY);
		
		btnx = new JButton("x^2");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=(Double.parseDouble(textField.getText()));
				a=a*a;
				textField.setText("");
				textField.setText(textField.getText()+a);
				
			}
		});
		btnx.setBorder(new CompoundBorder());
		btnx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnx.setForeground(SystemColor.inactiveCaptionBorder);
		btnx.setBackground(Color.DARK_GRAY);
		
		btn2sx = new JButton("2^\u221Ax");
		btn2sx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a=Math.sqrt(Double.parseDouble(textField.getText()));
				if(!usedEqual) {					
					usedEqual = true;
				}
				first=Double.parseDouble(textField.getText());			
				textField_1.setText("\u221A"+"("+first+")"+" =");
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		btn2sx.setBorder(new CompoundBorder());
		btn2sx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn2sx.setBackground(Color.DARK_GRAY);
		btn2sx.setForeground(SystemColor.inactiveCaptionBorder);
		
		JButton btndivide = new JButton("\u00F7");
		btndivide.setBorder(new CompoundBorder());
		btndivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usedEqual) {					
					usedEqual = true;
				}if(!hasZero) {					
					hasZero = true;
				}
				first=Double.parseDouble(textField.getText());
				sign = "/";
				operation = sign;
				isSecond = true;
				hasDecimal = false;
				textField_1.setText(first+" "+sign);	
			}
		});
		btndivide.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btndivide.setForeground(SystemColor.inactiveCaptionBorder);
		btndivide.setBackground(Color.DARK_GRAY);
		
		btn7 = new JButton("7");
		btn7.setBorder(new CompoundBorder());
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "7");
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn7.setForeground(SystemColor.inactiveCaptionBorder);
		btn7.setBackground(Color.BLACK);
		
		btn8 = new JButton("8");
		btn8.setBorder(new CompoundBorder());
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "8");
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn8.setForeground(SystemColor.inactiveCaptionBorder);
		btn8.setBackground(Color.BLACK);
		
		btn9 = new JButton("9");
		btn9.setBorder(new CompoundBorder());
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "9");
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn9.setForeground(SystemColor.inactiveCaptionBorder);
		btn9.setBackground(Color.BLACK);
		
		btnmultiply = new JButton("x");
		btnmultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usedEqual) {					
					usedEqual = true;
				}if(!hasZero) {					
					hasZero = true;
				}
				first=Double.parseDouble(textField.getText());
				sign = "*";
				operation = sign;
				isSecond = true;
				hasDecimal = false;
				textField_1.setText(first+" "+"x");						
			}
		});
		btnmultiply.setBorder(new CompoundBorder());
		btnmultiply.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnmultiply.setForeground(SystemColor.inactiveCaptionBorder);
		btnmultiply.setBackground(Color.DARK_GRAY);
		
		btn4 = new JButton("4");
		btn4.setBorder(new CompoundBorder());
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "4");
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn4.setForeground(SystemColor.inactiveCaptionBorder);
		btn4.setBackground(Color.BLACK);
		
		btn5 = new JButton("5");
		btn5.setBorder(new CompoundBorder());
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "5");
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn5.setForeground(SystemColor.inactiveCaptionBorder);
		btn5.setBackground(Color.BLACK);
		
		btn6 = new JButton("6");
		btn6.setBorder(new CompoundBorder());
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "6");
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn6.setForeground(SystemColor.inactiveCaptionBorder);
		btn6.setBackground(Color.BLACK);
		
		btnminus = new JButton("-");
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usedEqual) {					
					usedEqual = true;
				}if(!hasZero) {					
					hasZero = true;
				}
				first=Double.parseDouble(textField.getText());
				sign = "-";
				operation = sign;
				isSecond = true;
				hasDecimal = false;
				textField_1.setText(first+" "+sign);
			}
		});
		btnminus.setBorder(new CompoundBorder());
		btnminus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnminus.setForeground(SystemColor.inactiveCaptionBorder);
		btnminus.setBackground(Color.DARK_GRAY);
		
		btn1 = new JButton("1");
		btn1.setBorder(new CompoundBorder());
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "1");
								
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn1.setForeground(SystemColor.inactiveCaptionBorder);
		btn1.setBackground(Color.BLACK);
		
		btn2 = new JButton("2");
		btn2.setBorder(new CompoundBorder());
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "2");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn2.setForeground(SystemColor.inactiveCaptionBorder);
		btn2.setBackground(Color.BLACK);
		
		btn3 = new JButton("3");
		btn3.setBorder(new CompoundBorder());
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "3");
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn3.setForeground(SystemColor.inactiveCaptionBorder);
		btn3.setBackground(Color.BLACK);
		
		btnadd = new JButton("+");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!usedEqual) {					
					usedEqual = true;
				}if(!hasZero) {					
					hasZero = true;
				}
				first=Double.parseDouble(textField.getText());
				sign = "+";
				operation = sign;
				isSecond = true;
				hasDecimal = false;
				textField_1.setText(first+" "+sign);
				
			}
		});
		btnadd.setBorder(new CompoundBorder());
		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnadd.setForeground(SystemColor.inactiveCaptionBorder);
		btnadd.setBackground(Color.DARK_GRAY);
		
		btnplusminus = new JButton("+/-");
		btnplusminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String value = textField.getText();
				if(!value.contains("-")) {
					textField.setText("-"+value);
				}else{			
					try {
					textField.setText(value.split("-")[1]);
					}catch(IndexOutOfBoundsException e1){}											
				}				
			}
		});
		btnplusminus.setBorder(new CompoundBorder());
		btnplusminus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnplusminus.setForeground(SystemColor.inactiveCaptionBorder);
		btnplusminus.setBackground(Color.BLACK);
		
		btn0 = new JButton("0");
		btn0.setBorder(new CompoundBorder());
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(isSecond) {
					textField.setText("");
					isSecond = false;
				}if(hasZero) {
					textField.setText("");
					hasZero = false;
				}
				textField.setText(textField.getText() + "0");
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn0.setForeground(SystemColor.inactiveCaptionBorder);
		btn0.setBackground(Color.BLACK);
		
		btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!hasDecimal) {					
					textField.setText(textField.getText()+".");					
					hasDecimal = true;
				}
			}
		});
		btndot.setBorder(new CompoundBorder());
		btndot.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btndot.setForeground(SystemColor.inactiveCaptionBorder);
		btndot.setBackground(Color.BLACK);
		
		btnequal = new JButton("=");
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usedEqual) {
					second = Double.parseDouble(textField.getText());
					hasDecimal = false;
					usedEqual = false;
				}
				
				if(operation=="+")
				{			
					result=first+second;
					textField_1.setText(first+" "+sign+" "+second+" =");
					textField.setText(Double.toString(result));
					first = result;
				}
				else if(operation=="-")
				{
					result=first-second;
					textField_1.setText(first+" "+sign+" "+second+" =");
					textField.setText(Double.toString(result));					
					first = result;
				}
				else if(operation=="*")
				{
					result=first*second;
					textField_1.setText(first+" "+"x"+" "+second+" =");
					textField.setText(Double.toString(result));					
					first = result;
				}
				else if(operation=="/")
				{
					result=first/second;
					textField_1.setText(first+" "+sign+" "+second+" =");
					textField.setText(Double.toString(result));					
					first = result;
				}
				
				else if(operation=="%")
				{
					result=first%second;
					textField_1.setText(first+" "+sign+" "+second+" =");
					textField.setText(Double.toString(result));
					first = result;
				}
			}
		});
		btnequal.setBorder(new CompoundBorder());
		btnequal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnequal.setForeground(SystemColor.inactiveCaptionBorder);
		btnequal.setBackground(Color.DARK_GRAY);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.DARK_GRAY);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setCaretColor(Color.DARK_GRAY);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField_1.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		textField_1.setColumns(10);
		
		list = new JList();
		GroupLayout groupLayout = new GroupLayout(frmCalculator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnper, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnce, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnc, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnerase, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btn1x, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnx, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn2sx, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btndivide, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btn7, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn8, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn9, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnmultiply, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btn4, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn5, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn6, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnminus, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btn1, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn2, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn3, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnadd, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnplusminus, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btn0, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btndot, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(btnequal, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(1))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(136)
					.addComponent(list)
					.addGap(203))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
					.addGap(18))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(list)
					.addGap(22)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnper, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(btnce, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(btnc, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
						.addComponent(btnerase, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn1x, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btnx, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btn2sx, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
						.addComponent(btndivide, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn7, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(btn8, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(btn9, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
						.addComponent(btnmultiply, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn4, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btn5, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btn6, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnminus, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btn1, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btn2, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btn3, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
						.addComponent(btnadd, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnplusminus, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(btn0, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(btndot, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(btnequal, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)))
		);
		frmCalculator.getContentPane().setLayout(groupLayout);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		menuBar.setForeground(UIManager.getColor("CheckBox.darkShadow"));
		frmCalculator.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("\u2261");
		menuBar.add(mnNewMenu);
		
		mnInfo = new JMenu("Info");
		mnNewMenu.add(mnInfo);
		
		mnNewMenu_1 = new JMenu("HINANAY, ALEXANDER M.");
		mnInfo.add(mnNewMenu_1);
		
		lblNewLabel = new JLabel("Standard");
		lblNewLabel.setBorder(null);
		menuBar.add(lblNewLabel);
		lblNewLabel.setForeground(UIManager.getColor("CheckBox.focus"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
