package com.example.practicemain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.practicemain.Retrofit.RetrofitInstance;
import com.example.practicemain.Retrofit.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Post>postList;
    RecyclerViewPostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        postList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ServiceApi serviceApi = RetrofitInstance.getRetrofit().create(ServiceApi.class);
        Call<List<Post>>call = serviceApi.getAllPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful())
                {
                    return;
                }
                postList=response.body();
                adapter = new RecyclerViewPostAdapter(postList,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}