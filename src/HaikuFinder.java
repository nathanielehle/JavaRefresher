import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HaikuFinder 
{
	BufferedReader br = null;
	String currentLine;
	String sentence;
	String haiku;
	ArrayList<String> sentences = new ArrayList<String>();
	int locP;
	int locQ;
	int locE;
	int loc;
	boolean cont;
	
	public void readFile(String s) throws FileNotFoundException
	{
		br = new BufferedReader(new FileReader(s));
	}
	
	public void findSentences(String s) throws IOException
	{
		String temp = s;
		while (temp != null)
		{
			while (s.contains(".") || s.contains("!") || s.contains("?"))
			{
				locP = 999;
				locE = 999;
				locQ = 999;
				
				if (s.contains("."))
					locP = s.indexOf(".");
				if (s.contains("?"))
					locQ = s.indexOf("?");
				if (s.contains("!"))
					locE = s.indexOf("!");
				
				loc = Math.min(locP, locQ);
				loc = Math.min(loc, locE);
				//System.out.println(loc);
				
				if (s.length() <= loc)
				{
					//System.out.println(s.trim());
					sentences.add(s.trim());
					s = br.readLine();
				}
				else
				{
					//System.out.println(s.substring(0, loc+1).trim());
					sentences.add(s.substring(0, loc+1).trim());
					s = s.substring(loc+1);
				}
			}
			temp = br.readLine();
			s += " " + temp;
			//System.out.println("<" + s + ">");
		}
	}
	
	public int getNumSyllables(String s)
	{
		s = s.toLowerCase();
		int numSyllables = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y')
				numSyllables++;
		}
		
		if (s.contains("ea"))
			numSyllables--;
		
		if (s.contains("ou"))
			numSyllables--;
		
		if (s.charAt(s.length()-1) == 'e')
			numSyllables--;
		
		return numSyllables;
	}
	
	public void findHaiku(String s)
	{
		cont = true;
		int numSyllables1;
		int numSyllables2;
		int numSyllables3;
		haiku = "";
		while (cont == true)
		{
			String word = s.substring(0, s.indexOf(' '));
			s = s.substring(s.indexOf(' '+1));
			
		}
	}
		
	public HaikuFinder() throws IOException
	{
		readFile("CoMC.txt");
		currentLine = br.readLine();
		findSentences(currentLine);
		for (int i = 0; i < sentences.size(); i++)
			System.out.println(sentences.get(i));
	}
}
