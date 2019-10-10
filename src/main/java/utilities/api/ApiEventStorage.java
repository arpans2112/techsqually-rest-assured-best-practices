package utilities.api;

import java.util.*;

public class ApiEventStorage {


    private static ApiEventStorage instance ;
    private LinkedHashMap<String, LinkedList<ApiEvent>> producedEvents = new LinkedHashMap<>();
    private LinkedHashMap<String, LinkedList<ApiEvent>> consumedEvents = new LinkedHashMap<>();

    private String lastEventNameProduced;
    private String lastEventNameConsumed;





    private ApiEventStorage(){
        instance = this;
    }


    public static ApiEventStorage getInstance(){
        return instance == null ? new ApiEventStorage() : instance;

    }

    public static void reset(){
        instance.producedEvents.clear();
        instance.consumedEvents.clear();
        instance.lastEventNameConsumed = null;
        instance.lastEventNameProduced = null;

    }

    /**Adding an object of an event class in the List of Produced Event*/
    public String addProducted(ApiEvent apiEvent){

        int newKeyNumber = 0;

        LinkedList<ApiEvent> producedEventList = new LinkedList<>();

        if (this.producedEvents.containsKey(apiEvent.getName())){

            for (int count = 1 ; count < 99999 ; count++){

                if (this.producedEvents.containsKey(apiEvent.getName() + "_" + count)){

                }else {
                    newKeyNumber = count;
                    break;
                }
            }

            String newKey = apiEvent.getName() + "_" + newKeyNumber;
            producedEventList =  this.producedEvents.computeIfAbsent(newKey  , v -> {
            return new LinkedList<>();
            });
            producedEventList.add(apiEvent);
            this.lastEventNameProduced = newKey;


        }else{
            producedEventList =   this.producedEvents.computeIfAbsent(apiEvent.getName(),k -> {
                return new LinkedList<>();
            });
            producedEventList.add(apiEvent);

        }


        this.lastEventNameProduced = apiEvent.getName();
        return this.lastEventNameProduced;
    }

    public String addConsumed(ApiEvent apiEvent) {

        int newKeyNumber = 0;

        LinkedList<ApiEvent> consumedEventList = new LinkedList<>();

        if (this.producedEvents.containsKey(apiEvent.getName())){

            for (int count = 1 ; count < 99999 ; count++){

                if (this.producedEvents.containsKey(apiEvent.getName() + "_" + count)){

                }else {
                    newKeyNumber = count;
                    break;
                }
            }

            String newKey = apiEvent.getName() + "_" + newKeyNumber;

            consumedEventList =  this.producedEvents.computeIfAbsent(newKey  , v -> {
                return new LinkedList<>();
            });
            consumedEventList.add(apiEvent);
            this.lastEventNameConsumed = newKey;


        }else{
            consumedEventList =   this.producedEvents.computeIfAbsent(apiEvent.getName(),k -> {
                return new LinkedList<>();
            });
            consumedEventList.add(apiEvent);
            this.lastEventNameConsumed = apiEvent.getName();

        }

        return this.lastEventNameConsumed;

    }





    public ApiEvent getLastEventProduced() {
        return this.producedEvents.get(this.lastEventNameProduced).getFirst();
    }


    public ApiEvent getProducedEventWithName(String eventName) {
       if (this.producedEvents.containsKey(eventName)){
           return this.producedEvents.get(eventName).getFirst();
       }else {
           throw new RuntimeException("Produced event is not found by name: " + eventName);
       }
    }


    public ApiEvent getConsumedEventWithName(String eventName) {
        if (this.consumedEvents.containsKey(eventName)){
            return this.consumedEvents.get(eventName).getFirst();
        }else {
            throw new RuntimeException("Consumed event is not found by name: " + eventName);
        }
    }


    public ApiEvent getLastEventConsumed() {
        return this.consumedEvents.get(this.lastEventNameConsumed).getFirst();
    }

}
