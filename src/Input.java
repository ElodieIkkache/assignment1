/**
* @author Elodie
*
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

public class Input<T,U extends ArrayList<ArrayList<String>>> extends Filter<T,ArrayList<ArrayList<String>>> {
	private Stream<T> inputstream;
	private Stream<ArrayList<ArrayList<String>>> outputstream;
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
	
	
	public Stream<ArrayList<ArrayList<String>>> getOutputstream() {
		return outputstream;
	}

	public void setOutputstream(Stream<ArrayList<ArrayList<String>>> outputstream) {
		this.outputstream = outputstream;
	}


	//method
	public void transform(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Hello! Can you indicate the pathway to your .txt file that contains the titles? \n");
		titlesfilename = reader.next();
		
		System.out.print("Thanks, and the one with the words to ignore? \n");
		wordstoignorefilename = reader.next();
		reader.close();
		

		try (BufferedReader br = new BufferedReader(new FileReader(titlesfilename))) {
				String sCurrentLine;
				ArrayList<ArrayList<String>> aas = new ArrayList<ArrayList<String>>();
				Stream<ArrayList<ArrayList<String>>> stream = new Stream<ArrayList<ArrayList<String>>>(aas);
				this.setOutputstream(stream);
				while ((sCurrentLine = br.readLine()) != null) {
					ArrayList<String> newtitle = new ArrayList<String>();
					String[] words = sCurrentLine.split(" ");
					for (int i=0; i< words.length; i++){
						newtitle.add(words[i]);
					}
					this.outputstream.content.add(newtitle);
			
			}
			} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br2 = new BufferedReader(new FileReader(wordstoignorefilename))) {
			String sCurrentLine;
			ArrayList<String> list = new ArrayList<String>();
			while ((sCurrentLine = br2.readLine()) != null) {
				list.add(sCurrentLine);
			}
			this.outputstream.content.add(list);
		
		
		} catch (IOException e) {
		e.printStackTrace();
		}

		}


	
	public void setInputstream(Stream<T> stream) {
		this.inputstream = stream;
	}

}
