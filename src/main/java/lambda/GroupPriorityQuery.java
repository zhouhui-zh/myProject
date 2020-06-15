package lambda;

public class GroupPriorityQuery {
    private String engineType;
    private String name;
    private Ingestion ingestion;

    public GroupPriorityQuery(String engineType, Ingestion ingestion) {
        System.out.println("GroupPriorityQuery.....");
        this.ingestion = ingestion;
        this.engineType = engineType;
        this.name = name;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /*public interface Ingestion {
        Long ingestion(GroupPriorityQuery groupPriorityQuery, long startId, int limited);
    }*/
}
