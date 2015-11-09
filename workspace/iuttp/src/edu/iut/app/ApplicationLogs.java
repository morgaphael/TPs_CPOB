package edu.iut.app;

import java.util.ArrayList;


public class ApplicationLogs extends ArrayList<IApplicationLog> {

	public ApplicationLogs() {		
	}
	
	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for(IApplicationLog l : this)
		{
			if (l instanceof ApplicationErrorLog)
				filteredLogs.add(l);
		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for(IApplicationLog l : this)
		{
			if (l instanceof ApplicationWarningLog)
				filteredLogs.add(l);
		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for(IApplicationLog l : this)
		{
			if (l instanceof ApplicationInfoLog)
				filteredLogs.add(l);
		}
		return filteredLogs;
	}
	

}
