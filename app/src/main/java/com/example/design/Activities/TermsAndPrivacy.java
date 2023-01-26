package com.example.design.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.design.R;

public class TermsAndPrivacy extends AppCompatActivity {

    private TextView title_text, condition_text, text_introduction, legal_basis, text_legal_basis, marketing, text_marketing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_privacy);

        initialization();
        actions();
    }

    public void initialization() {

        //Here we initialize the elements of our Layout.xml file
        title_text = findViewById(R.id.title_text);
        condition_text = findViewById(R.id.condition_text);
        text_introduction = findViewById(R.id.text_introduction);
        legal_basis = findViewById(R.id.legal_basis);
        text_legal_basis = findViewById(R.id.text_legal_basis);
        marketing = findViewById(R.id.marketing);
        text_marketing = findViewById(R.id.text_marketing);
    }

    //Here we create the actions
    @SuppressLint("SetTextI18n")
    public void actions() {
        text_introduction.setText("This Privacy Notice is designed to inform you about the personal data relating to you and which is collected via the ON MOVIE app (OnMovie.tv referred to hereinafter as the “Websites”) by the European Union (\"EU\")/ with registered office at L’Ancienne-Route 17A, 1218 Le Grand-Saconnex (Geneva) Switzerland and registered with the Commercial Registry in Geneva (Switzerland) under number IDE CHE 107.741.07.\n" +
                "\n" +
                "We describe hereafter why we collect and process your personal data, on which legal basis, and how we treat the personal data which you provide us and the personal data we obtain from your visit to the Websites.\n" +
                "\n" +
                "Your use of these Websites implies your acknowledgement of this Privacy Notice.");

        text_legal_basis.setText("We are only processing your personal data " +
                "because you have given us specific consent or because such processing is necessary for the performance of a contract " +
                "to which you are a party or where the processing is in our legitimate interests and not overridden by your data protection interests or fundamental rights and freedoms. " +
                "When the legal basis of the processing is consent, you have the right to withdraw your consent at any time, without affecting the lawfulness of any processing carried out before the withdrawal of consent.");

        text_marketing.setText("We will not use your Personal Data for direct marketing purposes without your explicit prior consent, except where authorised under applicable law.\n" +
                "\n" +
                "If at any time you decide to no longer receive commercial or promotional information from us, you may, free of charge and without providing any justification, opt out of any direct marketing campaigns and oppose future processing of your Personal Data for such purposes by sending us an email at privacy@onm.ch and mentioning \"opt-out\" in the subject line of your email." +
                " Alternatively, you may use the opt-out procedure provided in any promotional message you receive from us.\n" +
                "\n" +
                "Please note that opting out from receiving promotional messages from us will not prevent you from receiving information that relates to any contract you may have entered into with us.");
    }
}