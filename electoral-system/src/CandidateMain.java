import java.util.Random;

/**
 * Entry point for the electoral poll simulation.
 *
 * Demonstrates the full workflow:
 *   1. Populate a {@link StaticList} with 20 auto-generated {@link Candidate} objects.
 *   2. Print the list before sorting.
 *   3. Sort the list by candidate number using Insertion Sort.
 *   4. Print the list after sorting.
 *   5. Perform a binary search for a randomly chosen candidate number and display the result.
 */
public class CandidateMain {
    public static void main(String[] args) throws Exception {
        StaticList<Candidate> candidates = new StaticList<>(20);

        String[] names = { "João", "Maria", "Pedro", "Ana", "Lucas", "Julia", "Carlos", "Fernanda", "Rafael", "Beatriz",
                "Gustavo", "Camila", "Bruno", "Larissa", "Felipe", "Mariana", "Ricardo", "Sofia", "Diego",
                "Amanda" };
        String[] parties = { "Party A", "Party B", "Party C", "Party D" };

        // Tracks which candidate numbers have already been assigned to ensure uniqueness.
        boolean[] usedNumbers = new boolean[21];

        // Insert candidates in reverse name order so the list starts unsorted by number,
        // making the subsequent sort step meaningful.
        for (int i = names.length - 1; i >= 0; i--) {
            String name = names[i];
            String party = parties[i % parties.length];

            // Pick a random unique number between 1 and 20.
            int number;
            do {
                number = new Random().nextInt(20) + 1;
            } while (usedNumbers[number]);

            usedNumbers[number] = true;
            candidates.insert(new Candidate(number, name, party), i);

            candidates.get(i).setVoteIntentions(new Random().nextInt(5000));
        }

        System.out.println("Candidates before sorting:");
        System.out.println();

        for (int i = 0; i < candidates.numElements(); i++) {
            System.out.println(candidates.get(i));
        }

        candidates.insertionSortCandidates();

        System.out.println();
        System.out.println("Candidates after sorting:");
        System.out.println();

        for (int i = 0; i < candidates.numElements(); i++) {
            System.out.println(candidates.get(i));
        }

        // Search for a randomly chosen number; it may or may not exist in the list.
        int searchedNumber = new Random().nextInt(20) + 1;
        int pos = candidates.binarySearchCandidates(searchedNumber);

        System.out.println();
        System.out.println("Binary search for candidate number: " + searchedNumber);
        System.out.println();

        if (pos != -1) {
            System.out.println("Candidate found: " + candidates.get(pos));
        } else {
            System.out.println("Candidate not found.");
        }
    }
}
