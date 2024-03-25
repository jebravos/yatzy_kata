package yatzy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

 class RollTests {


    @Test
    void should_count_occurrences_grouping_by_die_value(){
        var roll =  new Roll(1,1,2,2,3);
        Assertions.assertThat(roll.counts()).containsEntry(1, 2L);
        Assertions.assertThat(roll.counts()).containsEntry(2, 2L);
        Assertions.assertThat(roll.counts()).containsEntry(3, 1L);
        Assertions.assertThat(roll.counts()).doesNotContainKey(4);
        Assertions.assertThat(roll.counts()).doesNotContainKey(5);
        Assertions.assertThat(roll.counts()).doesNotContainKey(6);
    }
}
