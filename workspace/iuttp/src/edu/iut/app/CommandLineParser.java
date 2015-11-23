package edu.iut.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class CommandLineParser {
	
	protected HashMap<String, CommandLineOption<?>> options;
	protected ArrayList<String> parseErrors;
		
	public CommandLineParser() {
		options = new HashMap<String, CommandLineOption<?> >();
		parseErrors = new ArrayList<String>();
	}
	
	public void addOption(CommandLineOption<?> option) {
		if (option != null) {
			options.put(option.getKey(),option);
		}
	}
	
	public void parse(String[] args) {
		for (String argument: args) {
			String[] keyValue=argument.split("=");
			if (options.containsKey(keyValue[0])) {
				switch (((CommandLineOption<?>)options.get(keyValue[0])).getOptionType()) {
					case FILE:
						CommandLineOption<File> fileOption = (CommandLineOption<File>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							fileOption.setValue(new File(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					/* EX1 : reproduire le comportement de 'case FILE', pour STRING,INTEGER, ... */
					case STRING:
						CommandLineOption<String> stringOption = (CommandLineOption<String>) options.get(keyValue[0]);
						if(keyValue.length == 2 ) {
							stringOption.setValue(keyValue[1]);
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case INTEGER:
						CommandLineOption<Integer> intOption = (CommandLineOption<Integer>) options.get(keyValue[0]);
						if(keyValue.length == 2 ) {
							intOption.setValue(Integer.parseInt(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case DOUBLE:
						CommandLineOption<Double> doubleOption = (CommandLineOption<Double>) options.get(keyValue[0]);
						if(keyValue.length == 2 ) {
							doubleOption.setValue(Double.parseDouble(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case BOOLEAN:
						CommandLineOption<Boolean> boolOption = (CommandLineOption<Boolean>) options.get(keyValue[0]);
						if(keyValue.length == 2 ) {
							boolOption.setValue(Boolean.parseBoolean(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
						
					default:
						parseErrors.add("Unrecognize option type.");						
				}
			}
		}
	}
	
	public CommandLineOption<?> getOption(String key) {
		if (options.containsKey(key)) {
			return options.get(key);
		}
		return null;
	}
	
	public ArrayList<String> getErrors() {
		return parseErrors;
	}
	
}
