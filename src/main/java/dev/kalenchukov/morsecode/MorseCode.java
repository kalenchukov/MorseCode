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

package dev.kalenchukov.morsecode;

import dev.kalenchukov.morsecode.resources.Language;
import dev.kalenchukov.morsecode.schemes.Schematic;
import dev.kalenchukov.morsecode.schemes.additions.SpecialScheme;
import dev.kalenchukov.morsecode.schemes.additions.NumberScheme;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Класс кодирования / декодирования азбуки Морзе.
 *
 * @author Алексей Каленчуков
 */
public class MorseCode implements MorseCodable
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull List<@NotNull String>> scheme;

	/**
	 * Конструктор для {@code MorseCode}.
	 *
	 * @param scheme схема сопоставления.
	 */
	public MorseCode(@NotNull final Language scheme)
	{
		this.scheme = new LinkedHashMap<>();

		this.addScheme(scheme.getScheme());
		this.addScheme(new SpecialScheme());
		this.addScheme(new NumberScheme());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param text {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code text} передан {@code null}.
	 */
	@NotNull
	@Override
	public String encode(@NotNull final String text)
	{
		Objects.requireNonNull(text);

		boolean endWord = false;

		StringBuilder encodeText = new StringBuilder();

		for (String symbol : text.split(""))
		{
			String signal = this.getSignalBySymbol(symbol);

			if (endWord) {
				encodeText.append("  ");
				endWord = false;
			}
			if (signal != null) {
				encodeText.append(signal).append(" ");
			}

			if (symbol.equals(" ")) {
				endWord = true;
			}
		}

		return encodeText.toString().trim();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param code {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code code} передан {@code null}.
	 */
	@NotNull
	@Override
	public String decode(@NotNull final String code)
	{
		Objects.requireNonNull(code);

		StringBuilder decodeCode = new StringBuilder();

		for (String signal : code.split(" "))
		{
			String sing = this.getSymbolBySignal(signal);

			if (sing != null) {
				decodeCode.append(sing);
			} else if (signal.equals("")) {
				decodeCode.append(" ");
			}
		}

		return decodeCode.toString().replaceAll("\s+", " ");
	}

	/**
	 * Возвращает символ соответствующий сигналу в схеме сопоставления.
	 *
	 * @param signal сигнал.
	 * @return символ или {@code null}, если для {@code signal} нет символа в схеме сопоставления.
	 * @throws NullPointerException если в качестве {@code signal} передан {@code null}.
	 */
	@Nullable
	private String getSymbolBySignal(@NotNull final String signal)
	{
		Objects.requireNonNull(signal);

		for (Map.Entry<String, List<String>> contrast : this.scheme.entrySet())
		{
			if (contrast.getValue().contains(signal)) {
				return contrast.getKey();
			}
		}

		return null;
	}

	/**
	 * Возвращает сигнал соответствующий символу в схеме сопоставления.
	 *
	 * @param symbol символ.
	 * @return сигнал или {@code null}, если для {@code symbol} нет сигнала в схеме сопоставления.
	 * @throws NullPointerException если в качестве {@code symbol} передан {@code null}.
	 */
	@Nullable
	private String getSignalBySymbol(@NotNull final String symbol)
	{
		Objects.requireNonNull(symbol);

		for (Map.Entry<String, List<String>> contrast : this.scheme.entrySet())
		{
			if (contrast.getKey().contains(symbol.toLowerCase()) ||
				contrast.getKey().contains(symbol.toUpperCase()))
			{
				return (!contrast.getValue().isEmpty()) ? contrast.getValue().get(0) : null;
			}
		}

		return null;
	}

	/**
	 * Добавляет схему сопоставления.
	 *
	 * @param scheme схема сопоставления.
	 * @throws NullPointerException если в качестве {@code scheme} передан {@code null}.
	 */
	private void addScheme(@NotNull final Schematic scheme)
	{
		Objects.requireNonNull(scheme);

		this.scheme.putAll(scheme.getScheme());
	}
}
