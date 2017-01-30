import java.util.ArrayList;


/**
	 * @author Elodie
	 *
	 */


public class Alphabetizer<T extends ArrayList<ArrayList<String>>,U extends ArrayList<String>> extends Filter<ArrayList<ArrayList<String>>,ArrayList<String>> {
	private Stream<ArrayList<ArrayList<String>>> inputstream;
	private Stream<ArrayList<String>> outputstream;
		
	//constructors
	public Alphabetizer() {
		super();
	}

	
	//getters and setters

	public Stream<ArrayList<ArrayList<String>>> getInputstream() {
		return inputstream;
	}
	
	
	public Stream<ArrayList<String>> getOutputstream() {
		return outputstream;
	}

	public void setOutputstream(Stream<ArrayList<String>> outputstream) {
		this.outputstream = outputstream;
	}


	//method
	public void transform(){
		//convert the arrayList<String> into a string
		int sizeinput = this.inputstream.content.size();
		
		ArrayList<String> aas = new ArrayList<String>();
		Stream<ArrayList<String>> str = new Stream<ArrayList<String>>(aas);
		this.outputstream = str;
		
		
		for (int counter=0; counter<(sizeinput); counter++){
			ArrayList<String> title = new ArrayList<String>();
			title = this.inputstream.content.get(counter);
			String newtitle = new String();
			for (int j=0; j<(title.size()); j++){
				String word = title.get(j);
				newtitle = newtitle + word+ " ";
			}
			this.outputstream.content.add(newtitle);
		}
		
		
		//sort the output
		this.outputstream.content.sort(null);
		
		
		//erase the input
		ArrayList<ArrayList<String>> empty = new ArrayList<ArrayList<String>>();
		Stream<ArrayList<ArrayList<String>>> emptystream = new Stream<ArrayList<ArrayList<String>>>(empty);
		this.setInputstream(emptystream) ;
	}
	
	public void setInputstream(Stream<ArrayList<ArrayList<String>>> stream) {
		this.inputstream = stream;
	}

}
