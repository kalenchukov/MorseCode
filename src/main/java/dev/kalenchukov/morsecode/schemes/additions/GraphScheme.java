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
 * Класс схемы сопоставления спецсимволов и сигналов.<br>
 * Схема соответствует рекомендации МСЭ-R M.1677-1.
 */
public class GraphScheme implements Schematic
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
		return Collections.unmodifiableMap(GraphScheme.SCHEME);
	}
}
