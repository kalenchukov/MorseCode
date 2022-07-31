/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode;

import dev.kalenchukov.morsecode.schemes.Schematic;
import dev.kalenchukov.morsecode.schemes.additions.GraphScheme;
import dev.kalenchukov.morsecode.schemes.additions.NumberScheme;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Класс кодирования / декодирования азбуки Морзе.
 */
public class MorseCode implements Codable
{
	/**
	 * Схема сопоставления символов с сигналами.
	 */
	@NotNull
	private final Map<@NotNull String, @NotNull List<@NotNull String>> scheme = new LinkedHashMap<>();

	/**
	 * Конструктор для {@code MorseCode}.
	 *
	 * @param scheme Схема сопоставления.
	 */
	public MorseCode(@NotNull final Schematic scheme)
	{
		this.addScheme(scheme);
		this.addScheme(new GraphScheme());
		this.addScheme(new NumberScheme());
	}

	/**
	 * @see Codable#encode(String)
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
	 * @see Codable#decode(String)
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
	 * @param signal Сигнал.
	 * @return Символ или {@code null} если для данного сигнала нет символа в схеме сопоставления.
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
	 * @param symbol Символ.
	 * @return Сигнал или {@code null} если для данного символа нет сигнала в схеме сопоставления.
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
	 * @param scheme Схема сопоставления.
	 */
	private void addScheme(@NotNull final Schematic scheme)
	{
		Objects.requireNonNull(scheme);

		this.scheme.putAll(scheme.getScheme());
	}
}
