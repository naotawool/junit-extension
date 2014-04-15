package org.junit.extention.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * 数値が「より小さい」ことを検証する{@link Matcher}。
 * 
 * FIXME 他の数値型に対応する
 * 
 * @author naotake
 */
public class LessThan extends TypeSafeMatcher<Integer> {

    /** 期待値 */
    private final Integer expect;

    private LessThan(Integer expect) {
        this.expect = expect;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.valueOf(expect));
    }

    @Override
    protected boolean matchesSafely(Integer actual) {
        return (actual < expect);
    }

    /**
     * 期待値より小さいことを検証する。
     * 
     * @param expect 期待値
     * @return {@link LessThan}
     */
    public static LessThan lessThan(Integer expect) {
        return new LessThan(expect);
    }

    /**
     * 0 より小さいことを検証する。
     * 
     * @return {@link LessThan}
     */
    public static LessThan lessThanZero() {
        return new LessThan(0);
    }
}
