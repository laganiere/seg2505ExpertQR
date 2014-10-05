/**
 * This file contains material supporting the course SEG2505: Introduction to Software 
 * Engineering at the University of Ottawa.
 *
 * This program is free software; permission is hereby granted to use, copy, modify,
 * and distribute this source code, or portions thereof, for any purpose, without fee,
 * subject to the restriction that the copyright notice may not be removed
 * or altered from any source or altered source distribution.
 * The software is released on an as-is basis and without any warranties of any kind.
 * In particular, the software is not guaranteed to be fault-tolerant or free from failure.
 * The author disclaims all warranties with regard to this software, any use,
 * and any consequent failure, is purely the responsibility of the user.
 */
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
