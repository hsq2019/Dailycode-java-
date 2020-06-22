package niuke;
import java.lang.Math;

public class RichAndPoor {
    public static void main(String[] args) {
        long rich=0;
        long poor=0;
        for(int i=0;i<30;i++){
            rich+=10;
            poor=poor+(long)Math.pow(2,i);
        }
        System.out.println(rich+" "+poor);
    }
}
