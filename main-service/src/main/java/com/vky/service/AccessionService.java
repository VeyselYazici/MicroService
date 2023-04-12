package com.vky.service;


import com.vky.repository.IAccessionRepository;
import com.vky.repository.entity.Accession;
import com.vky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AccessionService extends ServiceManager<Accession, Long> {
    private final IAccessionRepository accessionRepository;

    public AccessionService(IAccessionRepository accessionRepository) {
        super(accessionRepository);
        this.accessionRepository = accessionRepository;
    }
}
