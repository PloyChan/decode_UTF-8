package th.co.geniustre.intern.unicode;

public class UTF8Decoder {
    public String decode(byte[] utf8s){
        Unicode unicode = new Unicode();
        StringBuilder str = new StringBuilder();
        final Integer PREFIX = 0b1110_0000;
        final Integer PREFIX_FOLLOW = 0b10000_0000;
        Integer[] result = new Integer[utf8s.length];;
        int first = 0;
        int follow = 0;
        int total = 0;

        for(int i = 0; i< utf8s.length; i++){
            if(PREFIX.equals(PREFIX & utf8s[i])){
                first = utf8s[i] & 0b0000_1111;
                result[i] = first << 16;
            } else if (PREFIX_FOLLOW.equals(PREFIX_FOLLOW & utf8s[i])){
                follow = utf8s[i] & 0b0011_1111;
                if(first == 0){
                    result[i] = follow << 6;
                } else {
                    result[i] = follow;
                }
                first = follow;
            }
            total += result[i];
            if((i+1) % 3 == 0){
                String unicodeStr = unicode.unicodeChars.get(total).toString();
                str.append(unicodeStr);
                total = 0;
            }

        }
        return str.toString();
    }
}
