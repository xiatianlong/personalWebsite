package com.personalWebsite.listener;

import com.personalWebsite.dictionary.DictionarySingleton;
import com.personalWebsite.entity.DictionaryEntity;
import com.personalWebsite.service.DictionaryService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * DictionaryListener
 * Created by xiatianlong on 2018/1/6.
 */
@WebListener()
public class DictionaryListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    /**
     * 日志
     */
    private final Logger log = Logger.getLogger(getClass());

    // Public constructor is required by servlet spec
    public DictionaryListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized for DictionaryListener ---------- xtl---------begin--");
        // 获取字典表全部内容，放如单例中供使用
        ServletContext sc = sce.getServletContext();
        ApplicationContext beans = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
        DictionaryService dictionaryService = beans.getBean(DictionaryService.class);

        List<DictionaryEntity> dictionaryList = dictionaryService.findAll();

        DictionarySingleton.getInstance().setDictionaryList(dictionaryList);

        log.info("contextInitialized for DictionaryListener ---------- xtl---------end--");

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
