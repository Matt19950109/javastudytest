package dto;

public class QuestionDto {

    private int no;

    private String content;

    private String selection;

    private int category;

    private int answer;

    private int participantCount;

    private int correctionCount;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public int getCorrectionCount() {
        return correctionCount;
    }

    public void setCorrectionCount(int correctionCount) {
        this.correctionCount = correctionCount;
    }
}