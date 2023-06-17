/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.morsecode.schemes;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link AbstractScheme}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractSchemeTest
{
    /**
     * Проверка метода {@link AbstractScheme#getScheme()}.
     */
    @Test
    public void getScheme()
    {
        Schematic scheme = new RussianScheme();

        Map<String, List<String>> actualScheme = scheme.getScheme();

        assertThat(actualScheme).hasSize(33);
    }

	/**
	 * Класс проверки метода {@link AbstractScheme#equals(Object)}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class Equals
	{
		/**
		 * Проверка метода {@link AbstractScheme#equals(Object)}.
		 */
		@Test
		public void testEquals()
		{
			Schematic scheme1 = new RussianScheme();
			Schematic scheme2 = new RussianScheme();

			boolean actual = scheme1.equals(scheme2);

			assertThat(actual).isTrue();
		}

		/**
		 * Проверка метода {@link AbstractScheme#equals(Object)} с {@code null}.
		 */
		@Test
		public void testEqualsNull()
		{
			Schematic scheme1 = new RussianScheme();
			Schematic scheme2 = null;

			boolean actual = scheme1.equals(scheme2);

			assertThat(actual).isFalse();
		}

		/**
		 * Проверка метода {@link AbstractScheme#equals(Object)} с разными классами.
		 */
		@Test
		public void testEqualsDifferentClass()
		{
			Schematic scheme1 = new RussianScheme();
			Schematic scheme2 = new EnglishScheme();

			boolean actual = scheme1.equals(scheme2);

			assertThat(actual).isFalse();
		}
	}

	/**
	 * Класс проверки метода {@link AbstractScheme#hashCode()}.
	 *
	 * @author Алексей Каленчуков
	 */
	@Nested
	public class HashCode
	{
		/**
		 * Проверка метода {@link AbstractScheme#hashCode()}.
		 */
		@Test
		public void testHashCode()
		{
			Schematic scheme1 = new RussianScheme();
			Schematic scheme2 = new RussianScheme();

			int expectedHashCode = scheme1.hashCode();
			int actualHashCode = scheme2.hashCode();

			assertThat(actualHashCode).isEqualTo(expectedHashCode);
		}

		/**
		 * Проверка метода {@link AbstractScheme#hashCode()} с разными классами.
		 */
		@Test
		public void testHashCodeDifferentClass()
		{
			Schematic scheme1 = new RussianScheme();
			Schematic scheme2 = new EnglishScheme();

			int expectedHashCode = scheme1.hashCode();
			int actualHashCode = scheme2.hashCode();

			assertThat(actualHashCode).isNotEqualTo(expectedHashCode);
		}
	}
}