package info.romeosierra.baleb;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import info.romeosierra.baleb.math.Vec4;

public class RenderScene {
    private String TAG = "RAGE- RenderScene";
    protected Vec4 backgroundColor;
    private Vec4 overlayColor;
    ArrayList<Float> vertices;
    ArrayList<Integer> indices;

    public RenderScene() {
        backgroundColor = new Vec4(1.0,0.0,0.0,1.0);
        overlayColor = new Vec4(0.0,0.0,0.0,0.0);
        vertices = new ArrayList<>(Arrays.asList(-0.5f,-0.5f,1.0f, 1.0f, 0.0f, 1.0f,0.5f, -0.5f,1.0f, 1.0f, 0.0f, 1.0f,  0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 1.0f, -0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 1.0f));
        indices = new ArrayList<>(Arrays.asList(0,1,2,0,2,3));
    }


    @Override
    public Object clone()  {
        RenderScene renderScene = new RenderScene();
        renderScene.backgroundColor = new Vec4(backgroundColor);
        renderScene.overlayColor = new Vec4(overlayColor);
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
    public void reset() {
        backgroundColor.reset();
        overlayColor.reset();
        vertices.clear();
        indices.clear();
    }
    public void addRenderObject() {
        vertices = new ArrayList<>(Arrays.asList(-0.5f,-0.5f,1.0f, 1.0f, 0.0f, 1.0f,0.5f, -0.5f,1.0f, 1.0f, 0.0f, 1.0f,  0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 1.0f, -0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 1.0f));
        indices = new ArrayList<>(Arrays.asList(0,1,2,0,2,3));
//        ArrayList tempVertices = new ArrayList<>(Arrays.asList(-1.0f,-1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f));
//        ArrayList tempIndices = new ArrayList<>(Arrays.asList(4,5,6,4,6,7));
//        vertices.addAll(tempVertices);
//        indices.addAll(tempIndices);
//        Log.i(TAG, "" + vertices.size());
    }

    public void setBackgroundColor(Vec4 backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setOverlayColor(Vec4 overlayColor) {
        this.overlayColor = overlayColor;
    }
}
