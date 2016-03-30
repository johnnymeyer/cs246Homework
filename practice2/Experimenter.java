package socialmedia;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class is the Experiment shell for the classification program.
 * 
 * @author sburton
 */
public class Experimenter {
    
    /**
     * Runs the Experiment and outputs the results
     */
    public void runTest() {
        
        // First get the entries from the file
        String file = getFileName();
        Set<SocialMediaEntry> entries = loadEntriesFromFile(file);
        
        // Next Load the training and test data
        Set<SocialMediaEntry> trainingSet = loadTrainingData(entries);
        Set<SocialMediaEntry> testSet = loadTestData(entries);
        
        // Induce a model and classify the results
        Map<SocialMediaEntry, Boolean> results = classifyEntries(trainingSet, testSet);
        
        // Give the results to the user
        outputResults(results);
    }
    
    /**
     * Gets a filename from the user
     * @return 
     */
    private String getFileName() {
        System.out.println("Getting the filename from the user...");
        
        // In a real use case, this would prompt the user
        
        return "newFileName.txt";
    }
    
    /**
     * Loads SocialMediaEntries from the given file.
     * @param file
     * @return 
     */
    private Set<SocialMediaEntry> loadEntriesFromFile(String file) {
        System.out.println("Reading social media entries from file '" + file + "' ...");
        
        Set<SocialMediaEntry> entries = new HashSet<>();
        
        // In a real use case, this would load these from a file
        FacebookPost post1 = new FacebookPost("John", "It's another great day", 300);
        FacebookPost post2 = new FacebookPost("Emily", "I love CS 246", 21);
        FacebookPost post3 = new FacebookPost("Andy", "Everything is awesome!", 1000);        
        
        entries.add(post1);
        entries.add(post2);
        entries.add(post3);
        
        return entries;
    }
    
    /**
     * Gets the training set from the given entries.
     * @param entries
     * @return 
     */
    private Set<SocialMediaEntry> loadTrainingData(Set<SocialMediaEntry> entries) {
        System.out.println("Loading the training set...");
        
        // In a real use case, this would partition the set, rather than return the whole thing.
        Set<SocialMediaEntry> trainingSet = new HashSet<>();
        trainingSet.addAll(entries);
        
        return trainingSet;
    }
    
    /**
     * Gets the test set from the given entries.
     * @param entries
     * @return 
     */
    private Set<SocialMediaEntry> loadTestData(Set<SocialMediaEntry> entries) {
        System.out.println("Loading the test set...");
        
        // In a real use case, this would partition the set, rather than return the whole thing.
        Set<SocialMediaEntry> testSet = new HashSet<>();
        testSet.addAll(entries);
        
        return testSet;
    }
    
    /**
     * Builds a model and classifies the test set.
     * @param trainingSet
     * @param testSet
     * @return A mapping of true or false to each entry in the test set.
     */
    private Map<SocialMediaEntry, Boolean> classifyEntries(Set<SocialMediaEntry> trainingSet,
            Set<SocialMediaEntry> testSet) {
        
        System.out.println("Running classifier...");
        
        // In a real use case, build a machine learning model from the training set,
        // then use it to classify the entries in the test set.

        
        Map<SocialMediaEntry, Boolean> results = new HashMap<>();
        
        // Right now this is putting a "true" for everything
        // TODO: This method will need to be changes / replaced.
        for (SocialMediaEntry entry : testSet) {
            results.put(entry, true);
        }
        
        return results;
    }
    
    /**
     * Outputs the results of the experiment
     * @param results 
     */
    private void outputResults(Map<SocialMediaEntry, Boolean> results) {
        System.out.println("The results of your experiment are: \n");
        
        int correct = 0;
        int total = 0;
        
        for (SocialMediaEntry entry : results.keySet()) {
            total++;
            
            // In a real case, we would see if the classification matched
            // what it was supposed to be. For this one, we will just count
            // it as "correct" if the classification was true.
            
            if (results.get(entry)) {
                System.out.print("Correct: ");
                correct++;
            } else {
                System.out.print("Missed: ");
            }
            
            System.out.println(entry.getPostText() + " by " + entry.getUser());
        }
        
        float percent = (float) correct / total * 100;
        
        System.out.println("\nAccuracy: " + percent);
    }
}
