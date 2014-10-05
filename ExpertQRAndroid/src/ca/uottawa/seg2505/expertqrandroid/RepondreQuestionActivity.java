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
import android.widget.Toast;
import ca.uottawa.eecs.seg2505.expertqr.Delegateur;
import ca.uottawa.eecs.seg2505.expertqr.model.Expertise;
import ca.uottawa.eecs.seg2505.expertqr.model.Question;
import ca.uottawa.eecs.seg2505.expertqr.model.Reponse;
import ca.uottawa.seg2505.expertqrandroid.util.UtilisateurUtil;

public class RepondreQuestionActivity extends ActionBarActivity {

	private Spinner spinnerChoixQuestion = null;
	private EditText edReponse = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repondre_question);
		
		spinnerChoixQuestion = (Spinner)findViewById(R.id.spinnerRepondreQuestion);
		edReponse = (EditText)findViewById(R.id.editTextReponse);
		
		updateUI();
	}
	
	private void updateUI() {
		Expertise expertise = UtilisateurUtil.getExpertise();
		if (expertise != null) {
			List<Question> questions = Delegateur.getQuestionsPourExpertise(expertise);
			ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(RepondreQuestionActivity.this,
	    			android.R.layout.simple_spinner_item, questions);
	    	spinnerChoixQuestion.setAdapter(adapter);
		} else {
			Toast.makeText(this, R.string.label_pas_de_question, Toast.LENGTH_LONG).show();
		}
	}
	
	public void onOk(View view) {
		Question question = (Question)spinnerChoixQuestion.getSelectedItem();
		if (question != null) {
			Reponse reponse = new Reponse();
			reponse.setQuestion(question);
			reponse.setTexte(edReponse.getText().toString());
			reponse.setExpertID(UtilisateurUtil.getUsername());
			
			Delegateur.sauvegardeReponse(reponse);
		}
		finish();
	}
	
	public void onCancel(View view) {
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.repondre_question, menu);
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
