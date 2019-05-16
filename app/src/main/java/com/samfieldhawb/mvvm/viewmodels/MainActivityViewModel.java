package com.samfieldhawb.mvvm.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.samfieldhawb.mvvm.models.NicePlace;
import com.samfieldhawb.mvvm.repositories.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNiceplaces;
    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    private NicePlaceRepository mRepo;

    public LiveData<List<NicePlace>> getNiceplaces() {
        return mNiceplaces;
    }

    public void init(){
        if(mNiceplaces !=null){
            return;
        }
        mRepo = NicePlaceRepository.getInstance();
        mNiceplaces  = mRepo.getNicePlaces();
//        mNiceplaces = NicePlaceRepository.getInstance().getNicePlaces();
    }

    public void setNiceplaces(MutableLiveData<List<NicePlace>> niceplaces) {
        mNiceplaces = niceplaces;
    }

    public void addNiceplace (final NicePlace nicePlace){
        isUpdating.setValue(true);
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<NicePlace> currentNicePlace = mNiceplaces.getValue();
                currentNicePlace.add(nicePlace);
                mNiceplaces.postValue(currentNicePlace);
                isUpdating.setValue(false);
            }
        }.execute();

    }

    public MutableLiveData<Boolean> getIsUpdating(){
        return isUpdating;
    }
}
