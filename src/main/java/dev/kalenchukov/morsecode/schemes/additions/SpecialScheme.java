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

import dev.kalenchukov.morsecode.schemes.Schematic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.*;

/**
 * Класс схемы сопоставления спецсимволов и сигналов.<br>
 * Схема соответствует рекомендации МСЭ-R M.1677-1.
 */
public class SpecialScheme implements Schematic
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private static final Map<@NotNull String, @NotNull List<@NotNull String>> SCHEME = new LinkedHashMap<>();

	static
	{
		SCHEME.put(".", List.of(".-.-.-"));
		SCHEME.put(",", List.of("--..--"));
		SCHEME.put(":", List.of("---..."));
		SCHEME.put("?", List.of("..--.."));
		SCHEME.put("'", List.of(".----."));
		SCHEME.put("-", List.of("-....-"));
		SCHEME.put("/", List.of("-..-."));
		SCHEME.put(";", List.of("-.-.-."));
		SCHEME.put("(", List.of("-.--."));
		SCHEME.put(")", List.of("-.--.-"));
		SCHEME.put("\"", List.of(".-..-."));
		SCHEME.put("=", List.of("-...-"));
		SCHEME.put("+", List.of(".-.-."));

		// Дополнительные символы не входящие в рекомендацию МСЭ-R M.1677-1
//		SCHEME.put("&", List.of(".-..."));
//		SCHEME.put("_", List.of("..--.-"));
//		SCHEME.put("$", List.of("...-..-"));
	}

	/**
	 * @see Schematic#getScheme()
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Map<@NotNull String, @NotNull List<@NotNull String>> getScheme()
	{
		return Collections.unmodifiableMap(SpecialScheme.SCHEME);
	}

	/**
	 * @see Schematic#equals(Object)
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

		final SpecialScheme specialScheme = (SpecialScheme) obj;

		if (!Objects.equals(this.getScheme(), specialScheme.getScheme())) {
			return false;
		}

		return true;
	}

	/**
	 * @see Schematic#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return this.getScheme().hashCode();
	}
}
