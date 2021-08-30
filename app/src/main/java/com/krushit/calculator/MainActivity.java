package com.krushit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button ac,power,back,div,seven,eight,nine,mul,four,five,six,sub,one,two,three,add,zero,point,ans,equal;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        ac=findViewById(R.id.ac);
        power=findViewById(R.id.power);
        back=findViewById(R.id.back);
        div=findViewById(R.id.div);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        mul=findViewById(R.id.mul);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        sub=findViewById(R.id.sub);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        add=findViewById(R.id.add);
        zero=findViewById(R.id.zero);
        point=findViewById(R.id.point);
        ans=findViewById(R.id.ans);
        equal=findViewById(R.id.equal);
    }
    public void Butonclick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case"AC":
                input="";
                break;
            case"Ans":
                Solve();
                input+=Answer;
                break;
            case"x":
                input+="*";
                break;
            case"^":
                Solve();
                input+="^";
                break;
            case"=":
                Solve();
                Answer=input;
                break;
            case"←":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input+=data;
        }
        Screen.setText(input);
    }
    private void Solve(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = mul+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]) , Double.parseDouble(number[1]));
                input = pow+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        if (input.split("-").length>1){
            String number[]=input.split("-");
            if(number[0]=="" && number.length==2){
                number[0]=0+"";
            }
            try {
                double sub=0;
                if(number.length==2){
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                else if(number.length==3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = sub+"";
            }
            catch (Exception e){
                //Toggle Error
            }
        }
        String n[]=input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }
        }
        Screen.setText(input);
    }
}
