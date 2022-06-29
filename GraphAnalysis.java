import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A Program to determine if a given graph is strongly connected
 * @author Kendrick Smith
 * @param <E>
 *
 */

public class GraphAnalysis<E> {
	Graph<E> graph;

	/**
	 * Take a graph object and store it to run analysis
	 * @param g
	 */
	public GraphAnalysis(Graph<E> g) {
		graph = g;
	}
	
	/**
	 * This method will determine if the graph is connected.
	 * That is, there is a path between all pairs of vertices.
	 * @return
	 */
	public boolean isConnected() {
		Set<E> v = this.graph.getVertexes();
		E x;
		Set<E> set = new HashSet<E>();
		Iterator<E> it = v.iterator();
		while(it.hasNext()) {
			x = it.next();
			set.addAll(this.graph.getAllAdjacent(x));
		}
		
		return set.equals(v);
	}
	
	/**
	 * Determines if a set of vertices is a vertex cut
	 * @param vertices
	 * @return
	 */
	public boolean isVertexCut(Set<E> vertices) {
		Set<E> v = this.graph.getVertexes();
		Iterator<E> it = vertices.iterator();
		Iterator<E> vit = v.iterator();
		E x;
		while (vit.hasNext()) {
			Set<E> check = new HashSet<E>();
			check.addAll(vertices);
			x = vit.next();
			if(!check.addAll(this.graph.getAllAdjacent(x))) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public Set<E> getCriticalVertices(){
		HashSet<E> output = new HashSet<E>();
		E x;
		Iterator<E> it = this.graph.getVertexes().iterator();
		while(it.hasNext()) {
			HashSet<E> set = new HashSet<E>();
			set.add(x = it.next());
			if(isVertexCut(set)) {
				output.add(x);
			}
		}
		
		return output;
	}
	
	

}
