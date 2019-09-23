/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package philips.swcoe.xpers.samples.tdd.main;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This is a JUnitRunner class that invokes cucumber's feature file & executes it as junits.
 * Coverage can also be seen via this file!
 * @author dsvellal
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/json"},
    features = "src/test/resources",
    monochrome = true)
public class CucumberJUnitRunner {}
