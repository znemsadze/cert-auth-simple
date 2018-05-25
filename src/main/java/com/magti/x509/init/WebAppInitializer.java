package com.magti.x509.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by zviad on 5/20/18.
 * Simple web App initialisation config class
 */
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "spring-mvc";
    private static final String DISPATCHER_SERVLET_MAPPING = "/rest/*";

    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter encoder = new CharacterEncodingFilter();
        encoder.setEncoding("UTF-8");
        encoder.setForceEncoding(true);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", encoder);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(RootConfig.class);
        ServletRegistration.Dynamic springMvc = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(appContext));
        springMvc.setLoadOnStartup(1);
        springMvc.addMapping(DISPATCHER_SERVLET_MAPPING);
        servletContext.addListener(new ContextLoaderListener(appContext));
    }
}
