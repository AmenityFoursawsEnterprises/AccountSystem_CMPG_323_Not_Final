package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.MilesDto;
import za.ac.nwu.ac.domain.dto.RewardsDto;
import za.ac.nwu.ac.translator.RewardsTranslator;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchRewardsFlowImplTest {
    @Mock
    private RewardsTranslator translator;
    @InjectMocks
    private FetchRewardsFlowImpl flow;

    private String name = "HokkyStick";
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllRewards() {
        //Mockito.when(translator.getAllRewards()).thenReturn(null);
        List<RewardsDto> result = flow.getAllRewards();
        assertNull(result);
        Mockito.verify(translator, Mockito.never()).getAllRewards();
    }
    @Test
    public void getRewardByName() {
        //Mockito.when(translator.getAllRewards()).thenReturn(null);
        //List<RewardsDto> result = flow.getAllRewards();
        // assertNull(result);
       List <RewardsDto> result = flow.getRewardByName( name);
        assertNull(result);
        Mockito.verify(translator, Mockito.never()).getRewardByName(name);
    }
}