package za.ac.nwu.ac.logic.flow.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.AddMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("addMilesFlowName")
public class AddMilesFlowImpl implements AddMilesFlow{

    private static final Logger LOGGER = LoggerFactory.getLogger(AddMilesFlowImpl.class);

    private final  MilesTranslator milesTranslator;

    public AddMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }
    @Override
    public MilesDto addMiles(Long miles_ID, Long milesToAdd, LocalDate startDate){
        LOGGER.info("The input for addMiles is MilesID: {}, MilesToAdd: {} and StartDate: {}",miles_ID,milesToAdd,startDate);

        if(null == miles_ID){
            miles_ID = 1L;
            LOGGER.info("The input milesID was null, so it was changed to {}", miles_ID);
        }
        if (null == startDate){
            startDate = LocalDate.of(2021,01,01);
            LOGGER.info("The input date was null, so it was changed to {}", startDate);
        }
        return milesTranslator.addMiles(miles_ID, milesToAdd, startDate);
    }
}
