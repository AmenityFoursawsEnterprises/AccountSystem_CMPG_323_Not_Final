package za.ac.nwu.ac.logic.flow.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.ViewMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("viewMilesFlowName")
public class ViewMilesFlowImpl implements ViewMilesFlow{
    private final MilesTranslator milesTranslator;

    @Autowired
    public ViewMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }

    @Override
    public MilesDto getTotalMilesByID(Long miles_ID){
        return milesTranslator.getTotalMilesByID(miles_ID);
    }
}
