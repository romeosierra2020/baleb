package info.romeosierra.baleb;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES32;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RAGERenderer implements GLSurfaceView.Renderer {
    private static String TAG = "RAGE- RAGERenderer";
    Context context;
    RenderScene renderScene;
    private int width, height;
    private int program = 0;
    private int aPositionLocation = 0;
    private float[] projectionMatrix;

    public RAGERenderer(Context context) {
        this.context = context;
        this.renderScene = new RenderScene();
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    @Override
    public void onSurfaceCreated(GL10 unused, EGLConfig eglConfig) {
        Log.i(TAG, "Renderer constructed");
        GLES20.glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
        String vertexShaderSrc = ShaderUtils.getStringFromFile(context, R.raw.vertex_shader);
        String fragmentShaderSrc = ShaderUtils.getStringFromFile(context, R.raw.fragment_shader);
        program = ShaderUtils.getProgram(vertexShaderSrc, fragmentShaderSrc);
        aPositionLocation = GLES20.glGetAttribLocation(program, "a_position");
        Log.i(TAG, "Program:");
    }

    @Override
    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES32.glViewport(0,0,width, height);
        this.width = width;
        this.height = height;
        float aspectRatio = (float) width / height;
        Matrix.frustumM(projectionMatrix, 0, -aspectRatio, aspectRatio, -1, 1, 3, 7);
        // Set Projection Matrix
    }

    @Override
    public void onDrawFrame(GL10 unused) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        float[] vertices = renderScene.getVertexArray();
        int[] indices = renderScene.getIndexArray();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * Float.BYTES);
        byteBuffer.order(ByteOrder.nativeOrder());
        FloatBuffer vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);

        byteBuffer = ByteBuffer.allocateDirect(indices.length * Integer.BYTES);
        byteBuffer.order(ByteOrder.nativeOrder());
        IntBuffer indicesBuffer = byteBuffer.asIntBuffer();
        indicesBuffer.put(indices);
        indicesBuffer.position(0);

        GLES20.glUseProgram(program);

        GLES20.glEnableVertexAttribArray(aPositionLocation);
        GLES20.glVertexAttribPointer(aPositionLocation, 2, GLES20.GL_FLOAT, false, 8, vertexBuffer);
        GLES20.glDrawElements(GLES20.GL_TRIANGLES, indices.length, GLES20.GL_UNSIGNED_INT, indicesBuffer);

    }

    public void setScene() {
        this.renderScene = (RenderScene) renderScene.clone();

    }
}
