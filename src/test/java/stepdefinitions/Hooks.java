package stepdefinitions;

import constants.Context;
import cucumber.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void beforeAll() {
        Awaitility.setDefaultPollInterval(300, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollDelay(Duration.ZERO);
        Awaitility.setDefaultTimeout(Duration.ofSeconds(40));
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        testContext.scenarioContext().setContext(Context.SCENARIO_NAME, scenario.getName());
    }
}