import static java.lang.Integer.parseInt;

//Arbetar med programmet
public class Model {
    public class CryptModel{
        int teck = 'd';
        int key = '¤';
        String binaryKey = Integer.toBinaryString(key);
        String binaryTeck = Integer.toBinaryString(teck);
        int IntBinaryTeck = parseInt(binaryTeck,2);
        int IntBinaryKey = parseInt(binaryKey,2);
        int xorTeck = IntBinaryTeck^IntBinaryKey;
    }
}
