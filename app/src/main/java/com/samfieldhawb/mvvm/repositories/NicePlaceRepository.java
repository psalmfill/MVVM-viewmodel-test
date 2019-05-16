package com.samfieldhawb.mvvm.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.samfieldhawb.mvvm.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {
    private static NicePlaceRepository instance;
    ArrayList<NicePlace> dataset = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
       if(instance == null ){
           return new NicePlaceRepository();
       }
        return instance;
    }
// get data from source
    public MutableLiveData<List<NicePlace>> getNicePlaces(){
        setData();
        MutableLiveData<List<NicePlace>> niceplaces = new MutableLiveData<>();
        niceplaces.setValue(dataset);
        return niceplaces;
    }
    private void setData(){
        dataset.add(new NicePlace("https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2017/07/541.jpg","Tokyo"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/Place.de_.la_.Bourse.original.22895.jpg","China"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/JadeMountain-exterior.jpg","Jade Mountain"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/BordeauxVineyard2013Cadillac.jpg","Bordeaux Vineyard"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/PARIS1015-catacombs.jpg","PARIS"));
        dataset.add(new NicePlace("https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2017/07/541.jpg","Tokyo"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/JadeMountain-exterior.jpg","Jade Mountain"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/BordeauxVineyard2013Cadillac.jpg","Bordeaux Vineyard"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/PARIS1015-catacombs.jpg","PARIS"));
        dataset.add(new NicePlace("https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2017/07/541.jpg","Tokyo"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/JadeMountain-exterior.jpg","Jade Mountain"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/BordeauxVineyard2013Cadillac.jpg","Bordeaux Vineyard"));
        dataset.add(new NicePlace("https://blog.pickyourtrail.com/wp-content/uploads/2016/01/PARIS1015-catacombs.jpg","PARIS"));
        dataset.add(new NicePlace("https://d27k8xmh3cuzik.cloudfront.net/wp-content/uploads/2017/07/541.jpg","Tokyo"));

    }
}
