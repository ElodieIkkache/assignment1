/**
 * @author Elodie IKKACHEs
 *
 */
public class Pipe <T,U>{
	private Stream<T> inputstream;
	
	//constructor
	/**
	 * 
	 */
	public Pipe() {
	}

	// getters and setters
	public Stream<T> getInputstream() {
		return inputstream;
	}

	public void setInputstream(Stream<T> inputstream) {
		this.inputstream = inputstream;
	}
	
	//methods
	public void sendtonextfilter(Filter<T,U> nextfilter) {
		nextfilter.setInputstream(this.getInputstream());
		this.setInputstream(null);
	}

		

}
