package com.avolatile.ultimate.doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllAppointments extends AppCompatActivity {

    private TableFixHeaders tablefixheaders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_appointments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();   // back button pressed
            }
        });

        tablefixheaders = (TableFixHeaders) findViewById(R.id.tablefixheaders);
        tablefixheaders.setAdapter(getAdapter());
    }

    public BaseTableAdapter getAdapter() {
        BasicTableFixHeaderAdapter adapter = new BasicTableFixHeaderAdapter(this);
        List<List<String>> body = getBody();

        adapter.setFirstHeader("BASIC");
        adapter.setHeader(getHeader());
        adapter.setFirstBody(body);
        adapter.setBody(body);
        adapter.setSection(body);

        return adapter;
    }


    private List<String> getHeader() {
        List<String> header = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            header.add("H " + (i + 1));

        return header;
    }

    private List<List<String>> getBody() {
        List<List<String>> rows = new ArrayList<>();

        for (int row = 0; row < 100; row++) {
            List<String>  cols = new ArrayList<>();

            for (int col = 0; col < 30; col++)
                cols.add("Col " + col);

            rows.add(cols);
        }

        return rows;
    }
    }

