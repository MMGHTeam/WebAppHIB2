package ir.mmghteam.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//Using this class while extending the mentioned class will enable us to access Spring MVC without the
//old method of servlet configuring through an XML file.
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Includes properties
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{HibernateConfig.class};
    }
    //Includes Spring MVC framework
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }
    //Servlet mapping for DispatcherServlet. In this case the root URL is "/"
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
