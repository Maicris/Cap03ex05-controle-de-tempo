package br.com.criandojogosandroid.cap03ex05_controle_de_tempo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Tela tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tela = new Tela(this);
        setContentView(tela);
    }

    private class Tela extends View {

        private Random rnd = new Random();
        private long startTime;
        private float elapsedTime = 0.0f;
        private int r = 0, g = 0, b = 0;

        public Tela(Context context) {
            super(context);
            startTime = System.nanoTime();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float deltaTime = (System.nanoTime() - startTime) / 1000000.0f;
            startTime = System.nanoTime();
            elapsedTime += deltaTime;
            if (elapsedTime >= 1000) {
                elapsedTime = 0;
                r = rnd.nextInt(256);
                g = rnd.nextInt(256);
                b = rnd.nextInt(256);
            }
            canvas.drawRGB(r, g, b);
            invalidate();
        }
    }
}
