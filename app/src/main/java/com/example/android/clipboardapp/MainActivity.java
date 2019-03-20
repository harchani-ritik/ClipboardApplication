package com.example.android.clipboardapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ClipboardManager clipboard;
    private ClipData myClip;
    EditText copyField,pasteField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clipboard=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        copyField=(EditText)findViewById(R.id.editText);
        pasteField=(EditText)findViewById(R.id.editText2);
    }

    public void copyData(View view)
    {
        String text=copyField.getText().toString();
        myClip=ClipData.newPlainText("text",text);//Need to understand this line of code
        clipboard.setPrimaryClip(myClip);
        Toast.makeText(getApplicationContext(),"Text Copied",Toast.LENGTH_SHORT).show();
    }

    public void pasteData(View view)
    {
        ClipData abc = clipboard.getPrimaryClip();
        ClipData.Item item=abc.getItemAt(0);
        String text=item.getText().toString();
        pasteField.setText(text);
        Toast.makeText(getApplicationContext(),"Text Pasted",Toast.LENGTH_SHORT).show();
    }
}
