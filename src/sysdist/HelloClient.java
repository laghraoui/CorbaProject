package sysdist;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class HelloClient {

	public static void main(String[] args) {
		try{
			
			// création et initialisation de l'ORB
			ORB orb = ORB.init(args, null); 
			// Obtention d'une référence au serveur de noms
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			// L'objet obtenu est un objet CORBA générique. Il est converti dans
			// son type propre grâce à la classe HelloHelper générée par le compilateur
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			// nom symbolique de l'objet recherché
			String nom = "Hello";
			// Obtention d'une référence sur l'objet
			Hello helloImpl = HelloHelper.narrow(ncRef.resolve_str(nom));
			System.out.println(" la référence "+ helloImpl + " sur l'objet est obtenue");
			
			String msg = helloImpl.sayHello();
			System.out.println(msg);
			Thread.sleep(1000);
			helloImpl.sayBye();		
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		

	}

}
