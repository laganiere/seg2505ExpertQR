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
package ca.uottawa.eecs.seg2505.expertqr.model;

import java.io.Serializable;

import ca.uottawa.eecs.seg2505.expertqr.Constantes;

/**
 * @author Hanna
 *
 */
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 5825260818261095125L;
	/**
	 * le nom de l'utilisateur est unique
	 */
	protected String nom = Constantes.STRING_VIDE;
	/**
	 * Cette valeur n'est pas nulle si l'utilisateur est un expert
	 */
	protected Expert roleExpert = null;
	
	public Utilisateur() {
	}
	
	/**
	 * @return le nom de l'utilisateur
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom le nom de l'utilisateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Un objet qui n'est pas nul si l'utilisateur est un expert
	 */
	public Expert getRoleExpert() {
		return roleExpert;
	}

	/**
	 * @param roleExpert Le role expert associe a l'utilisateur
	 */
	public void setRoleExpert(Expert roleExpert) {
		this.roleExpert = roleExpert;
	}
}
