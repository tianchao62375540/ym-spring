import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @Auther: tianchao
 * @Date: 2020/2/22 10:41
 * @Description:
 */
public class MySpringApplication {
    public static void run() {
        File base = new File(System.getProperty("java.io.tmpdir"));
        Tomcat tomcat = new Tomcat();


        tomcat.setPort(8888);
        System.out.println(base.getAbsolutePath());
        //String sourcePath = MySpringApplication.class.getResource("/").getPath();

        //告訴tomcat你的源碼在哪裏
        Context ctx = tomcat.addWebapp("/",base.getAbsolutePath());
        //final Context ctx = tomcat.addContext("/", base.getAbsolutePath());
        /*WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",

                sourcePath, "/"));
        ctx.setResources(resources);*/
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
