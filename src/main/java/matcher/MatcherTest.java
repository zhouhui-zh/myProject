package matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    public static void main(String[] args) {
        String target ="乘露车露露车，王者乘22路车归来，张军乘eei路车网";
        String reg= "乘+(.)+车";
        Pattern pat=Pattern.compile(reg);
        Matcher mat=pat.matcher(target);
        if(mat.find()){
            String result=mat.group();
            System.out.println(result);
        }
    }
}
