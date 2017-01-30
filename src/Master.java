/**
 * @author Elodie
 *
 */

import java.util.ArrayList;

public class Master {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//creation of the filters
		Input<ArrayList<String>, ArrayList<ArrayList<String>>> i = new Input<ArrayList<String>, ArrayList<ArrayList<String>>>();
		CircularShift<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> c = new CircularShift<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>>();
		Alphabetizer<ArrayList<ArrayList<String>>, ArrayList<String>> a = new Alphabetizer<ArrayList<ArrayList<String>>, ArrayList<String>>();
		Output<ArrayList<String>, String> o = new Output<ArrayList<String>, String>();
		
		//creation of the pipes
		Pipe<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>> pipeIC = new Pipe<ArrayList<ArrayList<String>>, ArrayList<ArrayList<String>>>();
		Pipe<ArrayList<ArrayList<String>>, ArrayList<String>> pipeCA = new Pipe<ArrayList<ArrayList<String>>, ArrayList<String>>();
		Pipe<ArrayList<String>, String> pipeAO = new Pipe<ArrayList<String>, String>();
		
		
		//sends it into the filters
		i.transform();
		pipeIC.setInputstream(i.getOutputstream());
		pipeIC.sendtonextfilter(c);
		c.transform();
		pipeCA.setInputstream(c.getOutputstream());
		pipeCA.sendtonextfilter(a);
		a.transform();
		pipeAO.setInputstream(a.getOutputstream());
		pipeAO.sendtonextfilter(o);
		o.transform();
		
		
		
			
		
	}

}
