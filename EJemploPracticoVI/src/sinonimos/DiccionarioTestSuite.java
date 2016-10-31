package sinonimos;
/**
 * En este caso al Fixture lo incluimos en una clase aparte lo que nos permitiria 
 * eventualmente tratar diferentes incializaciones desde dicha clase sin tocar los
 * testcases.
 * 
 * */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({DiccionarioPR5Test2.class, DiccionarioPR5Test1.class
                                       })
public class DiccionarioTestSuite {
}
