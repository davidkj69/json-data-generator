package net.acesinc.data.json.generator.types;

import java.util.List;

import net.acesinc.data.json.generator.utils.JsonDictionary;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

public class DictionaryType extends TypeHandler {

	public static final String TYPE_NAME = "dictionary";
    public static final String TYPE_DISPLAY_NAME = "Dictionary";
    
    private String key = null;
    
    @Override
    public void setLaunchArguments(String[] launchArguments) {
        super.setLaunchArguments(launchArguments);
        if (!ArrayUtils.isEmpty(launchArguments) && launchArguments[0].contains("[") && launchArguments[0].contains("]")) {
        	key = StringUtils.remove(StringUtils.remove(launchArguments[0], '['), ']' );
        }
        
        if (key == null)
        	throw new RuntimeException("You need to specify a key");
        
        if ( !JsonDictionary.getInstance().getDictionary().containsKey(key) )
        	throw new RuntimeException("You need to specify a valid key");
    }
    
	@Override
	public Object getNextRandomValue() {
		List<String> values = JsonDictionary.getInstance().getDictionary().get(key);
		Object random = values.get(getRand().nextInt(0, values.size() - 1));
		if (random instanceof String) {
			return random;
		} else	{		
			return random;  // JsonDictionary.getInstance().toJson(random);
		}
	}

	@Override
	public String getName() {
		return TYPE_NAME;
	}

}
