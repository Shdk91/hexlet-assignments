package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReversedSequenceTest {

    public CharSequence text;
    @BeforeEach
    public void before() {
       text = new ReversedSequence("abcdef");
    }

  @Test
  public void testTotal() {
        assertThat(text.length()).isEqualTo(6);
        assertThat(text.toString()).isEqualTo("fedcba");
        assertThat(text.charAt(1)).isEqualTo('e');
        assertThat(text.subSequence(1, 2)).isEqualTo('e');


  }


}
