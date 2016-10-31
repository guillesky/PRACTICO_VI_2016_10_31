package sinonimos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DiccionarioAccessDirectGUITest.class,
                      DiccionarioAccessByNameGUITest.class,
                      DiccionarioRobotGUITest.class,
                      })
public class DiccionarioGUITestSuite {
}
