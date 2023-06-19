package th.co.geniustre.intern.unicode;

public class UTF8Decoder {
    public String decode(byte[] utf8s) {
        Unicode unicode = new Unicode();
        StringBuilder str = new StringBuilder();
        final int PREFIX = 0b1110_0000;
        final int BIT_MASK_STARTER = 0b0000_1111;
        final int BIT_MASK_FOLLOWER = 0b0011_1111;
        int result = 0, total = 0, i = 0;

        while (i < utf8s.length) {
            if (PREFIX == (PREFIX & utf8s[i])) {
                total = utf8s[i] & BIT_MASK_STARTER;
                result += total << 12;
                total = utf8s[i + 1] & BIT_MASK_FOLLOWER;
                result += total << 6;
                total = utf8s[i + 2] & BIT_MASK_FOLLOWER;
                result += total;
                String st = unicode.unicodeChars.get(result).toString();
                str.append(st);
                result = 0;
            }
            i++;
        }
        return str.toString();
    }
}
