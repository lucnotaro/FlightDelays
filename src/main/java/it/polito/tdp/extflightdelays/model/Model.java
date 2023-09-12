package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport,DefaultWeightedEdge> grafo; 
	private ExtFlightDelaysDAO dao;
	private Map<Integer,Airport> idMap;
	
	public Model() {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.dao=new ExtFlightDelaysDAO();
		this.idMap=new HashMap<>();
		this.dao.loadAllAirports(idMap);
	}
	
	public void creaGrafo(Integer x) {
		this.grafo=new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo,this.dao.getVertici(x,idMap));
		List<Rotta> edges=this.dao.getRotte(idMap);
		for(Rotta r:edges) {
			Airport origine=r.getOrigine();
			Airport destinazione=r.getDestinazione();
			Integer n=r.getN();
			if(this.grafo.vertexSet().contains(origine) && this.grafo.vertexSet().contains(destinazione)) {
				DefaultWeightedEdge edge=this.grafo.getEdge(origine,destinazione);
			    if(edge!=null) {
				double w=this.grafo.getEdgeWeight(edge);
				w+=n;
				this.grafo.setEdgeWeight(origine,destinazione,w);
			    }else {
				this.grafo.addEdge(origine,destinazione);
				this.grafo.setEdgeWeight(origine,destinazione,n);
			    }
			}	
		}
		System.out.println("vertici: "+this.grafo.vertexSet().size());
		System.out.println("archi: "+this.grafo.edgeSet().size());
	}
	
}



















