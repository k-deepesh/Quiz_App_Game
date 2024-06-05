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
