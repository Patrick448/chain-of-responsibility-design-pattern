import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private static CachedDatabase cachedDatabase;
    private static LocalNetworkDatabase localNetworkDatabase;
    private static RemoteDatabase remoteDatabase;


    @BeforeEach
     void setUp() {
        remoteDatabase = new RemoteDatabase(null);
        localNetworkDatabase = new LocalNetworkDatabase(remoteDatabase);
        cachedDatabase = new CachedDatabase(localNetworkDatabase);
    }

    @Test
    void shouldReturnFoundInCache() {
        remoteDatabase.addUser("1", "Maria");
        localNetworkDatabase.addUser("2", "João");
        cachedDatabase.addUser("3", "José");

        assertEquals("Cached Database", cachedDatabase.findUser("3").getDatabaseName());
    }

    @Test
    void shouldReturnFoundLocalNetwork() {
        remoteDatabase.addUser("1", "Maria");
        localNetworkDatabase.addUser("2", "João");
        cachedDatabase.addUser("3", "José");

        assertEquals("Local Network Database", cachedDatabase.findUser("2").getDatabaseName());
    }

    @Test
    void shouldReturnFoundRemote() {
        remoteDatabase.addUser("1", "Maria");
        localNetworkDatabase.addUser("2", "João");
        cachedDatabase.addUser("3", "José");

        assertEquals("Remote Database", cachedDatabase.findUser("1").getDatabaseName());
    }

    @Test
    void shouldReturnNotFound() {
        remoteDatabase.addUser("1", "Maria");
        localNetworkDatabase.addUser("2", "João");
        cachedDatabase.addUser("3", "José");

        try{
            cachedDatabase.findUser("4");
            fail();
        }catch (RuntimeException e){
            assertEquals("User not found", e.getMessage());
        }

    }



}