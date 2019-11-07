package GraystoneSQL;
import java.io.File;


/**
 * main class used for testing the db queries and updates
 * 
 * 
 * @author 17col
 *
 */
public class GraystoneMain {
	public static void main(String[] args) {
		
		//getting the DB file path
		File jarFile = new File(GraystoneMain.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		File file = new File(jarFile.getAbsolutePath() + "\\GraystoneResident.db");

		//Checking if the DB file exists and making sure it is in a folder that can be edited
		//if not then it creates it
		if (!file.exists() && !file.isDirectory()) {
			//the object to create the db
			GraystoneCreate c = new GraystoneCreate();
			c.create();
		}
		
		GraystoneReg reg = new GraystoneReg();
		reg.insert();
				
	}
	
}
