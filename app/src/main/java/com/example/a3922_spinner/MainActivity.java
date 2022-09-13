package com.example.a3922_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editText;
    private String sp1;
    private String sp2;
    private String sp3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.mainText);
        Spinner spinner1 = findViewById(R.id.spinnerWheelColor);
        Spinner spinner2 = findViewById(R.id.spinnerWheelAlignment);
        Spinner spinner3 = findViewById(R.id.spinnerWheelSize);
        sp1 = findViewById(R.id.spinnerWheelColor).toString();
        sp2 = findViewById(R.id.spinnerWheelAlignment).toString();
        sp3 = findViewById(R.id.spinnerWheelSize).toString();
        
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.Colors, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Fonts, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.Styles, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
//        spinner1.setOnItemSelectedListener(this);
        spinner1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        sp1 = spinner1.getSelectedItem().toString();
                        switch (sp1){
                            case "Black":
                                editText.setTextColor(Color.BLACK);
                                break;
                            case "Yellow":
                                editText.setTextColor(Color.YELLOW);
                                break;
                            case "Red":
                                editText.setTextColor(Color.RED);
                                break;
                            case "Blue":
                                editText.setTextColor(Color.BLUE);
                                break;
                            case "Green":
                                editText.setTextColor(Color.GREEN);
                                break;
                            case "Magenta":
                                editText.setTextColor(Color.MAGENTA);
                                break;
                            case "Cyan":
                                editText.setTextColor(Color.CYAN);
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        sp2 = spinner2.getSelectedItem().toString();
                        SpannableStringBuilder spannableString;
                        switch (sp2) {
                            case "left":
                            editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                            spannableString = new SpannableStringBuilder(editText.getText());
                            editText.setText(spannableString);
                            break;
                            case "centre":
                                editText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                spannableString = new SpannableStringBuilder(editText.getText());
                                editText.setText(spannableString);
                                break;
                            case "right":
                                editText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                                spannableString = new SpannableStringBuilder(editText.getText());
                                editText.setText(spannableString);
                                break;
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        sp3 = spinner3.getSelectedItem().toString();
                        String spannableString;
                        switch (sp3) {
                            case "12":
                                editText.setTextSize(12);
                                break;
                            case "14":
                                editText.setTextSize(14);
                                break;
                            case "16":
                                editText.setTextSize(16);
                                break;
                            case "18":
                                editText.setTextSize(18);
                                break;
                            case "20":
                                editText.setTextSize(20);
                                break;
                            case "22":
                                editText.setTextSize(22);
                                break;
                            case "24":
                                editText.setTextSize(24);
                                break;
                            case "26":
                                editText.setTextSize(26);
                                break;
                            case "28":
                                editText.setTextSize(28);
                                break;
                            case "30":
                                editText.setTextSize(30);
                                break;
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
//        Spinner spinnerText1 = (Spinner)findViewById(R.id.spinnerWheelColor);
//        String text1 = spinner1.getSelectedItem().toString();
//        Spinner spinnerText2 = (Spinner)findViewById(R.id.spinnerWheelAlignment);
//        String text2 = spinner2.getSelectedItem().toString();
//        Spinner spinnerText3 = (Spinner)findViewById(R.id.spinnerWheelSize);
//        String text3 = spinner2.getSelectedItem().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String text = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void buttonBold(View view){
        Spannable spannableString = new SpannableStringBuilder(editText.getText());
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                editText.getSelectionStart(),
                editText.getSelectionEnd(),
                0);

        editText.setText(spannableString);
    }
    public void buttonUnderline(View view){
        Spannable spannableString = new SpannableStringBuilder(editText.getText());
        spannableString.setSpan(new UnderlineSpan(),
                editText.getSelectionStart(),
                editText.getSelectionEnd(),
                0);

        editText.setText(spannableString);
    }
    public void buttonItalic(View view){
        Spannable spannableString = new SpannableStringBuilder(editText.getText());
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                editText.getSelectionStart(),
                editText.getSelectionEnd(),
                0);

        editText.setText(spannableString);
    }

}