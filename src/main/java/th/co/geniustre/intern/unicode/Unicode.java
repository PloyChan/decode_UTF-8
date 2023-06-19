package th.co.geniustre.intern.unicode;

import java.util.Map;

public class Unicode {
    public Map<Integer,Character> unicodeChars = Map.of(3585,'ก',3586,'ข',3588,'ค');
    public Character getChar(int codePoint){
        return unicodeChars.get(codePoint);
    }

}
