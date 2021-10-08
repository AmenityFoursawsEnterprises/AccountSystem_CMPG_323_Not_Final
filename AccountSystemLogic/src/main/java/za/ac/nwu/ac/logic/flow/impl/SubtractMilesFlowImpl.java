package za.ac.nwu.ac.logic.flow.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.logic.flow.SubtractMilesFlow;
import za.ac.nwu.ac.translator.MilesTranslator;
import javax.transaction.Transactional;

@Transactional
@Component("subtractMilesFlowName")
public class SubtractMilesFlowImpl implements SubtractMilesFlow {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubtractMilesFlowImpl.class);

    private final MilesTranslator milesTranslator;

    public SubtractMilesFlowImpl(MilesTranslator milesTranslator){
        this.milesTranslator = milesTranslator;
    }

    @Override
    public MilesDto subtractMiles(Long MilesID, Long MilesToSubtract){
        LOGGER.info("The input for the subtractMiles are {} and {} .", MilesID, MilesToSubtract);
        if(null == MilesID){
            LOGGER.info("The milesID was null and thus it was changed to 1.");
            MilesID = 1L;
        }
        return milesTranslator.subtractMiles(MilesID, MilesToSubtract);
    }

}
