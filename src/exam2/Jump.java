package exam2;

import java.math.BigDecimal;

public class Jump {

    public static BigDecimal[] arr;

    public static void main(String[] args) {
        int n = 3;
        arr = new BigDecimal[n+1];

    }

    public static BigDecimal calc (int n) {
        BigDecimal bc = new BigDecimal(0);

        for(int i=1 ; i<=n ; i++) {
            if(i==1) bc = BigDecimal.valueOf(1);

        }
        return BigDecimal.valueOf(0);
    }
}
