package calculator;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	final private String[] numerical_buttons = {"0"," ","|","1","2","3","4","5","6","7","8","9"};
	final private String[] operators_col1 = {"+","-","*","e",};
	final private String[] operators_col2 = {"=","D","C","-(x)"};
	private JTextArea resultado;
	private String value1, value2, operator;
	private JLabel warning;
	
	public void generateButtons(){
		for (int x = 0;x < 3; x++){
			for (int y = 0;y < 4; y++){
				 JButton btn = new JButton(numerical_buttons[x+3*y]);
				 btn.setBounds(10+ x*60, 320-y*60, 50, 50);
				 contentPane.add(btn);
				 final int x1 = x;
				 final int y1 = y;
				 btn.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 final String a = numerical_buttons[x1+3*y1];
						 resultado.append(a);
						 warning.setText("");
					 }
				 });
			} 
		}
		for (int y = 0;y < 4; y++){
			 JButton btn = new JButton(operators_col1[y]);
			 btn.setBounds(10+ 3*60, 320-y*60, 50, 50);
			 contentPane.add(btn);
			 buttonMethodSetterCol1(btn);
			 warning.setText("");
		} 
		JButton btn = new JButton(operators_col2[3]);
		 btn.setBounds(10+ 4*60, 320-3*60, 50, 50);
		 contentPane.add(btn);
		 btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 resultado.append("-");
				 warning.setText("");
			 }
		 });
		 btn = new JButton(operators_col2[2]);
		 btn.setBounds(10+ 4*60, 320-2*60, 50, 50);
		 contentPane.add(btn);
		 btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				resultado.setText("");
				value1 =value2 = operator = null;
				warning.setText("");
			 }
		 });
		 btn = new JButton(operators_col2[1]);
		 btn.setBounds(10+ 4*60, 320-60, 50, 50);
		 contentPane.add(btn);
		 btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 if (resultado.getText().length() > 0){
					 if (operator !=null){
						 operator = null;
						 value1 = null;
					 }
					 resultado.setText(resultado.getText().substring(0, resultado.getText().length()-1)); 
				 }
				 warning.setText("");
			 }
		 });
		 btn = new JButton(operators_col2[0]);
		 btn.setBounds(10+ 4*60, 320, 50, 50);
		 contentPane.add(btn);
		 btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 String result = null;
				 if (value1 != null && operator != null) result = poli.resolve(value1, resultado.getText(), operator);
				 if(result != null){
					 System.out.println("oper: " + operator + " v1: " + value1 + " v2: " + resultado.getText());
					 resultado.setText(result); 
					 value1 =value2 = operator = null;
				 }
				 else{
					 System.out.println("oper: " + operator + " v1: " + value1 + " v2: " + resultado.getText());
					 resultado.setText("");
					 value1 =value2 = operator = null;
					 warning.setText("Invalid operation!");
				 }
			 }
		 });
		 
	}
	
	private void buttonMethodSetterCol1(JButton btn){
		final String oper = btn.getText();
		btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 if (value1 == null && !resultado.getText().equals("")){
					 value1 = resultado.getText();
					 resultado.setText("");
					 operator = oper;
				 } 
				 else if (value1 != null && value2 == null){
					 operator = oper; 
				 }
				 warning.setText("");
			 }
		 });
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310,380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		warning = new JLabel("");
		warning.setBounds(10, 70, 290, 50);
		contentPane.add(warning);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 290, 50);
		contentPane.add(scrollPane);
		
		resultado = new JTextArea();
		resultado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '1' || e.getKeyChar() == '2'
						|| e.getKeyChar() == '3'|| e.getKeyChar() == '4'
						|| e.getKeyChar() == '5'|| e.getKeyChar() == '7'
						|| e.getKeyChar() == '6'|| e.getKeyChar() == '8'
						|| e.getKeyChar() == '9'|| e.getKeyChar() == '0'
						|| e.getKeyChar() == ' '|| e.getKeyChar() == '|'
						|| e.getKeyChar() == '-'){
					resultado.append(e.getKeyChar() + "");
				}
				else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					if (resultado.getText().length() > 0){
						 if (operator !=null){
							 operator = null;
							 value1 = null;
						 }
						 resultado.setText(resultado.getText().substring(0, resultado.getText().length()-1)); 
					 }
					 warning.setText("");
				}
			}
		});
		scrollPane.setViewportView(resultado);
		resultado.setEditable(false);
		resultado.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		generateButtons();
		setResizable(false);
	}
}
