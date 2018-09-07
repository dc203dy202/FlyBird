package com.cucumko.flybird;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();

        scoreView = findViewById(R.id.scoreView);
        scoreView.setText("score : " + intent.getStringExtra("score"));

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void onBtnRestartClicked(View v){
        StartGame startGame = (StartGame)StartGame.startGame;
        startGame.finish();
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
        finish();
    }

    private long time= 0;
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-time>=2000){
            time=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"뒤로 버튼을 한번 더 누르면 종료합니다.",Toast.LENGTH_SHORT).show();
        }else if(System.currentTimeMillis()-time<2000){
//            finishAffinity();
            ActivityCompat.finishAffinity(this);
        }
    }

}