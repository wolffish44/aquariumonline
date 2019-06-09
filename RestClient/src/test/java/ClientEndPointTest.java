import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientEndPointTest
{
    ClientEndPoint clientEndPoint = new ClientEndPoint();

    @Test
    public void clientConnectionIsSuccessful()
    {
       User user= clientEndPoint.getTestUser();
       int expectedUserId =1;
       int resultUserId =user.getId();
        assertEquals(expectedUserId,resultUserId);
    }
    @Test
    public void postUserIsSuccessful()
    {
        clientEndPoint.postUser();
    }

}