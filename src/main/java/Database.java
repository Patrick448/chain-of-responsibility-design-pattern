import java.util.HashMap;

public abstract class Database {

    private HashMap<String, String> users = new HashMap<String, String>();
    private Database nextLevel;

    public Database(Database nextLevel){
        this.nextLevel = nextLevel;
    }

    public void addUser(String id, String name){
        this.users.put(id, name);
        if(nextLevel != null){
            nextLevel.addUser(id, name);
        }
    }

    public Database findUser(String id){
        String user = users.get(id);
        Database foundLevel;
            if (user == null && nextLevel != null){
                foundLevel = nextLevel.findUser(id);
            }
            else if (user != null){
                foundLevel = this;
            }
            else{
                 throw new RuntimeException("User not found");
            }

        return foundLevel;
    }

    public abstract String getDatabaseName();
}
