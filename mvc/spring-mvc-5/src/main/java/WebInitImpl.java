import com.WebInit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 10:46
 * @Description:
 */
public class WebInitImpl implements WebInit {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("===========WebInitImpl============");
    }
}
