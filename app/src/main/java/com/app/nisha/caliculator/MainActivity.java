package com.app.nisha.caliculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.nisha.caliculator.utils.CalUtils;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mTvResult,mTvValues,mTvStore,mTvBack;
    private Button mBtnOne,mBtnTwo,mBtnThree,mBtnFour,mBtnFive,mBtnSix,mBtnSeven,mBtnEight,
    mBtnNine,mBtnAddition,mBtnDivision,mBtnMul,mBtnSubstraction,mBtnBracketLeft,
    mBtnBracketRight,mBtnPower,mBtnZero,mBtnDecimal,mBtnEqual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
    }

    private  void bindViews(){

        mTvBack=(TextView)findViewById(R.id.id_tv_back);
        mTvResult=(TextView)findViewById(R.id.id_tv_result);
        mTvValues=(TextView)findViewById(R.id.id_tv_values);
        mTvStore=(TextView)findViewById(R.id.id_tv_store);
        mTvBack=(TextView)findViewById(R.id.id_tv_back);
        mBtnOne=(Button)findViewById(R.id.id_btn_one);
        mBtnTwo=(Button)findViewById(R.id.id_btn_two);
        mBtnThree=(Button)findViewById(R.id.id_btn_three);
        mBtnFour=(Button)findViewById(R.id.id_btn_four);
        mBtnFive=(Button)findViewById(R.id.id_btn_five);
        mBtnSix=(Button)findViewById(R.id.id_btn_six);
        mBtnSeven=(Button)findViewById(R.id.id_btn_seven);
        mBtnEight=(Button)findViewById(R.id.id_btn_eight);
        mBtnNine=(Button)findViewById(R.id.id_btn_nine);
        mBtnZero=(Button)findViewById(R.id.id_btn_zero);
        mBtnAddition=(Button)findViewById(R.id.id_btn_addition);
        mBtnSubstraction=(Button)findViewById(R.id.id_btn_minus);
        mBtnMul=(Button)findViewById(R.id.id_btn_mul);
        mBtnBracketLeft=(Button)findViewById(R.id.id_btn_bracketleft);
        mBtnBracketRight=(Button)findViewById(R.id.id_btn_bracketright);
        mBtnPower=(Button)findViewById(R.id.id_btn_power);
        mBtnDecimal=(Button)findViewById(R.id.id_btn_decimal);
        mBtnDivision=(Button)findViewById(R.id.id_btn_division);
        mBtnEqual=(Button)findViewById(R.id.id_btn_result);
        mTvBack.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThree.setOnClickListener(this);
        mBtnFour.setOnClickListener(this);
        mBtnFive.setOnClickListener(this);
        mBtnSix.setOnClickListener(this);
        mBtnSeven.setOnClickListener(this);
        mBtnEight.setOnClickListener(this);
        mBtnNine.setOnClickListener(this);
        mBtnZero.setOnClickListener(this);
        mBtnAddition.setOnClickListener(this);
        mBtnSubstraction.setOnClickListener(this);
        mBtnMul.setOnClickListener(this);
        mBtnBracketLeft.setOnClickListener(this);
        mBtnBracketRight.setOnClickListener(this);
        mBtnPower.setOnClickListener(this);
        mBtnDecimal.setOnClickListener(this);
        mBtnDivision.setOnClickListener(this);
        mBtnEqual.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {


        switch (v.getId()){
            case R.id.id_btn_addition:  setText(mBtnAddition);            break;
            case R.id.id_btn_minus:    setText(mBtnSubstraction);          break;

            case R.id.id_btn_division:   setText(mBtnDivision);        break;

            case R.id.id_btn_mul:  setText(mBtnMul);          break;

            case R.id.id_btn_one:   setText(mBtnOne);         break;

            case R.id.id_btn_two:    setText(mBtnTwo);          break;

            case R.id.id_btn_three:        setText(mBtnThree);        break;

            case R.id.id_btn_four:   setText(mBtnFour);             break;
            case R.id.id_btn_five:          setText(mBtnFive);      break;
            case R.id.id_btn_six:          setText(mBtnSix);      break;
            case R.id.id_btn_seven:          setText(mBtnSeven);      break;
            case R.id.id_btn_eight:          setText(mBtnEight);      break;
            case R.id.id_btn_nine:    setText(mBtnNine);            break;
            case R.id.id_btn_zero:      setText(mBtnZero);          break;
            case R.id.id_btn_bracketleft:    setText(mBtnBracketLeft);     break;
            case R.id.id_btn_bracketright:   setText(mBtnBracketRight);     break;
            case R.id.id_btn_decimal:        setText(mBtnDecimal);        break;
            case R.id.id_btn_mr:            break;

            case R.id.id_btn_result:   setResult();         break;

            case R.id.id_btn_power:            break;

            case R.id.id_tv_back : removeLastEnteredValue(); break;

        }

    }

    private String TAG="MainActivity";
    private void setResult(){
        String enteredValue = mTvValues.getText().toString().trim();
        if(enteredValue.length()==0) return;
        Log.v(TAG," enteredValue:"+enteredValue);
        enteredValue=enteredValue.replaceAll("÷","/");
        enteredValue=enteredValue.replaceAll("X","*");
        Log.v(TAG," Final value:"+enteredValue);
        String result = CalUtils.findValueInBraces(enteredValue);
        mTvResult.setText(result+"");
    }


    private void setText(Button btnText){


        mTvValues.append(btnText.getText().toString().trim());


    }


    private void removeLastEnteredValue(){
        String value = mTvValues.getText().toString().trim();
        if(value.length()==0) return;
        value = value.substring(0,value.length()-1);
        mTvValues.setText(value);

    }
}
