package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.SubtractMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("subtractMilesFlowName")
public class SubtractMilesFlowImpl implements SubtractMilesFlow {
    private final MilesTranslator milesTranslator;

    public SubtractMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }

    @Override
    public MilesDto subtractMiles(Long MilesID, Long MilesToSubtract){
        if(null == MilesID){
            MilesID = 0L;
        }
        return milesTranslator.subtractMiles(MilesID, MilesToSubtract);
    }

}
