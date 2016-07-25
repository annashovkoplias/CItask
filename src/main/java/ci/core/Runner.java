package ci.core;

import ci.steps.UITests;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.Steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner extends JUnitStories {

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().
                        withFormats(Format.XML, Format.HTML));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        ArrayList<Steps> stepFileList = new ArrayList<Steps>();
        stepFileList.add(new UITests());
        return new InstanceStepsFactory(configuration(), stepFileList);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/main/resources"),
                Arrays.asList("**/*.story"), Arrays.asList(""));
    }
}

