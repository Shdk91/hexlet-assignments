package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private String tag;
    private TagInterface anyTag;

    public LabelTag(String tag, TagInterface anyTag) {
        this.tag = tag;
        this.anyTag = anyTag;
    }


    @Override
    public String render() {
        return "<label>"+tag+anyTag.render()+"</label>";
    }
}
// END
