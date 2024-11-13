package at.kalwodaknezevic.moviemanagement.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TitleTest {

    @Test
    void when_instantiated_with_null_throws_appropriate_TitleException() {
        Title.TitleException ex = assertThrows(Title.TitleException.class, () -> new Title(null));
        assertThat(ex.getMessage()).isEqualTo("Title value must not be null!");
    }

    @Test
    void when_instantiated_with_to_long_value_throws_appropriate_TitleException() {
        assertThatThrownBy(() -> new Title("The Matrix is a 1999 science fiction action film written and directed by the Wachowskis. It stars Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano and is the first installment in the Matrix franchise. It depicts a dystopian future in which humanity is unknowingly trapped inside a simulated reality created by intelligent machines to distract humans while using their bodies as an energy source. When computer programmer Thomas Anderson, under the hacker alias Neo, uncovers the truth, he \"is drawn into a rebellion against the machines\" along with other people who have been freed from the Matrix. The film is an example of the cyberpunk subgenre. The Wachowskis' approach to action scenes drew upon their admiration for Japanese animation and martial arts films, and the film's use of fight choreographers and wire fu techniques from Hong Kong action cinema influenced subsequent Hollywood action film productions. The film popularized a visual effect known as \"bullet time\", which has since been featured in other movies as well as in video games and advertising. The film was praised for its innovative visual effects, action sequences, cinematography and entertainment value. It won four Academy Awards, including for Best Visual Effects, Best Film Editing, Best Sound, and Best Sound Effects Editing. Its success led to the release of two sequels, The Matrix Reloaded and The Matrix Revolutions, both released in 2003. The Matrix Resurrections, a fourth installment, is scheduled for release in December 2021. The Matrix was added to the National Film Registry for preservation in 2012. The film was a commercial success, grossing over $465 million worldwide, and was well-received by critics. It is widely regarded as one of the greatest science fiction films of all time. The film's mainstream success had widespread impact on the film industry, popular culture, and the cyberpunk genre. The film has since been widely parodied and imitated. The film's success led to the release of two sequels, The Matrix Reloaded and The Matrix Revolutions, both released in 2003. The Matrix Resurrections, a fourth installment, is scheduled for release in December 2021. The Matrix was added to the National Film Registry for preservation in 2012. The film was a commercial success, grossing over $465 million worldwide, and was well-received by critics. It is widely regarded as one of"))
                .isInstanceOf(Title.TitleException.class)
                .hasMessage("Title value must not be longer than 50 characters!");
    }

    @Test
    void when_instantiated_with_to_short_value_throws_appropriate_TitleException() {
        assertThatThrownBy(() -> new Title(""))
                .isInstanceOf(Title.TitleException.class)
                .hasMessage("Title value must not be shorter than 1 characters!");
    }
}