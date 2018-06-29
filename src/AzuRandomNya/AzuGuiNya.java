package AzuRandomNya;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class AzuGuiNya extends JFrame implements ActionListener
{
	private ClientHelper ch = new ClientHelper();
	
	private JFrame mainWnd;
	private JList<String> list;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	private JScrollPane scrollPane;
	private JLabel insertValues, img, nyanya, valueNya;
	private JTextField values;
	private JButton remove, add, nya;
	
	/**
	 * Constructor from class AzuGuiNya
	 */
	public AzuGuiNya()
	{}

	/**
	 * Create the main Window
	 */
	public void AzuCreatGuiNya() 
	{
		mainWnd = new JFrame();
		mainWnd.setLayout(null);
		mainWnd.setTitle("AzuRandomNya");
		mainWnd.setBounds(400,500,335,300);
		mainWnd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		img = new JLabel();
		img.setIcon(ch.loadImg("../images/AzuNya.jpg"));
		img.setBounds(0,0,mainWnd.getWidth(),mainWnd.getHeight());
		
		list = new JList<String>();
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10,10,180,250);
		list.setFont(new Font("Arial", Font.CENTER_BASELINE, 18));
		list.setModel(listModel);
		scrollPane.setBorder(new LineBorder(Color.BLACK));
		
		insertValues = new JLabel("Insert a value!");
		insertValues.setBounds(200,5,145,35);
		insertValues.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		insertValues.setForeground(Color.ORANGE);
		
		nyanya = new JLabel("Azunya has chosen!");
		nyanya.setBounds(50,10,250,60);
		nyanya.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		nyanya.setForeground(Color.MAGENTA);
		
		valueNya = new JLabel("");
		valueNya.setBounds(180,100,200,60);
		valueNya.setFont(new Font("Arial", Font.CENTER_BASELINE, 24));
		valueNya.setForeground(Color.CYAN);
		
		values = new JTextField("");
		values.setBounds(200,40,120,30);
		values.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		values.setBorder(new LineBorder(Color.BLACK));
		
		remove = new JButton("-");
		remove.setBounds(200,80,50,25);
		remove.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		remove.setBackground(Color.RED);
		remove.setFocusable(false);
		remove.setBorder(new LineBorder(Color.BLACK));
		
		add = new JButton("+");
		add.setBounds(270,80,50,25);
		add.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		add.setBackground(Color.GREEN);
		add.setFocusable(false);
		add.setBorder(new LineBorder(Color.BLACK));
		
		nya = new JButton("Nya!");
		nya.setBounds(200,235,120,25);
		nya.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
		nya.setBackground(Color.BLACK);
		nya.setFocusable(false);
		nya.setForeground(Color.WHITE);
		nya.setBorder(new LineBorder(Color.BLACK));
		
		mainWnd.add(nya);
		mainWnd.add(remove);
		mainWnd.add(add);
		mainWnd.add(insertValues);
		mainWnd.add(scrollPane);
		mainWnd.add(values);
		mainWnd.add(nyanya);
		mainWnd.add(valueNya);
		mainWnd.add(img);
		
		
		mainWnd.setResizable(false);
		mainWnd.setVisible(true);
		
		nyanya.setVisible(false);
		valueNya.setVisible(false);
		
		add.addActionListener(this);
		remove.addActionListener(this);
		nya.addActionListener(this);
	}
	
	/**
	 * Triggered by ActionListener on an Object
	 */
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == add)
		{
			if(!values.getText().equals("") && values != null)
			{
				listModel.addElement(values.getText());
				values.setText("");
			}
		}
		
		if(event.getSource() == remove)
		{
			if(values != null && !(list.getSelectedIndex() < 0))
			{
				listModel.remove(list.getSelectedIndex());
			}
		}
		
		if(event.getSource() == nya)
		{
			if(!(listModel.getSize() < 1))
			{	
				list.setVisible(false);
				scrollPane.setVisible(false);
				add.setVisible(false);
				remove.setVisible(false);
				insertValues.setVisible(false);
				nya.setVisible(false);
				values.setVisible(false);
				
				Random rand = new Random();
				valueNya.setText(listModel.getElementAt(rand.nextInt(listModel.getSize())));
				
				nyanya.setVisible(true);
				valueNya.setVisible(true);
				
				mainWnd.repaint();
			}
		}	
	}
}