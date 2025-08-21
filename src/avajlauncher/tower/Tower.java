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
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
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