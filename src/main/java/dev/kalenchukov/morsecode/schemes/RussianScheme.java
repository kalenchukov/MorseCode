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

package dev.kalenchukov.morsecode.schemes;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

/**
 * Класс схемы сопоставления букв русского алфавита и сигналов.
 */
public class RussianScheme implements Schematic
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private static final Map<@NotNull String, @NotNull List<@NotNull String>> SCHEME = new LinkedHashMap<>();

	static
	{
		SCHEME.put("А", List.of(".-"));
		SCHEME.put("Б", List.of("-..."));
		SCHEME.put("В", List.of(".--"));
		SCHEME.put("Г", List.of("--."));
		SCHEME.put("Д", List.of("-.."));
		SCHEME.put("Е", List.of("."));
		SCHEME.put("Ё", List.of("."));
		SCHEME.put("Ж", List.of("...-"));
		SCHEME.put("З", List.of("--.."));
		SCHEME.put("И", List.of(".."));
		SCHEME.put("Й", List.of(".---"));
		SCHEME.put("К", List.of("-.-"));
		SCHEME.put("Л", List.of(".-.."));
		SCHEME.put("М", List.of("--"));
		SCHEME.put("Н", List.of("-."));
		SCHEME.put("О", List.of("---"));
		SCHEME.put("П", List.of(".--."));
		SCHEME.put("Р", List.of(".-."));
		SCHEME.put("С", List.of("..."));
		SCHEME.put("Т", List.of("-"));
		SCHEME.put("У", List.of("..-"));
		SCHEME.put("Ф", List.of("..-."));
		SCHEME.put("Х", List.of("...."));
		SCHEME.put("Ц", List.of("-.-."));
		SCHEME.put("Ч", List.of("---."));
		SCHEME.put("Ш", List.of("----"));
		SCHEME.put("Щ", List.of("--.-"));
		SCHEME.put("Ъ", List.of(".--.-."));
		SCHEME.put("Ы", List.of("-.--"));
		SCHEME.put("Ь", List.of("-..-"));
		SCHEME.put("Э", List.of("..-.."));
		SCHEME.put("Ю", List.of("..--"));
		SCHEME.put("Я", List.of(".-.-"));
	}

	/**
	 * Конструктор для {@code RussianScheme}.
	 */
	public RussianScheme() {}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Map<@NotNull String, @NotNull List<@NotNull String>> getScheme()
	{
		return Collections.unmodifiableMap(RussianScheme.SCHEME);
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

		final RussianScheme russianScheme = (RussianScheme) obj;

		if (!Objects.equals(this.getScheme(), russianScheme.getScheme())) {
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
