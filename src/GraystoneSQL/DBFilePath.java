package GraystoneSQL;
import java.io.File;

public abstract class DBFilePath {
	
	private static File jarFile = new File(GraystoneMain.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	private static File file = new File(jarFile.getAbsolutePath() + "\\GraystoneResident.db");
	
	
	public static File getFile() {
		return file;
	}	
}
