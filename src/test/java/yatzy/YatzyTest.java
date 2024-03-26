package yatzy;


import org.junit.jupiter.api.Test;
import yatzy.categories.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @Test
    void chance_scores_sum_of_all_dice() {
        assertEquals(15, Chance.of(new Roll(2, 3, 4, 5, 1)).computeScore());
        assertEquals(16, Chance.of(new Roll(3, 3, 4, 5, 1)).computeScore());
    }

    @Test
    void yatzy_scores_50_when_all_dice_read_the_same_number() {
        assertEquals(50, Yatzy.of(new Roll(4, 4, 4, 4, 4)).computeScore());
        assertEquals(50, Yatzy.of(new Roll(6, 6, 6, 6, 6)).computeScore());
    }

    @Test
    void yatzy_scores_0_when_NOT_all_dice_read_the_same_number() {
        assertEquals(0, Yatzy.of(new Roll(6, 6, 6, 6, 3)).computeScore());;
    }

    @Test
    void ones_should_score_the_sum_of_all_dice_reading_1() {
        assertEquals(1, Ones.of(new Roll(1, 2, 3, 4, 5)).computeScore());
        assertEquals(2, Ones.of(new Roll(1, 2, 1, 4, 5)).computeScore());
        assertEquals(4, Ones.of(new Roll(1, 2, 1, 1, 1)).computeScore());
        assertEquals(0, Ones.of(new Roll(6, 2, 2, 4, 5)).computeScore());
    }

    @Test
    void twos_should_score_the_sum_of_all_dice_reading_2() {
        assertEquals(4, Twos.of(new Roll(1, 2, 3, 2, 6)).computeScore());
        assertEquals(10, Twos.of(new Roll(2, 2, 2, 2, 2)).computeScore());
        assertEquals(0, Twos.of(new Roll(1, 1, 3, 3, 6)).computeScore());
    }

    @Test
    void threes_should_score_the_sum_of_all_dice_reading_3() {
        assertEquals(6,  Threes.of(new Roll(1, 2, 3, 2, 3)).computeScore());
        assertEquals(12, Threes.of(new Roll(2, 3, 3, 3, 3)).computeScore());
        assertEquals(0,  Threes.of(new Roll(1, 1, 1, 2, 6)).computeScore());
    }

    @Test
    void fours_should_score_the_sum_of_all_dice_reading_4() {
        assertEquals(12, Fours.of(new Roll(4, 4, 4, 5, 5)).computeScore());
        assertEquals(8,  Fours.of(new Roll(4, 4, 5, 5, 5)).computeScore());
        assertEquals(4,  Fours.of(new Roll(4, 5, 5, 5, 5)).computeScore());
        assertEquals(0,  Fours.of(new Roll(1, 5, 5, 5, 5)).computeScore());
    }

    @Test
    void fives_should_score_the_sum_of_all_dice_reading_5() {
        assertEquals(10, Fives.of(new Roll(4, 4, 4, 5, 5)).computeScore());
        assertEquals(15, Fives.of(new Roll(4, 4, 5, 5, 5)).computeScore());
        assertEquals(20, Fives.of(new Roll(4, 5, 5, 5, 5)).computeScore());
        assertEquals(0,  Fives.of(new Roll(4, 1, 2, 3, 6)).computeScore());
    }

    @Test
    void sixes_should_score_the_sum_of_all_dice_reading_6() {
        assertEquals(6,  Sixes.of(new Roll(4, 4, 6, 5, 5)).computeScore());
        assertEquals(18, Sixes.of(new Roll(6, 5, 6, 6, 5)).computeScore());
        assertEquals(0,  Sixes.of(new Roll(4, 4, 4, 5, 5)).computeScore());
    }

    @Test
    void pair_scores_the_sum_of_the_two_highest_matching_dice() {
        assertEquals(6,  Pair.of(new Roll(3, 4, 3, 5, 6)).computeScore());
        assertEquals(10, Pair.of(new Roll(5, 3, 3, 3, 5)).computeScore());
        assertEquals(12, Pair.of(new Roll(5, 3, 6, 6, 5)).computeScore());
        assertEquals(0,  Pair.of(new Roll(5, 3, 1, 6, 2)).computeScore());
    }

    @Test
    void two_pair_scores_the_sum_of_matching_dice() {
        assertEquals(16, TwoPairs.of(new Roll(3, 3, 5, 4, 5)).computeScore());
        assertEquals(16, TwoPairs.of(new Roll(3, 3, 5, 5, 5)).computeScore());
        assertEquals(0,  TwoPairs.of(new Roll(3, 2, 5, 1, 6)).computeScore());
    }

    @Test
    void three_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(9,  ThreeOfAKind.of(new Roll(3, 3, 3, 4, 5)).computeScore());
        assertEquals(15, ThreeOfAKind.of(new Roll(5, 3, 5, 4, 5)).computeScore());
        assertEquals(9,  ThreeOfAKind.of(new Roll(3, 3, 3, 3, 5)).computeScore());
        assertEquals(0,  ThreeOfAKind.of(new Roll(3, 2, 1, 3, 5)).computeScore());
    }

    @Test
    void four_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(12, FourOfAKind.of(new Roll(3, 3, 3, 3, 5)).computeScore());
        assertEquals(20, FourOfAKind.of(new Roll(5, 5, 5, 4, 5)).computeScore());
        assertEquals(0,  FourOfAKind.of(new Roll(3, 3, 3, 5, 2)).computeScore());
    }

    @Test
    void smallStraight_scores_15() {
        assertEquals(15, SmallStraight.of(new Roll(1, 2, 3, 4, 5)).computeScore());
        assertEquals(15, SmallStraight.of(new Roll(2, 3, 4, 5, 1)).computeScore());

    }

    @Test
    void smallStraight_scores_0_when_no_small_straight() {
        assertEquals(0, SmallStraight.of(new Roll(1, 2, 2, 4, 5)).computeScore());
    }

    @Test
    void largeStraight_scores_20() {
        assertEquals(20, LargeStraight.of(new Roll(6, 2, 3, 4, 5)).computeScore());
        assertEquals(20, LargeStraight.of(new Roll(2, 3, 4, 5, 6)).computeScore());
    }
    @Test
    void largeStraight_scores_0_when_no_large_straight() {
        assertEquals(0, LargeStraight.of(new Roll(1, 2, 2, 4, 5)).computeScore());
    }

    @Test
    void fullHouse_scores_the_sum_of_all_dice() {
        assertEquals(18, FullHouse.of(new Roll(6, 2, 2, 2, 6)).computeScore());

    }
    @Test
    void fullHouse_scores_0_when_no_fullHouse() {
        assertEquals(0, FullHouse.of(new Roll(2, 3, 4, 5, 6)).computeScore());

    }
}