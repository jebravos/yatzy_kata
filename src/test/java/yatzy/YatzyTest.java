package yatzy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @Test
    void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(new Roll(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new Roll(3, 3, 4, 5, 1)));
    }

    @Test
    void yatzy_scores_50_when_all_dice_read_the_same_number() {
        assertEquals(50, Yatzy.yatzy(new Roll(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.yatzy(new Roll(6, 6, 6, 6, 6)));
    }

    @Test
    void yatzy_scores_0_when_NOT_all_dice_read_the_same_number() {
        assertEquals(0, Yatzy.yatzy(new Roll(6, 6, 6, 6, 3)));
    }

    @Test
    void ones_should_score_the_sum_of_all_dice_reading_1() {
        assertEquals(1, Yatzy.ones(new Roll(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new Roll(1, 2, 1, 4, 5)));
        assertEquals(4, Yatzy.ones(new Roll(1, 2, 1, 1, 1)));
        assertEquals(0, Yatzy.ones(new Roll(6, 2, 2, 4, 5)));
    }

    @Test
    void twos_should_score_the_sum_of_all_dice_reading_2() {
        assertEquals(4, Yatzy.twos(new Roll(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new Roll(2, 2, 2, 2, 2)));
        assertEquals(0, Yatzy.twos(new Roll(1, 1, 3, 3, 6)));
    }

    @Test
    void threes_should_score_the_sum_of_all_dice_reading_3() {
        assertEquals(6, Yatzy.threes(new Roll(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new Roll(2, 3, 3, 3, 3)));
        assertEquals(0, Yatzy.threes(new Roll(1, 1, 1, 2, 6)));
    }

    @Test
    void fours_should_score_the_sum_of_all_dice_reading_4() {
        assertEquals(12, Yatzy.fours(new Roll(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(new Roll(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(new Roll(4, 5, 5, 5, 5)));
        assertEquals(0, Yatzy.fours(new Roll(1, 5, 5, 5, 5)));
    }

    @Test
    void fives_should_score_the_sum_of_all_dice_reading_5() {
        assertEquals(10, Yatzy.fives(new Roll(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(new Roll(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(new Roll(4, 5, 5, 5, 5)));
        assertEquals(0,  Yatzy.fives(new Roll(4, 1, 2, 3, 6)));
    }

    @Test
    void sixes_should_score_the_sum_of_all_dice_reading_6() {
        assertEquals(6, Yatzy.sixes(new Roll(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy.sixes(new Roll(6, 5, 6, 6, 5)));
        assertEquals(0, Yatzy.sixes(new Roll(4, 4, 4, 5, 5)));
    }

    @Test
    void pair_scores_the_sum_of_the_two_highest_matching_dice() {
        assertEquals(6, Yatzy.pair(new Roll(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.pair(new Roll(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.pair(new Roll(5, 3, 6, 6, 5)));
        assertEquals(0, Yatzy.pair(new Roll(5, 3, 1, 6, 2)));
    }

    @Test
    void two_pair_scores_the_sum_of_matching_dice() {
        assertEquals(16, Yatzy.twoPairs(new Roll(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPairs(new Roll(3, 3, 5, 5, 5)));
        assertEquals(0, Yatzy.twoPairs(new Roll(3, 2, 5, 1, 6)));
    }

    @Test
    void three_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfAKind(new Roll(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(0, Yatzy.threeOfAKind(new Roll(3, 2, 1, 3, 5)));
    }

    @Test
    void four_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(12, Yatzy.fourOfAKind(new Roll(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.fourOfAKind(new Roll(5, 5, 5, 4, 5)));
        assertEquals(0, Yatzy.fourOfAKind(new Roll(3, 3, 3, 5, 2)));
    }

    @Test
    void smallStraight_scores_15() {
        assertEquals(15, Yatzy.smallStraight(new Roll(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new Roll(2, 3, 4, 5, 1)));

    }

    @Test
    void smallStraight_scores_0_when_no_small_straight() {
        assertEquals(0, Yatzy.smallStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    void largeStraight_scores_20() {
        assertEquals(20, Yatzy.largeStraight(new Roll(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(new Roll(2, 3, 4, 5, 6)));
    }
    @Test
    void largeStraight_scores_0_when_no_large_straight() {
        assertEquals(0, Yatzy.largeStraight(new Roll(1, 2, 2, 4, 5)));
    }

    @Test
    void fullHouse_scores_the_sum_of_all_dice() {
        assertEquals(18, Yatzy.fullHouse(new Roll(6, 2, 2, 2, 6)));

    }
    @Test
    void fullHouse_scores_0_when_no_fullHouse() {
        assertEquals(0, Yatzy.fullHouse(new Roll(2, 3, 4, 5, 6)));

    }
}