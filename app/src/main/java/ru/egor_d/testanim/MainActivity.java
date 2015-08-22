package ru.egor_d.testanim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.transitionseverywhere.ChangeBounds;
import com.transitionseverywhere.Scene;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;

public class MainActivity extends Activity {
    private boolean direct = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        View square = findViewById(R.id.transition_square);

        final Scene scene1 = Scene.getSceneForLayout(sceneRoot, R.layout.scene1, this);
        final Scene scene2 = Scene.getSceneForLayout(sceneRoot, R.layout.scene2, this);

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (direct) {
                    TransitionSet set = new TransitionSet();
                    set.addTransition(new ChangeBounds());
                    set.setDuration(500);
                    TransitionManager.go(scene2, set);
                } else {
                    TransitionSet set = new TransitionSet();
                    set.addTransition(new ChangeBounds());
                    set.setDuration(500);
                    TransitionManager.go(scene1, set);
                }
                direct = !direct;
            }
        });
    }
}
