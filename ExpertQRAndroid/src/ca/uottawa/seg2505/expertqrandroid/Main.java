package ca.uottawa.seg2505.expertqrandroid;

import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.seg2505.expertqrandroid.parse.ParseFacade;

import com.parse.Parse;

import android.app.Application;

/**
 * @author Hanna
 *
 */
public class Main extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this,
				"448LCfDpX4KQW2j6HHbpXbhOBLiRHm2eqCrEjHWD", 
				"d4x4A5SJVyWYyznzqlOj6Q8MXnGdD2W6K3HkrfHl");
		
		Delegateur.setDBFacade(new ParseFacade());
	}
}
