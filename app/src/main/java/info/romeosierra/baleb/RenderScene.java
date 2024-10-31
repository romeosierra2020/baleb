package info.romeosierra.baleb;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class RenderScene {
    ArrayList<Float> vertices;
    ArrayList<Integer> indices;

    public RenderScene() {
        vertices = new ArrayList<>(Arrays.asList(-0.5f,-0.5f,0.5f, -0.5f, 0.5f, 0.5f, -0.5f, 0.5f));
        indices = new ArrayList<>(Arrays.asList(0,1,2,0,2,3));
    }


    @Override
    public Object clone()  {
        RenderScene renderScene = new RenderScene();
        for(Float element : vertices) {
            renderScene.vertices.add(element);
        }
        for(Integer element : indices) {
            renderScene.indices.add(element);
        }

        return renderScene;
    }
    public float[] getVertexArray() {
        float[] fVertices = new float[vertices.size()];
        for(int i = 0; i < vertices.size(); i++) {
            fVertices[i] = (float) vertices.get(i);
        }
        return fVertices;
    }
    public int[] getIndexArray() {
        int[] iIndices = new int[indices.size()];
        for(int i = 0; i < indices.size(); i++) {
            iIndices[i] = (int) indices.get(i);
        }
        return iIndices;
    }
}
