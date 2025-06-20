import java.util.*;


// Main Voting System class
public class VotingSystem {
    private static List<Candidate> candidates = new ArrayList<>();
    private static List<Voter> voters = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("           WELCOME TO VOTING SYSTEM");
        System.out.println("=".repeat(60));
        
        int choice;
        do {
            displayMainMenu();
            choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    manageCandidates();
                    break;
                case 2:
                    manageVoters();
                    break;
                case 3:
                    startVoting();
                    break;
                case 4:
                    displayResults();
                    break;
                case 5:
                    System.out.println("Thank you for using the Voting System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
            if (choice != 5) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
            
        } while (choice != 5);
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    VOTING SYSTEM MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. Manage Candidates");
        System.out.println("2. Manage Voters");
        System.out.println("3. Start Voting");
        System.out.println("4. Display Results");
        System.out.println("5. Exit");
        System.out.println("=".repeat(60));
    }
    
    private static void manageCandidates() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("         CANDIDATE MANAGEMENT");
        System.out.println("-".repeat(40));
        System.out.println("1. Add Candidates");
        System.out.println("2. View Candidates");
        System.out.println("-".repeat(40));
        
        int choice = getIntInput("Enter choice: ");
        
        switch (choice) {
            case 1:
                addCandidates();
                break;
            case 2:
                viewCandidates();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void manageVoters() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("           VOTER MANAGEMENT");
        System.out.println("-".repeat(40));
        System.out.println("1. Register Voters");
        System.out.println("2. View Voters");
        System.out.println("-".repeat(40));
        
        int choice = getIntInput("Enter choice: ");
        
        switch (choice) {
            case 1:
                registerVoters();
                break;
            case 2:
                viewVoters();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void addCandidates() {
        System.out.println("\n--- ADD CANDIDATES ---");
        int numCandidates = getIntInput("Enter the number of candidates: ");
        
        for (int i = 0; i < numCandidates; i++) {
            System.out.print("Candidate " + (i + 1) + ": ");
            String name = scanner.nextLine();
            
            // Check for duplicate candidate names
            boolean exists = candidates.stream().anyMatch(c -> c.getName().equalsIgnoreCase(name));
            if (exists) {
                System.out.println("Candidate with this name already exists!");
                i--; // Retry current candidate
                continue;
            }
            
            candidates.add(new Candidate(name));
        }
        
        System.out.println("Candidates added successfully!");
        viewCandidates();
    }
    
    private static void viewCandidates() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                   LIST OF CANDIDATES");
        System.out.println("=".repeat(60));
        
        if (candidates.isEmpty()) {
            System.out.println("|" + " ".repeat(58) + "|");
            System.out.println("|" + centerText("No candidates registered yet!", 58) + "|");
            System.out.println("|" + " ".repeat(58) + "|");
            System.out.println("=".repeat(60));
            return;
        }
        
        // Table header
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(18) + "|");
        System.out.printf("| %-5s | %-30s | %-16s |%n", "S.No", "Candidate Name", "Votes");
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(18) + "|");
        
