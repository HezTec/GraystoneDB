package GraystoneSQL;
import java.io.File;
/**
 * This abstract class holds the file path of the db file
 * 
 * -call getFilePath to return the location of the directory 
 * 	that the jarfile is stored in
 * 
 * -call getDBFile to get the database file
 * 
 * @author 17col
 *
 */
public abstract class DBFilePath {
	
	//gets the location of the exported jarfile in the file system
	private static File jarFile = new File(GraystoneMain.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	//uses the jarfile path to find the database path
	private static File file = new File(jarFile.getAbsolutePath() + "\\GraystoneResident.db");
	//the path to the directory where the files are kept
	private static File filePath = new File(jarFile.getAbsolutePath());
	
	/**
	 * method for getting the file path to the database file
	 * @return a file object that points to the db file
	 */
	public static File getDBFile() {
		return file ;
	}
	
	/**
	 * method for getting the directory that the jarfile is stored in
	 * @return a file object that points to the directory of the jarfile
	 */
	public static File getFilePath() {
		return filePath;
	}
}
