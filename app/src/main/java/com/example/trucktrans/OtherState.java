package com.example.trucktrans;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class OtherState extends AppCompatActivity {
    Button AP,AR,AS,BR,CG,DL,GA,GJ,HR,HP,JR,JK,KA,KL,MH,MN,ML,MR,MP,NL,OD,PB,RJ,SK,TN,TS,TR,UP,UK,WB,NE,BH,AI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_state);
        AP=findViewById(R.id.btnAP);
        AP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,ANDHRA.class);
                startActivity(intent);
            }
        });
        AR=findViewById(R.id.btnAR);
        AR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,ARUNACHAL.class);
                startActivity(intent);
            }
        });
        AS=findViewById(R.id.btnAS);
        AS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,ASSAM.class);
                startActivity(intent);
            }
        });
        BR=findViewById(R.id.btnBR);
        BR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,BIHAR.class);
                startActivity(intent);
            }
        });
        CG=findViewById(R.id.btnCG);
        CG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,CHATTISGARH.class);
                startActivity(intent);
            }
        });
        DL=findViewById(R.id.btnDL);
        DL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,DELHI.class);
                startActivity(intent);
            }
        });
        GA=findViewById(R.id.btnGA);
        GA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,GOA.class);
                startActivity(intent);
            }
        });
        GJ=findViewById(R.id.btnGJ);
        GJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,GUJARAT.class);
                startActivity(intent);
            }
        });
        HR=findViewById(R.id.btnHR);
        HR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,HARYANA.class);
                startActivity(intent);
            }
        });
        HP=findViewById(R.id.btnHP);
        HP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,HIMACHAL.class);
                startActivity(intent);
            }
        });
        JR=findViewById(R.id.btnJR);
        JR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,JHARKHAND.class);
                startActivity(intent);
            }
        });
        JK=findViewById(R.id.btnJK);
        JK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,JK.class);
                startActivity(intent);
            }
        });
        KA=findViewById(R.id.btnKA);
        KA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,KARNATAKA.class);
                startActivity(intent);
            }
        });
        KL=findViewById(R.id.btnKL);
        KL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,KERALA.class);
                startActivity(intent);
            }
        });
        MH=findViewById(R.id.btnMH);
        MH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,MAHARASHTRA.class);
                startActivity(intent);
            }
        });
        MN=findViewById(R.id.btnMN);
        MN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,MANIPUR.class);
                startActivity(intent);
            }
        });
        ML=findViewById(R.id.btnML);
        ML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,MEGHALAYA.class);
                startActivity(intent);
            }
        });
        MR=findViewById(R.id.btnMR);
        MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,MIZORAM.class);
                startActivity(intent);
            }
        });
        MP=findViewById(R.id.btnMP);
        MP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,MP.class);
                startActivity(intent);
            }
        });
        NL=findViewById(R.id.btnNL);
        NL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,NAGALAND.class);
                startActivity(intent);
            }
        });
        OD=findViewById(R.id.btnod);
        OD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,ODISHA.class);
                startActivity(intent);
            }
        });
        PB=findViewById(R.id.btnPB);
        PB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,PUNJAB.class);
                startActivity(intent);
            }
        });
        RJ=findViewById(R.id.btnRJ);
        RJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,RAJASTHAN.class);
                startActivity(intent);
            }
        });
        SK=findViewById(R.id.btnSK);
        SK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,SIKKIM.class);
                startActivity(intent);
            }
        });


        TR=findViewById(R.id.btnTR);
        TR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,TRIPURA.class);
                startActivity(intent);
            }
        });
        TN=findViewById(R.id.btnTN);
        TN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,TAMILNADU.class);
                startActivity(intent);
            }
        });

        TS=findViewById(R.id.btnTS);
        TS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,TELANGANA.class);
                startActivity(intent);
            }
        });
        UP=findViewById(R.id.btnUP);
        UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,UP.class);
                startActivity(intent);
            }
        });
        UK=findViewById(R.id.btnUK);
        UK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,UTTARAKHAND.class);
                startActivity(intent);
            }
        });
        WB=findViewById(R.id.btnwb);
        WB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,WBENGAL.class);
                startActivity(intent);
            }
        });
        NE=findViewById(R.id.btnNE);
        NE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,NEPAL.class);
                startActivity(intent);
            }
        });
        BH=findViewById(R.id.btnBH);
        BH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,BHUTAN.class);
                startActivity(intent);
            }
        });
        AI=findViewById(R.id.btnAI);
        AI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OtherState.this,userlist.class);
                startActivity(intent);
            }
        });

    }
}
