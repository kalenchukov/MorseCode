/*
 * Copyright © 2022 Алексей Каленчуков
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
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс схемы сопоставления букв английского алфавита и сигналов.<br>
 * Схема соответствует рекомендации МСЭ-R M.1677-1.
 */
public class EnglishScheme implements Schematic
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private static final Map<@NotNull String, @NotNull List<@NotNull String>> SCHEME = new LinkedHashMap<>();

	static
	{
		SCHEME.put("A", List.of(".-"));
		SCHEME.put("B", List.of("-..."));
		SCHEME.put("C", List.of("-.-."));
		SCHEME.put("D", List.of("-.."));
		SCHEME.put("E", List.of(".", "..-.."));
		SCHEME.put("F", List.of("..-."));
		SCHEME.put("G", List.of("--."));
		SCHEME.put("H", List.of("...."));
		SCHEME.put("I", List.of(".."));
		SCHEME.put("J", List.of(".---"));
		SCHEME.put("K", List.of("-.-"));
		SCHEME.put("L", List.of(".-.."));
		SCHEME.put("M", List.of("--"));
		SCHEME.put("N", List.of("-."));
		SCHEME.put("O", List.of("---"));
		SCHEME.put("P", List.of(".--."));
		SCHEME.put("Q", List.of("--.-"));
		SCHEME.put("R", List.of(".-."));
		SCHEME.put("S", List.of("..."));
		SCHEME.put("T", List.of("-"));
		SCHEME.put("U", List.of("..-"));
		SCHEME.put("V", List.of("...-"));
		SCHEME.put("W", List.of(".--"));
		SCHEME.put("X", List.of("-..-"));
		SCHEME.put("Y", List.of("-.--"));
		SCHEME.put("Z", List.of("--.."));
	}

	/**
	 * @see Schematic#getScheme()
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Map<@NotNull String, @NotNull List<@NotNull String>> getScheme()
	{
		return Collections.unmodifiableMap(EnglishScheme.SCHEME);
	}
}
