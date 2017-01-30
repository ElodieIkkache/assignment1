import java.util.ArrayList;

/**
	 * @author Elodie
	 *
	 */


public class CircularShift <T extends ArrayList<ArrayList<String>>,U extends ArrayList<ArrayList<String>>> extends Filter<ArrayList<ArrayList<String>>,ArrayList<ArrayList<String>>> {
	private Stream<ArrayList<ArrayList<String>>> inputstream;
	private Stream<ArrayList<ArrayList<String>>> outputstream;
		
	//constructors
	public CircularShift() {
		super();
	}

	
	//getters and setters

	public Stream<ArrayList<ArrayList<String>>> getInputstream() {
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
		ArrayList<ArrayList<String>> aas = new ArrayList<ArrayList<String>>();
		Stream<ArrayList<ArrayList<String>>> str = new Stream<ArrayList<ArrayList<String>>>(aas);
		this.outputstream = str;
		
		int sizeinput = this.inputstream.content.size();
		
		for (int counter=0; counter<(sizeinput-1); counter++){
			ArrayList<String> title = new ArrayList<String>();
			title = this.inputstream.content.get(counter);
			for (int j=0; j<(title.size()); j++){
				String word = title.get(0);
				if (this.inputstream.content.get(sizeinput-1).contains(word)){
					}
				else {
					ArrayList<String> newtitle = (ArrayList<String>) title.clone();
					this.outputstream.content.add(newtitle);
				}
				
				title.remove(0);
				title.add(word);
			}
			
		}
		//empty the inputstream
		ArrayList<ArrayList<String>> empty = new ArrayList<ArrayList<String>>();
		Stream<ArrayList<ArrayList<String>>> emptystream = new Stream<ArrayList<ArrayList<String>>>(empty);
		this.setInputstream(emptystream) ;
		
	}
	
	public void setInputstream(Stream<ArrayList<ArrayList<String>>> stream) {
		this.inputstream = stream;
	}

}
