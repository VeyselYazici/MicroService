package com.vky.service;


import com.vky.repository.IDegreHoldersRepository;
import com.vky.repository.entity.DegreeHolders;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class DegreHoldersService extends ServiceManager<DegreeHolders, Long> {
    private final IDegreHoldersRepository degreHoldersRepository;

    public DegreHoldersService(IDegreHoldersRepository degreHoldersRepository) {
        super(degreHoldersRepository);
        this.degreHoldersRepository = degreHoldersRepository;
    }
}
