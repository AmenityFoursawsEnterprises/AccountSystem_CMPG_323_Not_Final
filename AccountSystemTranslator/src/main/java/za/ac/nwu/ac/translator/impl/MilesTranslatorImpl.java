package za.ac.nwu.ac.translator.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.domain.persistence.Miles;
import za.ac.nwu.ac.repo.persistence.MilesRepository;
import za.ac.nwu.ac.translator.MilesTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MilesTranslatorImpl implements MilesTranslator {

    private  final  MilesRepository milesRepository;

    @Autowired
    public  MilesTranslatorImpl(MilesRepository milesRepository){
        this.milesRepository = milesRepository;
    }

    public MilesDto getTotalMilesByID(Long miles_ID){
        try{
            MilesDto milesNew = new MilesDto(milesRepository.getTotalMilesByID(miles_ID));
            return milesNew;
            //return milesRepository.findById(miles_ID);
        }catch (Exception e){
            // TODO: Get Total Miles
            throw new RuntimeException("Unable to view miles from DB.", e);
        }
    }

    @Override
    public  MilesDto addMiles(Long milesID, Long milesToAdd, LocalDate startDate){
        try{
            //Miles miles = milesRepository.save(milesRepository.addMiles(milesID, milesToAdd, startDate));
            Miles miles = milesRepository.addMiles(milesID, milesToAdd, startDate);
            return new MilesDto(miles);
        }catch (Exception e){
            // TODO: Add Miles
            throw new RuntimeException("Could not add miles to the DB.",e);
        }
    }

    @Override
    public MilesDto subtractMiles(Long MilesID, Long MilesToSubtract){
        try {
            Miles miles = milesRepository.subtractMiles(MilesID, MilesToSubtract);
            return new MilesDto(miles);
        }catch (Exception e){
            // TODO: Subtract Miles
            throw new RuntimeException("Unable to subtract miles form DB.",e);
        }
    }
/*@Override
    public  AccountTypeDto create(AccountTypeDto accountTypeDto){
        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }*/
    /*@Override
    public  MilesDto addMiles(Long miles_ID, int milesToAdd){
        try {
            MilesDto miles = milesRepository.getTotalMilesByID(miles_ID);
            //addMiles(miles_ID);
            Miles milesNewTotal = milesRepository.addMiles(milesToAdd, miles);
            return new MilesDto(milesNewTotal);
        }catch (Exception e){
            throw new RuntimeException("Unable to add miles to the DB", e);
        }
    }*/
    /*@Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic){
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB.", e);

        }
    }*/


}
