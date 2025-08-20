package avajlauncher.tower;

import java.util.ArrayList;
import avajlauncher.aircraft.Flyable;


public class Tower {
    private ArrayList<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable p_flyable) {
        
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }
    
    protected void conditionChanged() {
        System.out.println("Conditions have changed !");
    }
}


/*
 * class Tower
{
- List<Flyable*> observers
+void register(Flyable* p_flyable)
+void unregister(Flyable* p_flyable)
#void conditionChanged()
}
 */