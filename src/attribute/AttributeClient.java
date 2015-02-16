package attribute;

import java.util.HashMap;
import java.util.Map;

public class AttributeClient {
    public static String write(AttributeEntity map) {
        StringBuilder rtn = new StringBuilder();
        rtn.append(map.id);
        for (Map.Entry<String, Attribute> entry : map.map.entrySet()) {
            rtn.append(",");
            rtn.append(entry.getKey());
            rtn.append(":");
            rtn.append(entry.getValue());
        }
        return rtn.toString();
    }
}
