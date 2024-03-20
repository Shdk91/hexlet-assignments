package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String text;

    public ReversedSequence(String text) {
        StringBuilder sb = new StringBuilder(text);
        this.text = sb.reverse().toString();
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.subSequence(start, end);
    }


}
// END
