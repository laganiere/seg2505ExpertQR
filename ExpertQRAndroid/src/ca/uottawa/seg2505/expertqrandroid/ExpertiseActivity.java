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

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.seg2505.expertqrandroid.util.UtilisateurUtil;

public class ExpertiseActivity extends ActionBarActivity {
	
	private Spinner spinnerChoixExpertise = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expertise);
		spinnerChoixExpertise = (Spinner)findViewById(R.id.spinnerChoixExpertise);
		updateUI();
	}
	
	private void updateUI() {
		// chercher les expertise de parse
		List<Expertise> expertises = Delegateur.getListeExpertises();
		ArrayAdapter<Expertise> adapter = new ArrayAdapter<Expertise>(this,
    			android.R.layout.simple_spinner_item, expertises);
    	spinnerChoixExpertise.setAdapter(adapter);
    	
    	// chercher l'expertise de l'utilisateur
		Expertise expertise = UtilisateurUtil.getExpertise();
		if (expertise != null) {
			int index = expertises.indexOf(expertise);
			spinnerChoixExpertise.setSelection(index);
		}
	}
	
	public void onAjouterExpertise(View view) {
		EditText ed = (EditText)findViewById(R.id.editTextNouvelleCategorie);
    	String cat = ed.getText().toString();
    	Expertise expertise = new Expertise();
    	expertise.setTexte(cat);
    	Delegateur.sauvegardeExpertise(expertise);
	}

	public void onOk(View view) {
		Expertise cat = (Expertise)spinnerChoixExpertise.getSelectedItem();
		if (cat != null) {
			UtilisateurUtil.setExpertise(cat);
		}
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expertise, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
