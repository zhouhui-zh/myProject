package lambda;

import com.google.common.collect.Maps;

import java.util.Map;

public class WorkNode {
    Map<String, GroupPriorityQuery> priorityQueueMap = Maps.newConcurrentMap();
    GroupPriorityQuery groupPriorityQuery2 = null;

    public void redirectSubmitJob(String engineType, String name) {
        try {
            System.out.println("priorityQueueMap=" + priorityQueueMap);
            priorityQueueMap.computeIfAbsent(engineType, k -> new GroupPriorityQuery(engineType,
                    (groupPriorityQuery, startId, limited) -> {
                        System.out.println("-emitJob2GQ---->");
                        return this.emitJob2GQ(engineType, groupPriorityQuery, startId, limited);
                    })
            );

            Ingestion ingestion3=(groupPriorityQuery, startId, limited)->{
                System.out.printf("-emitJob2GQ---->");
                return this.emitJob2GQ(engineType, groupPriorityQuery, startId, limited);
            };
            System.out.println("ingestion3=" + ingestion3);


              groupPriorityQuery2 = new GroupPriorityQuery(engineType,
                    ingestion3);

            System.out.println("groupPriorityQuery2=" + groupPriorityQuery2);


        } catch (Exception e) {

        }
    }

    private Long emitJob2GQ(String engineType, GroupPriorityQuery groupPriorityQuery, long startId, int limited) {
        System.out.println("emitJob2GQ");
        System.out.println("groupPriorityQuery");
        System.out.println("startId");
        System.out.println("limited");
        return 3l;
    }

    public static void main(String[] args) {
        WorkNode workNode = new WorkNode();
        workNode.redirectSubmitJob("batch", " ide");

        System.out.println("priorityQueueMap=" + workNode.priorityQueueMap);


        System.out.println("groupPriorityQuery2=" + workNode.groupPriorityQuery2);

    }


}
