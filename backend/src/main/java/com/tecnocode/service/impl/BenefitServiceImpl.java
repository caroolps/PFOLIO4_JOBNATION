package com.tecnocode.service.impl;

import com.tecnocode.model.Benefit;
import com.tecnocode.repository.BenefitRepository;
import com.tecnocode.service.BenefitService;
import com.tecnocode.validator.BenefitValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {
    private final BenefitRepository repository;
    private final BenefitValidator validator;

    @Override
    public Benefit save(final Benefit benefit) {
        validator.validate(benefit);
        return repository.saveAndFlush(benefit);
    }
}
