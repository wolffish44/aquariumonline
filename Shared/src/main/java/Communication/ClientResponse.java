package Communication;

public class ClientResponse
{
    private Object parameter;
    CLIENTRESPONSETYPE clientResponseType;
    public CLIENTRESPONSETYPE getClientResponseType() {
        return clientResponseType;

    }
    public void setClientResponseType(CLIENTRESPONSETYPE clientResponseType) {
        this.clientResponseType = clientResponseType;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }
}
