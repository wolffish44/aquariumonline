import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;



public class RunServer
{
    static int port = 10;
    public static void main (String[] args)
    {
        runServer();
    }


    public static void runServer()
    {
        org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        connector.setIdleTimeout(30000);
        server.addConnector(connector);
        ServletContextHandler webSocketContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
        webSocketContext.setContextPath("/");
        server.setHandler(webSocketContext);

        try {

            ServerContainer wscontainer = WebSocketServerContainerInitializer.configureContext(webSocketContext);
            wscontainer.addEndpoint(ServerEndPoint.class);
            server.start();
            server.join();
        } catch (Throwable t) {
            t.printStackTrace(System.err);
        }
    }
}
