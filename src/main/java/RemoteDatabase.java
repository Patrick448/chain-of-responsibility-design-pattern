public class RemoteDatabase extends Database{

    public RemoteDatabase(Database nextLevel) {
        super(nextLevel);
    }

    public String getDatabaseName(){
        return "Remote Database";
    }
}
