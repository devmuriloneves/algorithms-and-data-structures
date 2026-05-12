/**
 * Represents a candidate in an electoral poll.
 * Each candidate has a unique number, a name, a party, and a vote-intention count.
 */
public class Candidate {
    private int number;
    private String name;
    private String party;
    private int voteIntentions;

    /**
     * Creates a new candidate with zero vote intentions.
     *
     * @param number unique candidate number
     * @param name   candidate's first name
     * @param party  party name
     */
    public Candidate(int number, String name, String party) {
        this.number = number;
        this.name = name;
        this.party = party;
        this.voteIntentions = 0;
    }

    /** Returns the candidate's unique number. */
    public int getNumber() {
        return number;
    }

    /** Returns the candidate's name. */
    public String getName() {
        return name;
    }

    /** Returns the candidate's party. */
    public String getParty() {
        return party;
    }

    /** Returns the current vote-intention count. */
    public int getVoteIntentions() {
        return voteIntentions;
    }

    /** Sets the vote-intention count. */
    public void setVoteIntentions(int voteIntentions) {
        this.voteIntentions = voteIntentions;
    }

    /** Returns a formatted string: {@code number - name - party - N votes}. */
    @Override
    public String toString() {
        return number + " - " + name + " - " + party + " - " + voteIntentions + " votes";
    }
}
