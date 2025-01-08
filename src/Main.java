import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] s = {"2","5","9","34","30","3"};
        Arrays.sort(s,(a,b) -> (b+a).compareTo(a+b));
        System.out.println(s[0] +" " +  s[1] + " " + s[2] + " " + s[3]
                + " " +  s[4] + " "  + s[5] );
    }
}