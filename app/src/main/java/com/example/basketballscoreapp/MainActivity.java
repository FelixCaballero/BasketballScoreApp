package com.example.basketballscoreapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.basketballscoreapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int localScore = 0;
    private int visitorScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnLocalPlus1.setOnClickListener(v -> changeLocal(1));
        binding.btnLocalPlus2.setOnClickListener(v -> changeLocal(2));
        binding.btnLocalMinus1.setOnClickListener(v -> changeLocal(-1));

        binding.btnVisitorPlus1.setOnClickListener(v -> changeVisitor(1));
        binding.btnVisitorPlus2.setOnClickListener(v -> changeVisitor(2));
        binding.btnVisitorMinus1.setOnClickListener(v -> changeVisitor(-1));

        binding.btnReset.setOnClickListener(v -> resetScores());

        binding.btnResults.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra(Constants.EXTRA_LOCAL, localScore);
            intent.putExtra(Constants.EXTRA_VISITOR, visitorScore);
            startActivity(intent);
        });

        updateScoreViews();
    }

    private void changeLocal(int delta) {
        localScore += delta;
        if (localScore < 0) localScore = 0;
        updateScoreViews();
    }

    private void changeVisitor(int delta) {
        visitorScore += delta;
        if (visitorScore < 0) visitorScore = 0;
        updateScoreViews();
    }

    private void resetScores() {
        localScore = 0;
        visitorScore = 0;
        updateScoreViews();
    }

    private void updateScoreViews() {
        binding.localScore.setText(String.valueOf(localScore));
        binding.visitorScore.setText(String.valueOf(visitorScore));
    }
}
