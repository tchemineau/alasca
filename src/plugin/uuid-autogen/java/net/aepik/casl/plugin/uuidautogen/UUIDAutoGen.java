/*
 * Copyright (C) 2006-2010 Thomas Chemineau
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */


package net.aepik.casl.plugin.uuidautogen;

import net.aepik.casl.core.PluginImpl;
import net.aepik.casl.core.ldap.Schema;
import net.aepik.casl.core.SchemaManager;
import net.aepik.casl.core.ldap.SchemaSyntax;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UUIDAutoGen extends PluginImpl {

	/**
	 * Indique si le plugin peut-être éxécuté.
	 * @return boolean True si c'est le cas, false sinon.
	**/
	public boolean canRun() {

		Schema schema = schemaManager.getCurrentSchema();

		if( schema!=null && schema.getSyntax().toString().equals( "ADSyntax" ) )
			return true;
		return false;
	}

	/**
	 * Retourne une catégorie.
	 * @return String Une catégorie.
	**/
	public String getCategory() {
		return "Active Directory";
	}

	/**
	 * Retourne une description du plugin.
	 * @return String Une description.
	**/
	public String getDescription() {
		return "Cet outil permet de générer des identifiants uniques pour"
				+ " chaque objet sélectionné du schéma en cours.";
	}

	/**
	 * Retourne le nom du plugin.
	 * @return String Un nom sous forme de chaîne de caractères.
	**/
	public String getName() {
		return "Générateur d'UUID";
	}

	/**
	 * Retourne la version du plugin.
	 * @return String Une version.
	**/
	public String getVersion() { return "1.0.1"; }

	/**
	 * Permet de lancer l'application.
	**/
	public void run() {

		if( canRun() ) {
			String schemaId = schemaManager.getCurrentSchemaId();
			Schema schema = schemaManager.getCurrentSchema();

			UUIDAutoGenFrame f = new UUIDAutoGenFrame( parentFrame, schema );
			f.setTitle( getName() + " [" + schemaId + "]" );
			f.setVisible( true );
		}
	}

}
