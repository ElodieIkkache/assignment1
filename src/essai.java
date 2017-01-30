import java.util.ArrayList;

public class essai {

	public static void main(String[] args) {
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
		
		
		CircularShift<ArrayList<ArrayList<String>>,ArrayList<ArrayList<String>>> c = new CircularShift<ArrayList<ArrayList<String>>,ArrayList<ArrayList<String>>>();
		Stream<ArrayList<ArrayList<String>>> stream = new Stream<ArrayList<ArrayList<String>>>(listetitre);
		
		c.setInputstream(stream);
		
		c.transform();
		System.out.print(c.getOutputstream().content);
		
	}

}
