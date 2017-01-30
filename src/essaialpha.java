import java.util.ArrayList;

public class essaialpha {
	public static void main(String[] args) {
		ArrayList<String> titre = new ArrayList<String>();
		ArrayList<String> titre2 = new ArrayList<String>();
		titre2.add("wll");
		titre.add("the");
		titre.add("lost");
		titre.add("world");
		ArrayList<ArrayList<String>> listetitre = new ArrayList<ArrayList<String>>();
		listetitre.add(titre);
		listetitre.add(titre);
		listetitre.add(titre2);
		Stream<ArrayList<ArrayList<String>>> stream = new Stream<ArrayList<ArrayList<String>>>(listetitre);
		
		Alphabetizer<ArrayList<ArrayList<String>>,ArrayList<String>> a = new Alphabetizer<ArrayList<ArrayList<String>>,ArrayList<String>>();
		
		a.setInputstream(stream);
		
		a.transform();
		System.out.print(a.getOutputstream().content);
	}

}
