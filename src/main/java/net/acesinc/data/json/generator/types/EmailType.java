package net.acesinc.data.json.generator.types;

public class EmailType extends TypeHandler {

	public static final String TYPE_NAME = "email";
    public static final String TYPE_DISPLAY_NAME = "Email";
    
    private AlphaNumericType alpha;
    
    public EmailType() {
    	alpha = new AlphaNumericType();
    	alpha.setLaunchArguments(new String [] {"8"});
    }
    
    private String[] providers = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com", "zoho.com", "yandex.mail", "outlook.com", "mail.com", "inbox.com"};

    
	@Override
	public Object getNextRandomValue() {
		return alpha.getNextRandomValue() + "@" + providers[getRand().nextInt(0, providers.length - 1)];
	}

	@Override
	public String getName() {
		return TYPE_NAME;
	}

}
