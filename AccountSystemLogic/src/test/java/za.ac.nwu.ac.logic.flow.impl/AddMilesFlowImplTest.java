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
import za.ac.nwu.ac.translator.MilesTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddMilesFlowImplTest {

    @Mock
    private  MilesTranslator translator;
    @InjectMocks
    private AddMilesFlowImpl flow;

    private Long miles_ID;
    private Long milesToAdd;
    private LocalDate startDate;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addMiles() {
        //Mockito.when(translator.addMiles(miles_ID,milesToAdd,startDate)).thenReturn(null);
        MilesDto result = flow.addMiles( miles_ID ,  milesToAdd,  startDate);
        assertNull(result);
        //Mockito.verify(translator, Mockito.never()).addMiles((miles_ID) ,  milesToAdd,  startDate);
    }
}