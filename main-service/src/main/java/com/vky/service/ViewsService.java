package com.vky.service;


import com.vky.repository.IViewsRepository;
import com.vky.repository.entity.Views;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ViewsService extends ServiceManager<Views, Long> {
    private final IViewsRepository viewsRepository;

    public ViewsService(IViewsRepository viewsRepository) {
        super(viewsRepository);
        this.viewsRepository = viewsRepository;
    }
}
