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
		
		//creates the first stream
		ArrayList<String> titre = new ArrayList<String>();
		titre.add("the");
		titre.add("lost");
		titre.add("world");
		ArrayList<ArrayList<String>> listetitre = new ArrayList<ArrayList<String>>();
		listetitre.add(titre);
		listetitre.add(titre);
		ArrayList<String> interdit = new ArrayList<String>();
		interdit.add("the");
		listetitre.add(interdit);
		Stream<ArrayList<ArrayList<String>>> stream = new Stream<ArrayList<ArrayList<String>>>(listetitre);
		
		//sends it into the filters
		i.transform();
		c.setInputstream(stream);
		c.transform();
		pipeCA.setInputstream(c.getOutputstream());
		pipeCA.sendtonextfilter(a);
		a.transform();
		pipeAO.setInputstream(a.getOutputstream());
		pipeAO.sendtonextfilter(o);
		o.transform();
		
		
		
			
		
	}

}
