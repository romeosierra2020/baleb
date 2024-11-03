package info.romeosierra.baleb.ECS;

import java.util.List;

public class Entity {
    private String entityTag;
    private int entityId;
    private List<Component> components;
    public Entity() {
        entityTag = "";
        entityId = 0;
    }
    public Entity(String entityTag) {
        this.entityTag = entityTag;
        entityId = 0;
    }
    public Entity(int entityId) {
        entityTag = "";
        this.entityId = entityId;
    }
    public Entity(String entityTag, int entityId) {
        this.entityId = entityId;
        this.entityTag = entityTag;
    }
    public <T extends Component> T getComponent(Class<T> componentClass) {
        for(Component c : components) {
            if(componentClass.isAssignableFrom(c.getClass())) {
                try {
                    return componentClass.cast(c);
                } catch(ClassCastException e) {
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for(int i = 0; i < components.size(); i++) {
            Component c = components.get(i);
            if(componentClass.isAssignableFrom(c.getClass())) {
                components.remove(i);
                return;
            }
        }
    }
    public void addComponent(Component c) {
        c.setEntityTag(entityTag);
        c.setEntityId(entityId);
        //c.entity = this; ?? alternative way of referencing ??
        components.add(c);
    }
    public void update(float dt) {
        for(int i = 0; i < components.size(); i++) {
            components.get(i).update(dt);
        }
    }
    public void start() {
        for(int i = 0; i < components.size(); i++) {
            components.get(i).start();
        }
    }
}
