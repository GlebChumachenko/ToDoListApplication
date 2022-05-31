package com.codegama.todolistapplication.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codegama.todolistapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlarmActivity extends BaseActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.timeAndData)
    TextView timeAndData;
    @BindView(R.id.closeButton)
    Button closeButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        ButterKnife.bind(this);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.notification);
        mediaPlayer.start();

        if (getIntent().getExtras() != null) {
            title.setText(getIntent().getStringExtra("НАЗВ"));
            description.setText(getIntent().getStringExtra("ОПИС"));
            timeAndData.setText(getIntent().getStringExtra("ДАТА") + ", " + getIntent().getStringExtra("ВРЕМЯ"));
        }

        Glide.with(getApplicationContext()).load(R.drawable.alert).into(imageView);
        closeButton.setOnClickListener(view -> finish());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
