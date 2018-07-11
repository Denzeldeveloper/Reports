package xyz.vinayak.dailysalesreport;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etDate, etName, etTown, etBeat, etWorkingWith, etTC, etPC, etPOB, etCumPOB,etRachni15, etRachniKG, etGreenCone,
            etFastHenna, etClassicCone;

    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSend);

        etBeat = findViewById(R.id.etBeat);
        etClassicCone = findViewById(R.id.etClassicCone);
        etCumPOB = findViewById(R.id.etCumPOB);
        etDate = findViewById(R.id.etDate);
        etFastHenna = findViewById(R.id.etFastHenna);
        etGreenCone = findViewById(R.id.etGreenCone);
        etName = findViewById(R.id.etName);
        etPC = findViewById(R.id.etPC);
        etPOB = findViewById(R.id.etPOB);
        etRachni15 = findViewById(R.id.etRachni15);
        etRachniKG = findViewById(R.id.etRachniKG);
        etTC = findViewById(R.id.etTC);
        etTown = findViewById(R.id.etTown);
        etWorkingWith = findViewById(R.id.etWorkingWith);

        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        etDate.setText( sdf.format( new Date() ));

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgToSend = buildString();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("DSR Report", msgToSend);
                clipboard.setPrimaryClip(clip);


                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT,msgToSend);
                i.setType("text/plain");
                startActivity(i);
            }
        });

    }

    private String buildString() {
        String s = "Date : ";
        s += etDate.getText().toString();
        s += "\nName : ";
        s += etName.getText().toString();
        s += "\nTown : ";
        s += etTown.getText().toString();
        s += "\nBeat : ";
        s += etBeat.getText().toString();
        s += "\n\nWorking With : ";
        s += etWorkingWith.getText().toString();
        s += "\nTC : ";
        s += etTC.getText().toString();
        s += "\nPC : ";
        s += etPC.getText().toString();
        s += "\nPOB Target : ";
        s += etPOB.getText().toString();
        s += "\nCumm POB : ";
        s += etCumPOB.getText().toString();
        s += "\nRachni 15/25gm : ";
        s += etRachni15.getText().toString();
        s += "\nRachni in KG : ";
        s += etRachniKG.getText().toString();
        s += "\nGreen Cone : ";
        s += etGreenCone.getText().toString();
        s += "\nFast Henna : ";
        s += etFastHenna.getText().toString();
        s += "\nClassic Cone : ";
        s += etClassicCone.getText().toString();
        s += "\n";

        return s;
    }
}
