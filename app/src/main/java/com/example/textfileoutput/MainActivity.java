package com.example.textfileoutput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileNameDialog dialog = new FileNameDialog();
                dialog.show(getFragmentManager(),"dialog");

                EditText et = (EditText) findViewById(R.id.editText);
                String str = et.getText().toString();

                //ファイルの保存処理
                BufferedWriter bw = null;
                try{

                    FileOutputStream fos = openFileOutput("text.dat",MODE_PRIVATE);
                    OutputStreamWriter osr = new OutputStreamWriter(fos);
                    bw = new BufferedWriter(osr);
                    bw.write(str);
                    bw.flush();
                }catch(IOException e){
                    e.printStackTrace();
                }finally {
                    try{
                        bw.close();
                    }catch(IOException ee){
                        ee.printStackTrace();
                    }
                }
            }
        });
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BufferedReader br = null;
                StringBuffer sb = new StringBuffer();
                try{
                    FileInputStream fis = openFileInput("text.dat");
                    InputStreamReader isr = new InputStreamReader(fis);
                    br = new BufferedReader(isr);
                    String str;
                    while((str = br.readLine()) != null){
                        sb.append(str);
                        sb.append("line.separator");
                    }

                }catch(IOException e){

                }finally {
                    try{
                        br.close();
                    }catch (IOException ee){

                    }
                }

                EditText et = findViewById(R.id.editText);
                et.setText(sb);
            }
        });
    }
}
