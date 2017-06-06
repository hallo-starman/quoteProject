import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class QuoteWindow
{
	JLabel theLabel;

	public static void main(String[] args)
	{
		QuoteWindow quoteWindow = new QuoteWindow();
		quoteWindow.createWindow();
	}

	public void createWindow()
	{
		Color alienGreen = new Color(31, 163, 78);

		QuoteOfTheDay runner = new QuoteOfTheDay();

		// instantiate a JFrame object
		JFrame quoteFrame = new JFrame("Quote of the Day");
		// end program when window is closed
		quoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String todayQuote = runner.getQuote();
		char[] quoteArray = todayQuote.toCharArray();

		theLabel = new JLabel("", SwingConstants.CENTER);
		theLabel.setBorder(BorderFactory.createLineBorder(alienGreen, 3));
		theLabel.setForeground(alienGreen);
		// put green border inside empty border by using compound border
		// parameters: (outside border, inside border)
		Border border = theLabel.getBorder();
		Border margin = new EmptyBorder(15, 15, 15, 15);
		theLabel.setBorder(new CompoundBorder(margin, border));

		// set size of label
		theLabel.setPreferredSize(new Dimension(700, 400));
		// set background color
		quoteFrame.getContentPane().setBackground(Color.BLACK);
		// add label to frame
		quoteFrame.getContentPane().add(theLabel, BorderLayout.CENTER);
		// display window in center of screen
		quoteFrame.setLocationRelativeTo(null);
		// set window's size
		quoteFrame.pack();
		// show window
		quoteFrame.setVisible(true);
		
		// initialize timer
		Timer timer = new Timer(50, new ActionListener()
		{
			int i = 0;
			String quote = "";
			// does this after every delay 
			public void actionPerformed(ActionEvent e)
			{
				if(i != quoteArray.length)
				{
					quote += quoteArray[i];
					theLabel.setText(quote);
					i++;
				}

			}

		});
		
		// start the timer
		timer.start();
	}
	
	

}
