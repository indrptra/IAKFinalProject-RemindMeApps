package digital.iakfinalproject_remindmeapps.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import digital.iakfinalproject_remindmeapps.R;
import digital.iakfinalproject_remindmeapps.model.ListDataResponse;

import static android.R.attr.width;
import static android.support.v7.appcompat.R.attr.height;

/**
 * Created by apc-lap008 on 03/12/17.
 */

public class CustomCreateNoteDialog extends Dialog implements View.OnClickListener {

    private Context context;
    private dialogCallback callback;
    private Button btn_create;
    private EditText et_tittle, et_content;
    private Activity activity;

    public CustomCreateNoteDialog(){
        super(null);

    }

    public CustomCreateNoteDialog(Context context, Activity activity) {
        super(context);
        this.context = context;
        this.activity = activity;
        this.callback = (dialogCallback) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(getWindow().getAttributes());
        lp.width = width;
        lp.height = height;
        getWindow().setAttributes(lp);
        setContentView(R.layout.dialog_note);

        btn_create = (Button) findViewById(R.id.btn_create);
        et_tittle = (EditText) findViewById(R.id.et_tittle);
        et_content = (EditText) findViewById(R.id.et_content);

        btn_create.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == btn_create){
            if(et_tittle.getText().toString().equals("")||et_content.getText().toString().equals("")){
                Toast.makeText(context, "Write something", Toast.LENGTH_SHORT).show();
            }else{
                dismiss();
                ListDataResponse data = new ListDataResponse();
                data.setTitle(et_tittle.getText().toString());
                data.setContent(et_content.getText().toString());
                callback.succesCreate(data);
            }
        }
    }

    public interface dialogCallback {

        void succesCreate(ListDataResponse data);
    }

}




