package lesson_22;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation <T extends Transport>{
    private Queue <T> queue;

    public ServiceStation() {
        queue = new LinkedList<>();
    }

    public void addToQueue(T transport) {
        if(transport==null){
            System.out.println("Error! Tranport is NULL");
            return;
        }

        if(transport.isNeedDiagnostic()) {
            if (queue.offer(transport))
                System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно добавлен в очередь на обслуживание");
            else
                System.out.println("что-то пошло не так с " + transport.getModel() + " " + transport.getModel());
        } else
            System.out.println("Автобусы диагностику не проходят! "+transport.getBrand()+" "+transport.getModel());
    }

    public void makeDiagnostic() {
        T transport = queue.poll();
        if (transport != null) {
            System.out.println(transport.getBrand() + " " + transport.getModel() + " успешно прошел облуживание");
        }else
            System.out.println("Очередь на облуживание пуста");
    }
    @Override
    public String toString() {
        String totalTransports = "";
        int count = 0;
        if (queue != null && queue.peek() != null) {
            for (Transport ts: queue) {
                totalTransports+=" #"+(++count)+": "+ts.getModel()+" "+ts.getBrand()+" ";
            }
        }
        if(count==0)
            return "'Очередь на обслуживиние пуста'";
        return totalTransports;
    }
}
