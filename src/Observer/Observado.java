package Observer;

public interface Observado {
	public void addObservador(Observador o);

	public void removeObservador(Observador o);

	public int get(int i);
}
