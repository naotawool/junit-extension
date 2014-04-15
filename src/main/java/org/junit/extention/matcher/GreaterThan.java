package org.junit.extention.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * 数値が「より大きい」ことを検証する{@link Matcher}。
 * 
 * FIXME 他の数値型に対応する
 * 
 * @author naotake
 */
public class GreaterThan extends TypeSafeMatcher<Integer> {

    /** 期待値 */
    private final Integer expect;

    private GreaterThan(Integer expect) {
        this.expect = expect;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.valueOf(expect));
    }

    @Override
    protected boolean matchesSafely(Integer actual) {
        return (actual > expect);
    }

    /**
     * 期待値より大きいことを検証する。
     * 
     * @param expect 期待値
     * @return {@link GreaterThan}
     */
    public static GreaterThan greaterThan(Integer expect) {
        return new GreaterThan(expect);
    }

    /**
     * 0 より大きいことを検証する。
     * 
     * @return {@link GreaterThan}
     */
    public static GreaterThan greaterThanZero() {
        return new GreaterThan(0);
    }
}
