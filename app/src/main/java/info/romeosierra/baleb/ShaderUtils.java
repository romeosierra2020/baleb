package info.romeosierra.baleb;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLES32;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShaderUtils {
    private static final String TAG = "RAGE- ShaderUtils";
    public static String getStringFromFile(Context context, int resourceId) {


        StringBuilder body = new StringBuilder();
        try {
            InputStream inputStream = context.getResources().openRawResource(resourceId);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String nextLine;
            while((nextLine = bufferedReader.readLine())!= null) {
                body.append(nextLine);
                body.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return body.toString();
    }

    public static int getProgram(String vertexShaderSrc, String fragmentShaderSrc) {
        int vertexShader = GLES20.glCreateShader(GLES20.GL_VERTEX_SHADER);
        GLES20.glShaderSource(vertexShader, vertexShaderSrc);
        GLES32.glCompileShader(vertexShader);

        Log.v(TAG, "Results of compiling source:" + "\n" + vertexShaderSrc + "\n:"
                + GLES20.glGetShaderInfoLog(vertexShader));

        int fragmentShader = GLES20.glCreateShader(GLES20.GL_FRAGMENT_SHADER);
        GLES20.glShaderSource(fragmentShader, fragmentShaderSrc);
        GLES32.glCompileShader(fragmentShader);

        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        return program;
    }
}
