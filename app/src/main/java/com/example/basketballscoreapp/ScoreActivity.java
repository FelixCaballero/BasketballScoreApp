package com.example.basketballscoreapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.basketballscoreapp.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_score);

        int local = getIntent().getIntExtra(Constants.EXTRA_LOCAL, 0);
        int visitor = getIntent().getIntExtra(Constants.EXTRA_VISITOR, 0);

        String scoreText = getString(R.string.score_format, local, visitor);
        binding.tvScore.setText(scoreText);

        String result;
        if (local > visitor) {
            result = getString(R.string.result_local_gana);
        } else if (visitor > local) {
            result = getString(R.string.result_visitante_gana);
        } else {
            result = getString(R.string.result_empate);
        }

        binding.tvResult.setText(result);
    }
}
