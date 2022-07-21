package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().replaceAll(" ", "~").split("~");
        BigInteger a = new BigInteger(split[0]);
        BigInteger b = new BigInteger(split[1]);

        a = a.add(b);

        System.out.println(a);

    }
}
