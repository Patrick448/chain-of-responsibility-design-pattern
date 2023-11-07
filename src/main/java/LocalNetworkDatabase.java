public class LocalNetworkDatabase extends Database{

    public LocalNetworkDatabase(Database nextLevel) {
        super(nextLevel);
    }

    public String getDatabaseName(){
        return "Local Network Database";
    }
}
