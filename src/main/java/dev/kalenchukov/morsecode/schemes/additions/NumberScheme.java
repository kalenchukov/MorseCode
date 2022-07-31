/*
 * Copyright © 2022 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 */

package dev.kalenchukov.morsecode.schemes.additions;

import dev.kalenchukov.morsecode.schemes.Schematic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс схемы сопоставления цифр и сигналов.<br>
 * Схема соответствует рекомендации МСЭ-R M.1677-1.
 */
public class NumberScheme implements Schematic
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
	 * @see Schematic#getScheme()
	 */
	@Unmodifiable
	@NotNull
	@Override
	public Map<@NotNull String, @NotNull List<@NotNull String>> getScheme()
	{
		return Collections.unmodifiableMap(NumberScheme.SCHEME);
	}
}
