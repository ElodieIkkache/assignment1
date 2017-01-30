/**
 * @author Elodie
 *
 */
public abstract class Filter<T,U> {
	
	//methods
	abstract void transform();
	abstract void setInputstream(Stream<T> stream);
}
