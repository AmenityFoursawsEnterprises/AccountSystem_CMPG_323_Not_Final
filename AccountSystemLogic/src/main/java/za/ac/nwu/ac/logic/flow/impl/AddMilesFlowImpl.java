package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.AddMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("addMilesFlowName")
public class AddMilesFlowImpl implements AddMilesFlow{
    private final  MilesTranslator milesTranslator;

    public AddMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }
    @Override
    public MilesDto addMiles(Long miles_ID, Long milesToAdd){
        if(null == miles_ID){
            miles_ID = 0L;
        }
        return milesTranslator.addMiles(miles_ID, milesToAdd);
    }
}
