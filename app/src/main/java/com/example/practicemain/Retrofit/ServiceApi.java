package com.example.practicemain.Retrofit;

import com.example.practicemain.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("posts")
    Call<List<Post>>getAllPost();
}
