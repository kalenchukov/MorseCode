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

package dev.kalenchukov.morsecode.types;

import dev.kalenchukov.morsecode.schemes.EnglishScheme;
import dev.kalenchukov.morsecode.schemes.RussianScheme;
import dev.kalenchukov.morsecode.schemes.Schematic;
import org.jetbrains.annotations.NotNull;

/**
 * Перечисление языков транслитерации.
 *
 * @author Алексей Каленчуков
 */
public enum Language
{
	/**
	 * Русский язык.
	 */
	RUSSIAN(new RussianScheme()),

	/**
	 * Английский язык.
	 */
	ENGLISH(new EnglishScheme());

	/**
	 * Схема сопоставления.
	 */
	@NotNull
	private final Schematic scheme;

	/**
	 * Конструктор для {@code Language}.
	 *
	 * @param scheme схема сопоставления.
	 */
	Language(@NotNull final Schematic scheme)
	{
		this.scheme = scheme;
	}

	/**
	 * Возвращает схему сопоставления.
	 *
	 * @return схема сопоставления.
	 */
	@NotNull
	public Schematic getScheme()
	{
		return this.scheme;
	}
}
