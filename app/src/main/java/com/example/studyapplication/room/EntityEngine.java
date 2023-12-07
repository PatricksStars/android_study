package com.example.studyapplication.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public class EntityEngine {
    EntityDao entityDao;
    public EntityEngine(Context context){
        EntityDatabase database = EntityDatabase.getInstance(context);
        entityDao = database.getEntityDao();
    }

    public void insert(Entity entity){
        entityDao.insert(entity);

        new InsertAsyncTask(entityDao).execute(entity);
    }

    static class InsertAsyncTask extends AsyncTask<Entity,Void,Void> {
        EntityDao entityDao;
        public InsertAsyncTask(EntityDao entityDao) {
            this.entityDao = entityDao;
        }

        @Override
        protected Void doInBackground(Entity... entities) {
            entityDao.insertAll(entities);
            return null;
        }
    }
}
