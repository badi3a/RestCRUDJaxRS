package rest.ressources;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import rest.entities.*;

@Path("employes")
public class EmployeRessources {
	//j'ai crée cette liste static pour simuler une BD
    public static List<Employe> listeEmploye= new ArrayList<Employe>();
    
	public EmployeRessources() {
		// TODO Auto-generated constructor stub
	}
	
	//méthode POST: Ajouter un objet de type employe dans la liste
	@POST
    @Consumes(MediaType.APPLICATION_XML)
	public Response ajouterEmploye(Employe employe) {
		 listeEmploye.add(employe);
		 System.out.println("add");
		 return Response
			      .status(200)
			      .header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity("")
			      .build();
	}

	//méthode GET: la liste des employes
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response afficherListeEmployes() {
		if (listeEmploye == null) {
			System.out.println("hello");
			return null;
		} else {
			System.out.println("hello2");
			return Response
				      .status(200)
				      .header("Access-Control-Allow-Origin", "*")
				      .header("Access-Control-Allow-Methods", 
				        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				      .entity(listeEmploye)
				      .build();
		}
	}
	
	//méthode Put: Modifier un employe
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public String modifEmploye(Employe e) {
		int index = getIndexByCin(e.getCin());
		if(index != -1) {
			listeEmploye.set(index, e);
			return "Employe modifié";
		}
		else return "Message Error";
	}
	
	
	//Méthode delete 
	@DELETE
	@Path("{cin}")
	//@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmploye(@PathParam(value="cin") String cin) {
		int index = getIndexByCin(cin);
		if(index != -1) {
			listeEmploye.remove(index);
			return "True";
		}
		else return "false";
	}
	
	public int getIndexByCin(String cin) {
		for(Employe emp: listeEmploye) {
			if(emp.getCin().equals(cin)) {
				return listeEmploye.indexOf(emp);
			}
			}
			return -1;
		
	}
	
		
	}
	

