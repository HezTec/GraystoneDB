package GraystoneView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomePage {

	    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

	    public HomePage() {

	        rootPane = new BorderPane();
	        // build UI, register event handlers, etc etc
	        

	    }

	    public Pane getRootPane() {
	        return rootPane ;
	    }

	    // other methods you may need to access, etc...

	}