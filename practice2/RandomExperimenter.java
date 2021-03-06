
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RandomExperimenter extends Experimenter {

	public Map<SocialMediaEntry, Boolean> classifyEntries(Set<SocialMediaEntry> trainingSet,
            Set<SocialMediaEntry> testSet) {
		System.out.println("Running classifier...");
        
        // In a real use case, build a machine learning model from the training set,
        // then use it to classify the entries in the test set.

        
        Map<SocialMediaEntry, Boolean> results = new HashMap<>();
        
        // Right now this is putting a "true" for everything
        // TODO: This method will need to be changed / replaced.

        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());


        for (SocialMediaEntry entry : testSet) {
            results.put(entry, rnd.nextInt(2) == 1 ? true : false);
        }
        
        return results;
	}
}