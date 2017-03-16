package com.example.quanla.smartschool.networks.services;

import com.example.quanla.smartschool.database.model.TeachingSchedule;
import com.example.quanla.smartschool.networks.jsonModels.TeachingScheduleResponJSON;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hieutran on 3/17/17.
 */

public interface TeachingScheduleService {
    @GET("schdule")
    Call<List<TeachingSchedule>> getAll();
}
