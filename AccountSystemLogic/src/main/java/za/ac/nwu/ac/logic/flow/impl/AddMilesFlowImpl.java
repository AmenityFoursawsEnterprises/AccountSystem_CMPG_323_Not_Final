package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.AddMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("addMilesFlowName")
public class AddMilesFlowImpl implements AddMilesFlow{
    private final  MilesTranslator milesTranslator;

    public AddMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }
    @Override
    public MilesDto addMiles(Long miles_ID, Long milesToAdd, LocalDate startDate){
        if(null == miles_ID){
            miles_ID = 0L;
        }
        if (null == startDate){
            startDate = LocalDate.of(2021,01,01);
        }
        return milesTranslator.addMiles(miles_ID, milesToAdd, startDate);
    }
}
