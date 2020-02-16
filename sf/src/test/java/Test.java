import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tianchao
 * @Date: 2020/2/16 19:12
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String[] strings = list.toArray(new String[list.size()]);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
