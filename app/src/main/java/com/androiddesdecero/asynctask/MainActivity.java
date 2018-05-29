package com.androiddesdecero.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btAsyncTask;
    private TextView tvProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvProgreso = findViewById(R.id.tvProgreso);
        btAsyncTask = findViewById(R.id.btAsyncTask);
        btAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
                tareaAsyncTask.execute();
            }
        });
    }

    private class TareaAsyncTask extends AsyncTask<Void, Integer, String>{

        @Override
        protected void onPreExecute(){
            tvProgreso.setText("0");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=1; i<=5; i++){
                esperarUnSegundo();
                publishProgress(i);
            }
            return "Finalizado";
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            tvProgreso.setText(values[0].toString());
        }

        @Override
        protected void onPostExecute(String resultado){
            tvProgreso.setText(resultado);
        }
    }

    private void esperarUnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

    }
}
