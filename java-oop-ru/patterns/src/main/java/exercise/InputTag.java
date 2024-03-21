package exercise;




// BEGIN


public class InputTag implements TagInterface {

    private String type;
    private String value;

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
    }

    public static void main(String[] args) {
        TagInterface tag = new InputTag("submit", "Save");
        System.out.println(tag.render());
        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        System.out.println(labelTag.render());
        // <label>Press Submit<input type="submit" value="Save"></label>
    }
}
// END
