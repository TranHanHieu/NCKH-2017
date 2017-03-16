package com.example.quanla.smartschool.database;

import android.util.Log;

import com.example.quanla.smartschool.database.model.ClassStudent;
import com.example.quanla.smartschool.database.model.TeachingSchedule;
import com.example.quanla.smartschool.eventbus.GetDataFaildedEvent;
import com.example.quanla.smartschool.eventbus.GetDataSuccusEvent;
import com.example.quanla.smartschool.networks.NetContextLogin;
import com.example.quanla.smartschool.networks.NetContextMicrosoft;
import com.example.quanla.smartschool.networks.jsonModels.TeachingScheduleResponJSON;
import com.example.quanla.smartschool.networks.services.ClassService;
import com.example.quanla.smartschool.networks.services.TeachingScheduleService;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by hieutran on 3/16/17.
 */

public class DbTeachingSchedule {

    public static final DbTeachingSchedule instance = new DbTeachingSchedule();

    private List<TeachingSchedule> teachingScheduleList ;

    private DbTeachingSchedule() {
        teachingScheduleList = new Vector<>();
        //getAllTeachingSchedule();
        //teachingScheduleList.add(new TeachingSchedule("1666","1999","hoa","tiết 9","325A4"));
    }

    public List<TeachingSchedule> getTeachingScheduleList() {
        return teachingScheduleList;
    }

    public int getSize(){
        return teachingScheduleList.size();
    }

    public void addTeachingSchedule (TeachingSchedule teachingSchedule){
        this.teachingScheduleList.add(teachingSchedule);
    }

    public void getAllTeachingSchedule(){
        TeachingScheduleService teachingScheduleService = NetContextLogin.instance.create(TeachingScheduleService.class);
        teachingScheduleService.getAll().enqueue(new Callback<List<TeachingSchedule>>() {
            @Override
            public void onResponse(Call<List<TeachingSchedule>> call, Response<List<TeachingSchedule>> response) {
                List<TeachingSchedule> list =response.body();
                for (int i = 0; i < list.size(); i++) {
                    addTeachingSchedule(list.get(i));
                    Log.d(DbTeachingSchedule.class.toString(), String.format("onResponse: %s", teachingScheduleList.get(i).toString()));


                }
                Log.d(DbTeachingSchedule.class.toString(), String.format("onResponse: %s", teachingScheduleList.toString()));
            }

            @Override
            public void onFailure(Call<List<TeachingSchedule>> call, Throwable t) {

            }
        });
//                enqueue(new Callback<List<TeachingScheduleResponJSON>>() {
//            @Override
//            public void onResponse(Call<List<TeachingScheduleResponJSON>> call, Response<List<TeachingScheduleResponJSON>> response) {
//                teachingScheduleList = response.body();
//                for (int i = 0; i < students.size(); i++) {
//                    Log.e(TAG, String.format("onResponse: %s", students.get(i)) );
//                }
//                Log.e(TAG, "onResponse: load hết group");
//                EventBus.getDefault().postSticky(new GetDataSuccusEvent());
//            }
//
//            @Override
//            public void onFailure(Call<List<ClassStudent>> call, Throwable t) {
//                Log.e(TAG, String.format("onFailure: %s", t.toString()));
//                EventBus.getDefault().postSticky(new GetDataFaildedEvent());
//            }
    }
}
