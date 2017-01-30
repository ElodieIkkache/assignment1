/**
* @author Elodie
*
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

public class Input<T,U> extends Filter<T,U> {
	private Stream<T> inputstream;
	private Stream<U> outputstream;
	public String titlesfilename= "";
	public String wordstoignorefilename= "";
		
	//constructors
	public Input() {
		super();
	}

	
	//getters and setters

	public Stream<T> getInputstream() {
		return inputstream;
	}
	
	
	public Stream<U> getOutputstream() {
		return outputstream;
	}

	public void setOutputstream(Stream<U> outputstream) {
		this.outputstream = outputstream;
	}


	//method
	public void transform(){
		Scanner readertitles = new Scanner(System.in);
		System.out.print("Hello! Can you indicate the pathway to your .txt file that contains the titles? \n");
		titlesfilename = readertitles.next();
		readertitles.close();
		
		Scanner readerignore = new Scanner(System.in);
		System.out.print("Thanks, and the one with the words to ignore? \n");
		wordstoignorefilename = readerignore.next();
		readerignore.close();
		
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(titlesfilename);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(titlesfilename));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	}
	
	public void setInputstream(Stream<T> stream) {
		this.inputstream = stream;
	}

}
