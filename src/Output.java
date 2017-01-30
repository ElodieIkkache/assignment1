/**
	 * @author Elodie
	 *
	 */

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Output<T extends ArrayList<String>,U> extends Filter<ArrayList<String>,U> {
	private Stream<ArrayList<String>> inputstream;
	//private Stream<WriteFile> writeFile;
	
	private static final String filename = "C:/Users/Elodie/Desktop/cours/software engineering principles and patterns/project/shifted titles.txt";
	
	
	//constructors
	public Output() {
		super();
	}

	
	//getters and setters

	public Stream<ArrayList<String>> getInputstream() {
		return inputstream;
	}


	//method
	public void transform(){
		//display
		System.out.print("This is the relevent shifted titles: ");
		System.out.print("\n");
		System.out.print("\n");
		for (int i=0; i<this.inputstream.content.size(); i++){
			System.out.print(this.inputstream.content.get(i));
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("your work has been saved in a .txt file");
		
		//save in a file !!!!!!!!!!!!!!!!!!

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String content = "List of the relevent shifted titles:";
			String newLine = System.getProperty("line.separator");
			content = content + newLine;
			for (int i=0; i<this.inputstream.content.size(); i++){
				content = content + newLine;
				content = content + this.inputstream.content.get(i);
			}
			

			fw = new FileWriter(filename);
			bw = new BufferedWriter(fw);
			bw.write(content);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		
	
		
		
		
		//erase the input
		ArrayList<String> empty = new ArrayList<String>();
		Stream<ArrayList<String>> emptystream = new Stream<ArrayList<String>>(empty);
		this.setInputstream(emptystream) ;
	}
	
	public void setInputstream(Stream<ArrayList<String>> stream) {
		this.inputstream = stream;
	}

}
