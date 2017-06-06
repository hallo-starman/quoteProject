import java.io.*;
import java.util.*;

public class QuoteOfTheDay
{

	// name of source file
	// this won't change
	private static final String FILENAME = "quotes.txt";
	
	
	public String getQuote()
	{
		// will later hold the random quote
		String quote;
		String line = null;
		ArrayList<String> quoteList = new ArrayList<String>();

		try
		{
			// FileReader will read the text file in the system's default encoding
			FileReader fileR = new FileReader(FILENAME);

			BufferedReader bufferedR = new BufferedReader(fileR);

			while((line = bufferedR.readLine()) != null)
			{
				quoteList.add(line);
			}
			
			bufferedR.close();
			


		}
		catch(IOException e)
		{
			System.out.println("Can't open file");
		}
		
		int pos = (int) (Math.random() * quoteList.size());
		quote = quoteList.get(pos);
		return quote;
	}

}
