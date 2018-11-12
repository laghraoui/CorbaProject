package sysdist;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class HelloServer {
	
	public static void main(String[] args){
		
		try {
			
		//create and initialize the ORB
		ORB orb = ORB.init(args, null);
		
		//Get reference to rootpoa & activate the POAManager
		POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		
			rootpoa.the_POAManager().activate();
		 
		
		//create servant and register it with the ORB
		HelloImpl helloImpl = new HelloImpl();
		helloImpl.setOrb(orb);
		
		//get object reference from
	    // obtention d'une référence sur l'objet servant
	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
	    
	    // la méthode narrow "caste" la référence à l'objet CORBA obtenue 
	    // en une référence dans son type propre
	    Hello exempleClassRef = HelloHelper.narrow(ref);

	    // Obtention d'une référence générique pour le service de nommage
	    org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	    
	    
	    // L'objet obtenu est un objet CORBA générique. Il est converti dans
	    // son type propre grâce à la classe HelloHelper générée par le compilateur
	    NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	    
	    // création du nom symbolique de l'objet servant
	    String nom = "Hello";
	    NameComponent path[] = ncRef.to_name(nom);
	    
	    // Lier la référence de l'objet servant (instance de HelloImpl) à son nom symbolique    
	    ncRef.rebind(path, (org.omg.CORBA.Object) exempleClassRef);

	    System.out.println(" HelloServer est prêt et attend une invocation de méthode");
	    
	    // mise en attente des invocations client
	    orb.run();
		}
		
	    catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
