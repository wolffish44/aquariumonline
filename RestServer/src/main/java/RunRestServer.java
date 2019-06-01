

import org.apache.log4j.BasicConfigurator;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//
public class RunRestServer
{
    private static final Logger log = LoggerFactory.getLogger(RestServerEndPoint.class);
    static int port = 11;
    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        Server server = new Server(port);
        server.setHandler(getJerseyHandler());

        server.start();
        log.info("Start rest server");
        server.join();
        log.info("Server joined");
    }

    private static Handler getJerseyHandler() {
        log.info("Create Jersey handler");
        ServletContextHandler handler = new ServletContextHandler(
                ServletContextHandler.SESSIONS);

        handler.setContextPath("/");

        ServletHolder servletHolder = handler.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(0);
        servletHolder.setInitParameter("jersey.config.server.provider.classnames",
                RestServerEndPoint.class.getCanonicalName());

        return handler;
    }
}
