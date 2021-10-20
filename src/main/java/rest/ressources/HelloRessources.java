package rest.ressources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("greeting")
public class HelloRessources {

	public HelloRessources() {
		// TODO Auto-generated constructor stub
	}
	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(){
		return "Hello form JAX-RS: classe 4SE2"; 
	}
	 
	
	
	
	@GET
	@Path("{FistName}/{LastName}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloTo(@PathParam(value="FistName") String prenom,
			@PathParam(value="LastName") String nom)  {
		return "hello from Jax-RS: "+ prenom +nom;
	}
	

}
