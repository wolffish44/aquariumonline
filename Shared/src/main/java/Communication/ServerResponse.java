package Communication;

public class ServerResponse
{
    private SERVERRESPONSETYPE serverResponseType;
    private Object parameter;

    public SERVERRESPONSETYPE getServerResponseType() {
        return serverResponseType;

    }

    public void setServerResponseType(SERVERRESPONSETYPE serverResponseType) {
        this.serverResponseType = serverResponseType;
    }
    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }
}
