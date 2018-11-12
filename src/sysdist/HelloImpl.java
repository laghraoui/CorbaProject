package sysdist;

import org.omg.CORBA.ORB;

public class HelloImpl extends HelloPOA{
	
	ORB orb;

	public void setOrb(ORB orb) {
		this.orb = orb;
	}

	@Override
	public String sayHello() {
		return "Hello isi";
	}

	@Override
	public void sayBye() {
		
		System.out.println("Bye!");
		
	}

}
