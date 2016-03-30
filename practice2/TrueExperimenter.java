
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrueExperimenter extends Experimenter {

	public Map<SocialMediaEntry, Boolean> classifyEntries(Set<SocialMediaEntry> trainingSet,
            Set<SocialMediaEntry> testSet) {
		System.out.println("Running classifier...");
        
        // In a real use case, build a machine learning model from the training set,
        // then use it to classify the entries in the test set.

        
        Map<SocialMediaEntry, Boolean> results = new HashMap<>();
        
        // Right now this is putting a "true" for everything
        // TODO: This method will need to be changed / replaced.
        for (SocialMediaEntry entry : testSet) {
            results.put(entry, true);
        }
        
        return results;
	}	
}