        // Table rows
        for (int i = 0; i < candidates.size(); i++) {
            Candidate candidate = candidates.get(i);
            System.out.printf("| %-5d | %-30s | %-16d |%n", 
                (i + 1), candidate.getName(), candidate.getVotes());
        }
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(18) + "|");
    }
    
    private static void registerVoters() {
        System.out.println("\n--- REGISTER VOTERS ---");
        int numVoters = getIntInput("Enter number of voters: ");
        
        for (int i = 0; i < numVoters; i++) {
            System.out.println("\nVoter " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            
            String voterID;
            while (true) {
                System.out.print("Voter ID: ");
                voterID = scanner.nextLine();
                final String finalVoterID = voterID; // Make it effectively final
                
                // Check for duplicate voter ID
                boolean exists = voters.stream().anyMatch(v -> v.getVoterID().equals(finalVoterID));
                if (exists) {
                    System.out.println("Voter ID already exists! Please enter a different ID.");
                } else {
                    break;
                }
            }
            
            System.out.print("Set Password: ");
            String password = scanner.nextLine();
            
            voters.add(new Voter(name, voterID, password));
        }
        
        System.out.println("Voters registered successfully!");
        viewVoters();
    }
    
    private static void viewVoters() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                           LIST OF REGISTERED VOTERS");
        System.out.println("=".repeat(80));
        
        if (voters.isEmpty()) {
            System.out.println("|" + " ".repeat(78) + "|");
            System.out.println("|" + centerText("No voters registered yet!", 78) + "|");
            System.out.println("|" + " ".repeat(78) + "|");
            System.out.println("=".repeat(80));
            return;
        }
        
        // Table header
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(27) + "|" + "-".repeat(17) + "|" + "-".repeat(25) + "|");
        System.out.printf("| %-5s | %-25s | %-15s | %-23s |%n", "S.No", "Voter Name", "Voter ID", "Voting Status");
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(27) + "|" + "-".repeat(17) + "|" + "-".repeat(25) + "|");
        
        // Table rows
        for (int i = 0; i < voters.size(); i++) {
            Voter voter = voters.get(i);
            String status = voter.hasVoted() ? "VOTED" : "NOT VOTED";
            System.out.printf("| %-5d | %-25s | %-15s | %-23s |%n", 
                (i + 1), voter.getName(), voter.getVoterID(), status);
        }
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(27) + "|" + "-".repeat(17) + "|" + "-".repeat(25) + "|");
    }
    
    private static void startVoting() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 VOTING PROCESS");
        System.out.println("=".repeat(50));
        
        if (candidates.isEmpty()) {
            System.out.println("No candidates available for voting!");
            return;
        }
        
        if (voters.isEmpty()) {
            System.out.println("No voters registered!");
            return;
        }
        
        System.out.println("Available Candidates:");
        viewCandidates();
        
        while (true) {
            System.out.println("\n--- VOTER AUTHENTICATION ---");
            System.out.print("Enter Voter ID (or 'exit' to stop voting): ");
            String voterID = scanner.nextLine();
            
            if (voterID.equalsIgnoreCase("exit")) {
                break;
            }
            
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            
            int voterIndex = verifyVoter(voterID, password);
            
            if (voterIndex != -1) {
                castVote(voterIndex);
            }
        }
    }
    
    private static int verifyVoter(String voterID, String password) {
        for (int i = 0; i < voters.size(); i++) {
            Voter voter = voters.get(i);
            if (voter.getVoterID().equals(voterID) && voter.getPassword().equals(password)) {
                if (voter.hasVoted()) {
                    System.out.println("Error: You have already voted!");
                    return -1;
                }
                return i;
            }
        }
        System.out.println("Invalid Voter ID or Password!");
        return -1;
    }
    
    private static void castVote(int voterIndex) {
        Voter voter = voters.get(voterIndex);
        System.out.println("\nHello " + voter.getName() + "! Please cast your vote.");
        
        while (true) {
            System.out.print("Vote for (enter candidate name): ");
            String candidateName = scanner.nextLine();
            
            boolean found = false;
            for (Candidate candidate : candidates) {
                if (candidate.getName().equalsIgnoreCase(candidateName)) {
                    candidate.addVote();
                    voter.setVoted(true);
                    System.out.println("Vote recorded successfully for " + candidate.getName() + "!");
                    found = true;
                    break;
                }
            }
            
            if (found) {
                break;
            } else {
                System.out.println("Candidate not found! Please enter a valid candidate name.");
                System.out.println("Available candidates:");
                for (int i = 0; i < candidates.size(); i++) {
                    System.out.println((i + 1) + ". " + candidates.get(i).getName());
                }
            }
        }
    }
    
    private static void displayResults() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("                        ELECTION RESULTS");
        System.out.println("=".repeat(80));
        
        if (candidates.isEmpty()) {
            System.out.println("|" + " ".repeat(78) + "|");
            System.out.println("|" + centerText("No candidates available!", 78) + "|");
            System.out.println("|" + " ".repeat(78) + "|");
            System.out.println("=".repeat(80));
            return;
        }
        
        // Sort candidates by votes in descending order
        List<Candidate> sortedCandidates = new ArrayList<>(candidates);
        sortedCandidates.sort((c1, c2) -> Integer.compare(c2.getVotes(), c1.getVotes()));
        
        // Table header
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(12) + "|" + "-".repeat(25) + "|");
        System.out.printf("| %-5s | %-30s | %-10s | %-23s |%n", "Rank", "Candidate Name", "Votes", "Percentage");
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(12) + "|" + "-".repeat(25) + "|");
        
        int totalVotes = candidates.stream().mapToInt(Candidate::getVotes).sum();
        
        // Table rows
        for (int i = 0; i < sortedCandidates.size(); i++) {
            Candidate candidate = sortedCandidates.get(i);
            double percentage = totalVotes > 0 ? (candidate.getVotes() * 100.0 / totalVotes) : 0;
            System.out.printf("| %-5d | %-30s | %-10d | %-21.2f%% |%n", 
                (i + 1), candidate.getName(), candidate.getVotes(), percentage);
        }
        System.out.println("|" + "-".repeat(7) + "|" + "-".repeat(32) + "|" + "-".repeat(12) + "|" + "-".repeat(25) + "|");
        
        // Summary information
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 SUMMARY");
        System.out.println("=".repeat(50));
        System.out.println("| Total votes cast: " + String.format("%-26d", totalVotes) + "|");
        System.out.println("| Total registered voters: " + String.format("%-19d", voters.size()) + "|");
        
        // Determine winner
        if (totalVotes > 0) {
            Candidate winner = sortedCandidates.get(0);
            System.out.println("| 🏆 WINNER: " + String.format("%-33s", winner.getName() + " (" + winner.getVotes() + " votes)") + "|");
            
            // Check for tie
            if (sortedCandidates.size() > 1 && sortedCandidates.get(0).getVotes() == sortedCandidates.get(1).getVotes()) {
                System.out.println("| ⚠️  NOTE: Tie for highest votes!" + String.format("%-15s", "") + "|");
            }
        } else {
            System.out.println("| ❌ No votes have been cast yet!" + String.format("%-16s", "") + "|");
        }
        
        // Display voting statistics
        long votedCount = voters.stream().mapToLong(v -> v.hasVoted() ? 1 : 0).sum();
        double turnout = voters.size() > 0 ? (votedCount * 100.0 / voters.size()) : 0;
        System.out.println("| Voter turnout: " + String.format("%-30s", votedCount + "/" + voters.size() + " (" + String.format("%.2f", turnout) + "%)") + "|");
        System.out.println("=".repeat(50));
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    // Helper method to center text within a given width
    private static String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int padding = (width - text.length()) / 2;
        int extraPadding = (width - text.length()) % 2;
        return " ".repeat(padding) + text + " ".repeat(padding + extraPadding);
    }
}

// Candidate class
class Candidate {
    private String name;
    private int votes;
    
    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public int getVotes() { return votes; }
    public void addVote() { this.votes++; }
    public void setVotes(int votes) { this.votes = votes; }
}

// Voter class
class Voter {
    private String name;
    private String voterID;
    private String password;
    private boolean hasVoted;
    
    public Voter(String name, String voterID, String password) {
        this.name = name;
        this.voterID = voterID;
        this.password = password;
        this.hasVoted = false;
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public String getVoterID() { return voterID; }
    public String getPassword() { return password; }
    public boolean hasVoted() { return hasVoted; }
    public void setVoted(boolean voted) { this.hasVoted = voted; }
}
