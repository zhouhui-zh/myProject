package lambda;

public interface Ingestion {
    Long ingestion(GroupPriorityQuery groupPriorityQuery, long startId, int limited);

}
