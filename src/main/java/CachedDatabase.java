public class CachedDatabase extends Database{

    public CachedDatabase(Database nextLevel) {
        super(nextLevel);
    }

    public String getDatabaseName(){
        return "Cached Database";
    }
}
