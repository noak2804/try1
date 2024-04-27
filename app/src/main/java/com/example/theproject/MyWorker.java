package com.example.theproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {
        return Result.success();
    }
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters
            workerParams) {
        super(context, workerParams);
    }



    @Override
    public void onStopped() {
        super.onStopped();
    }
}
