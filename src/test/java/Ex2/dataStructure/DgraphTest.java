package Ex2.dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex2.utils.Point3D;

class DgraphTest {

	@Test
	void getNode() {


		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		graph t = new DGraph();
		t.addNode(v3);
		//t.getNode(1).getKey();

		assertEquals(t.getNode(1), null);
		assertEquals(t.getNode(2), null);
		assertEquals(t.getNode(3) ,v3);

	}
	@Test
	void getEdge() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		//t.getNode(1).getKey();


		t.connect(2, 4, 0);
		edge_data ed =  t.getEdge(2, 4);
		assertEquals(t.getEdge(1, 2), null);
		assertEquals(t.getEdge(2, 4), ed);
		//		assertEquals(t.getNode(3) ,v3);


	}
	@Test
	void addNode() {

		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);

		assertEquals(t.getNode(v1.getKey()).getKey(), 1);
		assertEquals(t.getNode(v2.getKey()).getKey(), 2);
		assertEquals(t.getNode(v3.getKey()),null);

	}
	@Test
	void connect() {

		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);


		t.connect(1, 3, 2);
		t.connect(1, 2, 0);
		t.connect(2,3,1);
		assertEquals(t.getEdge(1, 3).getWeight(), 2);
		assertEquals(t.getEdge(1, 2).getWeight(), 0);
		assertEquals(t.getEdge(2, 3).getWeight(), 1);

	}
	@Test
	void removeNode() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		
		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		int nd = t.nodeSize();
		assertEquals(nd, 3);
		t.connect(2, 3, 2);
		t.connect(1, 2, 0);
		t.connect(3,1,1);
		
		t.removeNode(1);
		
		
		assertEquals(t.nodeSize(), 2);
		System.out.println(t.edgeSize());
		assertEquals(t.edgeSize(), 1);
		
		t.removeNode(2);
		assertEquals(t.nodeSize(), 1);
		assertEquals(t.edgeSize(), 0);
		//fail("Not yet implemented");
	}
	@Test
	void removeEdge() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));
		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		
		
		t.connect(2, 3, 2);
		t.connect(1, 2, 0);
		t.connect(3,1,1);
		int nd = t.edgeSize();
		assertEquals(nd, 3);
		t.removeEdge(1, 2);
		int nd2 = t.edgeSize();
		assertEquals(nd2, 2);
		//fail("Not yet implemented");
	}
	@Test
	void nodeSize() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));

		
		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		int nd = t.nodeSize();
		assertEquals(nd, 3);
		//fail("Not yet implemented");
	}
	@Test
	void edgeSize() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));
		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		
		
		t.connect(2, 3, 2);
		t.connect(1, 2, 0);
		t.connect(3,1,1);
		int nd = t.edgeSize();
		assertEquals(nd, 3);
		//fail("Not yet implemented");
	}
	@Test
	void getMC() {
		node_data v1 = new Node(1, new Point3D(0,0,0));
		node_data v2 = new Node(2, new Point3D(0,0,0));
		node_data v3 = new Node(3, new Point3D(0,0,0));
		graph t = new DGraph();
		t.addNode(v1);
		t.addNode(v2);
		t.addNode(v3);
		assertEquals(t.getMC(), 3);
		t.connect(2, 3, 2);
		t.connect(1, 2, 0);
		t.connect(3,1,1);
		assertEquals(t.getMC(),6);
		t.removeEdge(1, 2);
		assertEquals(t.getMC(),7);
		t.removeNode(1);
		assertEquals(t.getMC(),8);
		//fail("Not yet implemented");
	}

}
