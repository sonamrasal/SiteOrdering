package test.com.ordering;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.com.ordering.Node;
import main.com.ordering.SiteOrdering;

public class SiteOrderingTest {

	private SiteOrdering siteOrdering = new SiteOrdering();

	@Test
	public void visitFirstSite() {
		siteOrdering.visit(new Node("www.bbc.com"));
		assertTrue("www.bbc.com".equals(siteOrdering.latest()));
	}

	@Test
	public void buildOrdering() {
		siteOrdering.visit(new Node("www.bbc.com"));
		siteOrdering.visit(new Node("www.google.com"));
		assertTrue("www.google.com".equals(siteOrdering.latest()));
		assertTrue("www.google.com | www.bbc.com".equals(siteOrdering.history()));
	}

	@Test
	public void revisitSite() {
		siteOrdering.visit(new Node("www.bbc.com"));
		siteOrdering.visit(new Node("www.google.com"));
		siteOrdering.visit(new Node("www.bing.com"));

		assertTrue("www.bing.com".equals(siteOrdering.latest()));
		assertTrue("www.bing.com | www.google.com | www.bbc.com".equals(siteOrdering.history()));

		siteOrdering.visit(new Node("www.bbc.com"));
		assertTrue("www.bbc.com".equals(siteOrdering.latest()));
		assertTrue("www.bbc.com | www.bing.com | www.google.com".equals(siteOrdering.history()));
	}

}
