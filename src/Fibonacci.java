import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fibonacci extends JFrame
{
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField nTextField;
	private JButton calcButton;
	
	private final int WINDOW_WIDTH = 400;
	private final int WINDOW_HEIGHT = 100;
	
	public Fibonacci()
	{
		setTitle("Fibonacci Sequence");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
	}
	
	private void buildPanel()
	{
		messageLabel = new JLabel("Enter n for F(n): ");
		nTextField = new JTextField(10);
		calcButton = new JButton("Show sequence");
		calcButton.addActionListener(new ButtonListener());
		
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(nTextField);
		panel.add(calcButton);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String input;
			int n;
			
			input = nTextField.getText();
			n = Integer.parseInt(input);
			
			if (n <= 0)
			{
				JOptionPane.showMessageDialog(null, "Please enter a positive, non-zero value for n.");
			}
			else
			{
				for (int index = 1; index <= n; index++)
				{
					System.out.print(fib(index) + " ");
				}
				JOptionPane.showMessageDialog(null, "F(n) = " + fib(n));
				System.out.println(" ");
			}
			
			nTextField.setText("");
		}
	}
	
	private int fib(int n)
	{
		if (n == 0)
		{
			return n;
		}
		if (n == 1)
		{
			return n;
		}
		else
		{
			return (fib(n - 2) + fib(n - 1));
		}
	}
	
	public static void main(String[] args) 
	{
		new Fibonacci();
	}

}
