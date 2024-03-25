package yatzy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @Test
    void chance_scores_sum_of_all_dice() {
        assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1));
        assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1));
    }

    @Test
    void yatzy_scores_50_when_all_dice_read_the_same_number() {
        assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4));
        assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6));
    }

    @Test
    void yatzy_scores_0_when_NOT_all_dice_read_the_same_number() {
        assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3));
    }

    @Test
    void ones_should_score_the_sum_of_all_dice_reading_1() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
        assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5));
        assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1));
        assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5));
    }

    @Test
    void twos_should_score_the_sum_of_all_dice_reading_2() {
        assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6));
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
        assertEquals(0, Yatzy.twos(1, 1, 3, 3, 6));
    }

    @Test
    void threes_should_score_the_sum_of_all_dice_reading_3() {
        assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3));
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
        assertEquals(0, Yatzy.threes(1, 1, 1, 2, 6));
    }

    @Test
    void fours_should_score_the_sum_of_all_dice_reading_4() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
        assertEquals(0, new Yatzy(1, 5, 5, 5, 5).fours());
    }

    @Test
    void fives_should_score_the_sum_of_all_dice_reading_5() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
        assertEquals(0, new Yatzy(4, 1, 2, 3, 6).fives());
    }

    @Test
    void sixes_should_score_the_sum_of_all_dice_reading_6() {
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
    }

    @Test
    void pair_scores_the_sum_of_the_two_highest_matching_dice() {
        assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6));
        assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5));
        assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5));
        assertEquals(0, Yatzy.score_pair(5, 3, 1, 6, 2));
    }

    @Test
    void two_pair_scores_the_sum_of_matching_dice() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5));
        assertEquals(0, Yatzy.two_pair(3, 2, 5, 1, 6));
    }

    @Test
    void three_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5));
        assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5));
        assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(0, Yatzy.three_of_a_kind(3, 2, 1, 3, 5));
    }

    @Test
    void four_of_a_kind_scores_the_sum_of_matching_dice() {
        assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5));
        assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5));
        assertEquals(0, Yatzy.four_of_a_kind(3, 3, 3, 5, 2));
    }

    @Test
    void smallStraight_scores_15() {
        assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5));
        assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1));

    }

    @Test
    void smallStraight_scores_0_when_no_small_straight() {
        assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    void largeStraight_scores_20() {
        assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5));
        assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6));
    }
    @Test
    void largeStraight_scores_0_when_no_large_straight() {
        assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    void fullHouse_scores_the_sum_of_all_dice() {
        assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6));

    }
    @Test
    void fullHouse_scores_0_when_no_fullHouse() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));

    }
}