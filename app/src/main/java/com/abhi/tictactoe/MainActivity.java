package com.abhi.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    boolean gameactive=true;

    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playertap(View view) throws InterruptedException {
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());

        if(!gameactive)gamereset(view);

        if(gameState[tappedImage]==2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.o);



                
                activePlayer = 1;
                TextView status =findViewById(R.id.status);
                status.setText("O's Turn:Tap To Play");
            } else {
                img.setImageResource(R.drawable.dowd);

                activePlayer = 0;
                TextView status =findViewById(R.id.status);
                status.setText("X's Turn:Tap To Play");
            }

            img.animate().translationYBy(1000f).setDuration(500);
        }

        for(int[] win:winPos)
        {
            if(gameState[win[0]]==gameState[win[1]]&&gameState[win[2]]==gameState[win[1]]&&gameState[win[0]]!=2)
            {
                String winner;
                if(gameState[win[0]]==0)
                    winner="X has won";
                else
                    winner="O has won";


                TextView status =findViewById(R.id.status);
                status.setText(winner);
                gameactive=false;

            }
        }


    }

    public void gamereset(View view)
    {

        gameactive =true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);

        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
