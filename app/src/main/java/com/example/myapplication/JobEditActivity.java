package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobEditActivity extends AppCompatActivity {

    EditText edit_name,edit_job;
    ProgressDialog progressDialog;
    TextView responseTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_edit);

        edit_name=findViewById(R.id.edit_name);
        edit_job=findViewById(R.id.edit_job);
        responseTv=findViewById(R.id.response_text);


    }

    public void SaveClick(View view){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving");
        progressDialog.setCancelable(false);
        progressDialog.show();

        DataModel input=new DataModel();
        input.name=edit_name.getText().toString();
        input.job=edit_job.getText().toString();


        Call<DataModel> call=RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class).createPost(input);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                DataModel responseFromAPI = response.body();


                    Toast.makeText(JobEditActivity.this,"Data Added to API", Toast.LENGTH_SHORT).show();

                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.name + "\n" + "Job : " + responseFromAPI.job;

                // below line we are setting our
                // string to our text view.
                responseTv.setText(responseString);
                    finish();
                    progressDialog.dismiss();

            }
            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Toast.makeText(JobEditActivity.this, "not added", Toast.LENGTH_SHORT).show();
           progressDialog.dismiss();

            }
        });

    }
}