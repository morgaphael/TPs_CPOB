package edu.iut.app;

public class CommandLineOption <ValueType>{
	
	public enum OptionType{
		NONE("None"),
		FILE("File"),
		STRING("String"),
		INTEGER("Integer"),
		DOUBLE("Double"),
		BOOLEAN("Boolean"),
		NOVALUE("NoValue");
		private String optionType;
		
		OptionType(String optionType) {
			this.optionType = optionType;
		}
		
		public String toString() {
			return optionType;
		}		
	}
	
	public CommandLineOption() {
		this.optionType = OptionType.NOVALUE;
	}
	public CommandLineOption(final OptionType optionType, final String key, final String description, final ValueType defaultValue) {
		super();
		setOption(optionType, key, description, defaultValue);
	}
	public void setOption(OptionType optionType, String key, String description, ValueType defaultValue) {
		this.key = key;
		this.description = description;
		this.defaultValue = defaultValue;
		this.value = defaultValue;
		this.optionType = optionType;
	}
	public  void setValue(ValueType value) {
		this.value = value;
	}
		
	public String getKey() {
		return this.key;
	}
	public String getDescription() {
		return this.description;
	}
	public ValueType getValue() {
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	public OptionType getOptionType() {
		return optionType;
	}

	protected String key;
	protected String description;
	protected ValueType defaultValue;
	protected ValueType value;
	protected OptionType optionType;
	

}
