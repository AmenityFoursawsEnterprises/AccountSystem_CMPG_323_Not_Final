package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl testClass;
    private  String name = "aapie";
    @Mock
    private AccountTypeTranslator translator;

    @Before
    public void setUp() throws Exception {
        testClass = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        testClass = null;
    }

    @Test
    public void getAccountTypeByMnemonic() {
        //assertFalse(testClass.getAccountTypeByMnemonic(name));
        Mockito.verify(translator, Mockito.never()).getAccountTypeByMnemonic(name);

    }

    @Test
    public void getAllAccountTypes(){
        Mockito.verify(translator, Mockito.never()).getAllAccountTypes();

    }
}