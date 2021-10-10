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
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MilesTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
       // Mockito.verify(translator, Mockito.never()).create(miles_ID ,  milesToAdd,  startDate);

    }
}