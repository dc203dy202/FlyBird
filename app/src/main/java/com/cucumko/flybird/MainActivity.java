package com.cucumko.flybird;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;



public class MainActivity extends Activity {


    ImageButton startButton;
    Intent gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        gameView = new Intent(this, StartGame.class);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.startButton:
                    startActivity(gameView);
                    finish();
                    break;
            }
        }
    };


    void startGame(View v){
        Intent intent = new Intent(this, StartGame.class);
        startActivity(intent);
        finish();
    }

    private long eTime = 0;
    public void eBtnClicked(View v){
        if(System.currentTimeMillis()-eTime>=2000){
            eTime = System.currentTimeMillis();
        }
        else if(System.currentTimeMillis()-eTime<2000){
            Toast.makeText(this, "developed by dayeon / drew by woohyuk", Toast.LENGTH_SHORT).show();
        }
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
