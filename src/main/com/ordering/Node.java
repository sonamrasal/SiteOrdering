package main.com.ordering;

public class Node {

	private String site;

	public Node(String site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return site;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		Node node = (Node) o;	
		return node.site.equals(this.site);
	}
	
	@Override
	public int hashCode() {
		return this.site.hashCode();
	}
}
