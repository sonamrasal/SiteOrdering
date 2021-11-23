package main.com.ordering;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SiteOrdering {

	private LinkedList<Node> sites;
	private Map<String, Node> lookup;

	public SiteOrdering() {
		sites = new LinkedList<Node>();
		lookup = new HashMap<String, Node>();
	}

	public void visit(Node node) {
		if (lookup.containsKey(node.toString())) {
			sites.remove(node);
		} else {
			lookup.put(node.toString(), node);
		}
		sites.addFirst(node);
	}

	public String latest() {
		return sites.getFirst().toString();
	}

	public String history() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sites.size(); i++) {
			sb.append(sites.get(i).toString());
			if (i < sites.size() - 1) {
				sb.append(" | ");
			}
		}
		return sb.toString();
	}

}
