import java.util.*;

public class Main {
    static int score = 0;

    public static void main(String[] args) {
        startingConsole();
        System.out.println("Hey user, you completed the game.\nHere's your score: " + score);
    }

    static void startingConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready to start the game?\n" + "yes/No");
        String entryOpinion = scanner.next().toLowerCase();
        if (entryOpinion.equals("yes")) {
            rolesOpinion();
        } else {
            startingConsole();
        }
    }

    static void rolesOpinion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to play today?\n" + "Enter 1 for player, or 2 for instructor");
        int role;
        try {
            role = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter either 1 or 2.");
            rolesOpinion();
            return;
        }
        if (role == 1) {
            rules();
        } else {
            System.out.println("Not yet started.");
        }
    }

    static void rules() {
        System.out.println("->The game consists of 10 questions\n" +
                "->Each question carries one point\n" +
                "->The score will be given at the end\n" +
                "->The time for each question is 20 seconds\n" +
                "->After 20 seconds, the question will be skipped");
        guide();
    }

    static void guide() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************Are you ready to start****************\n" + "Enter yes or no");
        String willing = scanner.next().toLowerCase();
        if (willing.equals("yes")) {
            control();
        } else {
            startingConsole();
        }
    }

    static void control() {
        System.out.println("Hey user, here are the questions. Answer one by one.\n" +
                "Choose among the given options by entering the option");
        List<Question> quiz = initializeQuiz();
        Scanner scanner = new Scanner(System.in);

        for (Question question : quiz) {
            System.out.println("Question: " + question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((char) ('A' + i) + ". " + options.get(i));
            }
            String ansChoose = scanner.next().toUpperCase();
            if (ansChoose.equals(question.getAnswer())) {
                score(true);
                System.out.println("Correct!");
            } else {
                score(false);
                System.out.println("Incorrect!");
            }
        }
    }

    static void score(boolean ans) {
        if (ans)
            score++;

    }

    static List<Question> initializeQuiz() {
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("What is the capital of Japan?", Arrays.asList("Tokyo", "Kyoto", "Osaka", "Nagoya"), "A"));
        quiz.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Saturn"), "B"));
        quiz.add(new Question("Who wrote the play 'Romeo and Juliet'?", Arrays.asList("William Shakespeare", "Charles Dickens", "Mark Twain", "Jane Austen"), "A"));
        quiz.add(new Question("What is the largest mammal in the world?", Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Rhinoceros"), "B"));
        quiz.add(new Question("Which element has the chemical symbol O?", Arrays.asList("Oxygen", "Gold", "Osmium", "Zinc"), "A"));
        quiz.add(new Question("What is the hardest natural substance on Earth?", Arrays.asList("Diamond", "Gold", "Iron", "Granite"), "A"));
        quiz.add(new Question("What is the boiling point of water at sea level?", Arrays.asList("90°C", "100°C", "110°C", "120°C"), "B"));
        quiz.add(new Question("Which country is the largest by area?", Arrays.asList("Canada", "Russia", "China", "United States"), "B"));
        quiz.add(new Question("Which language is primarily spoken in Brazil?", Arrays.asList("Spanish", "French", "Portuguese", "English"), "C"));
        quiz.add(new Question("What is the smallest prime number?", Arrays.asList("0", "1", "2", "3"), "C"));
        return quiz;
    }
}

class Question {
    String question;
    List<String> options;
    String answer;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public Question(String question, List<String> options, String answer) {
        this.answer = answer;
        this.question = question;
        this.options = options;
    }
}
