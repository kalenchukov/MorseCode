/*
 * Copyright © 2022-2023 Алексей Каленчуков
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

package dev.kalenchukov.morsecode.schemes.additions;

import dev.kalenchukov.morsecode.schemes.AbstractScheme;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Класс схемы сопоставления цифр и сигналов.<br>
 * Схема соответствует рекомендации МСЭ-R M.1677-1.
 *
 * @author Алексей Каленчуков
 */
public class NumberScheme extends AbstractScheme
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private static final Map<@NotNull String, @NotNull List<@NotNull String>> SCHEME = new LinkedHashMap<>();

	static
	{
		SCHEME.put("0", List.of("-----"));
		SCHEME.put("1", List.of(".----"));
		SCHEME.put("2", List.of("..---"));
		SCHEME.put("3", List.of("...--"));
		SCHEME.put("4", List.of("....-"));
		SCHEME.put("5", List.of("....."));
		SCHEME.put("6", List.of("-...."));
		SCHEME.put("7", List.of("--..."));
		SCHEME.put("8", List.of("---.."));
		SCHEME.put("9", List.of("----."));
	}

	/**
	 * Конструктор для {@code NumberScheme}.
	 */
	public NumberScheme()
	{
		super(NumberScheme.SCHEME);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param obj {@inheritDoc}
	 * @return {@inheritDoc}
	 */
	@Override
	public boolean equals(@Nullable final Object obj)
	{
		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!this.getClass().equals(obj.getClass())) {
			return false;
		}

		final NumberScheme scheme = (NumberScheme) obj;

		if (!Objects.equals(this.getScheme(), scheme.getScheme())) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Override
	public int hashCode()
	{
		return this.getScheme().hashCode();
	}
}
