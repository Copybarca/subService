package org.example.subService.service;

import org.example.subService.model.Subscribe;
import org.example.subService.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubscribeService {

    SubscribeRepository subscribeRepository;
    @Autowired
    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public void addSubscribe (int userId, Subscribe subscribe){
        subscribeRepository.save(subscribe);
    }

    public List<Subscribe> getTop3List() {
        List<Subscribe> list = new ArrayList<>();
        Iterable<Subscribe> iterable = subscribeRepository.findAll();
        for (Subscribe subscribe : iterable) {
            list.add(subscribe);
        }
        return list;

    }

    public void deleteSubscription(int subId) {
        subscribeRepository.deleteById(subId);
    }
}
