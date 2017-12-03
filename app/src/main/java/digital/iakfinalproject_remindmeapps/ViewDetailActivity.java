package digital.iakfinalproject_remindmeapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewDetailActivity extends AppCompatActivity {
    private TextView tv_tittle, tv_content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String tittle = i.getStringExtra("tittle");
        String content = i.getStringExtra("content");

        tv_tittle = (TextView)findViewById(R.id.tv_tittle);
        tv_content = (TextView)findViewById(R.id.tv_content);

        tv_tittle.setText(tittle);
        tv_content.setText(content);
    }
}
