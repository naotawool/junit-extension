package org.junit.extention.matcher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * {@link LessThan}に対するテスト。
 * 
 * @author naotake
 */
public class LessThanTest {

    private LessThan testee;

    private int actual;

    /**
     * 事前処理。
     */
    @Before
    public void setUp() {
        this.actual = 100;
    }

    @Test
    public void 実値が期待値より小さい場合_true_が返されること() {
        testee = LessThan.lessThan(101);
        assertThat(testee.matchesSafely(actual), is(true));
    }

    @Test
    public void 実値が期待値と等しい場合_false_が返されること() {
        testee = LessThan.lessThan(100);
        assertThat(testee.matchesSafely(actual), is(false));
    }

    @Test
    public void 実値が期待値より大きい場合_false_が返されること() {
        testee = LessThan.lessThan(99);
        assertThat(testee.matchesSafely(actual), is(false));
    }
}
