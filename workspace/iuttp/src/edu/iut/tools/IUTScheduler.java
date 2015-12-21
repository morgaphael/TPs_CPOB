package edu.iut.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import edu.iut.app.CommandLineOption;
import edu.iut.app.CommandLineParser;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.app.Person.PersonFunction;
import edu.iut.io.XMLProjectReader;
import edu.iut.io.XMLProjectWriter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class IUTScheduler {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.FRANCE);
		
		
		
		CommandLineParser commandLineParser = new CommandLineParser();
		CommandLineOption<java.io.File> configOption = new CommandLineOption<java.io.File>(CommandLineOption.OptionType.FILE, 
				                                                                           "config","configuration file",
				                                                                           new java.io.File("/tmp"));
		CommandLineOption<String> localeOption = new CommandLineOption<String>(CommandLineOption.OptionType.STRING, 
																			   "locale","en|fr",
																			   new String("fr"));

		CommandLineOption<java.io.File> projectOption = new CommandLineOption<java.io.File>(CommandLineOption.OptionType.FILE, 
				   																			"project file","xml project file",
				   																		    new java.io.File("tmp"));
		
		commandLineParser.addOption(configOption);
		commandLineParser.addOption(localeOption);
		commandLineParser.addOption(projectOption);
		
		
		commandLineParser.parse(args);
		
		
		
		System.err.println("Option:"+commandLineParser.getOption("config").getValue());
		ArrayList<ExamEvent> events = XMLProjectReader.load((File) commandLineParser.getOption("project file").getValue());
		
		for(ExamEvent e : events){
			System.out.println(e);
			e.setStudent(new Person(PersonFunction.STUDENT, "arthur", "panetto", "email", "phone"));
		}
		
		XMLProjectWriter.save(events, (File) commandLineParser.getOption("project file").getValue());
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        JFrame mainFrame = new edu.iut.gui.frames.SchedulerFrame("IUT Scheduler");
		        mainFrame.setVisible(true);		        
		    }
		});
	}
	
}
