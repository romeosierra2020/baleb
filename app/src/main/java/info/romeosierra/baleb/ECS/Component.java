package info.romeosierra.baleb.ECS;

public abstract class Component {
    private String entityTag;
    private int entityId;
//    public Entity entity = null;
    public abstract void update(float dt);

    public void setEntityTag(String entityTag) {
        this.entityTag = entityTag;
    }
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public void start() {
    }
}
