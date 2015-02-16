package attribute;

import java.util.HashMap;
import java.util.Map;

public class AttributeEntity {
    public int id;
    public Map<String, Attribute> map = new HashMap<>();
    
    public int hashCode() {
        return id;
    }
}
