package digital.iakfinalproject_remindmeapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import digital.iakfinalproject_remindmeapps.adapter.RecyclerViewAdapter;
import digital.iakfinalproject_remindmeapps.model.ListDataResponse;
import digital.iakfinalproject_remindmeapps.widget.CustomCreateNoteDialog;

public class MainActivity extends AppCompatActivity implements CustomCreateNoteDialog.dialogCallback{
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    List<ListDataResponse> data =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomCreateNoteDialog dialog = new CustomCreateNoteDialog(MainActivity.this, MainActivity.this);
                dialog.show();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.rv_content);

        recylerViewLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recylerViewLayoutManager);

        recyclerViewAdapter = new RecyclerViewAdapter(this, data);

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void succesCreate(ListDataResponse datas) {

        data.add(datas);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
