package com.moonlabcoding.tp2.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.moonlabcoding.tp2.R;
import com.moonlabcoding.tp2.model.IMHelper;
import com.moonlabcoding.tp2.model.User;

public class MainActivity extends AppCompatActivity {

    private EditText _edtTaille;
    private EditText _edtPoids;
    private EditText _edtAge;
    private Button _btnCalculateIMG;
    private TextView _txtResultat;
    private TextView _txtInterpretation;
    private RadioGroup _radiogroup;

    private User mUser;

    private IMHelper mIMHelper;

    private char mSex;
    private char[] sexList;

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
//            if ((_edtAge.getText().toString().length() != 0) && (_edtPoids.getText().toString().length() != 0) && (_edtTaille.getText().toString().length() != 0)){
//
//            }

            _btnCalculateIMG.setEnabled(
                    (_edtAge.getText().toString().length() != 0) &&
                    (_edtPoids.getText().toString().length() != 0) &&
                    (_edtTaille.getText().toString().length() != 0));

            if (_radiogroup.getCheckedRadioButtonId() == -1) {
                _btnCalculateIMG.setEnabled(false);
            }
        }
    };

    private void connectViews() {
        _radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        _btnCalculateIMG = (Button) findViewById(R.id.btnCalculateIMG);
        _txtResultat = (TextView) findViewById(R.id.lblResultat);
        _txtInterpretation = (TextView) findViewById(R.id.lblInterpretation);
        _edtTaille = (EditText) findViewById(R.id.edtTaille);
        _edtPoids = (EditText) findViewById(R.id.edtPoids);
        _edtAge = (EditText) findViewById(R.id.edtAge);
    }

    @SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        _btnCalculateIMG.setEnabled(true);
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rdbHomme:
                if (checked) {
                    mSex = 'H';
                    Toast.makeText(this, "Homme", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rdbFemme:
                if (checked) {
                    mSex = 'F';
                    Toast.makeText(this, "Femme", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIMHelper=new IMHelper();
        mSex = 'N';
        sexList = new char[]{'H', 'F'};
        connectViews();
        _btnCalculateIMG.setEnabled(false);
        _btnCalculateIMG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                int age = Integer.parseInt(_edtAge.getText().toString());
                Float poids = Float.parseFloat(_edtPoids.getText().toString());
                Float taille = Float.parseFloat(_edtTaille.getText().toString());
                char sex = mSex;
                mUser = new User(age, poids, taille, sex);
                Float IMG = mUser.getIMG();
                String interpretation= mIMHelper.getIMGInterpretation(mUser.getSex(),IMG);
                _txtResultat.setText(IMG.toString());
                _txtInterpretation.setText(interpretation);
                Toast.makeText(getApplicationContext(), interpretation , Toast.LENGTH_SHORT).show();
            }
        });

        _edtTaille.addTextChangedListener(mTextWatcher);
        _edtPoids.addTextChangedListener(mTextWatcher);
        _edtAge.addTextChangedListener(mTextWatcher);
    }


}