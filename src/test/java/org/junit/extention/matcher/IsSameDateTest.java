package org.junit.extention.matcher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;

import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.extention.TestUtils;

/**
 * {@link IsSameDate}に対するテストクラス。
 * 
 * @author naotake
 */
public class IsSameDateTest {

    private IsSameDate testee;

    @Mocked
    private Description mock;

    private Date date;

    /**
     * 事前処理。
     */
    @Before
    public void setUp() {
        testee = IsSameDate.isSameDate(2013, 7, 18);
        date = TestUtils.createDate(2013, 7, 18);
    }

    @Test
    public void 同日日付を指定した場合に_true_が返されること() {
        boolean actual = testee.matchesSafely(date);
        assertThat(actual, is(true));
    }

    @Test
    public void 異なる日付を指定した場合に_false_が返されること() {
        boolean actual = testee.matchesSafely(TestUtils.createDate(2013, 7, 19));
        assertThat(actual, is(false));
    }

    @Test
    public void Descriptionに対してインスタンス時に指定された日付の文字列表現が設定されること() {
        // 振る舞いを定義
        new NonStrictExpectations() {
            {
                mock.appendText("2013/07/18");
            }
        };

        // 実行
        testee.describeTo(mock);

        // 検証
        new Verifications() {
            {
                mock.appendText("2013/07/18");
            }
        };
    }

    @Test
    public void Descriptionに対して指定した日付の文字列表現が設定されること() {
        // 振る舞いを定義
        new NonStrictExpectations() {
            {
                mock.appendText("2013/07/19");
            }
        };

        // 実行
        testee.describeMismatchSafely(TestUtils.createDate(2013, 7, 19), mock);

        // 検証
        new Verifications() {
            {
                mock.appendText("2013/07/19");
            }
        };
    }
}
